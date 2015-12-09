package com.hnb.admin;

import java.util.List;


public interface AdminDAO {
	public List<AdminVO> selectAll();
	public int update(AdminVO member);

}
