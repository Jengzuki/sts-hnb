package com.hnb.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hnb.member.MemberService;
import com.hnb.member.MemberServiceImpl;


@Service
public class AdminServiceImpl implements AdminService{
	MemberService memberService;
	AdminDAO dao;
	@Override
	public List getMemberList() {
		List list = new ArrayList();
		return list;
	}
}
