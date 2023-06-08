package com.checki.checkgroup.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.checki.checkgroup.domain.CheckGroup;
import com.checki.checkgroup.domain.CheckMst;

@Mapper 
public interface CheckGroupDao {

	void insert(CheckGroup checkgroup);
	
	long findById(String tagid);

	void cminsert(CheckMst cm);

	public List<CheckGroup> find();
}
