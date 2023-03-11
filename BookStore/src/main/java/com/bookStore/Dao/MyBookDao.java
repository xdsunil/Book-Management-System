package com.bookStore.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookStore.Entity.MyBookList;

@Repository
public interface MyBookDao extends JpaRepository<MyBookList, Integer> {
	

}
