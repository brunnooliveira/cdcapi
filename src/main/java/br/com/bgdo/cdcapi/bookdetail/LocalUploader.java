package br.com.bgdo.cdcapi.bookdetail;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class LocalUploader implements Uploader {

  @Override
  public String upload(@NotNull MultipartFile file) {
    System.out.println("sending file...");
    return "http://teste.com/" + file.getOriginalFilename();
  }

}
