package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

@Repository
public class BookRepository {
    private final Map<Long, Book> books = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    public Book findById(Long id) {
        return books.get(id);
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(counter.incrementAndGet());
        }
        books.put(book.getId(), book);
        return book;
    }

    public void deleteById(Long id) {
        books.remove(id);
    }
}
