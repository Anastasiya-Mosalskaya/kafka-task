package com.kafkatask.controller;

import com.kafkatask.entity.BookEntity;
import com.kafkatask.producer.KafkaAvroProducer;
import com.kafkatask.schema.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private static final int GENRE_FIELD_INDEX = 3;
    private static final String GENRE_FIELD = "genre";

    @Autowired
    private KafkaAvroProducer producer;

    @PostMapping(value = "/sendBook")
    public void sendBook(@RequestBody BookEntity request) {
        Book book = Book.newBuilder()
                .setId(request.getId())
                .setName(request.getName())
                .setAuthor(request.getAuthor())
                .build();
        if (book.hasField(GENRE_FIELD) && request.getGenre() != null) {
            book.put(GENRE_FIELD_INDEX, request.getGenre());
        }
        producer.sendMessage(book);
    }
}
