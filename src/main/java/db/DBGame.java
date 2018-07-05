package db;

import models.Console;
import models.Game;
import models.Owner;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBGame {

    public static void addGameToConsole(Game game, Console console) {
        game.addConsole(console);
        console.addGame(game);
        DBHelper.update(game); // updates join table
    }

    private static Session session;

    public static List<Console> getConsolesOfGame(Game game) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Console> results = null;
        try {
            Criteria cr = session.createCriteria(Console.class);
            cr.createAlias("games", "game");
            cr.add(Restrictions.eq("game.id", game.getId()));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static void addFanToGame(Owner owner, Game game) {
        owner.setFavourite(game);
        game.addOwnerWhoLovesIt(owner);
        DBHelper.update(game);
    }


    public static List<Owner> getFansForGame(Game game) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Owner> results = null;
        try {
            Criteria cr = session.createCriteria(Owner.class);
            cr.add(Restrictions.eq("favourite", game));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
