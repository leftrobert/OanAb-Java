package vn.com.fsoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.fsoft.dao.SupportDAO;
import vn.com.fsoft.model.Support;
@Controller
public class SupportController {
	@RequestMapping(value = "/handlingSupport", method = RequestMethod.POST)
	public String handlingSupport(@RequestParam("mail") String mail,@RequestParam("name") String name,
			@RequestParam("desc") String desc,RedirectAttributes redirectAttributes, HttpSession session ){
		SupportDAO supportDAO = new SupportDAO();	
		Support support= new Support();
		support.setEmail(mail);
		support.setDescription(desc);
		support.setTitle(name);
		supportDAO.saveSupport(support);
		session.setAttribute("message","Sent successfully!");
		return "redirect:support";
	}

	@RequestMapping(value = "/manageSupport", method = RequestMethod.POST)
	public String manageSupport(@RequestParam("sid") String sid, @RequestParam("sstt") String sstt,
			@RequestParam("action") String action, RedirectAttributes redirectAttributes, HttpSession session) {
		if (session.getAttribute("adminin") == null) return "redirect:admin";
		SupportDAO sdao = new SupportDAO();
		if (action.equals("update")) {
			sdao.updateSupport(sid, sstt);
		}
		if (action.equals("delete")) {
			sdao.deleteSupport(sid);
		}
		return "redirect:admin-supports";
	}
}