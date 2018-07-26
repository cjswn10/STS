<%@page import="org.springframework.util.FileCopyUtils"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="com.github.rcaller.rStuff.RCode"%>
<%@page import="com.github.rcaller.rStuff.RCaller"%>
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
		String fname="";
		try {
			RCaller caller = new RCaller();
			caller.setRscriptExecutable("C:/Program Files/R/R-3.5.1/bin/x64/Rscript.exe");
			
			RCode code = new RCode();
			code.clear();
			
			File file;
			file = code.startPlot();
			System.out.println("생성된 파일:" + file);
			
			code.addRCode("x=c(1,4,3,5,6,10)");
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


	<img src="resources/img/<%=fname %>">
</body>
</html>