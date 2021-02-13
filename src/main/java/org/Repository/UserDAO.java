package org.Repository;

import org.Database.DbInitializer;
import org.Entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UserDAO {
    public boolean login(String username, String password){
        Session session = DbInitializer.getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createNamedQuery("login");
        query.setParameter("username",username);
        query.setParameter("password",password);
        User user;
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException exception){
            user = null;
        }

        transaction.commit();
        session.close();
        return user != null;
    }
}
