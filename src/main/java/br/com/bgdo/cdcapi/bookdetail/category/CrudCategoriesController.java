package br.com.bgdo.cdcapi.bookdetail.category;

import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CrudCategoriesController {

  @Autowired
  private CategoryRepository categoryRepository;

  @InitBinder("newCategoryForm")
  public void init(WebDataBinder dataBinder) {
    dataBinder.addValidators(new UniqueCategoryNameValidator(categoryRepository));
  }

  @PostMapping(value = "/api/categories")
  @Transactional
  public void newCategory(@RequestBody @Valid NewCategoryForm form) {
    Category newCategory = new Category(form.getName());
    categoryRepository.save(newCategory);
  }

}
