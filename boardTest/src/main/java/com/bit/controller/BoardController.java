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

import com.bit.dao.BoardDAO;
import com.bit.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardDAO dao;
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping("/down.do")
	public ModelAndView down(String fname, HttpServletRequest request) {
		String path = request.getRealPath("resources/upload");
		File file = new File(path + "/" + fname);
		ModelAndView mv = new ModelAndView("down", "df", file);
		//down : servlet-context에서 정해준 id
		//df : DownloadView에서 정해준 파일이름
		return mv;
	}
	
	
	@RequestMapping("/listBoard.do")
	public ModelAndView listAll() {
		ModelAndView mv = new ModelAndView("listBoard");
		mv.addObject("list", dao.listAll());
		return mv;
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public ModelAndView insertForm(@RequestParam(value="no", defaultValue="0")int no) {
		ModelAndView mav = new ModelAndView();
	      String title = "새글작성";
	      if (no != 0) {
	         title = "답글작성";
	         mav.addObject("ptitle", "답글)" + dao.detail(no).getTitle());
	      }
	      mav.addObject("no", no);
	      mav.addObject("title", title);
	      return mav;
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public ModelAndView insertSubmit(BoardVO b, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:listBoard.do");
		
		//파일업로드의 처리
		String path = request.getRealPath("resources/upload");
		System.out.println(path);
		MultipartFile uploadFile = b.getUploadFile();
		if(uploadFile != null) {
			try {
				String fname = uploadFile.getOriginalFilename();
				byte data[] = uploadFile.getBytes();
				b.setFname(fname);
				b.setFsize(data.length);
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		
		
		int re = dao.insert(b, request);
		if(re < 0) {
			mv.addObject("msg", "등록 실패");
			mv.setViewName("error");
		}
		return mv;
	}
	
	@RequestMapping("/detailBoard.do")
	public ModelAndView detail(@RequestParam("no")int no) {
		ModelAndView mv = new ModelAndView("detailBoard");
		mv.addObject("b", dao.detail(no));
		return mv;
	}
	
	@RequestMapping(value="/updateBoard.do", method=RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("no")int no) {
		ModelAndView mv = new ModelAndView("updateBoard");
		mv.addObject("b", dao.detail(no));
		return mv;
	}
	
	@RequestMapping(value="/updateBoard.do", method=RequestMethod.POST)
	public ModelAndView updateSubmit(BoardVO b) {
		ModelAndView mv = new ModelAndView("redirect:listBoard.do");
		int re = dao.update(b);
		if(re < 0) {
			mv.addObject("msg", "수정실패");
			mv.setViewName("error");
		}
		return mv;
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public ModelAndView delete(int no) {
		ModelAndView mv = new ModelAndView("redirect:listBoard.do");
		int re = dao.delete(no);
		if(re < 0) {
			mv.addObject("msg", "삭제실패");
			mv.setViewName("error");
		}
		return mv;
	}
}
