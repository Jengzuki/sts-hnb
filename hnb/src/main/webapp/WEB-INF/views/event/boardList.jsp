<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<script type="text/javascript">
  $(function() {
	  board.load(context+'/event/boardList/1');
});
 var board = {
	load : function(url) {
		$.getJSON(url,function(data) {
		var table = '<div id="boardList">'
		+'<h1>회원목록</h1>'
		+'<TABLE id="tab_borderList">'
		+'<TR ALIGN=CENTER>'
		+'<TD WIDTH=10%><B>번호</B></TD><TD WIDTH=20%><B>아이디</B></TD>'
		+'<TD WIDTH=20%><B>회원명</B></TD><TD WIDTH=30%><B>이메일</B></TD>'
		+'<TD WIDTH=18%><B>가입일</B></TD></TR>'
		 +'<c:forEach var="member" items="${memberList}" varStatus="status">'
		+'<TR><TD WIDTH=10% ALIGN=CENTER>${status.index+1}</TD>'
		+'<TD WIDTH=20% ALIGN=CENTER>'+data.id+'</TD>'
		+'<TD WIDTH=20% ALIGN=CENTER><a href="BoardContent.jsp"></a>${member.name}</TD>'
		+'<TD WIDTH=30% ALIGN=LEFT>${member.email}</TD>'
		+'<TD WIDTH=18% ALIGN=CENTER>${member.regdate}</TD></TR>'
		+'</c:forEach>'
		+'</TABLE></div>'
		$('.mainView').empty();
		$('.mainView').html(table);
		board.style();
		});
	},
	
	
	style : function() {
		$('.mainView').css('height','400px');
		$('#tab_borderList').css('width','80%').css('margin','auto');
		$('#tab_borderList').add('td').css('border','1px solid white');
		$('#tab_borderList').add('a').css('color','#ffffff').css('text-decoration','none');
		$('h1').css("color","#ffffff").css('margin-bottom','50px').css('margin-left','45%');
		
	}
		 
 }

</script>

