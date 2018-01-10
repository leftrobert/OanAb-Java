<%@page import="vn.com.fsoft.dao.ManageShirtDAO"%>
<%@page import="vn.com.fsoft.model.Category"%>
<%@page import="vn.com.fsoft.model.Material"%>
<%@page import="vn.com.fsoft.model.Shirt"%>
<%@page import="vn.com.fsoft.model.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>OanAb - User Management</title>
		<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/resources/img/bg/VP.ico">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/oanab.css">
		<script src="${pageContext.request.contextPath}/resources/js/oanab.js"></script>
		<meta name="viewport" content="width=device-width, initial-scale=0.9">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body onload="launchingStatus();">
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
		<div class="page" style="top: 56px;">
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
			ManageShirtDAO msdao = new ManageShirtDAO(); %>
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
								By name<br>
								<input type="text" name="else" placeholder="Keyword" onblur="this.form.submit()"<%if (request.getParameter("else") != null) {%> value="<%=request.getParameter("else") %>"<%} %>>
							</div>
							<div class="field">
								Category<br>
								<select name="cat" onchange="this.form.submit()">
									<option value="0"<%if (request.getParameter("cat") != null && request.getParameter("cat").equals("0")) {%> selected<%} %>>All categories</option>
									<%if (msdao.getCatList() != null) {
										ArrayList<Category> clist = msdao.getCatList();
										for (Category c: clist) { %>
									<option value="<%=c.getId() %>"<%if (request.getParameter("cat") != null && request.getParameter("cat").equals(c.getId())) {%> selected<%} %>><%=c.getCatName() %></option>
									<%	}} %>
								</select>
							</div>
							<div class="field">
								Material<br>
								<select name="mat" onchange="this.form.submit()">
									<option value="0"<%if (request.getParameter("mat") != null && request.getParameter("mat").equals("0")) {%> selected<%} %>>All Materials</option>
									<%if (msdao.getMatList() != null) {
										ArrayList<Material> mlist = msdao.getMatList();
										for (Material m: mlist) { %>
									<option value="<%=c.getId() %>"<%if (request.getParameter("mat") != null && request.getParameter("mat").equals(c.getId())) {%> selected<%} %>><%=m.getMatName() %></option>
									<%	}} %>
								</select>
							</div>
							<div class="field">
								Gender<br>
								<select name="gen" onchange="this.form.submit()">
									<option value="3"<%if (request.getParameter("gen") != null && request.getParameter("gen").equals("2")) {%> selected<%} %>>All</option>
									<option value="2"<%if (request.getParameter("gen") != null && request.getParameter("gen").equals("2")) {%> selected<%} %>>Unisex</option>
									<option value="1"<%if (request.getParameter("gen") != null && request.getParameter("gen").equals("1")) {%> selected<%} %>>Male</option>
									<option value="0"<%if (request.getParameter("gen") != null && request.getParameter("gen").equals("0")) {%> selected<%} %>>Female</option>
								</select>
							</div>
							<div class="field">
								Prefered size<br>
								<select name="size" onchange="this.form.submit()">
									<option value="0">All sizes</option>
									<option value="XS" <%if (request.getParameter("size") != null && request.getParameter("size").equals("XS")) {%>selected<%};%>>XS</option>
									<option value="S" <%if (request.getParameter("size") != null && request.getParameter("size").equals("S")) {%>selected<%};%>>S</option>
									<option value="M" <%if (request.getParameter("size") != null && request.getParameter("size").equals("M")) {%>selected<%};%>>M</option>
									<option value="L" <%if (request.getParameter("size") != null && request.getParameter("size").equals("L")) {%>selected<%};%>>L</option>
									<option value="XL" <%if (request.getParameter("size") != null && request.getParameter("size").equals("XL")) {%>selected<%};%>>XL</option>
									<option value="XXL" <%if (request.getParameter("size") != null && request.getParameter("size").equals("XXL")) {%>selected<%};%>>XXL</option>
								</select>
							</div>
							<div class="field">
								Launching status<br>
								<select name="status" onchange="this.form.submit()">
									<option value="2"<%if (request.getParameter("status") != null && request.getParameter("status").equals("2")) {%> selected<%} %>>All statuses</option>
									<option value="1"<%if (request.getParameter("status") != null && request.getParameter("status").equals("1")) {%> selected<%} %>>Launching</option>
									<option value="0"<%if (request.getParameter("status") != null && request.getParameter("status").equals("0")) {%> selected<%} %>>Stopped</option>
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
								Sort by<br>
								<select name="sort" onchange="this.form.submit()">
									<option value="date"<%if (request.getParameter("sort") != null && request.getParameter("sort").equals("id")) {%> selected<%} %>>Registration date</option>
									<option value="name"<%if (request.getParameter("sort") != null && request.getParameter("sort").equals("name")) {%> selected<%} %>>Name</option>
									<option value="sold"<%if (request.getParameter("sort") != null && request.getParameter("sort").equals("sold")) {%> selected<%} %>>Sold amount</option>
									<option value="gender"<%if (request.getParameter("sort") != null && request.getParameter("sort").equals("gender")) {%> selected<%} %>>Gender</option>
									<option value="status"<%if (request.getParameter("sort") != null && request.getParameter("sort").equals("status")) {%> selected<%} %>>Launching status</option>
								</select>
							</div>
							<div class="field">
								Order<br>
								<select name="order" onchange="this.form.submit()">
									<option value="asc"<%if (request.getParameter("order") != null && request.getParameter("order").equals("asc")) {%> selected<%} %>>Ascending</option>
									<option value="desc"<%if (request.getParameter("order") != null && request.getParameter("order").equals("desc")) {%> selected<%} %>>Descending</option>
								</select>
								<input type="hidden" name="page" value="1">
								<%if (request.getParameter("sid") != null) {%>
									<input type="hidden" name="sid" value="<%=request.getParameter("sid") %>">
								<%} %>
								<%if (request.getParameter("new") != null) {%>
									<input type="hidden" name="new" value="new">
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
							USER LIST
						</div>
						<div class="sec-t-r"></div>
					</div>
					<div class="sec-f">
						<div class="clear"></div>
						<% ArrayList<Shirt> slist = null;
						if (request.getParameter("else") != null && request.getParameter("cat") != null && request.getParameter("gen") != null && request.getParameter("size") != null && request.getParameter("status") != null && request.getParameter("rpp") != null && request.getParameter("sort") != null && request.getParameter("order") != null) {
							uslist = msdao.getFilteredShirtList(request.getParameter("else"), request.getParameter("cat"), request.getParameter("gen"), request.getParameter("size"), request.getParameter("status"), request.getParameter("sort"), request.getParameter("order"));
						}
						else if (mudao.getShirtList() != null) {
							slist = mudao.getShirtList();
						}
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
						} else on = 1; %>
						<form style="width: 100%;" name="test">
							<% if (request.getParameter("else") != null && request.getParameter("gen") != null && request.getParameter("rpp") != null && request.getParameter("sort") != null && request.getParameter("order") != null && request.getParameter("status") != null) { %>
								<input type="hidden" name="else" value="<%=request.getParameter("else") %>">
								<input type="hidden" name="cat" value="<%=request.getParameter("cat") %>">
								<input type="hidden" name="gen" value="<%=request.getParameter("gen") %>">
								<input type="hidden" name="size" value="<%=request.getParameter("size") %>">
								<input type="hidden" name="rpp" value="<%=request.getParameter("rpp") %>">
								<input type="hidden" name="sort" value="<%=request.getParameter("sort") %>">
								<input type="hidden" name="order" value="<%=request.getParameter("order") %>">
								<input type="hidden" name="status" value="<%=request.getParameter("status") %>">
							<%} %>
							<% if (request.getParameter("page") != null) { %>
								<input type="hidden" name="page" value="<%=request.getParameter("page") %>">
							<%} %>
							<table>
								<tbody>
									<tr>
										<th>Name</th>
										<th>Category</th>
										<th>Gender</th>
										<th>Price</th>
										<th>Sold</th>
										<th>Status</th>
										<th>Action</th>
									</tr>
									<%
									for (Shirt sh: slist) {
										s = (on-1)*rpp-1;
										if (i > (on-1)*rpp && i <= on*rpp) {
										if ((i-s)%2 == 0) {%>
									<tr class="odd">
										<%} else { %>
									<tr class="even">
										<%}
// 										System.out.println(a.getRoleId());
										%>
										<td><%=sh.getName() %></td>
										<td><%=msdao.getCatName(sh.getCatId()) %></td>
										<td><%=sh.printGender() %></td>
										<td><%=sh.printPrice() %> VND</td>
										<td><%=sh.getSold() %></td>
										<td><%=(sh.isStatus()?"Yes":"No") %></td>
										<td><button name="sid" value="<%=sh.getId() %>">Select</button></td>
									</tr>
									<%}
										i++;
										}%>
								</tbody>
							</table>
						</form>
						<%} else {%>
						<center><strong>No results returned.</strong></center>
						<%} %>
					</div>
					<div class="sec-f">
						<div class="clear"></div>
<!-- 						<form style="width: 100%;" name="test"> -->
							<table style="box-shadow: none;">
								<tbody>
									<tr>
										<td align="left">
											<form id="paging">
												<% if (request.getParameter("else") != null && request.getParameter("gen") != null && request.getParameter("rpp") != null && request.getParameter("sort") != null && request.getParameter("order") != null && request.getParameter("status") != null) { %>
													<input type="hidden" name="else" value="<%=request.getParameter("else") %>">
													<input type="hidden" name="cat" value="<%=request.getParameter("cat") %>">
													<input type="hidden" name="gen" value="<%=request.getParameter("gen") %>">
													<input type="hidden" name="size" value="<%=request.getParameter("size") %>">
													<input type="hidden" name="rpp" value="<%=request.getParameter("rpp") %>">
													<input type="hidden" name="sort" value="<%=request.getParameter("sort") %>">
													<input type="hidden" name="order" value="<%=request.getParameter("order") %>">
													<input type="hidden" name="status" value="<%=request.getParameter("status") %>">
												<%} %>
												<% if (request.getParameter("sid") != null) { %>
													<input type="hidden" name="sid" value="<%=request.getParameter("sid") %>">
												<%} %>
												<% if (request.getParameter("new") != null) { %>
													<input type="hidden" name="new" value="<%=request.getParameter("new") %>">
												<%} %>
												<strong>Page: </strong>
											</form>
										</td>
										<td align="right">
											<form>
												<% if (request.getParameter("else") != null && request.getParameter("gen") != null && request.getParameter("rpp") != null && request.getParameter("sort") != null && request.getParameter("order") != null && request.getParameter("status") != null) { %>
													<input type="hidden" name="else" value="<%=request.getParameter("else") %>">
													<input type="hidden" name="cat" value="<%=request.getParameter("cat") %>">
													<input type="hidden" name="gen" value="<%=request.getParameter("gen") %>">
													<input type="hidden" name="size" value="<%=request.getParameter("size") %>">
													<input type="hidden" name="rpp" value="<%=request.getParameter("rpp") %>">
													<input type="hidden" name="sort" value="<%=request.getParameter("sort") %>">
													<input type="hidden" name="order" value="<%=request.getParameter("order") %>">
													<input type="hidden" name="status" value="<%=request.getParameter("status") %>">
												<%} %>
												<% if (request.getParameter("new") != null) { %>
													<input type="hidden" name="new" value="<%=request.getParameter("new") %>">
												<%} %>
												<% if (request.getParameter("page") != null) { %>
													<input type="hidden" name="page" value="<%=request.getParameter("page") %>">
												<%} %>
												<button name="new" value="new">Add</button>
											</form>
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
							CHANGE INFO
						</div>
						<div class="sec-t-r"></div>
					</div>
					<div class="clear"></div>
					<%if (request.getParameter("sid") == null && request.getParameter("new") == null) {%>
					<div class="sec-c">
						<center><strong>Select a shirt to change its information.</strong></center>
					</div>
					<%} else {
					Shirt s1 = null;
					if (request.getParameter("sid") != null) {
						s1 = mudao.getUser(request.getParameter("sid")); 
					}%>
					<form class="sec-i" id="regform" name="info" method="post" action="manageUser">
						<div class="field">
							Shirt name<br>
							<input type="text" name="sname" placeholder="T-shirt's name" <%if (u1 != null) {%>value="<%=u1.getName() %>"<%} %>>
						</div>
						<div class="field">
							Gender<br>
							<select name="ugen" form="regform">
								<option value="2" <% if (s1 != null) { if (s1.getGender()==2) {%>selected<%}} %>>Unisex</option>
								<option value="1" <% if (s1 != null) { if (s1.getGender()==1) {%>selected<%}} %>>Male</option>
								<option value="0" <% if (s1 != null) { if (s1.getGender()==0) {%>selected<%}} %>>Female</option>
							</select>
						</div>
						<div class="field">
							Date of birth<br>
							<input type="date" name="udob" <% if (u1 != null) {%>value="<%=u1.getDob() %>"<%} %>>
						</div>
						<div class="field" id="long">
							Address<br>
							<input type="text" name="uadd" placeholder="User's address" <%if (u1 != null) {%>value="<%=u1.getAddress() %>"<%} %>>
						</div>
						<div class="field">
							Password<br>
							<input type="password" name="upass" placeholder="Password" <%if (request.getParameter("new") != null) {%>required<%} %>>
						</div>
						<div class="field">
							Active status<br>
							<label class="container"><span name="s-status"></span>
								<input type="checkbox" name="status" <% if (u1 != null) { if (u1.isStatus()) {%>checked="checked"<%}} %> onchange="activeStatus();">
								<span class="checkmark"></span>
							</label>
							<input type="hidden" name="uid" value='<%=(u1==null?"0":u1.getId()) %>'>
							<input type="hidden" name="ustt">
						</div>
						<div class="field" id="long" style="text-align: center;">
							<%if (request.getParameter("new") != null) {%><button name="action" value="insert">Add</button><%} %>
							<%if (request.getParameter("new") == null && request.getParameter("uid") != null) {%><button name="action" value="update">Change</button><%} %>
							<%if (request.getParameter("new") == null) {%><button name="action" value="delete">Remove</button><%} %>
						</div>
					</form>
					<%} %>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<script>
			<%
			if (ulist != null) {
			int size = ulist.size();
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
						OANAB _ 2017
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>