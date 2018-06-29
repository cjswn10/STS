package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.DeptDAO;
import com.bit.vo.DeptVO;

@Controller
public class DeptController {
	@Autowired
	private DeptDAO dao;
	
	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listDept.do")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("listDept");
		
		mv.addObject("title", "�μ����");
		mv.addObject("list", dao.listAll());
		return mv;
	}
	
	@RequestMapping(value="/insertDept.do", method=RequestMethod.GET)
	public void insertForm() {
		
	}
	
	@RequestMapping(value="/insertDept.do", method=RequestMethod.POST)
	public ModelAndView insertSubmit(DeptVO d) {
		ModelAndView mv = new ModelAndView("redirect:listDept.do");
		int re = dao.insert(d);
		if ( re < 0) {
			mv.addObject("msg", "��� ����");
			mv.setViewName("error");
		}
		return mv;
	}
	
	@RequestMapping(value="/updateDept.do",method=RequestMethod.GET)
	   public ModelAndView updateForm(int dno)
	   {
	      ModelAndView mav = new ModelAndView();
	      
	      mav.addObject("d", dao.getDept(dno));
	      
	      return mav;
	   }
	   @RequestMapping(value="/updateDept.do",method=RequestMethod.POST)
	   public ModelAndView updateSubmit(DeptVO d)
	   {
	      ModelAndView mav = new ModelAndView("redirect:/listDept.do");
	      int re = dao.update(d);
	      
	      if(re<0)
	      {
	         mav.addObject("msg", "����");
	         mav.setViewName("error");
	      }
	      
	      return mav;
	   }
	   
	   
	   @RequestMapping("/detailDept.do")
	   public ModelAndView detail(int dno)
	   {
	      ModelAndView mav = new ModelAndView();
	      
	      mav.addObject("d", dao.getDept(dno));
	      
	      return mav;
	   }
	   @RequestMapping("/deleteDept.do")
	   public ModelAndView delete(int dno)
	   {
	      ModelAndView mav = new ModelAndView("redirect:/listDept.do");
	      int re = dao.delete(dno);
	      if(re<=0)
	      {
	         mav.addObject("msg", "�μ����� ����");
	         mav.setViewName("error");
	      }
	      
	      return mav;
	   }

}
