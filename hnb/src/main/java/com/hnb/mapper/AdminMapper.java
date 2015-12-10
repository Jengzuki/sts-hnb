package com.hnb.mapper;

import java.util.List;

import com.hnb.admin.AdminVO;


public interface AdminMapper {
	public List<AdminVO> selectAll();
	public int update(AdminVO member);

}
