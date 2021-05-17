package br.com.bgdo.cdcapi.bookdetail.book;

import java.util.Optional;

public class UniqueBookIsbnValidator extends UniqueBookFieldValidator {

  private BookRepository bookRepository;

  public UniqueBookIsbnValidator(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  protected Optional<Book> findBookByField(NewBookForm form) {
    return bookRepository.findByIsbn(form.getIsbn());
  }

  @Override
  protected String getInvalidField() {
    return "isbn";
  }
}
