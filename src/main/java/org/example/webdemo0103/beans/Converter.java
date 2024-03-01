package org.example.webdemo0103.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.example.webdemo0103.data.Book;
import org.example.webdemo0103.dto.BookDto;

import java.io.Serializable;

@Named
@ApplicationScoped
public class Converter implements Serializable {
    public BookDto bookToBookDto(Book book) {
        if (book.getStudent()!=null) {
            return new BookDto(book.getId(), book.getAuthor(), book.getTitle(), book.getPages(), book.getStudent().getName());
        } else {
            return new BookDto(book.getId(), book.getAuthor(), book.getTitle(), book.getPages(), "---");
        }
    }
}
