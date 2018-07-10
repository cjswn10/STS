<%@page import="com.mongodb.DBCursor"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="com.mongodb.DB"%>
<%@page import="com.mongodb.Mongo"%>
<%@page import="com.mongodb.DBObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript">
	function confirmDelete(id) {
		var re = confirm("Are you sure you want to delete this articles");
		if(re) {
			location.href = "blogDelete.jsp?id="+id;
		}
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		DBCursor c = null;
		int pageSIZE = 5;
		int currentPage = 1;
		
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int skip = (currentPage - 1) * pageSIZE;
		int totalCount = 0;
		int totalPage = 0;
		try {
			Mongo mongo = new Mongo();
			DB db = mongo.getDB("myblogdb");
			DBCollection collection = db.getCollection("articles");
			c = collection.find();

			totalCount = c.size();
			totalPage = (int) Math.ceil(totalCount / (double)pageSIZE);
			c.sort(new BasicDBObject().append("saved_at", -1)).skip(skip).limit(pageSIZE);
	%>
	<div id="contentarea">
		<div id="innercontentarea">
			<h1>Dashboard</h1>
			<table class="articles" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<th width="50%">Title</th>
						<th width="25%">Created at</th>
						<th width="*">Action</th>
					</tr>
				</thead>
				<tbody>
					<%
						while (c.hasNext()) {
								DBObject ob = c.next();
					%>
					<tr>
						<td><%=ob.get("title")%></td>
						<td><%=ob.get("saved_at")%></td>
						<td>
							<a href="blogDetail.jsp?id=<%=ob.get("_id")%>">View</a>
							<a href="blogEdit.jsp?id=<%=ob.get("_id")%>">Edit</a>
							<a href="#" onclick="confirmDelete('<%=ob.get("_id")%>')">Delete</a>
						</td>
					</tr>
					<%
						}
						mongo.close();
					} catch (Exception e) {
						System.out.println(e);
					}
					%>
				</tbody>
			</table>
		</div>
		<div id="navigation">
			<div class="prev">
				<%
					if (currentPage != 1) {
				%>
				<a href="blogDash.jsp?page=<%=currentPage - 1%>">Prev</a>
				<%
					}
				%>
			</div>
			<div class="page-number">
				<%=currentPage%>
			</div>
			<div class="next">
				<%
					if (currentPage != totalPage) {
				%>
				<a href="blogDash.jsp?page=<%=currentPage + 1%>">Next</a>
				<%
					}
				%>
			</div>
			<br class="clear" />
		</div>
	</div>
</body>
</html>