package com.bit.member;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.MemberDAO;
import com.bit.vo.MemberVO;

@Controller
@RequestMapping("/insertMember.do")
public class InsertMemberController {
	@Autowired
	private MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public void form() {
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(MemberVO m, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/listMember.do");
		String path = request.getRealPath("resources/img");
		System.out.println(path);
		
		MultipartFile uploadFile = m.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		System.out.println("파일명: " + fname);
		
		m.setFname("");
		
		if(fname != null && !fname.equals("")) {
			try {
				m.setFname(fname);
				byte[] data = uploadFile.getBytes();
				FileOutputStream fs = new FileOutputStream(path + "/" + fname);
				fs.write(data);
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		int re = dao.insert(m);
		String msg = "회원등록 성공";
		if (re < 0) {
			msg = "회원등록 실패";
		}
		request.getSession().setAttribute("msg", msg);
		
		return mv;
	}
	
	
	/*
	@RequestMapping(method = RequestMethod.POST)
	   public ModelAndView submit(MemberVO m, HttpServletRequest request) {
	      
	      m.setFname("");
	      
	      ModelAndView mav = new ModelAndView("redirect:/listMember.do");

	      String path = request.getRealPath("resources/img");
	      System.out.println(path);

	      MultipartFile upload = m.getUploadFile();
	      String fname = upload.getOriginalFilename();

	      if (fname != null && !fname.equals("")) {
	         try {
	            m.setFname(fname);
	            byte[] data = upload.getBytes();
	            FileOutputStream fos = new FileOutputStream(path+"/"+fname);
	            fos.write(data);
	            fos.close();

	         } catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage());
	         }

	      }

	      int re = dao.insert(m);
	      String msg = "회원등록에 성공하였습니다.";
	      if (re < 1) {
	         msg = "회원등록에 실패하였습니다.";
	      }

	      request.getSession().setAttribute("msg", msg);

	      return mav;
	   }
	*/
}
