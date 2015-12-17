package com.hnb.theme;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnb.article.ArticleVO;
import com.hnb.global.Command;
import com.hnb.mapper.MemberMapper;


@Service
public class ThemeServiceImpl implements ThemeService{
	private static final Logger logger = LoggerFactory.getLogger(ThemeServiceImpl.class);
	@Autowired private SqlSession sqlsession;
	@Override
	public int add(ThemeVO theme) {
		logger.info("ThemeServiceImpl : add");
		ThemeServiceImpl mapper = sqlsession.getMapper(ThemeServiceImpl.class);
		return mapper.add(theme);
	}
	@Override
	public List<ThemeVO> getList(Command command) {
		logger.info("ThemeServiceImpl : getList");
		ThemeServiceImpl mapper = sqlsession.getMapper(ThemeServiceImpl.class);
		return mapper.getList(command);
	}
	@Override
	public List<ThemeVO> searchByKeyword(Command command) {
		logger.info("ThemeServiceImpl : searchByKeyword");
		ThemeServiceImpl mapper = sqlsession.getMapper(ThemeServiceImpl.class);
		return mapper.searchByKeyword(command);
	}
	@Override
	public ThemeVO searchById(int rcdNo) {
		logger.info("ThemeServiceImpl : searchById");
		ThemeServiceImpl mapper = sqlsession.getMapper(ThemeServiceImpl.class);
		return mapper.searchById(rcdNo);
	}
	@Override
	public int count() {
		logger.info("ThemeServiceImpl : count");
		ThemeServiceImpl mapper = sqlsession.getMapper(ThemeServiceImpl.class);
		return mapper.count();
	}
	@Override
	public int countByKeyword(Command command) {
		logger.info("ThemeServiceImpl : countByKeyword");
		ThemeServiceImpl mapper = sqlsession.getMapper(ThemeServiceImpl.class);
		return mapper.countByKeyword(command);
	}
	@Override
	public int change(ThemeVO theme) {
		logger.info("ThemeServiceImpl : change");
		ThemeServiceImpl mapper = sqlsession.getMapper(ThemeServiceImpl.class);
		return mapper.change(theme);
	}
	@Override
	public int remove(String themeName) {
		logger.info("ThemeServiceImpl : remove");
		ThemeServiceImpl mapper = sqlsession.getMapper(ThemeServiceImpl.class);
		return mapper.remove(themeName);
	}
}
