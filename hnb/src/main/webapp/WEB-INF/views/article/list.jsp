<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<LINK REL='stylesheet' type='text/css' href='${css}/board.css'/>	

<script type="text/javascript">
  $(function() {
	  board.init('1');
});
 var board = {
	init : function(pageNo) {
		$.getJSON(context+'/article/list/'+pageNo,function(data) {
		var table = '<div id="boardList">'
		+'<h1 ALIGN=CENTER style="color: #ffffff; margin-bottom: 50px">자유게시판</h1>'
		+'<TABLE id="tab_borderList">'
		+'<TR ALIGN=CENTER>'
		+'<TD WIDTH=10%><B>번호</B></TD>'
		+'<TD WIDTH=40%><B>제 목</B></TD>'
		+'<TD WIDTH=10%><B>작성자</B></TD>'
		+'<TD WIDTH=20%><B>작성일</B></TD>'
		+'<TD WIDTH=8%><B>참조</B></TD></TR>'
		/*  +'<c:forEach var="member" items="${memberList}" varStatus="status">'
		+'<TR><TD WIDTH=10% ALIGN=CENTER>${status.index+1}</TD>'
		+'<TD WIDTH=20% ALIGN=CENTER>'+data.id+'</TD>'
		+'<TD WIDTH=20% ALIGN=CENTER><a href="BoardContent.jsp"></a>${member.name}</TD>'
		+'<TD WIDTH=30% ALIGN=LEFT>${member.email}</TD>'
		+'<TD WIDTH=18% ALIGN=CENTER>${member.regdate}</TD></TR>'
		+'</c:forEach>' */
		+'</TABLE></div>'
		+'<div style="width:100px; margin:auto"><a href="'+context+'/article/write" id="btn_write">글쓰기</a></div>';
		$('.mainView').html(table);
		});
	}
 }

</script>

