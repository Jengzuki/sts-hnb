package com.hnb.article;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnb.global.Command;
import com.hnb.mapper.ArticleMapper;

@Service
public class ArticleServiceImpl implements ArticleService{
	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
	@Autowired private SqlSession sqlsession;
	
	@Override
	public int wright(ArticleVO article) {
		logger.info("ArticleServiceImpl : wright");
		ArticleMapper mapper = sqlsession.getMapper(ArticleMapper.class);
		return mapper.wright(article);
	}

	@Override
	public List<ArticleVO> getList(Command command) {
		logger.info("ArticleServiceImpl : getList");
		ArticleMapper mapper = sqlsession.getMapper(ArticleMapper.class);
		return mapper.getList(command);
	}

	@Override
	public List<ArticleVO> searchByKeyword(Command command) {
		logger.info("ArticleServiceImpl : searchByKeyword");
		ArticleMapper mapper = sqlsession.getMapper(ArticleMapper.class);
		return mapper.searchByKeyword(command);
	}

	@Override
	public ArticleVO searchById(int rcdNo) {
		logger.info("ArticleServiceImpl : searchById");
		ArticleMapper mapper = sqlsession.getMapper(ArticleMapper.class);
		return mapper.searchById(rcdNo);
	}

	@Override
	public int count() {
		logger.info("ArticleServiceImpl : count");
		ArticleMapper mapper = sqlsession.getMapper(ArticleMapper.class);
		return mapper.count();
	}

	@Override
	public int countByKeyword(Command command) {
		logger.info("ArticleServiceImpl : countByKeyword");
		ArticleMapper mapper = sqlsession.getMapper(ArticleMapper.class);
		return mapper.countByKeyword(command);
	}

	@Override
	public int change(ArticleVO article) {
		logger.info("ArticleServiceImpl : change");
		ArticleMapper mapper = sqlsession.getMapper(ArticleMapper.class);
		return mapper.wright(article);
	}

	@Override
	public int remove(String id) {
		logger.info("ArticleServiceImpl : remove");
		ArticleMapper mapper = sqlsession.getMapper(ArticleMapper.class);
		return mapper.remove(id);
	}

}
