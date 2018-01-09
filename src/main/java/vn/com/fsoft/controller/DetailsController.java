package vn.com.fsoft.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.fsoft.dao.ShirtDAO;
import vn.com.fsoft.model.Shirt;

@Controller
public class DetailsController{
	@RequestMapping(value = "/handlingDetails", method=RequestMethod.POST)
	public String handlingIndex(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
	@RequestParam("shirtId") String shirtid, HttpSession session){
		// TODO Auto-generated method stub
//		session.setAttribute("s_to_see", shirtid);
		return "redirect:details";
	}
}
