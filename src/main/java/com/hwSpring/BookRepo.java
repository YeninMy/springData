package com.hwSpring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Integer> {
    List<Book> findAllByGenre(String genre);

    @Query("SELECT b FROM Book b WHERE b.author LIKE %:keyword%")
    List<Book> findAllByAuthor(String keyword);
    @Query("SELECT b FROM Book b WHERE b.name LIKE %:keyword%")
    Optional<Book> findBookByName(String keyword);

    @Transactional
    @Modifying
    @Query("UPDATE Book b SET b.genre =?1 WHERE b.id = ?2")
    void updateBookName(String genre, Integer id);

}

