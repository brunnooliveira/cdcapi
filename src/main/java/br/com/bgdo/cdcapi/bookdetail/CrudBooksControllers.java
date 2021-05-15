package br.com.bgdo.cdcapi.bookdetail;

import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class CrudBooksControllers {
  @Autowired
  private Uploader uploader;
  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private BookRepository bookRepository;

  @PostMapping(value = "/api/books")
  @Transactional
  public void newBook(@Valid NewBookForm form) {
    Book newBook = form.newBook(authorRepository, uploader);
    bookRepository.save(newBook);
  }

}
