package com.example.spring_data_advanced_queries_ex.service.impl;

import com.example.spring_data_advanced_queries_ex.model.entity.*;
import com.example.spring_data_advanced_queries_ex.repository.BookRepository;
import com.example.spring_data_advanced_queries_ex.service.AuthorService;
import com.example.spring_data_advanced_queries_ex.service.BookService;
import com.example.spring_data_advanced_queries_ex.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
        return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllTitlesByAgeRestriction(AgeRestriction ageRestriction) {
        return bookRepository.findByAgeRestriction(ageRestriction);
    }

    @Override
    public List<String> findAllGoldBookTitlesWithCopiesLessThan5000() {
        return bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBookTitlesWithPriceLessThan5OrMoreThan40() {
        return bookRepository.findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .stream()
                .map(book -> String.format("%s - $ %.2f",
                        book.getTitle(), book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findNotReleasedBookTitlesInYear(int year) {
        LocalDate lower = LocalDate.of(year, 1, 1);
        LocalDate upper = LocalDate.of(year, 12, 31);

        return bookRepository
                .findAllByReleaseDateBeforeOrReleaseDateAfter(lower, upper)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksBeforeDate(LocalDate localDate) {
        return bookRepository.findAllByReleaseDateBefore(localDate)
                .stream()
                .map(book -> String.format("%s %s %.2f",
                        book.getTitle(),
                        book.getEditionType().name(),
                        book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBookTitlesWhereTitleContainsStr(String str) {
        return bookRepository.findByTitleContains(str)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllTitlesWithAuthorLastNameStartsWith(String startStr) {
        return bookRepository.findAllByAuthor_LastNameStartsWith(startStr)
                .stream()
                .map(book -> String.format("%s (%s %s)",
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public int findCountOfBooksWithTitleLengthLongerThan(int titleLength) {
        return bookRepository.countOfBooksWithTitleLengthMoreThan(titleLength);
    }

    @Override
    public List<String> findBookInfoByTitle(String title) {
        return bookRepository.findAllByTitleIs(title)
                .stream()
                .map(book -> String.format("%s %s %s %.2f",
                        book.getTitle(),
                        book.getEditionType().name(),
                        book.getAgeRestriction().name(),
                        book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public void changePrice(long bookId) {
       bookRepository.changeBookPriceById(bookId);
    }

    @Override
    @Transactional
    public int increaseCopiesByDate(LocalDate localDate, int copies) {
       int affectedRows = bookRepository.updateCopiesByReleaseDate(copies, localDate);

       return affectedRows * copies;
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
