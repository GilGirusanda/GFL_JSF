package org.example.webdemo0103.beans;

import jakarta.ejb.EJB;
import jakarta.el.MethodExpression;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.example.webdemo0103.dao.ItemDao;
import org.example.webdemo0103.data.Item;
import org.example.webdemo0103.dto.ItemDto;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ItemBean implements Serializable {
    @EJB
    private ItemDao itemDao;

    @Inject
    private Converter converter;

    @Getter
    @Setter
    private Item item = new Item();

    public List<BookDto> getBooks() {
        return bookDao.findAll().stream().map(converter::bookToBookDto).toList();
    }

    public void addBook() {
        bookDao.addBook(book);
        book = new Book();
    }

}
