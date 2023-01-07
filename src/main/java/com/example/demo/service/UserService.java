package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.dto.CreateUserRequest;
import com.example.demo.dto.SearchUserInfoRequest;
import com.example.demo.dto.UpdateUserInfoRequest;
import com.example.demo.dto.UserInfoDto;
import com.example.demo.dto.common.PatchRequest;
import com.example.demo.exception.LBRException;


public interface UserService {

	UserInfoDto findById(String id) throws LBRException;

	Page<UserInfoDto> findAll(Pageable pageable);

	String delete(List<String> ids) throws LBRException;

	UserInfoDto create(@Valid CreateUserRequest account);

	UserInfoDto update(String id, @Valid PatchRequest<UpdateUserInfoRequest> request) throws LBRException;

	Page<UserInfoDto> violate(Pageable pageable);

	Page<UserInfoDto> advanceSearch(@Valid SearchUserInfoRequest searchRequest, Pageable pageable);

}
