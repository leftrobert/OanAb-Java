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

import vn.com.fsoft.dao.AdminDAO;
import vn.com.fsoft.dao.LoginDAO;
import vn.com.fsoft.dao.ManageAdminDAO;
import vn.com.fsoft.dao.UserDAO;
import vn.com.fsoft.model.Admin;
import vn.com.fsoft.model.User;

@Controller
public class ManAdminController{
	@RequestMapping(value = "/manageAdmin", method=RequestMethod.POST)
	public String manageAdmin(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
	@RequestParam("aid") String aid, @RequestParam("aname") String aname, @RequestParam("arol") String arol, @RequestParam("agen") String agen, 
	@RequestParam("adob") String adob, @RequestParam("aphone") String aphone, @RequestParam("amail") String amail, @RequestParam("apass") String apass, 
	@RequestParam("astt") String astt, @RequestParam("action") String action, HttpSession session) {
		// TODO Auto-generated method stub
		Admin in = (Admin)session.getAttribute("adminin");
		ManageAdminDAO adao = new ManageAdminDAO();
		if (action.equals("update")) {
			adao.updateAdmin(aid, aname, arol, agen, adob, aphone, amail, apass, astt);
			if (aid.equals(in.getId())) {
				LoginDAO ldao = new LoginDAO();
				Admin newin = ldao.getAdmin(aid);
				session.setAttribute("adminin", newin);
			}
		}
		if (action.equals("insert")) {
			String newID = adao.nextID();
			adao.insertAdmin(newID, aname, arol, agen, adob, aphone, amail, apass, astt);
		}
		if (action.equals("delete")) {
			adao.deleteAdmin(aid);
		}
		return "redirect:admin-admins";
	}

	@RequestMapping(value = "/updateAdmin", method=RequestMethod.POST)
	public String updateAdmin(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
	@RequestParam("name") String aname, @RequestParam("gender") String agen, 
	@RequestParam("dob") String adob, @RequestParam("phone") String aphone, HttpSession session) {
		// TODO Auto-generated method stub
		Admin in = (Admin)session.getAttribute("adminin");
		ManageAdminDAO adao = new ManageAdminDAO();
		adao.updateAdminPersonal(in.getId(), aname, agen, adob, aphone);
		LoginDAO ldao = new LoginDAO();
		Admin newin = ldao.getAdmin(in.getId());
		session.setAttribute("adminin", newin);
		return "redirect:admin-account";
	}

	@RequestMapping(value = "/updateAdminPass", method=RequestMethod.POST)
	public String updateAdminPass(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
			@RequestParam("pass") String pass, @RequestParam("passn") String passn, @RequestParam("passc") String passc, HttpSession session) {
		// TODO Auto-generated method stub
		Admin in = (Admin)session.getAttribute("adminin");
		ManageAdminDAO adao = new ManageAdminDAO();
		if (!adao.md5p(pass).equals(in.getPassword())) {
			session.setAttribute("message", "Wrong old password");
			return "redirect:admin-account";
		} else if (!passn.equals(passc)) {
			session.setAttribute("message", "Incorrect password confirmed");
			return "redirect:admin-account";
		}
		session.setAttribute("message", "Your password has been changed");
		adao.updateAdminPass(in.getId(), passn);
		LoginDAO ldao = new LoginDAO();
		Admin newin = ldao.getAdmin(in.getId());
		session.setAttribute("adminin", newin);
		return "redirect:admin-account";
	}
}
