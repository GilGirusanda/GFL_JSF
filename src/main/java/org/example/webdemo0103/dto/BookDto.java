package org.example.webdemo0103.dto;

import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.webdemo0103.data.Book}
 */
@Value
public class BookDto implements Serializable {
    Integer id;
    @Size(max = 30)
    String author;
    @Size(max = 100)
    String title;
    Integer pages;
    String studentName;
}