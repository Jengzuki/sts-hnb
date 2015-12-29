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

	private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
	@Autowired private SqlSession sqlsession;
	
	
	@Override
	public List<String> getRateList() {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getRateList();
	}
	@Override
	public List<String> getAscList() {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getAscList();
	}
	@Override
	public List<String> getTheaterList() {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getTheaterList();
	}
	@Override
	public List<String> getShowDateList() {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getShowDateList();
	}
	@Override
	public List<String> getTheaterListByM(String movie) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getTheaterListByM(movie);
	}
	@Override
	public List<String> getShowDateListByM(String movie) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getShowDateListByM(movie);
	}
	@Override
	public List getTheaterListByMD(String movie, String date) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getTheaterListByMD(movie, date);
	}
	@Override
	public List getShowDateListByMT(String movie, String theater) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getShowDateListByMT(movie, theater);
	}
	@Override
	public List getMovieRateByTD(String theater, String date) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getMovieRateByTD(theater,date);
	}
	@Override
	public List getMovieAscByTD(String theater, String date) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getMovieAscByTD(theater, date);
	}
	@Override
	public List getMovieRateByT(String theater) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getMovieRateByT(theater);
	}
	@Override
	public List getMovieAscByT(String theater) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getMovieAscByT(theater);
	}
	@Override
	public List getShowDateListByT(String theater) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getShowDateListByT(theater);
	}
	@Override
	public List getMovieRateByD(String date) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getMovieRateByD(date);
	}
	@Override
	public List getMovieAscByD(String date) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getMovieAscByD(date);
	}
	@Override
	public List getTheaterListByD(String date) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getTheaterListByD(date);
	}
	@Override
	public List getTimeList(String movie, String theater, String date) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getTimeList(movie, theater, date);
	}
	@Override
	public String getFilmNumberBy(String movie) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getFilmNumberBy(movie);
	}
	@Override
	public List getSeatList(String theater, String room) {
		TicketMapper mapper = sqlsession.getMapper(TicketMapper.class);
		return mapper.getSeatList(theater, room);
	}
}
