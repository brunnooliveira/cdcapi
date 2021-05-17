package br.com.bgdo.cdcapi.bookdetail.book;

import org.springframework.web.bind.annotation.RestController;

import br.com.bgdo.cdcapi.bookdetail.Uploader;
import br.com.bgdo.cdcapi.bookdetail.author.AuthorRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class CrudBooksControllers {
  @Autowired
  private Uploader uploader;
  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private BookRepository bookRepository;

  @InitBinder
  public void initBinder(WebDataBinder webDataBinder) {
    webDataBinder.addValidators(new UniqueBookIsbnValidator(bookRepository),
        new UniqueBookTitleValidator(bookRepository));
  }

  @PostMapping(value = "/api/books")
  @Transactional
  public void newBook(@Valid NewBookForm form) {
    Book newBook = form.newBook(authorRepository, uploader);
    bookRepository.save(newBook);
  }

}
