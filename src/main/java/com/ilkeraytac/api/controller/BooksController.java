package com.ilkeraytac.api.controller;

import com.ilkeraytac.business.abstracts.BookService;
import com.ilkeraytac.core.utilities.result.ErrorDataResult;
import com.ilkeraytac.core.utilities.result.Result;
import com.ilkeraytac.entities.abstracts.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private BookService bookService;
    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity getAll(){
        return  new ResponseEntity(this.bookService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity findById(@RequestParam int bookId){
        if(this.bookService.getBookById(bookId) == null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(this.bookService.getBookById(bookId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity saveData(@Valid @RequestBody Book book){
       return new ResponseEntity(this.bookService.save(book), HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception){
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ErrorDataResult<>(validationErrors, "Validation error.");
    }
}
