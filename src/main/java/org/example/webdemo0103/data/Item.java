package org.example.webdemo0103.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private Double x;

    private Double y;

    public Item(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

}