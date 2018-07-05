package db;

import models.Game;
import models.Owner;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBOwner {

    private static Session session;

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
