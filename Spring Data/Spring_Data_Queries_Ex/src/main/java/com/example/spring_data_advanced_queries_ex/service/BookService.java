package com.example.spring_data_advanced_queries_ex.service;

import com.example.spring_data_advanced_queries_ex.model.entity.AgeRestriction;
import com.example.spring_data_advanced_queries_ex.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllTitlesByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllGoldBookTitlesWithCopiesLessThan5000();

    List<String> findAllBookTitlesWithPriceLessThan5OrMoreThan40();

    List<String> findNotReleasedBookTitlesInYear(int year);

    List<String> findAllBooksBeforeDate(LocalDate localDate);

    List<String> findAllBookTitlesWhereTitleContainsStr(String str);

    List<String> findAllTitlesWithAuthorLastNameStartsWith(String startStr);

    int findCountOfBooksWithTitleLengthLongerThan(int titleLength);

    List<String> findBookInfoByTitle(String title);

    void changePrice(long bookId);

    int increaseCopiesByDate(LocalDate localDate, int copies);
}
