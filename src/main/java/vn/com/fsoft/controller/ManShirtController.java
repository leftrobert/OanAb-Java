package vn.com.fsoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.fsoft.dao.ManageShirtDAO;

@Controller
public class ManShirtController{
	@RequestMapping(value = "/manageShirt", method=RequestMethod.POST)
	public String manageShirt(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
	@RequestParam("sid") String sid, @RequestParam("sname") String sname, @RequestParam("sgen") String sgen, @RequestParam("scat") String scat, 
	@RequestParam("sdate") String sdate, @RequestParam("scolor") String scolor, @RequestParam("ssize") String ssize, @RequestParam("sprice") String sprice, 
	@RequestParam("sstt") String sstt, @RequestParam("action") String action, HttpSession session) {
		ManageShirtDAO sdao = new ManageShirtDAO();
		if (action.equals("update")) {
			sdao.updateShirt(sid, sname, scat, sgen, sdate, scolor, ssize, sprice, sstt);
		}
		if (action.equals("insert")) {
			String newID = sdao.nextID();
			sdao.insertShirt(newID, sname, scat, sgen, scolor, ssize, sprice, sstt);
		}
		if (action.equals("delete")) {
			sdao.deleteShirt(sid);
		}
		return "redirect:admin-shirts";
	}
}
