package com.example.spring_data_advanced_queries_ex.service.impl;

import com.example.spring_data_advanced_queries_ex.model.entity.Author;
import com.example.spring_data_advanced_queries_ex.model.entity.Book;
import com.example.spring_data_advanced_queries_ex.repository.AuthorRepository;
import com.example.spring_data_advanced_queries_ex.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(AUTHORS_FILE_PATH))
                .forEach(row -> {
                    String[] fullName = row.split("\\s+");
                    Author author = new Author(fullName[0], fullName[1]);

                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1,
                        authorRepository.count() + 1);

        return authorRepository
                .findById(randomId)
                .orElseThrow();
    }

    @Override
    public List<String> getAllAuthorsOrderByCountOfTheirBooks() {
        return authorRepository
                .findAllByBooksSizeDESC()
                .stream()
                .map(author -> String.format("%s %s %d",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAuthorFirstNameEndsWithStr(String endStr) {
        return authorRepository.findAllByFirstNameEndingWith(endStr)
                .stream()
                .map(author -> String.format("%s %s",
                        author.getFirstName(),
                        author.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllAuthorsAndTheirTotalCopies() {
        return authorRepository
                .findAll()
                .stream()
                .map(author -> String.format("%s %s - %d",
                           author.getFirstName(),
                           author.getLastName(),
                           author.getBooks().stream().map(Book::getCopies)
                                   .reduce(Integer::sum)
                                   .orElse(0)))
                .collect(Collectors.toList());
    }
}
