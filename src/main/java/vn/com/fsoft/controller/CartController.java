package vn.com.fsoft.controller;

import java.util.ArrayList;
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
import vn.com.fsoft.model.Cart;
import vn.com.fsoft.model.Shirt;

@Controller
public class CartController{
	@RequestMapping(value = "/addToCart", method=RequestMethod.POST)
	public String handlingCart(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
			@RequestParam("shirtId") String shirtid, @RequestParam("size") String size, @RequestParam("color") String color, @RequestParam("amount") String amount, HttpSession session){
		// TODO Auto-generated method stub
		ArrayList<Cart> cartlist;
		int a = Integer.parseInt(amount);
		ShirtDAO sdao = new ShirtDAO();
		if (session.getAttribute("cart") == null) {
			cartlist = new ArrayList<Cart>();
		} else {
			cartlist = (ArrayList<Cart>)session.getAttribute("cart");
		}
		for (Cart c0: cartlist) {
			if (c0.getShirtId().equals(shirtid) && c0.getSize().equals(size) && c0.getColor().equals(color)) {
				System.out.println("mat hang da co");
				c0.setAmount(c0.getAmount() + a);
				c0.setPrice(c0.getAmount() * sdao.getShirt(shirtid).getPrice());
				session.setAttribute("cart", cartlist);
				return "redirect:cart";
			}
		}
		Cart c = new Cart();
		c.setShirtId(shirtid);
		c.setSize(size);
		c.setColor(color);
		c.setAmount(a);
		c.setPrice(a * sdao.getShirt(shirtid).getPrice());
		cartlist.add(c);
		session.setAttribute("cart", cartlist);
		return "redirect:cart";
	}

	@RequestMapping(value = "/removeFromCart", method=RequestMethod.POST)
	public String handlingRemoveCart(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
			@RequestParam("remove") String index, HttpSession session){
		// TODO Auto-generated method stub
		ArrayList<Cart> cartlist = (ArrayList<Cart>)session.getAttribute("cart");
		int i = Integer.parseInt(index);
		cartlist.remove(i);
		if (cartlist.size() == 0) session.removeAttribute("cart");
		return "redirect:cart";
	}
}
