package vn.com.fsoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.fsoft.dao.ManageUserDAO;

@Controller
public class ManUserController{
	@RequestMapping(value = "/manageUser", method=RequestMethod.POST)
	public String manageUser(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
	@RequestParam("uid") String uid, @RequestParam("uname") String uname, @RequestParam("ugen") String ugen, 
	@RequestParam("udob") String udob, @RequestParam("uphone") String uphone, @RequestParam("uadd") String uadd, @RequestParam("upass") String upass, 
	@RequestParam("ustt") String ustt, @RequestParam("action") String action, HttpSession session) {
		ManageUserDAO udao = new ManageUserDAO();
		if (action.equals("update")) {
			udao.updateUser(uid, uname, ugen, udob, uphone, uadd, upass, ustt);
		}
		if (action.equals("insert")) {
			int newID = udao.nextID();
			udao.insertUser(newID, uname, ugen, udob, uphone, uadd, upass, ustt);
		}
		if (action.equals("delete")) {
			udao.deleteUser(uid);
		}
		return "redirect:admin-users";
	}
}
