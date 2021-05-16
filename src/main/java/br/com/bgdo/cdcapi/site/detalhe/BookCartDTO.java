package br.com.bgdo.cdcapi.site.detalhe;

import java.math.BigDecimal;

import br.com.bgdo.cdcapi.bookdetail.Book;

public class BookCartDTO {

  private String title;
  private BigDecimal price;
  private String linkBookCover;

  @Deprecated
  public BookCartDTO() {
    super();
  }

  public BookCartDTO(Book book) {
    title = book.getTitle();
    price = book.getPrice();
    linkBookCover = book.getLinkBookCover();
  }

  public String getTitle() {
    return title;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getLinkBookCover() {
    return linkBookCover;
  }

  @Override
  public String toString() {
    return "{" + " title='" + getTitle() + "'" + ", price='" + getPrice() + "'" + ", linkBookCover='"
        + getLinkBookCover() + "'" + "}";
  }

}
