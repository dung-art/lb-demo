package com.example.demo.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.dto.AdvanceSearchBookInfoRequest;
import com.example.demo.dto.BookInfoDto;
import com.example.demo.dto.CreateBookInfoRequest;
import com.example.demo.dto.UpdateBookRequest;
import com.example.demo.dto.common.PatchRequest;
import com.example.demo.exception.LBRException;


public interface BookService {
	Page<BookInfoDto> findAll(Pageable pageable);

	BookInfoDto findById(String id) throws LBRException;

	Page<BookInfoDto> advanceSearch(@Valid AdvanceSearchBookInfoRequest searchRequest, Pageable pageable);

	Page<BookInfoDto> viewNewBook(Pageable pageable);

	BookInfoDto create(CreateBookInfoRequest request);

	BookInfoDto update(String id, PatchRequest<UpdateBookRequest> patchRequest) throws LBRException;

	String delete(String id) throws LBRException;
}
