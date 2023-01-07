package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Borrow;
@Transactional
@Repository
public interface BorrowRepository  extends JpaRepository<Borrow, String>, JpaSpecificationExecutor<Borrow>{

}
