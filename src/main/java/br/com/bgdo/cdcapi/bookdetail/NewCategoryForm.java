package br.com.bgdo.cdcapi.bookdetail;

import javax.validation.constraints.NotBlank;

public class NewCategoryForm {

  @NotBlank
  private String name;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
