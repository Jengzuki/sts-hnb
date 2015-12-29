package com.hnb.schedule;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hnb.ticket.TicketVO;


@Controller
@RequestMapping("/ticket")
public class ScheduleController {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);
	
	@Autowired	ScheduleVO schedule;
	@Autowired 	ScheduleServiceImpl scheduleService;
	@Autowired  TicketVO ticket;
	
	List theaterList = new ArrayList();
	List dateList = new ArrayList();
	List timeList = new ArrayList();
	List movieSelectList = new ArrayList();
	List movieListRate = new ArrayList();
	List movieListAsc = new ArrayList();
	
	int result;
	

	@RequestMapping("/movieSelect")
	public Model movieSelect(String movie, String theater, String date,
			Model model){
		logger.info("TicketController-movieSelect()");
		
		
		if (theater==null && date!=null) {
			logger.info("movieSelect() : 극장널");
			theaterList = scheduleService.getTheaterListByMD(movie,date);
		} else if (theater!=null && date==null) {
			logger.info("movieSelect() : 날짜널");
			dateList = scheduleService.getShowDateListByMT(movie,theater);
		} else if (theater==null && date==null) {
			logger.info("movieSelect() : 다 널");
			theaterList = scheduleService.getTheaterListByM(movie);
			dateList = scheduleService.getShowDateListByM(movie);
		} else if (movie!=null&&theater!=null&&date!=null) {
			timeList = scheduleService.getTimeList(movie, theater, date);
		}
		logger.info("movieSelect() : 극장 : {}", theaterList);
		logger.info("movieSelect() : 날짜 : {}", dateList);
		movieSelectList.add(theaterList);
		movieSelectList.add(dateList);
		movieSelectList.add(timeList);
		model.addAttribute("movieCheckedList", movieSelectList);
		return model;
	}
	
	@RequestMapping("/theaterSelect")
	public Model theaterSelect(String movie, String theater, 
			String date, Model model){
		logger.info("TicketController-theaterSelect()");
		
		if (movie==null && date!=null) {
			movieListRate = scheduleService.getMovieRateByTD(theater,date);
			movieListAsc = scheduleService.getMovieAscByTD(theater,date);
		} else if (movie!=null && date==null) {
			dateList = scheduleService.getShowDateListByMT(movie, theater);
		} else if (movie==null && date==null) {
			movieListRate = scheduleService.getMovieRateByT(theater);
			movieListAsc = scheduleService.getMovieAscByT(theater);
			dateList = scheduleService.getShowDateListByT(theater);
		} else if (movie!=null&&theater!=null&&date!=null) {
			timeList = scheduleService.getTimeList(movie, theater, date);
		}
		List theaterSelectList = new ArrayList();
		theaterSelectList.add(movieListRate);
		theaterSelectList.add(movieListAsc);
		theaterSelectList.add(dateList);
		theaterSelectList.add(timeList);
		model.addAttribute("theaterCheckedList", theaterSelectList);
		return model;
	}
	
	@RequestMapping("/dateSelect")
	public Model dateSelect(String movie, String theater, String date,
			Model model){
		logger.info("TicketController-dateSelect()");
		List movieListRate = new ArrayList();
		List movieListAsc = new ArrayList();
		List theaterList = new ArrayList();
		List dateList = new ArrayList();
		List timeList = new ArrayList();
		
		if (movie==null && theater!=null) {
			movieListRate = scheduleService.getMovieRateByTD(theater,date);
			movieListAsc = scheduleService.getMovieAscByTD(theater,date);
		} else if (movie!=null && theater==null) {
			theaterList = scheduleService.getTheaterListByMD(movie,date);
		} else if (movie==null && theater==null) {
			movieListRate = scheduleService.getMovieRateByD(date);
			movieListAsc = scheduleService.getMovieAscByD(date);
			theaterList = scheduleService.getTheaterListByD(date);
		} else if (movie!=null&&theater!=null&&date!=null) {
			timeList = scheduleService.getTimeList(movie, theater, date);
		}
		List dateSelectList = new ArrayList();
		dateSelectList.add(movieListRate);
		dateSelectList.add(movieListAsc);
		dateSelectList.add(theaterList);
		dateSelectList.add(timeList);
		logger.info("dateSelect() : {} ",timeList);
		model.addAttribute("dateCheckedList", dateSelectList);
		return model;
	}
	
	@RequestMapping("/choiceseat")
	public Model choiceseat(
			@RequestParam("movie") String movie, 
			@RequestParam("theater") String theater, 
			@RequestParam("date") String date,
			@RequestParam("time") String time, 
			@RequestParam("filmNumber")String filmNumber, 
			Model model,
			int result){
		logger.info("TicketController-choiceseat()");
		filmNumber = scheduleService.getFilmNumberBy(movie);
		schedule.setFilmNumber(filmNumber);
		schedule.setTheaterName(theater);
		ticket.setDate(date);
		schedule.setRoomName(time.split(" ")[0]);
		ticket.setStartTime(time.split(" ")[1]);
		logger.info("choiceseat() {}", schedule.getFilmNumber());
		logger.info("choiceseat() {}", schedule.getTheaterName());
		logger.info("choiceseat() {}", ticket.getDate());
		logger.info("choiceseat() {}", schedule.getRoomName());
		logger.info("choiceseat() {}", ticket.getStartTime());
		
		if (result == 1) {
			model.addAttribute("result", "success");
		} else {
			model.addAttribute("result", "fail");
		}
		
		return model;
	}
	@RequestMapping("/initList")
	public Model initList(Model model){
		logger.info("TicketController-initList()");
		movieListRate = scheduleService.getRateList();
		movieListAsc = scheduleService.getAscList();
		theaterList = scheduleService.getTheaterList();
		dateList = scheduleService.getShowDateList();
		List initList = new ArrayList();
		initList.add(movieListAsc);
		initList.add(movieListAsc);
		initList.add(theaterList);
		initList.add(dateList);
		logger.info("initList() : {}", initList);
		model.addAttribute("totalInitList", initList);
		
		return model;
	}
	@RequestMapping("/Seats")
	public TicketVO seats(TicketVO ticket, String movie, String date, String time, Model model){
		logger.info("TicketController-seats()");
		model.addAttribute("movie", movie);
		model.addAttribute("date", date);
		model.addAttribute("time", ticket.getStartTime());
		return ticket;
	}
	
	
	@RequestMapping("/infoSave")
	public Model infoSave(
			@RequestParam("adult") String adult,			
			@RequestParam("old_man") String old_man,			
			@RequestParam("teenager") String teenager,			
			@RequestParam("price") String price,			
			@RequestParam("seat_number") String seat_number,
			Model model, int result
			){
		logger.info("TicketController-infoSave()");
		ticket.setAdult(Integer.parseInt(adult));
		ticket.setOldMan(Integer.parseInt(old_man));
		ticket.setTeenager(Integer.parseInt(teenager));
		ticket.setPrice(Integer.parseInt(price));
		ticket.setSeatNumber(seat_number);
		logger.info("infoSave() : {}", adult);
		logger.info("infoSave() : {}", old_man);
		logger.info("infoSave() : {}", teenager);
		logger.info("infoSave() : {}", seat_number);
		if (result == 1) {
			model.addAttribute("result", "success");
		} else {
			model.addAttribute("result", "fail");
		}
		
		return model;
	}
	
	@RequestMapping("/Confirm")
	public TicketVO confirm(String movie, String ticket, 
			Model model,TicketVO ticketVO){
		logger.info("TicketController-confirm()");
		model.addAttribute("movie", movie);
		model.addAttribute("ticket", ticketVO);
		return ticketVO;
	}
}
