/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-01-09 09:26:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vn.com.fsoft.dao.ShirtDAO;
import vn.com.fsoft.model.Shirt;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>OanAb</title>\r\n");
      out.write("\t\t<link rel=\"icon\" type=\"image/ico\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/VP.ico\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/oanab.css\">\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/js/oanab.js\"></script>\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=0.9\">\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t");
if (session.getAttribute("loggedin") != null || session.getAttribute("adminin") != null || session.getAttribute("cart") != null) { 
      out.write("\r\n");
      out.write("\t\t<div class=\"usernav\">\r\n");
      out.write("\t\t\t");
if (session.getAttribute("loggedin") == null && session.getAttribute("adminin") != null) {
      out.write("\r\n");
      out.write("\t\t\t<a href=\"admin-account\" class=\"navimg\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-5.svg\" width=\"20\" height=\"20\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t<a href=\"admin-admins\" class=\"navimg\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-7.svg\" width=\"20\" height=\"20\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t<a href=\"admin-users\" class=\"navimg\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-8.svg\" width=\"20\" height=\"20\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t<a href=\"admin-shirts\" class=\"navimg\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-9.svg\" width=\"20\" height=\"20\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t");
}
			if (session.getAttribute("adminin") == null && session.getAttribute("loggedin") != null) {
      out.write("\r\n");
      out.write("\t\t\t<a href=\"account\" class=\"navimg\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-5.svg\" width=\"20\" height=\"20\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t<a href=\"history\" class=\"navimg\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-6.svg\" width=\"20\" height=\"20\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t");
}
			if (session.getAttribute("cart") != null) {
      out.write("\r\n");
      out.write("\t\t\t<a href=\"cart\" class=\"navimg\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-1.svg\" width=\"20\" height=\"20\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t");
}
			if (session.getAttribute("loggedin") != null || session.getAttribute("adminin") != null) { 
      out.write("\r\n");
      out.write("\t\t\t<a href=\"logout\" class=\"navimg\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-10.svg\" width=\"20\" height=\"20\">\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t<div class=\"top\">\r\n");
      out.write("\t\t\t<div class=\"top-c\">\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"oanab-d\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"index\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"oanab\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>OANAB</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"nav-d\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"shop\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"nav\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>Shop</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"nav-d\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"request\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"nav\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>Request</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"nav-d\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"login\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"nav\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>Account</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"nav-d\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"support\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"nav\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>Support</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"nav-d-i\" onclick=\"menuIn();\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"nav-i\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-0.svg\" width=\"30\" height=\"30\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<div id=\"floatmenu\" class=\"hide\">\r\n");
      out.write("\t\t\t\t\t<a href=\"shop\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"menu-i\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"menuimg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-1.svg\" width=\"24\" height=\"24\">\r\n");
      out.write("\t\t\t\t\t\t\t</div><!--\r\n");
      out.write("\t\t\t\t\t\t\t--><div class=\"menuname\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Shop</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"request\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"menu-i\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"menuimg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-2.svg\" width=\"24\" height=\"24\">\r\n");
      out.write("\t\t\t\t\t\t\t</div><!--\r\n");
      out.write("\t\t\t\t\t\t\t--><div class=\"menuname\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Request</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"login\" id=\"hassub\" ");
if (session.getAttribute("loggedin") != null || session.getAttribute("adminin") != null) { 
      out.write("onmouseenter=\"subIn();\"");
} 
      out.write(">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"menu-i\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"menuimg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-3.svg\" width=\"24\" height=\"24\">\r\n");
      out.write("\t\t\t\t\t\t\t</div><!--\r\n");
      out.write("\t\t\t\t\t\t\t--><div class=\"menuname\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Account</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"support\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"menu-i\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"menuimg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-4.svg\" width=\"24\" height=\"24\">\r\n");
      out.write("\t\t\t\t\t\t\t</div><!--\r\n");
      out.write("\t\t\t\t\t\t\t--><div class=\"menuname\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Support</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");
if (session.getAttribute("loggedin") != null || session.getAttribute("adminin") != null) { 
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"floatsubmenu\" class=\"hidesub\" onmouseleave=\"subOut();\">\r\n");
      out.write("\t\t\t\t\t");
if (session.getAttribute("loggedin") == null) {
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"admin-account\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"menu-i\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"menuimg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-5.svg\" width=\"24\" height=\"24\">\r\n");
      out.write("\t\t\t\t\t\t\t</div><!--\r\n");
      out.write("\t\t\t\t\t\t\t--><div class=\"menuname\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Admin info</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"admin-admins\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"menu-i\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"menuimg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-7.svg\" width=\"24\" height=\"24\">\r\n");
      out.write("\t\t\t\t\t\t\t</div><!--\r\n");
      out.write("\t\t\t\t\t\t\t--><div class=\"menuname\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Manage admins</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"admin-users\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"menu-i\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"menuimg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-8.svg\" width=\"24\" height=\"24\">\r\n");
      out.write("\t\t\t\t\t\t\t</div><!--\r\n");
      out.write("\t\t\t\t\t\t\t--><div class=\"menuname\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Manage users</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"admin-shirts\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"menu-i\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"menuimg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-9.svg\" width=\"24\" height=\"24\">\r\n");
      out.write("\t\t\t\t\t\t\t</div><!--\r\n");
      out.write("\t\t\t\t\t\t\t--><div class=\"menuname\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Manage T-shirts</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t");
}
					if (session.getAttribute("adminin") == null) {
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"account\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"menu-i\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"menuimg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-5.svg\" width=\"24\" height=\"24\">\r\n");
      out.write("\t\t\t\t\t\t\t</div><!--\r\n");
      out.write("\t\t\t\t\t\t\t--><div class=\"menuname\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Personal info</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"cart\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"menu-i\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"menuimg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-1.svg\" width=\"24\" height=\"24\">\r\n");
      out.write("\t\t\t\t\t\t\t</div><!--\r\n");
      out.write("\t\t\t\t\t\t\t--><div class=\"menuname\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Cart</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"history\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"menu-i\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"menuimg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-6.svg\" width=\"24\" height=\"24\">\r\n");
      out.write("\t\t\t\t\t\t\t</div><!--\r\n");
      out.write("\t\t\t\t\t\t\t--><div class=\"menuname\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>History</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"logout\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"menu-i\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"menuimg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/bg/nav-i-10.svg\" width=\"24\" height=\"24\">\r\n");
      out.write("\t\t\t\t\t\t\t</div><!--\r\n");
      out.write("\t\t\t\t\t\t\t--><div class=\"menuname\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>Logout</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"dark\" class=\"hided\" onclick=\"menuOut();");
if (session.getAttribute("loggedin") != null || session.getAttribute("adminin") != null) { 
      out.write(" subOut();");
}
      out.write("\"></div>\r\n");
      out.write("\t\t<div class=\"banner\">\r\n");
      out.write("\t\t\t<form class=\"banner-c\" name=\"searchbox\" action=\"search\" method=\"get\">\r\n");
      out.write("\t\t\t\t<div class=\"slogan\">\r\n");
      out.write("\t\t\t\t\t<span>It's not just clothes, it's T-shirts.</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<table class=\"search-b\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"search-b-t\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"kw\" placeholder=\"Search through hundreds of tees ...\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"search-b-b\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" value=\"Search\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"page\">\r\n");
      out.write("\t\t\t<div class=\"page-c\">\r\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"sec\" id=\"hot\">\r\n");
      out.write("\t\t\t\t\t<div class=\"sec-t\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"sec-t-l\"></div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"sec-t-m\">\r\n");
      out.write("\t\t\t\t\t\t\tNEW!\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"sec-t-r\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"sec-c\">\r\n");
      out.write("\t\t\t\t\t\t");
 ShirtDAO sdao = new ShirtDAO();
						ArrayList<Shirt> hlist = sdao.getHotList();
						if(hlist != null){
						for(Shirt s: hlist){
						
      out.write("<a href=\"details?sid=");
      out.print(s.getId() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"sec-c-i\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div name=\"");
      out.print(s.getId() );
      out.write("\" class=\"indexcolor\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"sec-c-i-d\" style=\"background: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/t/m224.png) no-repeat, url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/simg/");
      out.print(s.getImageFile() );
      out.write(") no-repeat; background-size: cover, 80px auto; background-position: center, 72px 52px;\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<table class=\"sec-c-i-t\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"sec-c-i-n\" colspan=\"2\">");
      out.print(s.getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"sec-c-i-m\">");
      out.print(s.getMaterial() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"sec-c-t-s\" align=\"right\">");
      out.print(s.getSold() );
      out.write(" sold!</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"sec-c-i-p\" colspan=\"2\">");
      out.print(s.printPrice() );
      out.write(" VND</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</a>");
 }} 
      out.write("<!--\r\n");
      out.write("\t\t\t\t\t--></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"sec\" id=\"trend\">\r\n");
      out.write("\t\t\t\t\t<div class=\"sec-t\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"sec-t-l\"></div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"sec-t-m\">\r\n");
      out.write("\t\t\t\t\t\t\tTRENDING\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"sec-t-r\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"sec-c\">\r\n");
      out.write("\t\t\t\t\t\t");
 ArrayList<Shirt> tlist = sdao.getTrendingList();
						if(tlist != null){
						for(Shirt s: tlist){
						
      out.write("<a href=\"details?sid=");
      out.print(s.getId() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"sec-c-i\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div name=\"");
      out.print(s.getId() );
      out.write("\" class=\"indexcolor\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"sec-c-i-d\" style=\"background: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/img/t/m224.png) no-repeat, url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/simg/");
      out.print(s.getImageFile() );
      out.write(") no-repeat; background-size: cover, 80px auto; background-position: center, 72px 52px;\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<table class=\"sec-c-i-t\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"sec-c-i-n\" colspan=\"2\">");
      out.print(s.getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"sec-c-i-m\">");
      out.print(s.getMaterial() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"sec-c-t-s\" align=\"right\">");
      out.print(s.getSold() );
      out.write(" sold!</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"sec-c-i-p\" colspan=\"2\">");
      out.print(s.printPrice() );
      out.write(" VND</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</a>");
 }} 
      out.write("<!--\r\n");
      out.write("\t\t\t\t\t--></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t<div class=\"sec\" id=\"fun\">\r\n");
      out.write("\t\t\t\t\t<div class=\"sec-t\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"sec-t-l\"></div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"sec-t-m\">\r\n");
      out.write("\t\t\t\t\t\t\tMORE FUN?\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"sec-t-r\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<table class=\"sec-c\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t\t\t<form>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\tWant something interesting? Be our designer or submit a request for your own design.\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"92\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"join\" value=\"Join Us!\" onclick=\"window.location.assign('login');\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"92\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"request\" value=\"Request\" onclick=\"window.location.assign('request');\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t<div class=\"bot\">\r\n");
      out.write("\t\t\t<table class=\"bot-c\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"left\">\r\n");
      out.write("\t\t\t\t\t\tFor studying and internship only, not for any commercial purpose.\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\" width=\"128\">\r\n");
      out.write("\t\t\t\t\t\tOANAB _ 2017\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
if(hlist != null){
		for(Shirt s: hlist){
      out.write("\r\n");
      out.write("\t\t<script>firstColor(\"");
      out.print(s.getId() );
      out.write("\", \"");
      out.print(s.getColors() );
      out.write("\");</script>\r\n");
      out.write("\t\t");
}} 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
if(tlist != null){
		for(Shirt s: tlist){
      out.write("\r\n");
      out.write("\t\t<script>firstColor(\"");
      out.print(s.getId() );
      out.write("\", \"");
      out.print(s.getColors() );
      out.write("\");</script>\r\n");
      out.write("\t\t");
}} 
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
