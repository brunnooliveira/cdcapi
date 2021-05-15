package br.com.bgdo.cdcapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ControllerTest {

  @GetMapping(value = "api/test")
  public String teste() {
    return "up and running... ";
  }

}
