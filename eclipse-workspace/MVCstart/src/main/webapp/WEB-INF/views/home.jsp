<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>list 게시판</title>
</head>
<body>
${word}
	<script>
		function dtl(num)
		{
			document.vo.num.value=num;
			document.vo.action="/dtlselect.do";
			document.vo.submit();
		}
		function list(pgnum)
		{
			document.pg.pgnum.value=pgnum;
			document.pg.action="/";
			document.pg.submit();
		}
	</script>
	<form name="frm" method="post">
		<table border=1>
		<tr>
			<td>번호</td><td>제목</td><td>이름</td><td>날짜</td><td>조회수</td>
		</tr>
			<c:forEach var="board" items="${list}" varStatus="status">
				<tr>
				<input type="hidden" name="tot" value="${tot}">
					<td><c:out value="${tot-(status.index)-20*(pgnum-1)}"/></td>
					<td>
					
					<c:forEach  var="reply" begin="0" end="${board.deps}">
					&nbsp; &nbsp;
					</c:forEach>
					<c:if test="${board.deps > 0}">
						▶
					</c:if>
					<input type="hidden" name="pgnum" value="${pgnum}">
					<input type="hidden" name="word" value="${word}">
					<input type="hidden" name="search_box" value="${search_box}">
					<a href="javascript:dtl(${board.num})" style="text-decoration:none"><font color="black"><c:out value="${board.title}"/></a>
					</td>
					<td><c:out value="${board.name}"/></td>
					<td><c:out value="${board.sysdate}"/></td>
					<td><c:out value="${board.hit}"/></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	
	<form name="vo" method="post">
		<input type="hidden" name="num" value="">
		<input type="hidden" name="pgnum" value="${pgnum}">
		<input type="hidden" name="word" value="${word}">
		<input type="hidden" name="search_box" value="${search_box}">
	</form>
	<form name="pg" method="post">
		<input type="hidden" name="pgnum" value="">
		<input type="hidden" name="word" value="${word}">
		<input type="hidden" name="search_box" value="${search_box}">
	</form>
		<div style="float:left; margin-left:200px;">
			<c:forEach var="pg" begin="1" end="${pgcount}" varStatus="status">
				<a href="javascript:list(${status.count})" style="text-decoration:none"><font size="2" color="blue">${status.count}</font></a>
			</c:forEach>
		</div>
	<br>
	<input type="button" value="글쓰기" onclick="window.location='detail.do'"/>
	<input type="button" value="전체보기" onclick="window.location='/'">
	
	<form name="search_frm" action="/" method="post">
		<table id="search_table" >
			<tr>
				<td class="search_td">
					<select name="search_box" size="1" style="font-family:돋움체">
						<option value="writer">작성자</option>
						<option value="title">제목</option>
						<option value="contents" >내용</option>
					</select>
				</td>
				<td class="search_td">
					<input type="text" name="word" size="30">
				</td>
				<td>
					<input type="submit" value="검 색 " name="submitbtn" style="background-color: rgb(238,238,238);
					color: rgb(0,47,94); font-family:'돋움'; font-size:10pt; font-weight:bold">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>