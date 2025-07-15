package springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// 스프링에서 관리하는 클래스를 가리켜 빈이라 하며, 빈들을 대상으로, 어떤 역할을 수행하는 관점에서 지칭하는 말은
@Controller
public class NoticeController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/notice/list")
	public ModelAndView selectAll() {
		ModelAndView mav =  new ModelAndView();
		mav.addObject("list","게시물 목록");
		mav.setViewName("notice/list");
		logger.debug("mav: " + mav);
		return mav;
	}
	
	@RequestMapping("/notice/registForm")
	public String registForm() {
		return "notice/write";
	}
	
	@RequestMapping(value="/notice/regist", method=RequestMethod.POST)
	public String regist() {
		logger.debug("글쓰기 요청 받음");
		return "redirect:/shop/notice/list";
	}
	
	@RequestMapping("/notice/detail")
	public ModelAndView getDetail() {
		logger.debug("상세보기 요청 받음");
		
		return null;
	}
	
	@RequestMapping(value="/notice/update", method = RequestMethod.GET)
	public String update() {
		logger.debug("수정 요청 받음");
		return "redirect:/shop/notice/detail?notice_id=3";
	}
	
	@RequestMapping(value="/notice/delete", method = RequestMethod.GET)
	public String delete() {
		logger.debug("삭제 요청 받음");
		return "redirect:/shop/notice/detail?notice_id=3";
	}
}
