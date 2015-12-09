package com.hnb.movie;

import java.util.List;

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
@RequestMapping("/movie")
public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	MovieServiceImpl service;
	@Autowired
	MovieVO movie;
	
	@RequestMapping("/Movie")
	public String movie(){
		logger.info("MovieController-movie() 진입");
		return "/movie/Movie.tiles";
	}
	
	@RequestMapping("/movie_info")
	public Model movieInfo(Model model){
		logger.info("MovieController-movieInfo() 진입");
		List<MovieVO> list = service.getList();
		model.addAttribute("movieList", list);
		logger.info("영화 리스트 조회 결과 : {}", list);
		return model;
	}
	
	@RequestMapping("/movie_name/{movieName}")
	public @ResponseBody MovieVO movieName(
			@PathVariable("movie_name")String name,Model model){
		logger.info("MovieController-movieName()");
		logger.info("movieName :영화 아이디 : {}",name);
		movie = service.searchByName(name);
		logger.info("movieName :영화 제목 : {}",movie.getFilmName());
		return movie;
	}
	
	@RequestMapping("/movie_Cut")
	public Model movieCut(
			String filmNumber,Model model, String cut){
		logger.info("movieCut : 파일넘버 : {}", filmNumber);
		movie = service.searchByName(filmNumber);
		cut = movie.getCut();
		String[]arr = cut.split("/");
		logger.info("movieCut : 트레일러 : {}", arr);
		model.addAttribute("arr[]", arr);
		logger.info("MovieController-movieCut()");
		
		return model;
	}
	
	@RequestMapping("/movie_Tra")
	public Model movieTra(String filmNumber,Model model){
		logger.info("MovieController-movieTra() ");
		movie = service.searchByName(filmNumber);
		logger.info("movieTra : filmNumber : {}" ,filmNumber);
		String tra = movie.getTrailer();
		logger.info("movieTra : 트레일러 : {}", tra);
		String[]arrt = tra.split("/");
		logger.info("movieTra : 트레일러 : {}", arrt);
		model.addAttribute("arrt[]", arrt);
		
		return model;
	}
	
	@RequestMapping("/movie_Basic")
	public @ResponseBody MovieVO movieBasic
	(String filmNumber, Model model){
		logger.info("MovieController-movieBasic() ");
		movie = service.searchByName(filmNumber);
		logger.info("movieBasic -컷 영화제목 {}",movie.getFilmName());
		return movie;
	}
	
	@RequestMapping("/movie_Chart")
	public Model movieChart(Model model){
		logger.info("MovieController-movieChart()");
		List<MovieVO> list = service.getList();
		list = service.getList();
		model.addAttribute("movieList2", list);
		return model;
	}
	
}
