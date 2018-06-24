var session = "";
var userid = 0;
var foodplaceid = 0;
function setEvents() {
	let rq = new XMLHttpRequest();
	let places = document.getElementById("foodplaces");
	let searchform = document.getElementById("searchform");
	document.body.addEventListener("click", e => {
		if(e.target && e.target.matches("button#search-btn")) {
			let budget = document.getElementById("budget").value;
			let food = document.getElementById("food").value;
			let loc = document.getElementById("location").value;
				rq.onreadystatechange = () => {
				if(rq.readyState == 4) {
					searchform.style.display = "none";
					places.style.display = "flex";
					let foodPlace = rq.responseText;
					let parser = new DOMParser();
					let xmlDoc = parser.parseFromString(foodPlace, "text/xml");
					let foodPlaceTag = xmlDoc.getElementsByTagName("foodplace");
					if(foodPlaceTag.length != 0 ) {
						places.innerHTML = "<h4 id='search-fp--title'>Good day young foodie! We have found " + foodPlaceTag.length + " great foodplace/s near you! Enjoy your budget meal!</h4>";
					}
					else {
						places.innerHTML = "<h4 id='search-fp--title'>Good day young foodie! The queries you entered does not have any match from our records. Please try with more specific queries next time. Happy to serve!</h4>";
					}
					for (let i=0; i<foodPlaceTag.length; i++) {
						foodplaceid = foodPlaceTag[i].childNodes[0].textContent;
						let name = foodPlaceTag[i].childNodes[1].textContent;
						let add = foodPlaceTag[i].childNodes[2].textContent;
						let menu = foodPlaceTag[i].childNodes[3].textContent;
						let price = foodPlaceTag[i].childNodes[4].textContent;
						places.insertAdjacentHTML('beforeend', "<div class='fp'></p><p class='search-fp--name'>" + name + "</p><p class='search-fp--add'>@"+add+"</p><p class='search-fp--menu'> Menu: "+menu+"</p><p class='search-fp--price'>Price: "+price+"</p><button id='review-btn' onclick='addReview();'>Write a review</button></div>");
					}
					
				}
			};
			rq.open("GET", "/budgetmealapp/search?amount="+budget+"&food="+food+"&location="+loc+"&id="+session, true);
			rq.setRequestHeader("Content-Type", "text/xml");
			rq.send();
		}
		else if(e.target && e.target.matches("button#post-btn")) {
			let name = document.getElementById("fpname").value;
			let address = document.getElementById("fpaddress").value;
			let menu = document.getElementById("fpmenu").value;
			let price = document.getElementById("fpprice").value;
			let photo = document.getElementById("fpphoto").value;
			rq.onreadystatechange = () => {
				if(rq.readyState == 4) {
					alert("FoodPlace added!");
				}
			};
			rq.open("POST", "/budgetmealapp/addfoodplace?id="+session, true);
			rq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			rq.send("fpname="+name+"&fpaddress="+address+"&fpmenu="+menu+"&fpprice="+price+"&fpphoto="+photo);
		}
		else if(e.target && e.target.matches("button#account-btn")) {
			let fname = document.getElementById("fname").value;
			let lname = document.getElementById("lname").value;
			let age = document.getElementById("age").value;
			let un = document.getElementById("user").value;
			let pw = document.getElementById("pw").value;
			let email = document.getElementById("email").value;
			let loc = document.getElementById("loc").value;
			let food = document.getElementById("food").value;
			let en = document.getElementById("place").value;
			let user = document.getElementById("usertype").value;
			rq.onreadystatechange = () => {
				if(rq.readyState == 4) {
					location.href = "/budgetmealapp/login";
				}
			};
			rq.open("POST", "/budgetmealapp/addperson?id="+session, true);
			rq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			rq.send("firstname="+fname+"&lastname="+lname+"&age="+age+"&username="+un+"&password="+pw+"&email="+
				email+"&location="+loc+"&food="+food+"&place="+en+"&usertype="+user);
		}
		else if(e.target && e.target.matches("button#login-btn")) {
			let un = document.getElementById("username").value;
			let pass = document.getElementById("password").value;
			rq.onreadystatechange = () => {
				if(rq.readyState == 4) {
					session = rq.responseText;
					let jsession = JSON.parse(session);
					if(session.includes("not match")) {
						document.getElementById("login-error").innerHTML = "<small>"+session+"</small>";ssss
					}
					else {
						localStorage.setItem("sessionid", jsession[0].sessionid);
						localStorage.setItem("userid", jsession[0].userid);
						userid = jsession[0].userid;
						if(jsession[0].usertype == "foodie") {
							location.href="/budgetmealapp/search-place";
						}
						else if(jsession[0].usertype == "manager") {
							location.href="/budgetmealapp/postfoodplace";
						}
					}
				}
			};
			rq.open("GET", "/budgetmealapp/login?username="+un+"&password="+pass, true);
			rq.setRequestHeader("Content-Type", "text/html");
			rq.send();
		}
		else if(e.target && e.target.matches("a#logout-btn")) {
			localStorage.clear();
		}
	});
}

function addReview() {
	let popup = document.createElement('div');
	popup.className = 'fullscreenpopup';
	let container = document.createElement('div');
	container.className = 'fullscreenpopup_container';
	popup.appendChild(container);
	let content = document.createElement('div');
	content.className = 'fullscreenpopup_content';
	container.appendChild(content);
	let p1 = document.createElement('p');
	p1.appendChild(document.createTextNode("Write a review"));
	content.appendChild(p1);
	//review text
	let review_txt = document.createElement('p');
	let input_text = document.createElement('textarea');
	input_text.setAttribute('placeholder', 'Type your review');
	input_text.setAttribute('id', 'review-text');
	input_text.setAttribute('cols', '60');
	input_text.setAttribute('rows', '15');
	input_text.setAttribute('wrap', 'on');
	review_txt.appendChild(input_text);
	content.appendChild(review_txt);
	//review rating
	let review_rating = document.createElement('p');
	let select_type = document.createElement('select');
	select_type.setAttribute('id', 'review-rating');
	let rating_option = document.createElement('option');
	rating_option.value = "";
	rating_option.text = "Select Rating";
	let one_option = document.createElement('option');
	one_option.value = "1";
	one_option.text = "1";
	let two_option = document.createElement('option');
	two_option.value = "2";
	two_option.text = "2";
	let three_option = document.createElement('option');
	three_option.value = "3";
	three_option.text = "3";
	let four_option = document.createElement('option');
	four_option.value = "4";
	four_option.text = "4";
	let five_option = document.createElement('option');
	five_option.value = "5";
	five_option.text = "5";
	select_type.add(rating_option, null);
	select_type.add(one_option, null);
	select_type.add(two_option, null);
	select_type.add(three_option, null);
	select_type.add(four_option, null);
	select_type.add(five_option, null);
	review_rating.appendChild(select_type);
	content.appendChild(review_rating);
	//reviewerid
	let input_rid = document.createElement('input');
	input_rid.setAttribute('type', 'text');
	input_rid.setAttribute('hidden', true);
	input_rid.setAttribute('id', 'reviewer-id');
	content.appendChild(input_rid);
	//foodplaceid
	let input_fid = document.createElement('input');
	input_fid.setAttribute('type', 'text');
	input_fid.setAttribute('hidden', true);
	input_fid.setAttribute('id', 'foodplace-id');
	content.appendChild(input_fid);
	let p2 = document.createElement('p');
	content.appendChild(p2);
	let button = document.createElement('button');
	button.setAttribute('id', 'addreview-btn');
	button.appendChild(document.createTextNode('Post'));
	button.onclick = () => {
		let text = document.getElementById("review-text").value;
		let rating = document.getElementById("review-rating").value;
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = () => {
			if(rq.readyState == 4) {
				console.log("Review Success!");
				console.log(userid);
				console.log(foodplaceid);
			}
		};
		rq.open("POST", "/budgetmealapp/addreview", true);
		rq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		rq.send("text="+text+"&rating="+rating+"&foodplace="+foodplaceid+"&reviewer="+userid);
		document.body.removeChild(popup);
	}
	p2.appendChild(button);
	//cancelbutton
	let p_cancel = document.createElement('p');
	content.appendChild(p_cancel);
	let cancelBtn = document.createElement('button');
	cancelBtn.setAttribute('id', 'cancel-btn');
	cancelBtn.onclick = () => {
		document.body.removeChild(popup);
	}
	cancelBtn.appendChild(document.createTextNode('Cancel'));
	p_cancel.append(cancelBtn);
	document.body.appendChild(popup);
}



window.onload = () => {
	setEvents();
}
