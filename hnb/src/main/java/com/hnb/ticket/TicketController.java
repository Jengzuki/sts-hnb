package com.hnb.ticket;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/ticket")
public class TicketController {
	private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
	
	@Autowired
	TicketVO ticketVO;
	@Autowired
	TicketService ticketService;
	
	@RequestMapping("/Ticket")
	public String ticket(){
		logger.info("TicketController-ticket()");
		return "/ticket/Ticket";
	}
	
	@RequestMapping("/movieSelect")
	public Model movieSelect(String movie, String theater, String date,
			Model model){
		logger.info("TicketController-movieSelect()");
		List theaterList = new ArrayList();
		List dateList = new ArrayList();
		List timeList = new ArrayList();
		
		if (theater==null && date!=null) {
			logger.info("movieSelect() : 극장널");
			theaterList = ticketService.getTheaterListByMD(movie,date);
		} else if (theater!=null && date==null) {
			logger.info("movieSelect() : 날짜널");
			dateList = ticketService.getShowDateListByMT(movie,theater);
		} else if (theater==null && date==null) {
			logger.info("movieSelect() : 다 널");
			theaterList = ticketService.getTheaterListByM(movie);
			dateList = ticketService.getShowDateListByM(movie);
		} else if (movie!=null&&theater!=null&&date!=null) {
			timeList = ticketService.getTimeList(movie, theater, date);
		}
		logger.info("movieSelect() : 극장 : {}", theaterList);
		logger.info("movieSelect() : 날짜 : {}", dateList);
		List movieSelectList = new ArrayList();
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
		List movieListRate = new ArrayList();
		List movieListAsc = new ArrayList();
		List theaterList = new ArrayList();
		List dateList = new ArrayList();
		List timeList = new ArrayList();
		if (movie==null && date!=null) {
			movieListRate = ticketService.getMovieRateByTD(theater,date);
			movieListAsc = ticketService.getMovieAscByTD(theater,date);
		} else if (movie!=null && date==null) {
			dateList = ticketService.getShowDateListByMT(movie, theater);
		} else if (movie==null && date==null) {
			movieListRate = ticketService.getMovieRateByT(theater);
			movieListAsc = ticketService.getMovieAscByT(theater);
			dateList = ticketService.getShowDateListByT(theater);
		} else if (movie!=null&&theater!=null&&date!=null) {
			timeList = ticketService.getTimeList(movie, theater, date);
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
			movieListRate = ticketService.getMovieRateByTD(theater,date);
			movieListAsc = ticketService.getMovieAscByTD(theater,date);
		} else if (movie!=null && theater==null) {
			theaterList = ticketService.getTheaterListByMD(movie,date);
		} else if (movie==null && theater==null) {
			movieListRate = ticketService.getMovieRateByD(date);
			movieListAsc = ticketService.getMovieAscByD(date);
			theaterList = ticketService.getTheaterListByD(date);
		} else if (movie!=null&&theater!=null&&date!=null) {
			timeList = ticketService.getTimeList(movie, theater, date);
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
		filmNumber = ticketService.getFilmNumberBy(movie);
		ticketVO.setFilmNumber(filmNumber);
		ticketVO.setTheaterName(theater);
		ticketVO.setDate(date);
		ticketVO.setRoomName(time.split(" ")[0]);
		ticketVO.setStartTime(time.split(" ")[1]);
		logger.info("choiceseat() {}", ticketVO.getFilmNumber());
		logger.info("choiceseat() {}", ticketVO.getTheaterName());
		logger.info("choiceseat() {}", ticketVO.getDate());
		logger.info("choiceseat() {}", ticketVO.getRoomName());
		logger.info("choiceseat() {}", ticketVO.getStartTime());
		
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
		List movieListRate = new ArrayList();
		List movieListAsc = new ArrayList();
		List theaterList = new ArrayList();
		List dateList = new ArrayList();
		List timeList = new ArrayList();
		movieListRate = ticketService.getRateList();
		movieListAsc = ticketService.getAscList();
		theaterList = ticketService.getTheaterList();
		dateList = ticketService.getShowDateList();
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
		model.addAttribute("time", ticketVO.getStartTime());
		return ticket;
	}
	@RequestMapping("/initSeats")
	public Model initSeats(Model model){
		logger.info("TicketController-initSeats()");
		logger.info("initSeats() 좌석초기화진입");
		List seatList = new ArrayList();
		model.addAttribute("initSeats", seatList);
		return model;
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
		ticketVO.setAdult(Integer.parseInt(adult));
		ticketVO.setOldMan(Integer.parseInt(old_man));
		ticketVO.setTeenager(Integer.parseInt(teenager));
		ticketVO.setPrice(Integer.parseInt(price));
		ticketVO.setSeatNumber(seat_number);
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
