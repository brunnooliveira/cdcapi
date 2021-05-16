package br.com.bgdo.cdcapi.site.detalhe;

import org.springframework.web.bind.annotation.RestController;

import br.com.bgdo.cdcapi.bookdetail.Book;
import br.com.bgdo.cdcapi.bookdetail.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class BookDetailController {

  @Autowired
  private BookRepository bookRepository;

  @GetMapping(value = "/api/livros/{id}")
  public BookDetailDTO getBookDetail(@PathVariable("id") Long id) {

    Book book = bookRepository.findById(id).get();
    return new BookDetailDTO(book);
  }

}
