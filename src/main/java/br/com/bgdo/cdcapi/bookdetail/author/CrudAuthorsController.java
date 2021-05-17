package br.com.bgdo.cdcapi.bookdetail.author;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudAuthorsController {

  @Autowired
  private AuthorRepository authorRepository;

  @PostMapping("/api/authors")
  @Transactional
  public void newAuthor(@Valid @RequestBody NewAuthorForm form) {
    Author newAuthor = form.newAuthor();
    authorRepository.save(newAuthor);
  }

}
