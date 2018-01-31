<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guest3/add" method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
	</form>
	<br />

	<c:forEach items="${gList}" var="guestvo">
		<table width=510 border=1>
			<tr>
				<td>${guestvo.no }</td>
				<td>${guestvo.name }</td>
				<td>${guestvo.regDate }</td>
				<td><a href="/guest3/guestDeleteform?no=${guestvo.no }">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4>${guestvo.content }</td>
			</tr>
		</table>
		<br />
	</c:forEach>


</body>
</html>