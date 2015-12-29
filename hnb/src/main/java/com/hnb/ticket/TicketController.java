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
	

	
	public String initSeats(){
		logger.info("TicketController-initSeats()");
		logger.info("initSeats() 좌석초기화진입");
		List<?> seatList = ticketService.getSeatList(ticketVO.getTheaterName(), ticketVO.getRoomName());
		return "ticket/initSeats";
	}
	

}
