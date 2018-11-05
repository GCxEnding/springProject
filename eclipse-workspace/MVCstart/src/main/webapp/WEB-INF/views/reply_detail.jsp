<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>답글 등록 페이지</title>
</head>
<body>
<form name="detail" action="/reply_insert.do" method="post">
	<table border=1 style="margin-left:100px; margin-top:40px;">
		<tr>
			<td>
			이름: <input type="text" name="name"/>
			</td>
		</tr>
		<tr>
			<td>
			제목: <input type="text" name="title"/>
			</td>
		</tr>
		<tr>
			<td>
			내용
			</td>
		</tr>
		<tr>
			<td>
			<textarea rows="20" cols="28" name="contents"></textarea>
			</td>
		</tr>
	</table>
	<input type="hidden" name="num" value="${num}">
	<input type="hidden" name="fk" value="${fk}">
	<input type="hidden" name="deps" value="${deps}">
	<input type="hidden" name="num_order" value="${num_order}">
	<input type="submit" value="답글 등록">
	<input type="button" value="취소" onclick="window.location='/dtlselect.do?num=${num}'"/>
</form>
</body>
</html>