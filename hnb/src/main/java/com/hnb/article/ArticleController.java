package com.hnb.article;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnb.global.CommandFactory;

@Controller
@RequestMapping("/article")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired ArticleVO article;
	@Autowired ArticleServiceImpl articleService;
	
	@RequestMapping("/list/{pageNo}")
	public @ResponseBody List<ArticleVO> boardList(
			@PathVariable("pageNo")String pageNo,			
			Model model){
		logger.info("ArticleController-boardList()");
		logger.info("넘어온 페이지 번호 : {}",pageNo);
		List<ArticleVO> list = articleService.getList(CommandFactory.list(pageNo));
		/*model.addAttribute("memberList", list);
		model.addAttribute("count", service.count());
		model.addAttribute("pageNo", pageNo);*/
		return list;
	}
	
	@RequestMapping("/list")
	public String goList(
		){
		logger.info("ArticleController-goList()");
		return "event/boardList.tiles";
	}
	
	
	
}
