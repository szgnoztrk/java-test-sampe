package com.ilkeraytac.business.abstracts;

import com.ilkeraytac.core.utilities.result.Result;
import com.ilkeraytac.entities.abstracts.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    Book getBookById(int id);
    Result save(Book book);
}
