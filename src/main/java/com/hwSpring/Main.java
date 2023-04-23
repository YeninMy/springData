package com.hwSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.hwSpring");
        final BookService bookService = applicationContext.getBean("bookService", BookService.class);

        for (int i = 1; i < 8; i++) {
            final Book book = new Book();
            book.setName("Harry Potter part " + i);
            book.setAuthor("J.K. Rowling");
            if (i <= 3) {
                book.setGenre("children's fantasy");
            } else {
                book.setGenre("fantasy");
            }
            bookService.saveBook(book);
        }

        bookService.getAllBooks().forEach(System.out::println);
    }
}
