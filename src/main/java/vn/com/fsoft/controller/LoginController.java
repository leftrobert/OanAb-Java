package vn.com.fsoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.fsoft.dao.LoginDAO;
import vn.com.fsoft.model.Admin;
import vn.com.fsoft.model.User;

@Controller
public class LoginController{
	@RequestMapping(value = "/handlingLogin", method=RequestMethod.POST)
	public String handlingLogin(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
	@RequestParam("phone") String phone, @RequestParam("pass") String pass, HttpSession session){
		LoginDAO ldao = new LoginDAO();
		if(phone == "" || pass == "") {
			session.setAttribute("message", "Fill in the required field to continue");
			return "redirect:login";
		} else if (ldao.checkLogin(phone, pass)){
			User u = ldao.getUser(phone);
			if (u.isStatus()) {
				session.setAttribute("loggedin", u);
				if (session.getAttribute("adminin") != null) session.removeAttribute("adminin");
				if (session.getAttribute("message") != null) session.removeAttribute("message");
				return "redirect:account";
			} else {
				session.setAttribute("message", "You are temporarily banned");
				return "redirect:login";
			}
		} else {
			session.setAttribute("message", "Invalid credentials");
			return "redirect:login";
		}
	}
	

	@RequestMapping(value = "/handlingAdmin", method=RequestMethod.POST)
	public String handlingAdmin(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
	@RequestParam("admin") String admin, @RequestParam("pass") String pass, HttpSession session){
		LoginDAO ldao = new LoginDAO();
		if(admin == "" || pass == "") {
			session.setAttribute("message", "Fill in the required field to continue");
			return "redirect:admin";
		} else if (ldao.checkAdmin(admin, pass)){
			Admin a = ldao.getAdmin(admin);
			if (a.isStatus()) {
				session.setAttribute("adminin", a);
				if (session.getAttribute("loggedin") != null) session.removeAttribute("loggedin");
				if (session.getAttribute("message") != null) session.removeAttribute("message");
				return "redirect:admin-account";
			}
			else {
				session.setAttribute("message", "You are temporarily banned");
				return "redirect:admin";
			}
		} else {
			session.setAttribute("message", "Invalid credentials");
			return "redirect:admin";
		}
	}

	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest arg0, HttpServletResponse arg1m, RedirectAttributes redirectAttributes,
	HttpSession session){
		String from = "";
		if (session.getAttribute("loggedin") != null) {
			session.removeAttribute("loggedin");
			from = "u";
		}
		if (session.getAttribute("adminin") != null) {
			session.removeAttribute("adminin");
			from = "a";
		}
		if (from.equals("a")) return "redirect:admin";
		return "redirect:index";
	}
}
