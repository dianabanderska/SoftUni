package com.example.spring_data_advanced_queries_ex.service;

import com.example.spring_data_advanced_queries_ex.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    List<String> findAuthorFirstNameEndsWithStr(String endStr);

    List<String> findAllAuthorsAndTheirTotalCopies();
}
