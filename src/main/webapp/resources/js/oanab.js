// Xo menu khi responsive
function menuIn() {
	var el = document.getElementById("floatmenu");
	if (el.className == "show") {
		menuOut();
	}
	else {
		el.className="show";
		var eld = document.getElementById("dark");
		eld.className="showd";
	}
}

// An menu
function menuOut() {
	var el = document.getElementById("floatmenu");
	el.className="hide";
	var eld = document.getElementById("dark");
	eld.className="hided";
}

// Xo menu account
function subIn() {
	var el = document.getElementById("floatsubmenu");
	if (el.className == "hidesub") {
		el.className="showsub";
	}
}

// An menu account
function subOut() {
	var el = document.getElementById("floatsubmenu");
	el.className="hidesub";
}

// Tao cac nut chon mau o tren cung + do vao tag select
function colorButtonsRendering(colors) {
	var colorArray = colors.split(",");
	var colorContainer = document.getElementsByClassName("colors")[0];
	var colorSelect = document.getElementsByName("color")[0];
	for (var i = 0; i <= colorArray.length - 1; i++) {
		var divTag = document.createElement("div");
		var aTag = document.createElement("a");
		var optionTag = document.createElement("option");
		var optionText = document.createTextNode(colorArray[i].toUpperCase());
		divTag.setAttribute("class", "cc " + colorArray[i]);
		divTag.setAttribute("onclick", "colorChange('" + colorArray[i] + "')");
		aTag.setAttribute("href", "#color");
		aTag.appendChild(divTag);
		colorContainer.appendChild(aTag);
		optionTag.setAttribute("value", colorArray[i]);
		optionTag.appendChild(optionText);
		colorSelect.appendChild(optionTag);
	}
	colorChange(colorArray[0]);
}

// Thay doi lua chon trong form sau khi xem mau
function colorSelecting(c) {
	var colorSelect = document.getElementsByName("color")[0];
	colorSelect.value = c;
}

//Chon mau ao o muc xem hang
function colorChange(c) {
	var el = document.getElementById("color");
	el.className = c;
	colorSelecting(c);
}

//Lay mau ao dau tien o trang index va shop
function firstColor(id, c) {
	var el = document.getElementsByName(id);
	var getColor = c.split(",")[0];
	for (var i = 0; i <= el.length - 1; i++) {
		if (!el[i].classList.contains(getColor)){
			el[i].classList.add(getColor);
		}
	}
}

// Do vao tag select de chon size
function sizeSelectRendering(sizes) {
	var sizeArray = sizes.split(",");
	var selectTag = document.getElementsByName("size")[0];
	for (var i = 0; i <= sizeArray.length - 1; i++) {
		var optionTag = document.createElement("option");
		var optionText = document.createTextNode(sizeArray[i]);
		optionTag.setAttribute("value", sizeArray[i]);
		optionTag.appendChild(optionText);
		selectTag.appendChild(optionTag);
	}
	selectTag.value = sizeArray[0];
}

//Kiem tra o dang nhap trong
function isEmpty() {
	if (document.forms["lform"]["phone"].value == "" || document.forms["lform"]["pass"].value == "") {
		event.preventDefault();
		var al = document.getElementById("alert");
		al.innerHTML = "Fill in the required field to continue.";
		al.setAttribute("class", "alert");
		return true;
	}
	return false;
}

function loginFailed(message) {
	var al = document.getElementById("alert");
	al.innerHTML = message;
	al.setAttribute("class", "alert");
}

//Tu dong dien thong tin khach hang neu da dang nhap
function fillPay(name, phone, address) {
	document.forms["p-info"]["name"].value = name;
	document.forms["p-info"]["phone"].value = phone;
	document.forms["p-info"]["address"].value = address;
}

//Xem mau da chon trong gio hang
function selectedColor(id, c) {
	var el = document.getElementsByName(id);
	for (var i = 0; i <= el.length - 1; i++) {
		if (!el[i].classList.contains(c)){
			el[i].classList.add(c);
		}
	}
}

//Thay doi dong chu o o danh dau "working status"
function workingStatus() {
	if (document.forms["regform"]["status"]) {
		var el = document.forms["regform"]["status"];
		var ss = document.getElementsByName("s-status")[0];
		var astt = document.getElementsByName("astt")[0];
		if (el.checked) {
			ss.innerHTML = " Working";
			astt.value = "1";
		} else {
			ss.innerHTML = " Not working";
			astt.value = "0";
		}
	}
}

function activeStatus() {
	if (document.forms["regform"]["status"]) {
		var el = document.forms["regform"]["status"];
		var ss = document.getElementsByName("s-status")[0];
		var astt = document.getElementsByName("ustt")[0];
		if (el.checked) {
			ss.innerHTML = " Active";
			astt.value = "1";
		} else {
			ss.innerHTML = " Inactive";
			astt.value = "0";
		}
	}
}

function launchingStatus() {
	if (document.forms["regform"]["status"]) {
		var el = document.forms["regform"]["status"];
		var ss = document.getElementsByName("s-status")[0];
		var astt = document.getElementsByName("sstt")[0];
		if (el.checked) {
			ss.innerHTML = " Launching";
			astt.value = "1";
		} else {
			ss.innerHTML = " Stopped";
			astt.value = "0";
		}
	}
}

//Tao cac nut chuyen trang (manage)
function pagingManagement(listSize, rpp, onPage) {
	var amount;
	if (listSize % rpp == 0) {
		amount = listSize / rpp;
	} else {
		amount = (listSize - (listSize % rpp)) / rpp + 1; 
	}
	var paging = document.getElementById("paging");
	var tf = document.createTextNode("<<");
	var tp = document.createTextNode("<");
	var bf = document.createElement("button");
	var bp = document.createElement("button");
	if (onPage != 1) {
		bf.setAttribute("name", "page");
		bf.setAttribute("value", "1");
		bf.appendChild(tf);
		paging.appendChild(bf);
		paging.appendChild(document.createTextNode(" "));
		bp.setAttribute("name", "page");
		bp.setAttribute("value", onPage - 1);
		bp.appendChild(tp);
		paging.appendChild(bp);
		paging.appendChild(document.createTextNode(" "));
	}
	for (var i = 1; i <= amount; i++) {
		var t = document.createTextNode(i);
		var b = document.createElement("button");
		if (i == onPage) {
			b.setAttribute("class", "onpage");
			b.setAttribute("disabled", "disabled");
		}
		b.setAttribute("name", "page");
		b.setAttribute("value", i);
		b.appendChild(t);
		paging.appendChild(b);
	paging.appendChild(document.createTextNode(" "));
	}
	if (onPage != amount) {
		var tn = document.createTextNode(">");
		var tl = document.createTextNode(">>");
		var bn = document.createElement("button");
		var bl = document.createElement("button");
		bn.setAttribute("name", "page");
		bn.setAttribute("value", onPage + 1);
		bn.appendChild(tn);
		paging.appendChild(bn);
		paging.appendChild(document.createTextNode(" "));
		bl.setAttribute("name", "page");
		bl.setAttribute("value", amount);
		bl.appendChild(tl);
		paging.appendChild(bl);
	}
}

// Xem mau trong danh sach quan ly
function colorsInList(id, c) {
	var container = document.getElementById("cs"+id);
	var allColors = c.split(",");
	for (var i = 0; i < allColors.length; i++) {
		var colorBox = document.createElement("div");
		colorBox.setAttribute("name", "c");
		if (!colorBox.classList.contains(allColors[i])){
			colorBox.classList.add(allColors[i]);
		}
		container.appendChild(colorBox);
		if (i < allColors.length - 1) {
			container.appendChild(document.createTextNode(" "));
		}
	}
}

//Thay doi list mau trong Manage Shirt
function changeColorList() {
	var result = [];
	var scolor = document.forms["info"]["scolor"];
	if (document.forms["info"]["white"].checked) result.push("white");
	if (document.forms["info"]["lgray"].checked) result.push("lgray");
	if (document.forms["info"]["black"].checked) result.push("black");
	if (document.forms["info"]["red"].checked) result.push("red");
	if (document.forms["info"]["orange"].checked) result.push("orange");
	if (document.forms["info"]["green"].checked) result.push("green");
	if (document.forms["info"]["dblue"].checked) result.push("dblue");
	if (document.forms["info"]["purple"].checked) result.push("purple");
	scolor.value = result.toString();
}

//Thay doi list co ao trong Manage Shirt
function changeSizeList() {
	var result = [];
	var ssize = document.forms["info"]["ssize"];
	if (document.forms["info"]["XS"].checked) result.push("XS");
	if (document.forms["info"]["S"].checked) result.push("S");
	if (document.forms["info"]["M"].checked) result.push("M");
	if (document.forms["info"]["L"].checked) result.push("L");
	if (document.forms["info"]["XL"].checked) result.push("XL");
	if (document.forms["info"]["XXL"].checked) result.push("XXL");
	ssize.value = result.toString();
}