package com.ilkeraytac.dataAccess.abstracts;

import com.ilkeraytac.entities.abstracts.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksDao extends JpaRepository<Book, Integer> {
    Book findById(int id);
    boolean existsByAuthorAndTitle(String author, String title);
}
