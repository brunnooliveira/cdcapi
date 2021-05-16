package br.com.bgdo.cdcapi.site.detalhe;

import java.math.BigDecimal;

import br.com.bgdo.cdcapi.bookdetail.Book;

public class BookDetailDTO {

  private String title;
  private String subTitle;
  private BigDecimal price;
  private String content;
  private String sumary;
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
    sumary = book.getSumary();
    author = new BookAuthorDetailDTO(book.getAuthor());
    numPages = book.getNumPages();
    isbn = book.getIsbn();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubTitle() {
    return this.subTitle;
  }

  public void setSubTitle(String subTitle) {
    this.subTitle = subTitle;
  }

  public BigDecimal getPrice() {
    return this.price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getSumary() {
    return this.sumary;
  }

  public void setSumary(String sumary) {
    this.sumary = sumary;
  }

  public int getNumPages() {
    return this.numPages;
  }

  public void setNumPages(int numPages) {
    this.numPages = numPages;
  }

  public String getIsbn() {
    return this.isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public BookAuthorDetailDTO getAuthor() {
    return this.author;
  }

  public void setAuthor(BookAuthorDetailDTO author) {
    this.author = author;
  }

}
