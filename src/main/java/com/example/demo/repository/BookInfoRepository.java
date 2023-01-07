package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.BookInfo;

@Transactional
@Repository
public interface BookInfoRepository  extends JpaRepository<BookInfo, String>, JpaSpecificationExecutor<BookInfo>{

}
