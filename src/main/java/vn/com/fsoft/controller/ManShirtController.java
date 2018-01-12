package vn.com.fsoft.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.com.fsoft.dao.ManageShirtDAO;

@Controller
public class ManShirtController{
	@RequestMapping(value = "/manageShirt", method=RequestMethod.POST)
	public String manageShirt(HttpServletRequest arg0, HttpServletResponse arg1m,RedirectAttributes redirectAttributes,
	@RequestParam("sid") String sid, @RequestParam("sname") String sname, @RequestParam("sgen") String sgen, @RequestParam("scat") String scat, 
	@RequestParam("sdate") String sdate, @RequestParam("scolor") String scolor, @RequestParam("ssize") String ssize, @RequestParam("sprice") String sprice, 
	@RequestParam("sstt") String sstt, @RequestParam("sfile") MultipartFile sfile, @RequestParam("action") String action, HttpSession session) {
		if (session.getAttribute("adminin") == null) return "redirect:admin";
		ManageShirtDAO sdao = new ManageShirtDAO();
		if (action.equals("update")) {
			sdao.updateShirt(sid, sname, scat, sgen, sdate, scolor, ssize, sprice, sstt);
		}
		if (action.equals("insert")) {
			boolean hasFile = true;
			String fileName = null;
			String newID = sdao.nextID();
			ServletContext context = session.getServletContext(); 
			String rootPath = context.getRealPath("resources/simg");
			File dirFile = new File(rootPath);
			if(!dirFile.exists()){
				dirFile.mkdir();
			}
			if (sfile.isEmpty()) {
	            hasFile = false;
	        } else {
	        	String[] t = sfile.getOriginalFilename().split("\\.");
	        	fileName = newID+"."+t[t.length-1]; 
				BufferedOutputStream stream = null;
			    byte[] bytes;
			    try {
					bytes = sfile.getBytes();
				    stream =new BufferedOutputStream(new FileOutputStream(new File(rootPath + File.separator + fileName)));  
				    stream.write(bytes);  
				} catch (IOException e) {
					e.printStackTrace();
				}  
			    finally {
			    	try {
						stream.flush();
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}  
				}
			}
			sdao.insertShirt(newID, sname, scat, sgen, scolor, ssize, (hasFile?fileName:null), sprice, sstt);
		}
		if (action.equals("delete")) {
			sdao.deleteShirt(sid);
		}
		return "redirect:admin-shirts";
	}
}
