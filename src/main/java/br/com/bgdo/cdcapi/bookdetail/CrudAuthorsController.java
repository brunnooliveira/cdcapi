package br.com.bgdo.cdcapi.bookdetail;

import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CrudAuthorsController {

  @PersistenceContext
  private EntityManager manager;

  @PostMapping("/api/author")
  @Transactional
  public void newAuthor(@Valid @RequestBody NewAuthorForm form) {
    Author newAuthor = form.newAuthor();
    manager.persist(newAuthor);
  }

}
