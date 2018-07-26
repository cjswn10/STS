<%@page import="org.springframework.util.FileCopyUtils"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="com.github.rcaller.rStuff.RCode"%>
<%@page import="com.github.rcaller.rStuff.RCaller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
/*

$(function() {
	var makeChart = function() {
		var arr[];
		$.each($("<input"), function(i, age) {
			arr.push($(this).val());
		}));
*/
	<%
		String age1 = request.getParameter("age1");
		String age2 = request.getParameter("age2");
		String age3 = request.getParameter("age3");
		String age4 = request.getParameter("age4");
		String age5 = request.getParameter("age5");
		
		String fname="";
	
		try {
			RCaller caller = new RCaller();
			caller.setRscriptExecutable("C:/Program Files/R/R-3.5.1/bin/x64/Rscript.exe");
			
			RCode code = new RCode();
			code.clear();
			
			File file;
			file = code.startPlot();
			System.out.println("생성된 파일:" + file);

			String ages = age1 + "," + age2 + "," + age3 + "," + age4 + "," + age5;
			code.addRCode("x=c(" + ages + ")");
			code.addRCode("plot(x)");
			
			code.endPlot();
			
			caller.setRCode(code);
			caller.runOnly();
			code.showPlot(file);
			
			//생성된 파일을 resources 에 복사
			String path = request.getRealPath("resources/img");
			System.out.println(path);
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(path + "/" + file.getName());
			FileCopyUtils.copy(fis, fos);
			fis.close();
			fos.close();
			
			fname = file.getName();
			
		} catch(Exception e) {
			System.out.println("e.getMessage()");
		}
	%>
/*
	}
})
*/

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ageplotTest.jsp">
		나이입력 : 
		<input type="number" name="age1" id="age1"><br>
		<input type="number" name="age2" id="age2"><br>
		<input type="number" name="age3" id="age3"><br>
		<input type="number" name="age4" id="age4"><br>
		<input type="number" name="age5" id="age5"><br>
		<input type="submit" value="차트만들기">
	</form>

	<img src="resources/img/<%=fname %>">
</body>
</html>