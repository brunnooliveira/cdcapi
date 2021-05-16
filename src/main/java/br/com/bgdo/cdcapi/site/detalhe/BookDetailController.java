package br.com.bgdo.cdcapi.site.detalhe;

import org.springframework.web.bind.annotation.RestController;

import br.com.bgdo.cdcapi.bookdetail.Book;
import br.com.bgdo.cdcapi.bookdetail.BookRepository;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class BookDetailController {

  @Autowired
  private BookRepository bookRepository;

  @GetMapping(value = "/api/books/{id}")
  public BookDetailDTO getBookDetail(@PathVariable("id") Long id) {

    Book book = bookRepository.findById(id).get();
    return new BookDetailDTO(book);
  }

  @PostMapping(value = "/api/cart/add-book/{id}")
  public String addBookToCart(@PathVariable("id") Long bookId, @CookieValue("cart") Optional<String> jsonCart,
      HttpServletResponse response) throws JsonProcessingException {
    Cart cart = jsonCart.map(json -> {
      try {
        return new ObjectMapper().readValue(json, Cart.class);
      } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
      }
    }).orElse(new Cart());
    cart.add(bookRepository.findById(bookId).get());
    Cookie cookie = new Cookie("cart", new ObjectMapper().writeValueAsString(cart));
    cookie.setHttpOnly(true);
    response.addCookie(cookie);
    return cart.toString();
  }

}
