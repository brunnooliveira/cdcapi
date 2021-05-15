package br.com.bgdo.cdcapi.bookdetail;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.URL;

@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private @NotBlank String name;
  private @NotBlank @URL String githubLink;
  @PastOrPresent
  private LocalDateTime createdAt = LocalDateTime.now();

  @Deprecated
  public Author() {
    super();
  }

  public Author(@NotBlank String name, @NotBlank @URL String githubLink) {
    super();
    this.name = name;
    this.githubLink = githubLink;
  }

  @Override
  public String toString() {
    return "{" + " name='" + name + "'" + ", githubLink='" + githubLink + "'" + ", createdAt='" + createdAt + "'" + "}";
  }

}
