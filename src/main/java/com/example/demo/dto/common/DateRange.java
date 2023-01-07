package com.example.demo.dto.common;
import java.time.LocalDateTime;

import com.example.demo.validator.FieldLessThan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@FieldLessThan(first = "fromValue", second = "toValue")
public class DateRange {
  LocalDateTime fromValue;
  LocalDateTime toValue;
}
