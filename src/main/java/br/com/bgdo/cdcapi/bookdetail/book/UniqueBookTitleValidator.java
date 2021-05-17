package br.com.bgdo.cdcapi.bookdetail.book;

import java.util.Optional;

public class UniqueBookTitleValidator extends UniqueBookFieldValidator {

  private BookRepository bookRepository;

  public UniqueBookTitleValidator(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Optional<Book> findBookByField(NewBookForm form) {
    return bookRepository.findByTitle(form.getTitle());
  }

  @Override
  protected String getInvalidField() {
    return "title";
  }
}
