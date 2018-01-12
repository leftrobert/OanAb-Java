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
import vn.com.fsoft.dao.ManageAdminDAO;
import vn.com.fsoft.dao.ManageUserDAO;
import vn.com.fsoft.model.Admin;
import vn.com.fsoft.model.User;

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

	@RequestMapping(value = "/updateUser", method=RequestMethod.POST)
	public String updateUser(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
	@RequestParam("name") String uname, @RequestParam("gender") String ugen, @RequestParam("address") String uadd, 
	@RequestParam("dob") String udob, @RequestParam("phone") String uphone, HttpSession session) {
		User in = (User)session.getAttribute("loggedin");
		ManageUserDAO mdao = new ManageUserDAO();
		mdao.updateUserPersonal(in.getId(), uname, uphone, ugen, udob, uadd);
		LoginDAO ldao = new LoginDAO();
		User newin = ldao.getUser(uphone);
		session.setAttribute("loggedin", newin);
		return "redirect:account";
	}

	@RequestMapping(value = "/updateUserPass", method=RequestMethod.POST)
	public String updateUserPass(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
			@RequestParam("pass") String pass, @RequestParam("passn") String passn, @RequestParam("passc") String passc, HttpSession session) {
		User in = (User)session.getAttribute("loggedin");
		ManageUserDAO mdao = new ManageUserDAO();
		if (!mdao.md5p(pass).equals(in.getPassword())) {
			session.setAttribute("message", "Wrong old password");
			return "redirect:account";
		} else if (!passn.equals(passc)) {
			session.setAttribute("message", "Incorrect password confirmed");
			return "redirect:account";
		}
		session.setAttribute("message", "Your password has been changed");
		mdao.updateUserPass(in.getId(), passn);
		User newin = mdao.getUser(String.valueOf(in.getId()));
		session.setAttribute("loggedin", newin);
		return "redirect:account";
	}

	@RequestMapping(value = "/handlingSignup", method=RequestMethod.POST)
	public String handlingSignup(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
	@RequestParam("uname") String uname, @RequestParam("uphone") String uphone, @RequestParam("ugen") String ugen, @RequestParam("udob") String udob, 
	@RequestParam("agreed") String agreed, @RequestParam("uadd") String uadd, @RequestParam("pass") String pass, @RequestParam("cpass") String cpass, 
	HttpSession session) {
		ManageUserDAO udao = new ManageUserDAO();
		if (agreed.equals("0")) {
			session.setAttribute("message", "You have to agree our Terms and Policies");
		} else if (!pass.equals(cpass)) {
			session.setAttribute("message", "Invalid password confirmed");
		} else {
			int newID = udao.nextID();
			udao.insertUser(newID, uname, ugen, udob, uphone, uadd, pass, "1");
			session.setAttribute("message", "Signed successfully");
		}
		return "redirect:signup#alert";
	}
}
