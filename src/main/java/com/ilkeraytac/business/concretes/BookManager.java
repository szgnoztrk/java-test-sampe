package com.ilkeraytac.business.concretes;

import com.ilkeraytac.business.abstracts.BookService;
import com.ilkeraytac.core.utilities.result.ErrorResult;
import com.ilkeraytac.core.utilities.result.Result;
import com.ilkeraytac.core.utilities.result.SuccessDataResult;
import com.ilkeraytac.dataAccess.abstracts.BooksDao;
import com.ilkeraytac.entities.abstracts.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookManager implements BookService {
    private BooksDao booksDao;
    @Autowired
    public BookManager(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    @Override
    public List<Book> getAll() {
        return this.booksDao.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return this.booksDao.findById(id);
    }

    @Override
    public Result save(Book book) {
        if(this.booksDao.existsByAuthorAndTitle(book.getAuthor(), book.getTitle()))
            return new ErrorResult("Same data.");
        else
            return new SuccessDataResult<>(this.booksDao.save(book));
    }
}
