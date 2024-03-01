package org.example.webdemo0103.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.webdemo0103.data.Book;

import java.util.List;

@Stateless
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public List<Book> findAll() {
        return em.createNamedQuery("Book.findAll", Book.class).getResultList();
    }

    public void addBook(Book book) {
        em.persist(book);
    }
}
