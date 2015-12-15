package com.hnb.admin;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hnb.global.Command;
import com.hnb.global.CommandFactory;
import com.hnb.member.MemberServiceImpl;
import com.hnb.member.MemberVO;
import com.hnb.movie.MovieVO;



@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	MemberServiceImpl service;
	@Autowired
	MemberVO member;
	@Autowired
	MovieVO movie;
	@RequestMapping("/Admin")
	public String home(){
		logger.info("AdminController-home() 진입");
		return "admin/Admin";
	}
	@RequestMapping("/movie_list")
	public String movieList(){
		logger.info("AdminController-movieList() 진입");
		List<MovieVO> movieList= new ArrayList<MovieVO>();
		return "admin/movie_list";
	}
	@RequestMapping("/member_list")
	public Model memberList(Model model){
		logger.info("AdminController-memberList() 진입");
		List<MemberVO> list;
		Command command = CommandFactory.list("1");
		list = service.getList(command);
		model.addAttribute("memberList", list);
		return model;
	}
	@RequestMapping("/member_profile")
	public String memberProfile(){
		logger.info("AdminController-memberProfile() 진입");
		return "admin/member_profile";
	}
	@RequestMapping("/movie_profile")
	public String movieProfile(){
		logger.info("AdminController-movieProfile() 진입");
		return "admin/movie_profile";
	}
	@RequestMapping("/insert")
	public String insert(){
		logger.info("AdminController-insert() 진입");
		return "admin/insert";
	}
	@RequestMapping("/insert2")
	public String insert2(){
		logger.info("AdminController-insert2() 진입");
		return "admin/insert2";
	}
	@RequestMapping("/delete")
	public String delete(){
		logger.info("AdminController-detete() 진입");
		return "admin/delete";
	}
}
