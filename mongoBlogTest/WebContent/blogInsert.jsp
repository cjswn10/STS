<%@page import="org.bson.types.ObjectId"%>
<%@page import="org.bson.types.BSONTimestamp"%>
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
		String action = "show_form";
		ObjectId id = null;
		request.setCharacterEncoding("utf-8");
		if (request.getParameter("title") != null) {
			action = "save";
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			try {
				Mongo mongo = new Mongo();
				DB db = mongo.getDB("myblogdb");
				DBCollection collection = db.getCollection("articles");
				BasicDBObject obj = new BasicDBObject();
				obj.append("title", title);
				obj.append("content", content);
				obj.append("saved_at", new BSONTimestamp());
				collection.insert(obj);
				id = (ObjectId) obj.get("_id");
				mongo.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		if (action.equals("show_form")) {
	%>
		<div id="contentarea">
			<div id="innercontentarea">
				<h1>Blog Post Creator</h1>
				<form action="blogInsert.jsp" method="post">
					<h3>Title</h3>
					<p>
						<input type="text" name="title" id="title">
					</p>
					<h3>Content</h3>
					<textarea rows="20" name="content"></textarea>
					<p>
						<input type="submit" name="btn_submit" value="Save">
					</p>
				</form>
			</div>
		</div>
	<%
		} else {
	%>
		<p>
			Article saved. _id :
			<%=id%>
			<a href="blogInsert.jsp">Write another one?</a>
		</p>
	<%
		}
	%>
</body>
</html>