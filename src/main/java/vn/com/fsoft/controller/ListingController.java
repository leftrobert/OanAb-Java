package vn.com.fsoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ListingController{
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String handlingIndex(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
	HttpSession session){
		return "redirect:index";
	}
}
