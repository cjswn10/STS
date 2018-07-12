<%@page import="java.util.ListIterator"%>
<%@page import="com.mongodb.BasicDBList"%>
<%@page import="org.bson.types.ObjectId"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.DBObject"%>
<%@page import="com.mongodb.DBCursor"%>
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
	<div id="contentarea">
		<div id="innercontentarea">
			<h1>My Blogs</h1>
			<%
				String id = request.getParameter("id");
				try {
					Mongo mongo = new Mongo();
					DB db = mongo.getDB("myblogdb");
					DBCollection collection = db.getCollection("articles");
					BasicDBObject ob = new BasicDBObject();
					ob.append("_id", new ObjectId(id));
					DBObject obj = collection.findOne(ob);

					String title = (String) obj.get("title");
					String content = (String) obj.get("content");
			%>
			<h2><%=title%></h2>
			<p><%=content%></p>

			<div id="comment-section">
				<h3>Comments</h3>
				<%
					if (obj.get("comment") != null) {
							BasicDBList comm = (BasicDBList) obj.get("comment");
							ListIterator iter = comm.listIterator();
							while (iter.hasNext()) {
								BasicDBObject bo = (BasicDBObject) iter.next();
								out.println(bo.get("name") + "says...");
								out.println("<p>" + bo.get("comment") + "</p>");
								out.println("<span>" + bo.get("posted_at") + "</span><br><br><br>");
							}
						}
				%>
				<h3>Post your comment</h3>
				<form action="comment.jsp" method="post">
					<span class="input-lable">Name</span> <input type="text"
						name="commenter_name" class="comment-input"> <br>
					<br> <span class="input-label">Email</span> <input type="text"
						name="commenter_email" class="comment-email"> <br>
					<br>
					<textarea rows="5" name="comment"></textarea>
					<br>
					<br> <input type="hidden" name="article_id" value="<%=id%>">
					<input type="submit" value="Save" name="btn_submit">
				</form>
			</div>


			<%
					mongo.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			%>
		</div>
	</div>
</body>
</html>