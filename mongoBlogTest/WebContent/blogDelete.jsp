<%@page import="org.bson.types.ObjectId"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="com.mongodb.DB"%>
<%@page import="com.mongodb.Mongo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		request.setCharacterEncoding("EUC-KR");

		try {
			Mongo mongo = new Mongo();
			DB db = mongo.getDB("myblogdb");
			DBCollection collection = db.getCollection("articles");
			BasicDBObject q = new BasicDBObject();
			q.append("_id", new ObjectId(id));
			collection.remove(q);
			mongo.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	%>
	
	<div id="contentarea">
		<div id="innercontentarea">
			<h1>Blog Post Delete</h1>
			<p>
				<a href="blogDash.jsp">Go back to dashboard?</a>
			</p>
		</div>
	</div>
</body>
</html>