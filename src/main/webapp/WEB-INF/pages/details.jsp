<%@page import="vn.com.fsoft.dao.ShirtDAO"%>
<%@page import="vn.com.fsoft.model.Shirt"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>OanAb - T-shirt details</title>
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
				<div class="sec" id="details">
					<div class="sec-t">
						<div class="sec-t-l"></div>
						<div class="sec-t-m">
							T-SHIRT DETAILS
						</div>
						<div class="sec-t-r"></div>
					</div>
					<div class="sec-c">
						<div class="clear"></div>
						<% ShirtDAO sdao = new ShirtDAO();
						Shirt see = null;
						if(sdao.getShirt(request.getParameter("sid")) != null) {
							see = sdao.getShirt(request.getParameter("sid"));
						%>
						<div class="view">
							<div id="color"></div>
							<div id="shirt" style="background: url(${pageContext.request.contextPath}/resources/img/t/m430.png) no-repeat, url(${pageContext.request.contextPath}/resources/simg/<%=see.getImageFile() %>) no-repeat; background-size: cover, 156px auto; background-position: center, 137px 102px;"></div>
						</div>
						<form name="decide" id="decide" class="detail" method="post" action="addToCart">
							<table>
								<tr>
									<td class="choose" colspan="2">
										Available colors
										<div class="colors">
										</div>
										<div class="clear"></div>
									</td>
								</tr>
								<tr>
									<td class="rh">Name</td>
									<td class="rd"><%=see.getName() %></td>
								</tr>
								<tr>
									<td class="rh">Price</td>
									<td class="rd"><%=see.printPrice() %> VND</td>
								</tr>
								<tr>
									<td class="rh">Category</td>
									<td class="rd"><%=sdao.getCatName(see.getCatId()) %></td>
								</tr>
								<tr>
									<td class="rh">Gender</td>
									<td class="rd"><%=see.printGender() %></td>
								</tr>
								<tr>
									<td class="rh">Material</td>
									<td class="rd"><%=see.getMaterial() %></td>
								</tr>
								<tr>
									<td class="rh">Designed date</td>
									<td class="rd"><%=see.getDate() %></td>
								</tr>
								<tr>
									<td class="rh">Sold out</td>
									<td class="rd"><%=see.getSold() %></td>
								</tr>
								<%if (see.isStatus()) {%>
								<tr>
									<td class="rh">Select size</td>
									<td class="rd">
										<select name="size" form="decide">
										</select>
									</td>
								</tr>
								<tr>
									<td class="rh">Select color</td>
									<td class="rd">
										<select name="color" form="decide">
										</select>
									</td>
								</tr>
								<tr>
									<td class="rh">Amount</td>
									<td class="rd">
										<input type="number" name="amount" value="1" min="1" max="99" maxlength="2">
									</td>
								</tr>
								<tr>
									<td class="choose" colspan="2">
										<br>
										<input type="hidden" name="shirtId" value="<%=see.getId() %>">
										<input type="submit" name="buy" value="Add to cart">
									</td>
								</tr>
								<%} else { %>
								<tr>
									<td class="choose" colspan="2">
										<br>
										<strong class="stopped" style="background:#EA8B52;color:#FFFFFF;padding:9px 18px;box-shadow:0 2px 5px rgba(0,0,0,.3);cursor:default;">This T-shirt is stopped selling out.</strong>
									</td>
								</tr>
								<%} %>
							</table>
						</form>
						<script>
							colorButtonsRendering("<%=see.getColors() %>", "<%=see.isStatus() %>");
							<%if (see.isStatus()) {%>
							sizeSelectRendering("<%=see.getSizes() %>");
							<%} %>
						</script>
						<%} else {%>
							<center><strong>Invalid Shirt ID. T-Shirt not found!</strong>
						<%} %>
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
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
	</body>
</html>