package com.checki.checkitem.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.checki.checkitem.domain.CheckItem;
import com.checki.checkitem.domain.CheckItemPlus;

@Mapper 
public interface CheckItemDao {

	void insert(CheckItem  checkItem);
	
	public List<CheckItemPlus> find();
}
