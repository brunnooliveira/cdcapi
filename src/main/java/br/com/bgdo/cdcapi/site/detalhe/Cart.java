package br.com.bgdo.cdcapi.site.detalhe;

import java.util.ArrayList;
import java.util.List;

import br.com.bgdo.cdcapi.bookdetail.Book;

public class Cart {

  List<BookCartDTO> books = new ArrayList<>();

  @Deprecated
  public Cart() {
    super();
  }

  public void add(Book book) {
    books.add(new BookCartDTO(book));
  }

  public List<BookCartDTO> getBooks() {
    return books;
  }

  @Override
  public String toString() {
    return "{" + " books='" + books + "'" + "}";
  }

}
