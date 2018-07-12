<%@page import="org.bson.types.BSONTimestamp"%>
<%@page import="com.mongodb.BasicDBList"%>
<%@page import="com.mongodb.DBObject"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("article_id");
	String name = request.getParameter("commenter_name");
	String email = request.getParameter("commenter_email");
	String comment = request.getParameter("comment");
	
	System.out.println("name:" + name);
	
	try {
		Mongo mongo = new Mongo();
		DB db = mongo.getDB("myblogdb");
		DBCollection collection = db.getCollection("articles");
		
		BasicDBObject obId = new BasicDBObject();
		obId.append("_id", new ObjectId(id));
		DBObject old = collection.findOne(obId);
		
		BasicDBList comm = (BasicDBList)old.get("comment");
		
		BasicDBObject q = new BasicDBObject();
		q.append("_id", new ObjectId(id));
		
		BasicDBObject obj = new BasicDBObject();
		BasicDBObject cObj = new BasicDBObject().append("name", name).append("email", email)
				.append("comment", comment).append("posted_at", new BSONTimestamp());
		
		
		obj.append("$push", new BasicDBObject().append("comment", cObj));
		collection.update(q, obj);
		
		response.sendRedirect("blogDetail.jsp?id="+id);
		mongo.close();

	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
%>
</body>
</html>