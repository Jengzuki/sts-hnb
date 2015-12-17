package com.hnb.theme;

import java.util.List;

import com.hnb.article.ArticleVO;
import com.hnb.global.Command;

public interface ThemeService {

	// C : 추가
	public int add(ThemeVO theme);

	// R : 조회
	public List<ThemeVO> getList(Command command); // 전체회원목록
	public List<ThemeVO> searchByKeyword(Command command); // 임의의 값으로 검색
	public ThemeVO searchById(int rcdNo); // 번호로 조회
	public int count(); // 전체회원수 조회
	public int countByKeyword(Command command); // 검색결과의 갯수만 조회

	// U : 개인정보 변경
	public int change(ThemeVO theme);

	// D : 삭제
	public int remove(String themeName);
}
