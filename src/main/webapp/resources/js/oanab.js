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
		var astt = document.getElementsByName("astt")[0];
		if (el.checked) {
			ss.innerHTML = " Active";
			astt.value = "1";
		} else {
			ss.innerHTML = " Inactive";
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