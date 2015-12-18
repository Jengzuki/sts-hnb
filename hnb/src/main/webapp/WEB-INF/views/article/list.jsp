<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<LINK REL='stylesheet' type='text/css' href='${css}/board.css'/>	

<script type="text/javascript">
  $(function() {
	  board.init('142','1');
});
 var board = {
	init : function(themeNo,pageNo) {
		$.getJSON(context+'/article/list/'+themeNo+'/'+pageNo,function(data) {
		var table = '<div id="boardList">'
		+'<h1 ALIGN=CENTER style="color: #ffffff; margin-bottom: 50px">자유게시판</h1>'
		+'<TABLE id="tab_borderList">'
		+'<TR ALIGN=CENTER>'
		+'<TD WIDTH=8%><B>번호</B></TD>'
		+'<TD WIDTH=30%><B>제 목</B></TD>'
		+'<TD WIDTH=60%><B>내용</B></TD><TR>';
		$.each(data.list, function(index,value) {
			table += '<TR><TD WIDTH=8% ALIGN=CENTER>'+this.pageNo+'</TD>'
			+'<TD WIDTH=30% ALIGN=CENTER>'+this.usrSubject+'</TD>'
			+'<TD WIDTH=60% ALIGN=CENTER>'+this.usrContent+'</TD>'
		});
		table += '</TABLE></div>';
		table += '<div style="width:100px; margin:auto"><a href="'+context+'/article/write" id="btn_write">글쓰기</a></div>';
		$('.mainView').html(table);
		});
	}
 }

</script>

