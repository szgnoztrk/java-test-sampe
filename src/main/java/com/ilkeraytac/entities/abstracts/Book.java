package com.ilkeraytac.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Field 'author' is required.")
    @NotBlank(message = "Field 'author' is required.")
    private String author;

    @NotNull(message = "Field 'title' is required.")
    @NotBlank(message = "Field 'title' is required.")
    private String title;
}
