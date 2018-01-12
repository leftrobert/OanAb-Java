<%@page import="vn.com.fsoft.dao.SupportDAO"%>
<%@page import="vn.com.fsoft.model.Support"%>
<%@page import="vn.com.fsoft.model.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>OanAb - Request Management</title>
		<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/resources/img/bg/VP.ico">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/oanab.css">
		<script src="${pageContext.request.contextPath}/resources/js/oanab.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=0.9">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body<%if (request.getParameter("sid")!=null) {%> onload="solvingStatus();"<%} %>>
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
		<div class="page" style="top:56px;">
		<%if (session.getAttribute("adminin") == null) {%>
		<div class="page-c">
			<div class="clear"></div>
			<div class="sec" id="caution">
				<div class="sec-t">
					<div class="sec-t-l"></div>
					<div class="sec-t-m">
						CAUTION
					</div>
					<div class="sec-t-r"></div>
				</div>
				<div class="sec-f">
					<div class="clear"></div>
					<center><strong>You must <a href="admin">login as admin</a> in order to manage these stuffs.</strong></center>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	<%	} else {
			Admin ain = (Admin)session.getAttribute("adminin");
			if (ain.getRoleId().equals("r3")) { %>
		<div class="page-c">
			<div class="clear"></div>
			<div class="sec" id="caution">
				<div class="sec-t">
					<div class="sec-t-l"></div>
					<div class="sec-t-m">
						CAUTION
					</div>
					<div class="sec-t-r"></div>
				</div>
				<div class="sec-f">
					<div class="clear"></div>
					<center><strong>You do not have rights to manage user's support request.</strong></center>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<%	} else {
			SupportDAO spdao = new SupportDAO(); %>
		<div class="page-c">
				<div class="clear"></div>
				<div class="sec" id="filter">
					<div class="sec-t">
						<div class="sec-t-l"></div>
						<div class="sec-t-m">
							FILTER
						</div>
						<div class="sec-t-r"></div>
					</div>
					<div class="sec-f">
						<form name="filter" id="filter">
							<div class="field">
								By text<br>
								<input type="text" name="else" placeholder="Keyword" onblur="this.form.submit()"<%if (request.getParameter("else") != null) {%> value="<%=request.getParameter("else") %>"<%} %>>
							</div>
							<div class="field">
								Active status<br>
								<select name="status" onchange="this.form.submit()">
									<option value="2"<%if (request.getParameter("status") != null && request.getParameter("status").equals("2")) {%> selected<%} %>>All statuses</option>
									<option value="1"<%if (request.getParameter("status") != null && request.getParameter("status").equals("1")) {%> selected<%} %>>Done</option>
									<option value="0"<%if (request.getParameter("status") != null && request.getParameter("status").equals("0")) {%> selected<%} %>>Pending</option>
								</select>
							</div>
							<div class="field">
								Results per page<br>
								<select name="rpp" onchange="this.form.submit()">
									<option value="5"<%if (request.getParameter("rpp") != null && request.getParameter("rpp").equals("5")) {%> selected<%} %>>5</option>
									<option value="10"<%if (request.getParameter("rpp") != null && request.getParameter("rpp").equals("10")) {%> selected<%} %>>10</option>
									<option value="20"<%if (request.getParameter("rpp") != null && request.getParameter("rpp").equals("20")) {%> selected<%} %>>20</option>
								</select>
							</div>
							<div class="field">
								Order<br>
								<select name="order" onchange="this.form.submit()">
									<option value="asc"<%if (request.getParameter("order") != null && request.getParameter("order").equals("asc")) {%> selected<%} %>>Oldest first</option>
									<option value="desc"<%if (request.getParameter("order") != null && request.getParameter("order").equals("desc")) {%> selected<%} %>>Newest first</option>
								</select>
								<input type="hidden" name="page" value="1">
								<%if (request.getParameter("sid") != null) {%>
									<input type="hidden" name="sid" value="<%=request.getParameter("sid") %>">
								<%} %>
							</div>
						</form>
					</div>
				</div>
				<div class="clear"></div>
				<div class="sec" id="manage">
					<div class="sec-t">
						<div class="sec-t-l"></div>
						<div class="sec-t-m">
							REQUEST LIST
						</div>
						<div class="sec-t-r"></div>
					</div>
					<div class="sec-f">
						<div class="clear"></div>
						<% ArrayList<Support> slist = null;
						if (request.getParameter("else") != null && request.getParameter("rpp") != null && request.getParameter("order") != null && request.getParameter("status") != null) {
							slist = spdao.getFilteredList(request.getParameter("else"), request.getParameter("status"), request.getParameter("order"));
						}
						else if (spdao.getList() != null) {
							slist = spdao.getList();
						}%>
						<form style="width: 100%;" name="test">
							<% if (request.getParameter("else") != null && request.getParameter("rpp") != null && request.getParameter("order") != null && request.getParameter("status") != null) { %>
								<input type="hidden" name="else" value="<%=request.getParameter("else") %>">
								<input type="hidden" name="rpp" value="<%=request.getParameter("rpp") %>">
								<input type="hidden" name="order" value="<%=request.getParameter("order") %>">
								<input type="hidden" name="status" value="<%=request.getParameter("status") %>">
							<%} %>
							<% if (request.getParameter("page") != null) { %>
								<input type="hidden" name="page" value="<%=request.getParameter("page") %>">
							<%} %>
							<table>
								<tbody>
									<tr>
										<th>#</th>
										<th>Date</th>
										<th>Title</th>
										<th>Status</th>
										<th>Action</th>
									</tr>
									<%
									if (slist != null) {
										int s;
										int i = 1;
										int rpp = 5;
										int on = 1;
										if (request.getParameter("rpp") != null) {
											rpp = Integer.parseInt(request.getParameter("rpp"));
										}
										if (request.getParameter("page") != null) {
											on = Integer.parseInt(request.getParameter("page"));
										} else on = 1; 
									for (Support sp: slist) {
										s = (on-1)*rpp-1;
										if (i > (on-1)*rpp && i <= on*rpp) {%>
									<tr class="<%=((i-s)%2==0?"odd":"even") %>">
										<td><%=i %></td>
										<td><%=sp.enDate() %></td>
										<td><%=sp.getTitle() %></td>
										<td><%=(sp.isStatus()?"Done":"Pending") %></td>
										<td><button name="sid" value="<%=sp.getId() %>">Select</button></td>
									</tr>
									<%}
										i++;
										}%>
								</tbody>
							</table>
						</form>
					</div>
					<div class="sec-f">
						<div class="clear"></div>
<!-- 						<form style="width: 100%;" name="test"> -->
							<table style="box-shadow: none;">
								<tbody>
									<tr>
										<td align="left">
											<form id="paging">
												<% if (request.getParameter("else") != null && request.getParameter("rpp") != null && request.getParameter("order") != null && request.getParameter("status") != null) { %>
													<input type="hidden" name="else" value="<%=request.getParameter("else") %>">
													<input type="hidden" name="rpp" value="<%=request.getParameter("rpp") %>">
													<input type="hidden" name="order" value="<%=request.getParameter("order") %>">
													<input type="hidden" name="status" value="<%=request.getParameter("status") %>">
												<%} %>
												<% if (request.getParameter("sid") != null) { %>
													<input type="hidden" name="sid" value="<%=request.getParameter("sid") %>">
												<%} %>
												<strong>Page: </strong>
											</form>
										</td>
										<td align="right">
											<strong>Select a request to view in the section below.</strong>
										</td>
									</tr>
								</tbody>
							</table>
<!-- 						</form> -->
					</div>
				</div>
				<div class="clear"></div>
				<div class="sec" id="admin-account">
					<div class="sec-t">
						<div class="sec-t-l"></div>
						<div class="sec-t-m">
							VIEW
						</div>
						<div class="sec-t-r"></div>
					</div>
					<div class="clear"></div>
					<%if (request.getParameter("sid") == null && request.getParameter("new") == null) {%>
					<div class="sec-c">
						<center><strong>Select a request to view and make changes.</strong></center>
					</div>
					<%} else {
					Support s1 = null;
					if (request.getParameter("sid") != null) {
						s1 = spdao.getSupport(request.getParameter("sid")); 
					}%>
					<form class="sec-i" id="regform" name="info" method="post" action="manageSupport">
						<table style="width:100%; line-height:24px; background:#FFFFFF; box-shadow:0 2px 5px rgba(0,0,0,.3);">
							<tbody>
								<tr colspan="2" class="sp"><tr>
								<tr>
									<td align="left" class="rsl"><strong>Email</strong></td>
									<td align="justify" class="rsr"><%=s1.getEmail() %></td>
								</tr>
								<tr colspan="2" class="sp"><tr>
								<tr>
									<td align="left" class="rsl"><strong>Title</strong></td>
									<td align="justify" class="rsr"><%=s1.getTitle() %></td>
								</tr>
								<tr colspan="2" class="sp"><tr>
								<tr>
									<td align="left" class="rsl"><strong>Description</strong></td>
									<td align="justify" class="rsr"><%=s1.getDescription() %></td>
								</tr>
								<tr colspan="2" class="sp"><tr>
								<tr style="background:#E8E8E8;">
									<td align="left" class="rsl">
										Status<br>
										<label class="container"><span name="s-status"></span>
											<input type="checkbox" name="status" <% if (s1 != null) { if (s1.isStatus()) {%>checked="checked"<%}} %> onchange="solvingStatus();">
											<span class="checkmark"></span>
										</label>
										<input type="hidden" name="sid" value='<%=(s1==null?"0":s1.getId()) %>'>
										<input type="hidden" name="sstt">
									</td>
									<td align="right" class="rsr">
										<button name="action" value="update">Change</button>
										<button name="action" value="delete">Remove</button>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
					<%}} %>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<script>
			<%
			if (slist != null) {
			int size = slist.size();
			int rpp = 5;
			if (request.getParameter("rpp") != null) rpp = Integer.parseInt(request.getParameter("rpp"));
			int on = 1;
			if (request.getParameter("page") != null) on = Integer.parseInt(request.getParameter("page"));
			%>
			pagingManagement(<%=size %>, <%=rpp %> , <%=on %>);
		</script>
		<%}}} %>
		<div class="clear" style="top: 56px;"></div>
		<div class="bot" style="top: 56px;">
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
	</body>
</html>