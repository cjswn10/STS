<%@page import="org.bson.types.ObjectId"%>
<%@page import="com.mongodb.DBObject"%>
<%@page import="com.mongodb.DBCursor"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="com.mongodb.DB"%>
<%@page import="com.mongodb.Mongo"%>
<%@page import="jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode"%>
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
	<div id="contentarea">
		<div id="innercontentarea">
			<h1>My Blogs</h1>
			<%
				try {
					Mongo mongo = new Mongo();
					DB db = mongo.getDB("myblogdb");
					DBCollection collection = db.getCollection("articles");
					DBCursor c = collection.find();
					while (c.hasNext()) {
						DBObject obj = c.next();
						String title = (String) obj.get("title");
						String content = (String) obj.get("content");
						String id = ((ObjectId) obj.get("_id")).toString();

						if (content.length() >= 20) {
							content = content.substring(0, 20);
						}
			%>
			<h2><%=title%></h2>
			<p>
				<%=content%>
				...
			</p>
			<a href="blogDetail.jsp?id=<%=id%>">Read more</a>
			<%
				}
					mongo.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			%>
		</div>
	</div>
</body>
</html>