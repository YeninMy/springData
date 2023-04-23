package com.hwSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {
    private final BookRepo bookRepo;

    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public List<Book> getBooksByGenre(String genre){
        return bookRepo.findAllByGenre(genre);
    }

    public Book getBookByName(String name){
        return bookRepo.findBookByName(name).orElse(null);
    }

    @Transactional
    public void saveBook(Book book){
        bookRepo.save(book);
    }

    public void updateBookGenreById(String genre, Integer id){
        bookRepo.updateBookName(genre, id);
    }

    @Transactional
    public void deleteBookById(Integer id){
        bookRepo.deleteById(id);
    }
}
