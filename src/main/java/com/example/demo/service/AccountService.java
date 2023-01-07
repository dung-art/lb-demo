package com.example.demo.service;
import java.lang.reflect.InvocationTargetException;

import javax.validation.Valid;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.CreateAccountRequest;
import com.example.demo.dto.SearchAccountRequest;
import com.example.demo.dto.UpdateAccountRequest;
import com.example.demo.dto.common.PatchRequest;
import com.example.demo.entity.Account;
import com.example.demo.exception.LBRException;



public interface AccountService{

//	JwtResponse generateJwtToken(String Authorization, String accountName)
//			throws UsernameNotFoundException, LBRException, Exception;

	AccountDto findAccountByAccountName(String accountName) throws LBRException;

	Account findByAccountName(String accountName) throws NotFoundException;

	Account create(@Valid CreateAccountRequest accountRequest) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException;

	String deleteById(String id) throws LBRException;

	void setActive(String id, boolean isActive) throws LBRException;

//	String updatePassword(@Valid UpdatePasswordRequest request) throws NotFoundException;
//
//	void resetPassword(@Valid ResetPasswordRequest request) throws NotFoundException;
//
//	String revokeToken(String token) throws NotFoundException;

	Page<AccountDto> findAllAccount(Pageable pageable);

	Account findById(String id) throws LBRException;

	Object update(String id, @Valid PatchRequest<UpdateAccountRequest> request) throws LBRException;

	Page<AccountDto> advanceSearch(@Valid SearchAccountRequest searchRequest, Pageable pageable);

	void newAcc();


}