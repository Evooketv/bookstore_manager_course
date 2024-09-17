package com.rodrigopeleias.bookstoremanager.service;

import com.rodrigopeleias.bookstoremanager.dto.MessageResponseDTO;
import com.rodrigopeleias.bookstoremanager.entity.Book;
import com.rodrigopeleias.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        // Verifica se todos os campos obrigatórios são preenchidos
        if (book.getChapters() == null) {
            throw new IllegalArgumentException("Chapters field cannot be null");
        }
        return bookRepository.save(book);
    }
    public MessageResponseDTO create(Book book) {
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder().
                message("Book create with ID" + savedBook.getId())
                .build();

    }

}
