package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.demo.constant.BookConditionEnum;
import com.example.demo.constant.BookStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Book")
@Table(name = "lb_book")
@NoArgsConstructor
@AllArgsConstructor
public class Book extends EntityBase{

	private static final long serialVersionUID = 1L;

	@Column(name = "book_info_id", insertable = true)
	@NotNull
	private String bookInfoId;
//
//	@Column(name = "book_code", insertable = true)
//	@NotNull
//	private String bookCode;

	@Column(name = "book_condition", insertable = true)
	@NotNull
	private BookConditionEnum bookCondition; // tình trạng sách

	@Column(name = "status")
	@NotNull
	private BookStatusEnum status;
}
