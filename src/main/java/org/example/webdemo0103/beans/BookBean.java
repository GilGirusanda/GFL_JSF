package org.example.webdemo0103.beans;

import jakarta.ejb.EJB;
import jakarta.el.MethodExpression;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.example.webdemo0103.dao.BookDao;
import org.example.webdemo0103.data.Book;
import org.example.webdemo0103.dto.BookDto;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BookBean implements Serializable {
    @EJB
    private BookDao bookDao;

    @Inject
    private Converter converter;

    @Getter
    @Setter
    private Book book = new Book();

    public List<BookDto> getBooks() {
        return bookDao.findAll().stream().map(converter::bookToBookDto).toList();
    }

    public void addBook() {
        bookDao.addBook(book);
        book = new Book();
    }

}
