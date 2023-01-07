package com.example.demo.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchAccountRequest {
  String accountName;
  List<String> ids;
  String accountType;
  Boolean isDisable = false;
}
