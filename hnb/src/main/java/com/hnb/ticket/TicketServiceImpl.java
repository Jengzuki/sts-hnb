package com.hnb.ticket;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnb.mapper.TicketMapper;



@Service
public class TicketServiceImpl implements TicketService {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
	@Autowired private SqlSession sqlsession;
	
	@Override
	public List<?> getSeatList(String theater, String room) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getSeatList(theater, room);
	}
}
