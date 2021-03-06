package br.com.bgdo.cdcapi.bookdetail.book;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import br.com.bgdo.cdcapi.bookdetail.author.Author;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private @NotBlank @Size(max = 100) String title;
  private @NotBlank @Size(max = 50) String subTitle;
  private @Min(20) BigDecimal price;
  private @NotBlank String content;
  private @NotBlank String sumary;
  private @Min(100) int numPages;
  private @NotBlank String isbn;
  private @NotBlank @URL String linkBookCover;
  @ManyToOne
  private @NotNull Author author;

  @Deprecated
  public Book() {
  }

  public Book(@NotBlank @Size(max = 100) String title, @NotBlank @Size(max = 50) String subTitle,
      @Min(20) BigDecimal price, @NotBlank String content, @NotBlank String sumary, @Min(100) int numPages,
      @NotBlank String isbn, @NotBlank @URL String linkBookCover, @NotNull Author author) {
    this.title = title;
    this.subTitle = subTitle;
    this.price = price;
    this.content = content;
    this.sumary = sumary;
    this.numPages = numPages;
    this.isbn = isbn;
    this.linkBookCover = linkBookCover;
    this.author = author;
  }

  @Override
  public String toString() {
    return "{" + " title='" + title + "'" + ", subTitle='" + subTitle + "'" + ", price='" + price + "'" + ", content='"
        + content + "'" + ", sumary='" + sumary + "'" + ", numPages='" + numPages + "'" + ", isbn='" + isbn + "'"
        + ", linkBookCover='" + linkBookCover + "'" + ", author='" + author + "'" + "}";
  }

  public String getTitle() {
    return title;
  }

  public Long getId() {
    return id;
  }

  public Author getAuthor() {
    return author;
  }

  public String getSubTitle() {
    return subTitle;
  }

  public String getLinkBookCover() {
    return linkBookCover;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getContent() {
    return content;
  }

  public String getSumary() {
    return sumary;
  }

  public int getNumPages() {
    return numPages;
  }

  public String getIsbn() {
    return isbn;
  }

}
