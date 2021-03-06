package db;

import models.Console;
import models.Game;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBConsole {

    private static Session session;

    public static List<Game> getGamesOfConsole(Console console) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Game> results = null;
        try {
            Criteria cr = session.createCriteria(Game.class);
            cr.createAlias("consoles", "console");
            cr.add(Restrictions.eq("console.id", console.getId()));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
