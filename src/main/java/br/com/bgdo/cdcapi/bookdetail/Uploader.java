package br.com.bgdo.cdcapi.bookdetail;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public interface Uploader {

  String upload(@NotNull MultipartFile cover);

}
