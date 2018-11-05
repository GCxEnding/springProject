<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
</head>
<body>

<form name="detail_sel" action="/" method="post">
	<div style="width:100px; height:21px; margin-left:182px;">
		번호: <input type="text" name="num" style="width:20px; text-align:right" value="${dtl.num}" readonly>
	</div>
	<div style="width:400px; height:30px; float:top;">
		작성자 : <input type="text" name="name" style="text-align:center" value="${dtl.name}" readonly>
	</div>
	<div style="width:400px; height:30px; float:top;">
		날짜: <input type="text" name="date" style="margin-left:20px; text-align:center" value="${dtl.sysdate}" readonly>
	</div>
	<div style="width:400px; height:30px; float:top;">
		조회수: <input type="text" name="hit" style="margin-left:5px; text-align:center" value="${dtl.hit}" readonly>
	</div>
	<div style="width:400px; height:30px; float:top;">
		제목: <input type="text" name="title" style="margin-left:20px; text-align:center" value="${dtl.title}" readonly>
	</div>
	<div style="width:400px; height:160px; float:top;">
		<textarea rows="10" cols="53" name="contents" readonly>${dtl.contents}</textarea>
	</div>
	<input type="hidden" name="pgnum" value="${pgnum}">
	<input type="hidden" name="search_box" value="${search_box}">
	<input type="hidden" name="word" value="${word}">
	<input type="submit"  name="submitbtn" value="목록"/>
	</form>
	<input type="button" value="수정" onclick="window.location='/update.do?num=${dtl.num}'"/>
	<input type="button" value="삭제" onclick="window.location='/delete_list.do?num=${dtl.num}&pgnum=${pgnum}'">
	<input type="button" value="답글" onclick="window.location='/reply.do?num=${dtl.num}&fk=${dtl.fk}&deps=${dtl.deps}&num_order=${dtl.num_order}'">
	<form name="comment" action="/comment.do" method="post">
		<div style="border:1px solid; width:400px; height:150px; margin-top:25px; float:top;">
				<input type="hidden" name="fk" value="${dtl.num}">
				
			<div style="border:1px solid; width:100px; height:30px; float:left; line-height:5px;">
				이름
				<input type="text" name="re_name" style="width:50px; height:20px;">
			</div>
			<div style="border:1px solid; width:220px; height:30px; float:left; line-height:5px;">
				내용
				<input type="text" name="re_contents" style="width:150px; height:20px;">
			</div>
			<input type="submit" value="확인">
	<table border=1>
		<tr>
		<td>작성자</td><td>내용</td><td>날짜</td><td>삭제버튼</td>
		</tr>
	<c:forEach var="re" items="${re}" varStatus="status">
		<tr>
			<td><c:out value="${re.re_name}"/></td>
			<td><c:out value="${re.re_contents}"/></td>
			<td><c:out value="${re.re_date}"/></td>
			<td><input type="button" value="삭제" onClick="window.location='/comment_delete.do?re_num=${re.re_num}&num=${dtl.num}'"></td>
		</tr>
	</c:forEach>
	</table>
		</div>
	</form>
</body>
</html>