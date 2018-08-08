package com.bit.rTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
public class SeoulController {
	
	@RequestMapping("/seoul.do")
	public ModelAndView seoul(HttpServletRequest request)
	{
		//String fname = "seoul.png";
		ModelAndView mav = new ModelAndView();
		//String cmd = "python seoul.py";
		
		try {
//			Runtime.getRuntime().exec("cd C:/pythonTest2/day0807");
//			Runtime.getRuntime().exec("python seoul.py");	
//				
			RCaller caller = new RCaller();
			caller.setRscriptExecutable("C:\\Program Files\\R\\R-3.5.1\\bin\\x64\\Rscript.exe");
			
			RCode code = new RCode();
			code.clear();		
			
			File file;			
			file = code.startPlot();			
			
			code.addRCode("setwd('c:/r_temp')");
			code.addRCode("library(KoNLP)");
			code.addRCode("library(wordcloud)");
			code.addRCode("useSejongDic()");			
			code.addRCode("data1 =readLines('seoul2.txt')");
			code.addRCode("data2 <- sapply(data1,extractNoun,USE.NAMES=F)");
			code.addRCode("data3 <- unlist(data2)");
			code.addRCode("data3 <- Filter(function(x) {nchar(x) >= 2} ,data3)");
			code.addRCode("write(unlist(data3),'seoul_2.txt')");
			code.addRCode("data4 <- read.table('seoul_2.txt')");
			code.addRCode("library(RColorBrewer)");
			code.addRCode("wordcount = table(data4)");
			code.addRCode("palete <- brewer.pal(9,'Set3')");
			code.addRCode("wordcloud(names(wordcount),freq=wordcount,scale=c(5,1),rot.per=0.25,min.freq=1,random.order=F,random.color=T,colors=palete)");
//			code.addRCode("savePlot('"+fname+"',type='png')");
			
			code.endPlot();
			
			caller.setRCode(code);
			caller.runOnly();
			System.out.println(request.getRealPath("/resources/img"));
			String path = request.getRealPath("/resources/img");
			
			String file2 = file.getName();
			mav.addObject("fname", file2);
			try {
				FileInputStream fis = new FileInputStream(file);
				FileOutputStream fos = new FileOutputStream(path + "/" + file2);
				FileCopyUtils.copy(fis, fos);
				fis.close();
				fos.close();
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("ok");
		
		return mav;
	}
}
