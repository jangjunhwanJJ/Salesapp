<%@page import="www.jangjunhwan.kr.Goods"%>
<%@page import="java.util.List"%>
<%@page import="www.jangjunhwan.kr.Sales"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%Sales s=new Sales();
List<Goods> list = s.getlist();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Program Sales</title>
</head>
<body>

<table>
	<%for(int i = 0; i<list.size();i++){
		Goods app = list.get(i); 
	%>
	
	<%}%>
</table>

</body>
</html>