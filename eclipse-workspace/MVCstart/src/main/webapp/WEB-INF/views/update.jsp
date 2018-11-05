<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>수정 페이지</title>
</head>
<body>
<form name="signup" action="/update_db.do" method="post">
	<div style="border:1px solid; width:400px; height:520px; margin-top:50px; margin-left:150px; line-height:30px;">
			번호: <input type="text" name="num" value="${dtl1.num}" readonly>
		<div style="border:1px solid; width:400px; height:30px; float:top;">
			작성자 : <input type="text" name="name" value="${dtl1.name}">
		</div>
		<div style="border:1px solid; width:400px; height:30px; float:top;">
			날짜: <input type="text" name="date" value="${dtl1.sysdate}" readonly>
		</div>
		<div style="border:1px solid; width:400px; height:30px; float:top;">
			조회수: <input type="text" style="width:100px;" name="hit" value="${dtl1.hit}" readonly>
		</div>
		<div style="border:1px solid; width:400px; height:30px; float:top;">
			제목: <input type="text" style="width:150px;" name="title" value="${dtl1.title}">
		</div>
		<div style="border:1px solid; width:400px; height:385px; float:top;">
			<textarea rows="25" cols="53" name="contents">${dtl1.contents}</textarea>
		</div>
	</div>
	<input type="submit" name="submitButton" value="수정완료">
</form>
	<input type="button" value="취소" onClick="window.location='/'">
</body>
</html>