package com.bit.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.GoodsDAO;
import com.bit.vo.GoodsVO;

@Controller
@RequestMapping("/insertGoods.do")
@SessionAttributes("id")
public class InsertGoodsController {

	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void insertForm() {
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView insertSubmit(GoodsVO g, HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("redirect:listGoods.do");

		String path = request.getRealPath("resources/upload");
		System.out.println(path);
		g.setFname("");
		MultipartFile uploadFile = g.getUploadFile();
		try {
			if (uploadFile.getBytes().length != 0) {
				String fname = uploadFile.getOriginalFilename();
				byte data[] = uploadFile.getBytes();
				g.setFname(fname);
				FileOutputStream fs = new FileOutputStream(path + "/" + fname);
				fs.write(data);
				fs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		int re = dao.insert(g);
		if (re < 0) {
			//mv.addObject("msg", "등록실패");
			//mv.setViewName("error");
			session.setAttribute("msg", "등록실패");
		} else {
			//mv.addObject("msg", "등록성공");
			session.setAttribute("msg", "등록성공");
		}
		return mv;
	}
}
