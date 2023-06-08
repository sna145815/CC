package com.checki.checkclass.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.checki.checkclass.domain.CheckClass;

@Mapper
public interface CheckClassDao {

	   public List<CheckClass> find();

	   void insert(CheckClass checkSubClass);
	   
	   CheckClass findById(long idx);
}
