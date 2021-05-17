package br.com.bgdo.cdcapi.site.detalhe;

import br.com.bgdo.cdcapi.bookdetail.author.Author;

public class BookAuthorDetailDTO {

  private String name;
  private String description;

  public BookAuthorDetailDTO(Author author) {
    name = author.getName();
    description = "add description here";
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}
