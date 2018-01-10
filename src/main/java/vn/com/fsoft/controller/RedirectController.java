package vn.com.fsoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectController{
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public ModelAndView displayIndex(HttpServletRequest arg0, HttpServletResponse arg1){
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/shop", method=RequestMethod.GET)
	public ModelAndView displayShop(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		return new ModelAndView("shop");
	}

	@RequestMapping(value = "/admin", method=RequestMethod.GET)
	public ModelAndView displayAdminLogin(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		return new ModelAndView("admin");
	}

	@RequestMapping(value = "/admin-account", method=RequestMethod.GET)
	public ModelAndView displayAdminAccount(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		return new ModelAndView("admin-account");
	}

	@RequestMapping(value = "/admin-admins", method=RequestMethod.GET)
	public ModelAndView displayAdminManage(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		return new ModelAndView("admin-admins");
	}

	@RequestMapping(value = "/admin-users", method=RequestMethod.GET)
	public ModelAndView displayUserManage(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		return new ModelAndView("admin-users");
	}

	@RequestMapping(value = "/admin-shirts", method=RequestMethod.GET)
	public ModelAndView displayShirtManage(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		return new ModelAndView("admin-shirts");
	}

	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public ModelAndView displayUserLogin(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/account", method=RequestMethod.GET)
	public ModelAndView displayAccount(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		return new ModelAndView("account");
	}

	@RequestMapping(value = "/history", method=RequestMethod.GET)
	public ModelAndView displayHistory(HttpServletRequest arg0, HttpServletResponse arg1, HttpSession session){
		return new ModelAndView("history");
	}

	@RequestMapping(value = "/request", method=RequestMethod.GET)
	public ModelAndView displayRequest(HttpServletRequest arg0, HttpServletResponse arg1){
		return new ModelAndView("request");
	}

	@RequestMapping(value = "/details", method=RequestMethod.GET)
	public ModelAndView displayDetails(HttpServletRequest arg0, HttpServletResponse arg1){
		return new ModelAndView("details");
	}

	@RequestMapping(value = "/cart", method=RequestMethod.GET)
	public ModelAndView displayCart(HttpServletRequest arg0, HttpServletResponse arg1){
		return new ModelAndView("cart");
	}

	@RequestMapping(value = "/support", method=RequestMethod.GET)
	public ModelAndView displaySupport(HttpServletRequest arg0, HttpServletResponse arg1){
		return new ModelAndView("support");
	}

	@RequestMapping(value = "/search", method=RequestMethod.GET)
	public ModelAndView displaySearch(HttpServletRequest arg0, HttpServletResponse arg1){
		return new ModelAndView("search");
	}
}
