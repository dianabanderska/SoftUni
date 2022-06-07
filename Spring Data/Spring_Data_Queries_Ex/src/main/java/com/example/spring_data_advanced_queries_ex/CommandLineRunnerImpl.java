package com.example.spring_data_advanced_queries_ex;

import com.example.spring_data_advanced_queries_ex.model.entity.AgeRestriction;
import com.example.spring_data_advanced_queries_ex.model.entity.Book;
import com.example.spring_data_advanced_queries_ex.service.AuthorService;
import com.example.spring_data_advanced_queries_ex.service.BookService;
import com.example.spring_data_advanced_queries_ex.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        printAllBooksAfterYear(2000);
        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        printAllAuthorsAndNumberOfTheirBooks();
        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
        printAllBooksTitlesByAgeRest();
        printAllGoldBookTitlesWithCopiesLessThan5000();
        printBooksByPrice();
        printNotReleasedBooks();
        printBooksReleasedBefore();
        printAuthorSearch();
        printBookSearch();
        printBooksTitleSearch();
        printCountBooks();
        printTotalBooksCopies();
        printBookInfoByGivenTitle();
        changePrice();
        printIncreasedBookCopies();
    }

    private void printIncreasedBookCopies() throws IOException {
        System.out.println("Enter date in format: dd MMM yyyy");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(),
                DateTimeFormatter.ofPattern("dd MMM yyyy"));
        System.out.println("Enter copies: ");
        int copies = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bookService.increaseCopiesByDate(localDate, copies));
    }

    private void changePrice() {
        bookService.changePrice(1L);
    }

    private void printBookInfoByGivenTitle() throws IOException {
        System.out.println("Enter title: ");
        String title = bufferedReader.readLine();

        bookService.findBookInfoByTitle(title)
                .forEach(System.out::println);
    }

    private void printTotalBooksCopies() {
        authorService.findAllAuthorsAndTheirTotalCopies()
                .forEach(System.out::println);
    }

    private void printCountBooks() throws IOException {
        System.out.println("Enter title length: ");
        int titleLength = Integer.parseInt(bufferedReader.readLine());

        System.out.println(bookService.findCountOfBooksWithTitleLengthLongerThan(titleLength));
    }

    private void printBooksTitleSearch() throws IOException {
        System.out.println("Enter Author last name starts with str: ");
        String startStr = bufferedReader.readLine();

        bookService.findAllTitlesWithAuthorLastNameStartsWith(startStr)
                .forEach(System.out::println);
    }

    private void printBookSearch() throws IOException {
        System.out.println("Enter containing str: ");
        String str = bufferedReader.readLine();

        bookService.findAllBookTitlesWhereTitleContainsStr(str)
                .forEach(System.out::println);
    }

    private void printAuthorSearch() throws IOException {
        System.out.println("Enter first name ends with string: ");
        String endStr = bufferedReader.readLine();

        authorService.findAuthorFirstNameEndsWithStr(endStr)
                .forEach(System.out::println);
    }

    private void printBooksReleasedBefore() throws IOException {
        System.out.println("Enter date in format dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        bookService.findAllBooksBeforeDate(localDate)
                .forEach(System.out::println);
    }

    private void printNotReleasedBooks() throws IOException {
        System.out.println("Enter year: ");
        int year = Integer.parseInt(bufferedReader.readLine());

        bookService.findNotReleasedBookTitlesInYear(year)
                .forEach(System.out::println);
    }

    private void printBooksByPrice() {
        bookService.findAllBookTitlesWithPriceLessThan5OrMoreThan40()
                .forEach(System.out::println);
    }

    private void printAllGoldBookTitlesWithCopiesLessThan5000() {
        bookService.findAllGoldBookTitlesWithCopiesLessThan5000()
                .forEach(System.out::println);
    }

    private void printAllBooksTitlesByAgeRest() throws IOException {
        System.out.println("Enter Age Restriction: ");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toLowerCase());

        bookService.findAllTitlesByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
