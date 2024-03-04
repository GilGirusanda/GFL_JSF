package org.example.webdemo0103.beans;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.example.webdemo0103.dao.ItemDao;
import org.example.webdemo0103.data.Item;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ItemBean implements Serializable {
    @EJB
    private ItemDao itemDao;

    final double start = 0d, end = 3d, h = 0.004d;

    private List<Item> items = new ArrayList<>();

    @Getter
    private int rowsPerPage = 10;

    @Getter
    @Setter
    private int currentPage = 1;

    @Getter
    @Setter
    private Item item = new Item(0d, 0d);

    @Getter
    @Setter
    private String resultMessage;

    @PostConstruct
    public void init() {
        items = this.getItems();
    }

    public List<Item> getCurrentPageItems() {
        int fromIndex = (currentPage - 1) * rowsPerPage;
        int toIndex = Math.min(fromIndex + rowsPerPage, items.size());
        return items.subList(fromIndex, toIndex);
    }

    public Boolean isHasNext() {
        return currentPage < getTotalPages();
    }

    public Boolean isHasPrev() {
        return currentPage > 1;
    }

    public String nextPage() {
        if (currentPage < getTotalPages()) {
            currentPage++;
        }
        return "index";
    }

    public String previousPage() {
        if (currentPage > 1) {
            currentPage--;
        }
        return "index";
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) items.size() / rowsPerPage);
    }

    public List<Item> getItems() {
        if (!items.isEmpty()) return items;
        else return itemDao.getAll(start, end, h);
    }

    public void checkItem() {
        boolean result = itemDao.check(item.getX(), item.getY());

        if (result) {
            resultMessage = "Correct";
        } else {
            resultMessage = "Incorrect";
        }
    }

}
