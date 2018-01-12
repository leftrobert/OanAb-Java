package vn.com.fsoft.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.com.fsoft.dao.RequestDAO;
import vn.com.fsoft.model.Request;

@Controller
public class RequestController   {
	public static final String PARAM_LATESTPHOTO = "LATEST_PHOTO_PARAM";

	@RequestMapping(value = "/handlingRequest", method = RequestMethod.POST)
	public String handlingRequest(@RequestParam("reqmail") String reqmail, @RequestParam("reqname") String reqname,
			@RequestParam("reqdesc") String reqdesc , @RequestParam("reqfile") MultipartFile file, HttpSession session, RedirectAttributes redirectAttributes ) {
		RequestDAO requestDAO = new RequestDAO();
		boolean hasFile = true;
		String fileName = null;
		Request request = new Request();
		request.setEmail(reqmail);
		request.setTitle(reqname);
		request.setDescription(reqdesc);
		ServletContext context = session.getServletContext(); 
		String rootPath = context.getRealPath("resources/rimg");
		File dirFile = new File(rootPath);
		if(!dirFile.exists()){
			dirFile.mkdir();
		}
		if (file.isEmpty()) {
            hasFile = false;
        } else {
        	String[] t = file.getOriginalFilename().split("\\.");
        	fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"))+"."+t[t.length-1]; 
			BufferedOutputStream stream = null;
		    byte[] bytes;
		    try {
				bytes = file.getBytes();
			    stream =new BufferedOutputStream(new FileOutputStream(new File(rootPath + File.separator + fileName)));  
			    stream.write(bytes);  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		    finally {
		    	try {
					stream.flush();
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
			@SuppressWarnings("unused")
			String filePath = rootPath + java.io.File.separator + fileName;
		}
		if (hasFile) request.setImageFile(fileName);
		requestDAO.saveRequetsDAO(request);
		session.setAttribute("message","Request sent successfully!");
		return "redirect:request";
	}

	@RequestMapping(value = "/manageRequest", method = RequestMethod.POST)
	public String manageRequest(@RequestParam("rid") String rid, @RequestParam("rstt") String rstt,
			@RequestParam("action") String action, RedirectAttributes redirectAttributes, HttpSession session) {
		RequestDAO rdao = new RequestDAO();
		if (action.equals("update")) {
			rdao.updateRequest(rid, rstt);
		}
		if (action.equals("delete")) {
			rdao.deleteRequest(rid);
		}
		return "redirect:admin-requests";
	}
	
}
