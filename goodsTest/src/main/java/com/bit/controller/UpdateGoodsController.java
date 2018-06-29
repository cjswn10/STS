package com.bit.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.GoodsDAO;
import com.bit.vo.GoodsVO;

@Controller
@RequestMapping("/updateGoods.do")
public class UpdateGoodsController {
	@Autowired
	private GoodsDAO dao;
	
	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("no")int no) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("g", dao.getGoods(no));
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView updateSubmit(GoodsVO g, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:listGoods.do");
		
		String oldFname = dao.getGoods(g.getNo()).getFname();
		System.out.println("oldFname : "+oldFname);
		
		String path = request.getRealPath("resources/upload");
		MultipartFile uploadFile = g.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		try {
			//upload한 파일이 있고, 이전과 다른 파일이라면
			if((uploadFile.getBytes().length != 0) && !fname.equals(oldFname)) {
					//이전파일을 삭제
					if(!oldFname.equals("")) {
						File file = new File(path+"/"+oldFname); 
						file.delete();
					}
					//새로운 파일 업로드
					byte data[] = uploadFile.getBytes();
					g.setFname(fname);
					FileOutputStream fs = new FileOutputStream(path + "/" + fname);
					fs.write(data);
					fs.close();
			} else {
				g.setFname("");
				if(!oldFname.equals(""))
					g.setFname(oldFname);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		int re = dao.update(g);
		if(re < 0) {
			mv.addObject("msg", "등록 실패");
			mv.setViewName("error");
		}
		return mv;
	}
}
