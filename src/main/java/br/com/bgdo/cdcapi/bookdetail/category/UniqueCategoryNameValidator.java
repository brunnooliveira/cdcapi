package br.com.bgdo.cdcapi.bookdetail.category;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UniqueCategoryNameValidator implements Validator {

  private CategoryRepository categoryRepository;

  public UniqueCategoryNameValidator(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return NewCategoryForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    NewCategoryForm form = (NewCategoryForm) target;
    Optional<Category> possibleCategory = categoryRepository.findByName(form.getName());
    if (possibleCategory.isPresent()) {
      errors.rejectValue("name", null, "Category name already exists");
    }
  }

}
