<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="silicon.cms.common.factory.DAOFactory" %>
<%@ page import="silicon.cms.common.dao.CategoryDAO"%>
<%@ page import="java.util.List" %>
<%@ page import="silicon.cms.common.entity.CategoryEntity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>hello world</p>
<%
	List<CategoryEntity> posts = null;
	CategoryDAO category = DAOFactory.getCategoryInstance();
	posts = category.query("");
	
%>
<ul>
<% for (CategoryEntity post : posts) {%>
	<li>
		<div><%=post.getCategoryName() %></div>
	</li>
<%}%>
</ul>

<ul>

</ul>
</body>
</html>