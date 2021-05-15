package br.com.bgdo.cdcapi.bookdetail;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UniqueBookTitleValidator implements Validator {

  private BookRepository bookRepository;

  public UniqueBookTitleValidator(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return NewBookForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    NewBookForm form = (NewBookForm) target;
    String title = form.getTitle();
    Optional<Book> possibleBook = bookRepository.findByTitle(title);
    if (possibleBook.isPresent()) {
      errors.rejectValue("title", "Title already exists");
    }
  }

}
