<%@page import="vn.com.fsoft.dao.ManageUserDAO"%>
<%@page import="vn.com.fsoft.model.User"%>
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
	<body<%if (request.getParameter("uid")!=null || request.getParameter("new")!=null) {%> onload="activeStatus();"<%} %>>
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
					<center><strong>You do not have rights to manage OanAb's users.</strong></center>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<%	} else {
			ManageUserDAO mudao = new ManageUserDAO(); %>
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
								<input type="text" name="else" placeholder="User phone or name" onblur="this.form.submit()"<%if (request.getParameter("else") != null) {%> value="<%=request.getParameter("else") %>"<%} %>>
							</div>
							<div class="field">
								Gender<br>
								<select name="gen" onchange="this.form.submit()">
									<option value="2"<%if (request.getParameter("gen") != null && request.getParameter("gen").equals("2")) {%> selected<%} %>>All</option>
									<option value="1"<%if (request.getParameter("gen") != null && request.getParameter("gen").equals("1")) {%> selected<%} %>>Male</option>
									<option value="0"<%if (request.getParameter("gen") != null && request.getParameter("gen").equals("0")) {%> selected<%} %>>Female</option>
								</select>
							</div>
							<div class="field">
								Active status<br>
								<select name="status" onchange="this.form.submit()">
									<option value="2"<%if (request.getParameter("status") != null && request.getParameter("status").equals("2")) {%> selected<%} %>>All statuses</option>
									<option value="1"<%if (request.getParameter("status") != null && request.getParameter("status").equals("1")) {%> selected<%} %>>Active</option>
									<option value="0"<%if (request.getParameter("status") != null && request.getParameter("status").equals("0")) {%> selected<%} %>>Inactive</option>
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
									<option value="regDate"<%if (request.getParameter("sort") != null && request.getParameter("sort").equals("id")) {%> selected<%} %>>Registration date</option>
									<option value="name"<%if (request.getParameter("sort") != null && request.getParameter("sort").equals("name")) {%> selected<%} %>>Name</option>
									<option value="dob"<%if (request.getParameter("sort") != null && request.getParameter("sort").equals("dob")) {%> selected<%} %>>Date of birth</option>
									<option value="gender"<%if (request.getParameter("sort") != null && request.getParameter("sort").equals("gender")) {%> selected<%} %>>Gender</option>
									<option value="status"<%if (request.getParameter("sort") != null && request.getParameter("sort").equals("status")) {%> selected<%} %>>Working status</option>
								</select>
							</div>
							<div class="field">
								Order<br>
								<select name="order" onchange="this.form.submit()">
									<option value="asc"<%if (request.getParameter("order") != null && request.getParameter("order").equals("asc")) {%> selected<%} %>>Ascending</option>
									<option value="desc"<%if (request.getParameter("order") != null && request.getParameter("order").equals("desc")) {%> selected<%} %>>Descending</option>
								</select>
								<input type="hidden" name="page" value="1">
								<%if (request.getParameter("uid") != null) {%>
									<input type="hidden" name="uid" value="<%=request.getParameter("uid") %>">
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
						<% ArrayList<User> ulist = null;
						if (request.getParameter("else") != null && request.getParameter("gen") != null && request.getParameter("rpp") != null && request.getParameter("sort") != null && request.getParameter("order") != null && request.getParameter("status") != null) {
							ulist = mudao.getFilteredUserList(request.getParameter("else"), request.getParameter("gen"), request.getParameter("status"), request.getParameter("sort"), request.getParameter("order"));
						}
						else if (mudao.getUserList() != null) {
							ulist = mudao.getUserList();
						}
						if (ulist != null) {
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
								<input type="hidden" name="gen" value="<%=request.getParameter("gen") %>">
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
										<th>ID</th>
										<th>Name</th>
										<th>Gender</th>
										<th>DOB</th>
										<th>Phone</th>
										<th>Status</th>
										<th>Action</th>
									</tr>
									<%
									for (User u: ulist) {
										s = (on-1)*rpp-1;
										if (i > (on-1)*rpp && i <= on*rpp) {
										if ((i-s)%2 == 0) {%>
									<tr class="odd">
										<%} else { %>
									<tr class="even">
										<%}
// 										System.out.println(a.getRoleId());
										%>
										<td><%=u.getId() %></td>
										<td><%=u.getName() %></td>
										<td><%if (u.isGender()) {%>Male<%} else {%>Female<%} %></td>
										<td><%=u.enDob() %></td>
										<td><%=u.getPhone() %></td>
										<td><%if (u.isStatus()) {%>Yes<%} else {%>No<%} %></td>
										<td><button name="uid" value="<%=u.getId() %>">Select</button></td>
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
													<input type="hidden" name="gen" value="<%=request.getParameter("gen") %>">
													<input type="hidden" name="rpp" value="<%=request.getParameter("rpp") %>">
													<input type="hidden" name="sort" value="<%=request.getParameter("sort") %>">
													<input type="hidden" name="order" value="<%=request.getParameter("order") %>">
													<input type="hidden" name="status" value="<%=request.getParameter("status") %>">
												<%} %>
												<% if (request.getParameter("uid") != null) { %>
													<input type="hidden" name="uid" value="<%=request.getParameter("uid") %>">
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
													<input type="hidden" name="gen" value="<%=request.getParameter("gen") %>">
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
					<%if (request.getParameter("uid") == null && request.getParameter("new") == null) {%>
					<div class="sec-c">
						<center><strong>Select a user to change their information.</strong></center>
					</div>
					<%} else {
					User u1 = null;
					if (request.getParameter("uid") != null) {
						u1 = mudao.getUser(request.getParameter("uid")); 
					}%>
					<form class="sec-i" id="regform" name="info" method="post" action="manageUser">
						<div class="field">
							User phone<br>
							<input type="text" name="uphone" placeholder="Mobile phone number" <%if (u1 != null) {%>value="<%=u1.getPhone() %>"<%} %> <%if (request.getParameter("new") == null) {%> readonly<%} %>>
						</div>
						<div class="field">
							User name<br>
							<input type="text" name="uname" placeholder="User's full name" <%if (u1 != null) {%>value="<%=u1.getName() %>"<%} %>>
						</div>
						<div class="field">
							Gender<br>
							<select name="ugen" form="regform">
								<option value="1" <% if (u1 != null) { if (u1.isGender()) {%>selected<%}} %>>Male</option>
								<option value="0" <% if (u1 != null) { if (!u1.isGender()) {%>selected<%}} %>>Female</option>
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