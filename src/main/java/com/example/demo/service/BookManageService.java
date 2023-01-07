package com.example.demo.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.dto.AdvanceSearchBookRequest;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.CreateBookRequest;
import com.example.demo.dto.UpdateBookRequest;
import com.example.demo.dto.common.PatchRequest;
import com.example.demo.exception.LBRException;


public interface BookManageService {

	BookDto create(CreateBookRequest request);

	BookDto update(String id, PatchRequest<UpdateBookRequest> request) throws LBRException;

	Page<BookDto> findAll(Pageable pageable);

	BookDto findById(String id) throws LBRException;

	String delete(String id) throws LBRException;

	Page<BookDto> advanceSearch(@Valid AdvanceSearchBookRequest searchRequest, Pageable pageable);

}
