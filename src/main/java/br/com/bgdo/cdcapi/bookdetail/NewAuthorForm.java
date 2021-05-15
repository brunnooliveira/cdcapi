package br.com.bgdo.cdcapi.bookdetail;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

public class NewAuthorForm {
  @NotBlank
  private String name;
  @NotBlank
  @URL
  private String githubLink;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGithubLink() {
    return this.githubLink;
  }

  public void setGithubLink(String githubLink) {
    this.githubLink = githubLink;
  }

  public Author newAuthor() {
    return new Author(name, githubLink);
  }

}
