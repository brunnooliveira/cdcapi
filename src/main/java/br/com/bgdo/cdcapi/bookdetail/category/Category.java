package br.com.bgdo.cdcapi.bookdetail.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  @Column(unique = true)
  private String name;

  @Deprecated
  public Category() {
  }

  public Category(String name) {
    super();
    this.name = name;
  }

}
