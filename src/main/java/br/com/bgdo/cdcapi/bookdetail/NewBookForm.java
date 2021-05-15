package br.com.bgdo.cdcapi.bookdetail;

import java.math.BigDecimal;
import java.util.function.Function;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class NewBookForm {

  @NotBlank
  @Size(max = 100)
  private String title;
  @NotBlank
  @Size(max = 50)
  private String subTitle;
  @Min(20)
  private BigDecimal price;
  @NotBlank
  private String content;
  @NotBlank
  private String sumary;
  @Min(100)
  private int numPages;
  @NotBlank
  private String isbn;
  @NotNull
  private MultipartFile cover;
  @NotNull
  private Long authorId;

  public String getTitle() {
    return this.title;
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

  public MultipartFile getCover() {
    return this.cover;
  }

  public void setCover(MultipartFile cover) {
    this.cover = cover;
  }

  public Long getAuthorId() {
    return this.authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

  public Book newBook(AuthorRepository authorRepository, Uploader uploader) {
    Author author = authorRepository.findById(authorId).get();
    String linkBookCover = uploader.upload(cover);
    return new Book(title, subTitle, price, content, sumary, numPages, isbn, linkBookCover, author);
  }

}
