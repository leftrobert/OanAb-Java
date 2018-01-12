<%@page import="vn.com.fsoft.dao.ShirtDAO"%>
<%@page import="vn.com.fsoft.dao.CategoryDAO"%>
<%@page import="vn.com.fsoft.dao.MaterialDAO"%>
<%@page import="vn.com.fsoft.model.Shirt"%>
<%@page import="vn.com.fsoft.model.Category"%>
<%@page import="vn.com.fsoft.model.Material"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>OanAb - Shop</title>
		<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/resources/img/bg/VP.ico">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/oanab.css">
		<script src="${pageContext.request.contextPath}/resources/js/oanab.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=0.9">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<%if (session.getAttribute("loggedin") != null || session.getAttribute("adminin") != null || session.getAttribute("cart") != null) { %>
		<div class="usernav">
			<%if (session.getAttribute("loggedin") == null && session.getAttribute("adminin") != null) {%>
			<a href="admin-account" class="navimg">
				<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-5.svg" width="20" height="20">
			</a>
			<a href="admin-admins" class="navimg">
				<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-7.svg" width="20" height="20">
			</a>
			<a href="admin-users" class="navimg">
				<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-8.svg" width="20" height="20">
			</a>
			<a href="admin-shirts" class="navimg">
				<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-9.svg" width="20" height="20">
			</a>
			<a href="admin-supports" class="navimg">
				<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-11.svg" width="20" height="20">
			</a>
			<a href="admin-requests" class="navimg">
				<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-12.svg" width="20" height="20">
			</a>
			<%}
			if (session.getAttribute("adminin") == null && session.getAttribute("loggedin") != null) {%>
			<a href="account" class="navimg">
				<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-5.svg" width="20" height="20">
			</a>
			<a href="history" class="navimg">
				<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-6.svg" width="20" height="20">
			</a>
			<%}
			if (session.getAttribute("cart") != null) {%>
			<a href="cart" class="navimg">
				<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-1.svg" width="20" height="20">
			</a>
			<%}
			if (session.getAttribute("loggedin") != null || session.getAttribute("adminin") != null) { %>
			<a href="logout" class="navimg">
				<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-10.svg" width="20" height="20">
			</a>
			<%} %>
		</div>
		<%} %>
		<div class="top">
			<div class="top-c">
				<table>
					<tr>
						<td class="oanab-d">
							<a href="index">
								<div class="oanab">
									<span>OANAB</span>
								</div>
							</a>
						</td>
						<td></td>
						<td class="nav-d">
							<a href="shop">
								<div class="nav">
									<span>Shop</span>
								</div>
							</a>
						</td>
						<td class="nav-d">
							<a href="request">
								<div class="nav">
									<span>Request</span>
								</div>
							</a>
						</td>
						<td class="nav-d">
							<a href="login">
								<div class="nav">
									<span>Account</span>
								</div>
							</a>
						</td>
						<td class="nav-d">
							<a href="support">
								<div class="nav">
									<span>Support</span>
								</div>
							</a>
						</td>
						<td class="nav-d-i" onclick="menuIn();">
							<div class="nav-i">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-0.svg" width="30" height="30">
							</div>
						</td>
					</tr>
				</table>
				<div id="floatmenu" class="hide">
					<a href="shop">
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-1.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>Shop</span>
							</div>
						</div>
					</a>
					<a href="request">
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-2.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>Request</span>
							</div>
						</div>
					</a>
					<a href="login" id="hassub" <%if (session.getAttribute("loggedin") != null || session.getAttribute("adminin") != null) { %>onmouseenter="subIn();"<%} %>>
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-3.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>Account</span>
							</div>
						</div>
					</a>
					<a href="support">
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-4.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>Support</span>
							</div>
						</div>
					</a>
				</div>
				<%if (session.getAttribute("loggedin") != null || session.getAttribute("adminin") != null) { %>
				<div id="floatsubmenu" class="hidesub" onmouseleave="subOut();">
					<%if (session.getAttribute("loggedin") == null) {%>
					<a href="admin-account">
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-5.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>Admin info</span>
							</div>
						</div>
					</a>
					<a href="admin-admins">
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-7.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>Manage admins</span>
							</div>
						</div>
					</a>
					<a href="admin-users">
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-8.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>Manage users</span>
							</div>
						</div>
					</a>
					<a href="admin-shirts">
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-9.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>Manage T-shirts</span>
							</div>
						</div>
					</a>
					<a href="admin-supports">
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-11.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>Manage Q&A</span>
							</div>
						</div>
					</a>
					<a href="admin-requests">
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-12.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>Manage requests</span>
							</div>
						</div>
					</a>
					<%}
					if (session.getAttribute("adminin") == null) {%>
					<a href="account">
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-5.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>Personal info</span>
							</div>
						</div>
					</a>
					<a href="cart">
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-1.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>Cart</span>
							</div>
						</div>
					</a>
					<a href="history">
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-6.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>History</span>
							</div>
						</div>
					</a>
					<%} %>
					<a href="logout">
						<div class="menu-i">
							<div class="menuimg">
								<img src="${pageContext.request.contextPath}/resources/img/bg/nav-i-10.svg" width="24" height="24">
							</div><!--
							--><div class="menuname">
								<span>Logout</span>
							</div>
						</div>
					</a>
				</div>
				<%} %>
			</div>
		</div>
		<div id="dark" class="hided" onclick="menuOut();<%if (session.getAttribute("loggedin") != null || session.getAttribute("adminin") != null) { %> subOut();<%}%>"></div>
		<div class="banner">
			<form class="banner-c" name="searchbox" action="search" method="get">
				<div class="slogan">
					<span>It's not just clothes, it's T-shirts.</span>
				</div>
				<table class="search-b">
					<tr>
						<td class="search-b-t">
							<input type="text" name="kw" placeholder="Search through hundreds of tees ...">
						</td>
						<td class="search-b-b">
							<input type="submit" value="Search">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="page">
			<div class="page-c">
				<div class="clear"></div>
				<div class="sec" id="shop">
					<div class="sec-t">
						<div class="sec-t-l"></div>
						<div class="sec-t-m">
							CHOOSE YOUR T-SHIRTS!
						</div>
						<div class="sec-t-r"></div>
					</div>
					<div class="sec-f">
						<form name="filter" id="filter">
							<div class="field">
								Category<br>
								<select name="cat" form="filter" onchange="this.form.submit()">
									<option value="0">All categories</option>
									<% CategoryDAO cdao = new CategoryDAO();
									ArrayList<Category> clist = cdao.getList();
									if (clist != null) {
										for (Category c: clist) {%>
									<option value="<%=c.getId() %>" <%if (request.getParameter("cat") != null && request.getParameter("cat").equals(c.getId())) {%>selected<%};%>><%=c.getCatName() %></option>
									<%}} %>
								</select>
							</div>
							<div class="field">
								Gender<br>
								<select name="gen" form="filter" onchange="this.form.submit()">
									<option value="3">All genders</option>
									<option value="2" <%if (request.getParameter("gen") != null && request.getParameter("gen").equals("2")) {%>selected<%};%>>Unisex</option>
									<option value="1" <%if (request.getParameter("gen") != null && request.getParameter("gen").equals("1")) {%>selected<%};%>>Male</option>
									<option value="0" <%if (request.getParameter("gen") != null && request.getParameter("gen").equals("0")) {%>selected<%};%>>Female</option>
								</select>
							</div>
							<div class="field">
								Material<br>
								<select name="mat" form="filter" onchange="this.form.submit()">
									<option value="0">All materials</option>
									<% MaterialDAO mdao = new MaterialDAO();
									ArrayList<Material> mlist = mdao.getList();
									if (mlist != null) {
										for (Material m: mlist) {%>
									<option value="<%=m.getId() %>" <%if (request.getParameter("mat") != null && request.getParameter("mat").equals(m.getId())) {%>selected<%};%>><%=m.getMatName() %></option>
									<%}} %>
								</select>
							</div>
							<div class="field">
								Prefered size<br>
								<select name="size" form="filter" onchange="this.form.submit()">
									<option value="0">All sizes</option>
									<option value="XS" <%if (request.getParameter("gen") != null && request.getParameter("size").equals("XS")) {%>selected<%};%>>XS</option>
									<option value="S" <%if (request.getParameter("gen") != null && request.getParameter("size").equals("S")) {%>selected<%};%>>S</option>
									<option value="M" <%if (request.getParameter("gen") != null && request.getParameter("size").equals("M")) {%>selected<%};%>>M</option>
									<option value="L" <%if (request.getParameter("gen") != null && request.getParameter("size").equals("L")) {%>selected<%};%>>L</option>
									<option value="XL" <%if (request.getParameter("gen") != null && request.getParameter("size").equals("XL")) {%>selected<%};%>>XL</option>
									<option value="XXL" <%if (request.getParameter("gen") != null && request.getParameter("size").equals("XXL")) {%>selected<%};%>>XXL</option>
								</select>
							</div>
							<div class="field">
								Lowest price<br>
								<input type="number" name="low" min="0" <%if (request.getParameter("low") != null) {%>value="<%=request.getParameter("low") %>"<%} else {%>value="0"<%}; %> onblur="this.form.submit()">
							</div>
							<div class="field">
								Highest price (zero for infinite)<br>
								<input type="number" name="high" min="0" <%if (request.getParameter("high") != null) {%>value="<%=request.getParameter("high") %>"<%} else {%>value="0"<%}; %> onblur="this.form.submit()">
							</div>
							<br>
							<div class="field">
								Sort by<br>
								<select name="sort" form="filter" onchange="this.form.submit()">
									<option value="1" <%if (request.getParameter("gen") != null && request.getParameter("sort").equals("1")) {%>selected<%};%>>Newest first (default)</option>
									<option value="2" <%if (request.getParameter("gen") != null && request.getParameter("sort").equals("2")) {%>selected<%};%>>Oldest first</option>
									<option value="3" <%if (request.getParameter("gen") != null && request.getParameter("sort").equals("3")) {%>selected<%};%>>Most popular</option>
									<option value="4" <%if (request.getParameter("gen") != null && request.getParameter("sort").equals("4")) {%>selected<%};%>>Least popular</option>
									<option value="5" <%if (request.getParameter("gen") != null && request.getParameter("sort").equals("5")) {%>selected<%};%>>Cheap first</option>
									<option value="6" <%if (request.getParameter("gen") != null && request.getParameter("sort").equals("6")) {%>selected<%};%>>Expensive first</option>
								</select>
							</div>
							<br>
						</form>
					</div>
					<div class="clear"></div>
					<div class="sec-c">
						<% ShirtDAO sdao = new ShirtDAO();
						ArrayList<Shirt> slist;
						if (request.getParameter("cat") == null || request.getParameter("gen") == null || request.getParameter("mat") == null || request.getParameter("size") == null || request.getParameter("low") == null || request.getParameter("high") == null || request.getParameter("sort") == null) {
							slist = sdao.getList();
						} else {
							slist = sdao.getFilteredList(request.getParameter("cat"), request.getParameter("gen"), request.getParameter("mat"), request.getParameter("size"), request.getParameter("low"), request.getParameter("high"), request.getParameter("sort"));
						}
						if(slist != null){
						for(Shirt s: slist){
						%><a href="details?sid=<%=s.getId() %>">
							<div class="sec-c-i">
								<div name="<%=s.getId() %>" class="indexcolor"></div>
								<div class="sec-c-i-d" style="background: url(${pageContext.request.contextPath}/resources/img/t/m224.png) no-repeat, url(${pageContext.request.contextPath}/resources/simg/<%=s.getImageFile() %>) no-repeat; background-size: cover, 80px auto; background-position: center, 70px 52px;"></div>
								<table class="sec-c-i-t">
									<tr>
										<td class="sec-c-i-n" colspan="2"><%=s.getName() %></td>
									</tr>
									<tr>
										<td class="sec-c-i-m"><%=s.getMaterial() %></td>
										<td class="sec-c-t-s" align="right"><%=s.getSold() %> sold!</td>
									</tr>
									<tr>
										<td class="sec-c-i-p" colspan="2"><%=s.printPrice() %> VND</td>
									</tr>
								</table>
							</div>
						</a><% }} else { %><!--
					--><center><strong>No shirts could be found for your options for now. Please check back later.</strong></center><% } %>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="bot">
			<table class="bot-c">
				<tr>
					<td align="left">
						For studying and internship only, not for any commercial purpose.
					</td>
					<td align="right" width="128">
						OANAB _ 2018
					</td>
				</tr>
			</table>
		</div>
		
		<%if(slist != null){
		for(Shirt s: slist){%>
		<script>firstColor("<%=s.getId() %>", "<%=s.getColors() %>");</script>
		<%}} %>
	</body>
</html>