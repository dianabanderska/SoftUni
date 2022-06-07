package com.example.spring_data_advanced_queries_ex.repository;

import com.example.spring_data_advanced_queries_ex.model.entity.AgeRestriction;
import com.example.spring_data_advanced_queries_ex.model.entity.Book;
import com.example.spring_data_advanced_queries_ex.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    @Query("SELECT b.title FROM Book b WHERE b.ageRestriction = :ageRestriction")
    List<String> findByAgeRestriction(
         @Param(value = "ageRestriction") AgeRestriction restriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate lower, LocalDate upper);

    List<Book> findByTitleContains(String contStr);

    List<Book> findAllByAuthor_LastNameStartsWith(String startStr);

    @Query("SELECT COUNT(b) FROM Book b WHERE length(b.title) > :param ")
    int countOfBooksWithTitleLengthMoreThan(@Param(value = "param") int titleLength);

    List<Book> findAllByTitleIs(String title);

    @Procedure("change_book_price_by_id")
    void changeBookPriceById(Long book_id);

    @Modifying
    @Query("UPDATE Book b SET b.copies = b.copies + :copies WHERE b.releaseDate > :date")
    int updateCopiesByReleaseDate(@Param(value = "copies") int copies,
                                  @Param(value = "date") LocalDate localDate);
}
