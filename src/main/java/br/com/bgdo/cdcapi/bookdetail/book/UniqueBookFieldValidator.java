package br.com.bgdo.cdcapi.bookdetail.book;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class UniqueBookFieldValidator implements Validator {

  protected abstract Optional<Book> findBookByField(NewBookForm form);

  protected abstract String getInvalidField();

  @Override
  public boolean supports(Class<?> clazz) {
    return NewBookForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    NewBookForm form = (NewBookForm) target;

    Optional<Book> possibleBook = findBookByField(form);

    if (possibleBook.isPresent()) {
      String invalidField = getInvalidField();
      errors.rejectValue(invalidField, "This " + invalidField + " already exists");
    }
  }

}
