package br.com.bgdo.cdcapi.bookdetail;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UniqueBookIsbnValidator implements Validator {

  private BookRepository bookRepository;

  public UniqueBookIsbnValidator(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return NewBookForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    NewBookForm form = (NewBookForm) target;
    String isbn = form.getIsbn();
    Optional<Book> possibleBook = bookRepository.findByIsbn(isbn);
    if (possibleBook.isPresent()) {
      errors.rejectValue("isbn", "ISBN already exists");
    }
  }
}
