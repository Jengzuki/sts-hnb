package com.hnb.movie;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
		return "/movie/Movie";
	}
	
	@RequestMapping("/movie_info")
	public String movieInfo(Model model){
		logger.info("MovieController-movieInfo() 진입");
		List<MovieVO> list = service.getList();
		model.addAttribute("movieList", list);
		logger.info("영화 리스트 조회 결과 : {}", list);
		return "/movie/movie_info";
	}
	
	@RequestMapping("/movie_name/{movieName}")
	public String movieName(@PathVariable("movie_name")String name,Model model){
		logger.info("MovieController-movieName() 진입");
		logger.info("영화 아이디 : {}",name);
		movie = service.searchByName(name);
		logger.info("영화 제목 : {}",movie.getFilmName());
		model.addAttribute("movie", movie);
		return "/movie/movie_name";
	}
	
	@RequestMapping("/movie_Cut")
	public String movieCut(String filmNumber,Model model, String cut){
		logger.info("MovieController-파일넘버 : {}", filmNumber);
		movie = service.searchByName(filmNumber);
		cut = movie.getCut();
		String[]arr = cut.split("/");
		logger.info("트레일러 : {}", arr);
		model.addAttribute("arr[]", arr);
		logger.info("MovieController-movieCut() 진입");
		
		return "/movie/movie_Cut";
	}
	
	@RequestMapping("/movie_Tra")
	public String movieTra(String filmNumber,Model model){
		logger.info("MovieController-movieTra() 진입");
		movie = service.searchByName(filmNumber);
		logger.info("filmNumber : {}" ,filmNumber);
		String tra = movie.getTrailer();
		logger.info("트레일러 : {}", tra);
		String[]arrt = tra.split("/");
		logger.info("트레일러 : {}", arrt);
		model.addAttribute("arrt[]", arrt);
		
		return "/movie/movie_Tra";
	}
	
	@RequestMapping("/movie_Basic")
	public String movieBasic(String filmNumber, Model model){
		logger.info("MovieController-movieBasic() 진입");
		movie = service.searchByName(filmNumber);
		logger.info("MovieController-컷 영화제목 {}",movie.getFilmName());
		model.addAttribute("movie", movie);
		return "/movie/movie_Basic";
	}
	
	@RequestMapping("/movie_Chart")
	public String movieChart(){
		logger.info("MovieController-movieChart() 진입");
		List<MovieVO> list = service.getList();
		list = service.getList();
		return "/movie/movie_Chart";
	}
	
}
