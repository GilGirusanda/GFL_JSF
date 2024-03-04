package org.example.webdemo0103.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.webdemo0103.data.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ItemDao {
    @PersistenceContext
    private EntityManager em;

    final double a = -0.5, b = 2;

    public List<Item> getAll(double a, double b, double h) {
        List<Item> items = new ArrayList<>();
        items = Arrays.stream(genValues(a, b, h)).map(e-> new Item(e[0], e[1])).collect(Collectors.toList());
        return items;
    }

    public Boolean check(Double x, Double y) {
        if (x == null || y == null) {
            return false;
        }
        if(x <= 0.7 && y == 1) return true;
        else if(x > 1.4 && y==Math.exp(a*x)*Math.cos(b*x)) return true;
        else return x > 0.7 && x <= 1.4 && y == a * x * x * Math.log(x);
    }

    double func(double x) {
        if(x <= 0.7) return 1;
        if(x > 1.4) return Math.exp(a*x)*Math.cos(b*x);
        return a*x*x*Math.log(x);
    }

    double countSteps(double begin, double end, double h) {
        return (begin - end)/h;
    }

    double[][] genValues(double a, double b, double h){
        int size = Math.abs((int)countSteps(a, b, h))+1;

        double[][] arr = new double[size][2];
        for(int i = 0; i < size; i++) {
            double x = a+i*h;
            arr[i][0] = x;// X
            arr[i][1] = func(x);// Y
        }
        return arr;
    }

}
