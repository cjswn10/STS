package com.bit.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.rcaller.rStuff.RCaller;
import com.github.rcaller.rStuff.RCode;

@Controller
public class D3SimpleController {

	@RequestMapping("/emp.do")
	public ModelAndView d3(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		RCaller caller = new RCaller();
		caller.setRscriptExecutable("C:\\Program Files\\R\\R-3.5.1\\bin\\x64\\Rscript.exe");
		RCode code = new RCode();
		code.clear();
		code.addRCode("sql = 'SELECT e.ename ename, m.ename mname FROM emp e, emp m WHERE e.mgr = m.eno'");
		code.addRCode("library(DBI)");
		code.addRCode("library(RODBC)");
		code.addRCode("library(devtools)");
		code.addRCode("library(RCurl)");
		code.addRCode("library(d3Network)");
		code.addRCode("library(Rserve)");
		
		code.addRCode("db = odbcConnect('yj', 'madang', 'madang')");
		code.addRCode("data = sqlQuery(db, sql)");
		code.addRCode("Rserve(FALSE,port=6311,args='--RS-encoding utf8 --no-save --slave --encoding utf8')");
		code.addRCode("d3SimpleNetwork(data,width=600,height=600,file='c:/r_temp/emp.html')");
		caller.setRCode(code);
		caller.runOnly();
		
		String file = request.getRealPath("/resources/graph") + "/emp.html";
		System.out.println(file);
		try {
//			FileInputStream is = new FileInputStream("c:/r_temp/emp.html");
//			FileOutputStream os = new FileOutputStream(file);
//			FileCopyUtils.copy(is, os);
//			is.close();
//			os.close();
			
			BufferedReader reader = new BufferedReader(new FileReader("c:/r_temp/emp.html"));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
			
			String s;
			while((s = reader.readLine()) != null)
			{
				writer.write(s);
				writer.newLine();
			}
			
			//FileCopyUtils.copy(reader, writer);
			reader.close();
			writer.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mv;
	}
	
}
