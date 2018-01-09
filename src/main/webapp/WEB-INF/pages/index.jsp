<%@page import="vn.com.fsoft.dao.ShirtDAO"%>
<%@page import="vn.com.fsoft.model.Shirt"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>OanAb</title>
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
				<div class="sec" id="hot">
					<div class="sec-t">
						<div class="sec-t-l"></div>
						<div class="sec-t-m">
							NEW!
						</div>
						<div class="sec-t-r"></div>
					</div>
					<div class="sec-c">
						<% ShirtDAO sdao = new ShirtDAO();
						ArrayList<Shirt> hlist = sdao.getHotList();
						if(hlist != null){
						for(Shirt s: hlist){
						%><a href="details?sid=<%=s.getId() %>">
							<div class="sec-c-i">
								<div name="<%=s.getId() %>" class="indexcolor"></div>
								<div class="sec-c-i-d" style="background: url(${pageContext.request.contextPath}/resources/img/t/m224.png) no-repeat, url(${pageContext.request.contextPath}/resources/simg/<%=s.getImageFile() %>) no-repeat; background-size: cover, 80px auto; background-position: center, 72px 52px;"></div>
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
						</a><% }} %><!--
					--></div>
				</div>
				<div class="clear"></div>
				<div class="sec" id="trend">
					<div class="sec-t">
						<div class="sec-t-l"></div>
						<div class="sec-t-m">
							TRENDING
						</div>
						<div class="sec-t-r"></div>
					</div>
					<div class="sec-c">
						<% ArrayList<Shirt> tlist = sdao.getTrendingList();
						if(tlist != null){
						for(Shirt s: tlist){
						%><a href="details?sid=<%=s.getId() %>">
							<div class="sec-c-i">
								<div name="<%=s.getId() %>" class="indexcolor"></div>
								<div class="sec-c-i-d" style="background: url(${pageContext.request.contextPath}/resources/img/t/m224.png) no-repeat, url(${pageContext.request.contextPath}/resources/simg/<%=s.getImageFile() %>) no-repeat; background-size: cover, 80px auto; background-position: center, 72px 52px;"></div>
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
						</a><% }} %><!--
					--></div>
				</div>
				<div class="clear"></div>
				<div class="sec" id="fun">
					<div class="sec-t">
						<div class="sec-t-l"></div>
						<div class="sec-t-m">
							MORE FUN?
						</div>
						<div class="sec-t-r"></div>
					</div>
					<table class="sec-c">
						<div class="clear"></div>
						<form>
							<tr>
								<td>
									Want something interesting? Be our designer or submit a request for your own design.
								</td>
								<td width="92">
									<input type="button" name="join" value="Join Us!" onclick="window.location.assign('login');">
								</td>
								<td width="92">
									<input type="button" name="request" value="Request" onclick="window.location.assign('request');">
								</td>
							</tr>
						</form>
					</table>
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
						OANAB _ 2017
					</td>
				</tr>
			</table>
		</div>
		
		<%if(hlist != null){
		for(Shirt s: hlist){%>
		<script>firstColor("<%=s.getId() %>", "<%=s.getColors() %>");</script>
		<%}} %>
		
		<%if(tlist != null){
		for(Shirt s: tlist){%>
		<script>firstColor("<%=s.getId() %>", "<%=s.getColors() %>");</script>
		<%}} %>
	</body>
</html>