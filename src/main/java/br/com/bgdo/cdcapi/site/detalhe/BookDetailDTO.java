package br.com.bgdo.cdcapi.site.detalhe;

import java.math.BigDecimal;

import br.com.bgdo.cdcapi.bookdetail.Book;
import br.com.bgdo.cdcapi.shared.Markdown;

public class BookDetailDTO {

  private String title;
  private String subTitle;
  private BigDecimal price;
  private String content;
  private String originalSumary;
  private String htmlSumary;
  private int numPages;
  private String isbn;
  private BookAuthorDetailDTO author;
  private Long id;

  public BookDetailDTO(Book book) {
    id = book.getId();
    title = book.getTitle();
    subTitle = book.getSubTitle();
    price = book.getPrice();
    content = book.getContent();
    originalSumary = book.getSumary();
    htmlSumary = Markdown.renderHtml(book.getSumary());
    author = new BookAuthorDetailDTO(book.getAuthor());
    numPages = book.getNumPages();
    isbn = book.getIsbn();
  }

  public Long getId() {
    return this.id;
  }

  public String getTitle() {
    return title;
  }

  public String getSubTitle() {
    return this.subTitle;
  }

  public BigDecimal getPrice() {
    return this.price;
  }

  public String getContent() {
    return this.content;
  }

  public String getOriginalSumary() {
    return this.originalSumary;
  }

  public String getHtmlSumary() {
    return this.htmlSumary;
  }

  public int getNumPages() {
    return this.numPages;
  }

  public String getIsbn() {
    return this.isbn;
  }

  public BookAuthorDetailDTO getAuthor() {
    return this.author;
  }

}
