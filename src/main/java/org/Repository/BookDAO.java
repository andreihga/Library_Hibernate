package org.Repository;

import org.Database.DbInitializer;
import org.Entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class BookDAO {


    public void insertBook(Book book) {
        Session session = DbInitializer.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        transaction.commit();
        session.close();
    }

    public List<Book> getAllBooks() {
        Session session = DbInitializer.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createNamedQuery("getAllBooks");
        List<Book> listAllBooks = query.getResultList();
        transaction.commit();
        session.close();

        return  listAllBooks;
    }

    public List<Book> getBookByName(String bookName){
        Session session = DbInitializer.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createNamedQuery("getBookByName");
        query.setParameter("bookName", bookName);
        List<Book> listOfBooksByName = query.getResultList();
        transaction.commit();
        session.close();

        return listOfBooksByName;
    }


}
