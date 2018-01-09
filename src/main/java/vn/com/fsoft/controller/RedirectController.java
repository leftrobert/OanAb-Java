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

import vn.com.fsoft.dao.CategoryDAO;
import vn.com.fsoft.dao.LoginDAO;
import vn.com.fsoft.dao.MaterialDAO;
import vn.com.fsoft.dao.UserDAO;
import vn.com.fsoft.model.Category;
import vn.com.fsoft.model.Material;
import vn.com.fsoft.model.User;

@Controller
public class RedirectController{
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public ModelAndView displayIndex(HttpServletRequest arg0, HttpServletResponse arg1){
		// TODO Auto-generated method stub
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/shop", method=RequestMethod.GET)
	public ModelAndView displayShop(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		// TODO Auto-generated method stub
		return new ModelAndView("shop");
	}

//	@RequestMapping(value = "/login", method=RequestMethod.GET)
//	public ModelAndView displayLogin(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
//		// TODO Auto-generated method stub
//		if (session.getAttribute("loggedin") != null) return new ModelAndView("account");
//		return new ModelAndView("login");
//	}

	@RequestMapping(value = "/admin", method=RequestMethod.GET)
	public ModelAndView displayAdminLogin(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		// TODO Auto-generated method stub
		return new ModelAndView("admin");
	}

	@RequestMapping(value = "/admin-account", method=RequestMethod.GET)
	public ModelAndView displayAdminAccount(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		// TODO Auto-generated method stub
		return new ModelAndView("admin-account");
	}

	@RequestMapping(value = "/admin-admins", method=RequestMethod.GET)
	public ModelAndView displayAdminManage(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		// TODO Auto-generated method stub
		return new ModelAndView("admin-admins");
	}

	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public ModelAndView displayUserLogin(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		// TODO Auto-generated method stub
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/account", method=RequestMethod.GET)
	public ModelAndView displayAccount(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		// TODO Auto-generated method stub
		return new ModelAndView("account");
	}

	@RequestMapping(value = "/request", method=RequestMethod.GET)
	public ModelAndView displayRequest(HttpServletRequest arg0, HttpServletResponse arg1){
		// TODO Auto-generated method stub
		return new ModelAndView("request");
	}

	@RequestMapping(value = "/details", method=RequestMethod.GET)
	public ModelAndView displayDetails(HttpServletRequest arg0, HttpServletResponse arg1){
		// TODO Auto-generated method stub
		return new ModelAndView("details");
	}

	@RequestMapping(value = "/cart", method=RequestMethod.GET)
	public ModelAndView displayCart(HttpServletRequest arg0, HttpServletResponse arg1){
		// TODO Auto-generated method stub
		return new ModelAndView("cart");
	}

	@RequestMapping(value = "/support", method=RequestMethod.GET)
	public ModelAndView displaySupport(HttpServletRequest arg0, HttpServletResponse arg1){
		// TODO Auto-generated method stub
		return new ModelAndView("support");
	}

	@RequestMapping(value = "/search", method=RequestMethod.GET)
	public ModelAndView displaySearch(HttpServletRequest arg0, HttpServletResponse arg1){
		// TODO Auto-generated method stub
		return new ModelAndView("search");
	}
}
