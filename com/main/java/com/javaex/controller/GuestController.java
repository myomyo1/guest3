package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

//DAO에 insert(vo) showListAll delete(no, pw) 함수있음
//Vo에 no, name, password, content, regDate 있음
@Controller
public class GuestController {
	
	@Autowired
	private GuestDao guestdao;
	
	@RequestMapping("/list") 
	public String list(Model model) {
		System.out.println("list 진입");
		List<GuestVo> gList = guestdao.showListAll();
		model.addAttribute("gList", gList);		
		return "guestList";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute GuestVo guestvo) {  //@ModelAttribute : vo 객체 가져오는 것. 
		System.out.println(guestvo.toString());
		guestdao.insert(guestvo);
		return "redirect:/list";
	}
	
	@RequestMapping(value="/guestDeleteform", method=RequestMethod.GET)
	public String dform(@RequestParam("no") int no, Model model) {
		System.out.println("guestDeleteform 진입");
		model.addAttribute("no",no);
		return "guestDeleteform";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("no") int no, @RequestParam("password") String pw){  
		System.out.println(no + pw);
		guestdao.delete(no, pw);
		return "redirect:/list";
	}
	

}
