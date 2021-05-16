package br.com.bgdo.cdcapi.site;

import br.com.bgdo.cdcapi.bookdetail.Book;

public class BookForHomeDTO {

  private String title;
  private Long id;
  private String authorName;

  public BookForHomeDTO(Book book) {
    this.title = book.getTitle();
    this.id = book.getId();
    this.authorName = book.getAuthor().getName();
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthorName() {
    return this.authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

}
