package com.example.demo.dto.common;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.validator.FieldExists;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@FieldExists(dataFieldName = "data", listFieldName = "updateFields")
public class PatchRequest<T> {
  @NotNull
  T data;

  @NotNull
  @Size(min = 1)
  List<String> updateFields;
}
