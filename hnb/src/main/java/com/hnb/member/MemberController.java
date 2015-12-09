package com.hnb.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberVO member;
	@Autowired
	MemberServiceImpl service;
	
	@RequestMapping("/admin_home")
	public @ResponseBody MemberVO adminHome(){
		logger.info("MemberController-adminHome()");
		logger.info("adminHome() : 어드민 홈 입장");
		return member;
	}
	
	@RequestMapping("provision")
	public @ResponseBody MemberVO provision(){
		logger.info("MemberController-provision()");
		return member;
	}
	
	@RequestMapping("/join_member")
	public @ResponseBody MemberVO joinMember(Model model, 
		String id, String password, String name, String birth, String addr, 
		String gender, String email, String phone, int result){
		logger.info("MemberController-joinMember()");
		id = member.getId();
		password = member.getPassword();
		name = member.getName();
		birth = member.getBirth();
		addr = member.getAddr();
		gender = member.getGender();
		email = member.getEmail();
		phone = member.getPhone();
		logger.info("joinMember() : 조인_멤버로 들어옴!");
		logger.info("joinMember() : 가입 ID : {}", id);
		logger.info("joinMember() : 가입 패스워드 : {}", password);
		logger.info("joinMember() : 가입 이름 : {}", name);
		logger.info("joinMember() : 가입 생년 : {}", birth);
		logger.info("joinMember() : 가입 주소 : {}", addr);
		logger.info("joinMember() : 가입 성별 : {}", gender);
		logger.info("joinMember() : 가입 이메일 : {}", email);
		logger.info("joinMember() : 가입 전화번호 : {}", phone);
		
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setBirth(birth);
		member.setAddr(addr);
		member.setGender(gender);
		member.setEmail(email);
		member.setPhone(phone);
		
		result = service.join(member);
		if (result == 1 ) {
			logger.info("joinMember() : 회원가입 성공!!!");
			model.addAttribute("result", "success");
			model.addAttribute("name", member.getName());
		} else {
			logger.info("joinMember() : 가입 실패");
			model.addAttribute("result", "fail");
		}
		
		return member;
	}
	
	@RequestMapping("/join_Result")
	public @ResponseBody MemberVO joinResult(Model model){
		logger.info("MemberController-joinResult()");
		return member;
	}
	
	@RequestMapping("logout")
	public @ResponseBody MemberVO logout(Model model){
		logger.info("MemberController-logout()");
		logger.info("logout() : 로그아웃 진입");
		model.addAttribute("result", "success");
		return member;
	}
	
	@RequestMapping("login")
	public Model login(
			String id, String password, Model model
			){
		logger.info("MemberController-login()");
		logger.info("login() : 로그인 진입");
		logger.info("login() : 유저 아이디 : {}");
		logger.info("login() : 유저 비번 : {}");
		member = service.login(id, password);
		if (member==null) {
			model.addAttribute("result", "fail");
		} else {
			model.addAttribute("result", "success");
			model.addAttribute("id", id);
			model.addAttribute("pw", password);
			if (id.equals("choa")) {
				model.addAttribute("admin","yes");
			} else {
				model.addAttribute("admin","no");
			}
		}
		return model;
	}
	
	@RequestMapping("/check_Overlap")
	public Model checkOverlap(String id, Model model){
		logger.info("MemberController-checkOverlap()");
		logger.info("checkOverlap() : 컨트롤러 / 중복체크로 진입");
		if (service.selectById(id).getId() == null) {
			model.addAttribute("result", "usable");
			model.addAttribute("id", id);
			
		} else {
			model.addAttribute("result", "unusable");
			model.addAttribute("id", id);
		}
		return model;
	}
	
	@RequestMapping("/mypage")
	public @ResponseBody MemberVO mypage(Model model){
		logger.info("MemberController-mypage()");
		return member;
	}
	
	@RequestMapping("/detail")
	public @ResponseBody MemberVO detail(Model model){
		logger.info("MemberController-detail()");
		return member;
	}
}
