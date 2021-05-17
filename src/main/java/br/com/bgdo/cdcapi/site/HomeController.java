package br.com.bgdo.cdcapi.site;

import org.springframework.web.bind.annotation.RestController;

import br.com.bgdo.cdcapi.bookdetail.book.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {

  @Autowired
  private BookRepository bookRepository;

  @GetMapping(value = "/api/home")
  public List<BookForHomeDTO> listBooks() {
    return bookRepository.findAll().stream().map(BookForHomeDTO::new).collect(Collectors.toList());
  }

}
