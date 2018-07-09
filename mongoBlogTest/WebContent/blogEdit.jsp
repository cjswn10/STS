<%@page import="org.bson.types.ObjectId"%>
<%@page import="com.mongodb.DBObject"%>
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
	String action = "show_form";
	request.setCharacterEncoding("EUC-KR");

	if(request.getParameter("title") != null)
	{
	   action = "save";
	   String title = request.getParameter("title");
	   String content = request.getParameter("content");
	   try{
	      Mongo mongo = new Mongo();
	      DB db = mongo.getDB("myblogdb");
	      DBCollection collection = db.getCollection("articles");
	      BasicDBObject obj = new BasicDBObject();
	      obj.append("$set", new BasicDBObject().append("title", title).append("content", content));
	      BasicDBObject q = new BasicDBObject();
	      q.append("_id", new ObjectId(id));
	      
	      collection.update(q, obj);
	      
	      mongo.close();
	   }catch(Exception e)
	   {
	      System.out.println(e.getMessage());
	   }
	}

	String title = "";
	String content = "";

	try {
		Mongo mongo = new Mongo();
		DB db = mongo.getDB("myblogdb");
		DBCollection collection = db.getCollection("articles");
		BasicDBObject ob = new BasicDBObject();
		ob.append("_id", new ObjectId(id));
		DBObject obj = collection.findOne(ob);
		System.out.println("obj: "+ obj);
		
		title = (String)obj.get("title");
		content = (String)obj.get("content");
		
		out.println(title);
		out.println(content);
		
		mongo.close();
	} catch (Exception e) {
		System.out.println(e);
	}

%>
<%
	if (action.equals("show_form")) {
%>
	<div id="contentarea">
		<div id="innercontentarea">
			<h1>Blog Post Editor</h1>
			<form action="blogEdit.jsp" method="post">
				<input name="id" type="hidden" value="<%=id%>">
				<h3>Title</h3>
				<p>
					<input type="text" name="title" id="title" value="<%=title%>">
				</p>
				<h3>Content</h3>
				<textarea rows="20" name="content"><%=content%></textarea>
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
      Article.edited. _id :
      <%=id%>
      <a href="blogDetail.jsp?id=<%=id%>">Read it.</a>
   </p>
<%
	}
%>
</body>
</html>