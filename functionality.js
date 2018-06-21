var session = "";
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
					places.style.display = "block";
					let foodPlace = rq.responseText;
					let parser = new DOMParser();
					let xmlDoc = parser.parseFromString(foodPlace, "text/xml");
					let foodPlaceTag = xmlDoc.getElementsByTagName("foodplace");
					places.innerHTML = "";
					for (let i=0; i<foodPlaceTag.length; i++) {
						let photo = foodPlaceTag[i].childNodes[0].textContent;
						let name = foodPlaceTag[i].childNodes[1].textContent;
						let add = foodPlaceTag[i].childNodes[2].textContent;
						let menu = foodPlaceTag[i].childNodes[3].textContent;
						let price = foodPlaceTag[i].childNodes[4].textContent;
						places.innerHTML += "<div class='fp'><div><img src=\""+photo+"\" alt=\""+name+" image\" width='300px' height='300px' id='fpphoto'></div><p>Name: " + name + "</p><p>Address: "+add+"</p><p> Menu: "+menu+"</p><p>Price: "+price+"</p><button id='review-btn' onclick='addReview();'>Write a review</button></div>";
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
					alert("new Person added");
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
					localStorage.setItem("sessionid", session);
				}
			};
			rq.open("GET", "/budgetmealapp/login?username="+un+"&password="+pass, true);
			rq.setRequestHeader("Content-Type", "text/html");
			rq.send();
		}
		else if(e.target && e.target.matches("button#review-btn")) {
			
		}
		else if(e.target && e.target.matches("button#logout-btn")) {
			localStorage.clear();
			location.href = "/budgetmealapp";
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
	rating_option.value = "1";
	rating_option.text = "1";
	let two_option = document.createElement('option');
	rating_option.value = "2";
	rating_option.text = "2";
	let three_option = document.createElement('option');
	rating_option.value = "3";
	rating_option.text = "3";
	let four_option = document.createElement('option');
	rating_option.value = "4";
	rating_option.text = "4";
	let five_option = document.createElement('option');
	rating_option.value = "5";
	rating_option.text = "5";
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
	input_rid.value = 
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
	let button = document.createElement('a');
	button.href = '#';
	button.className = 'button';
	button.onclick = () => {
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = () => {
			if(rq.readyState == 4) {
				console.log("Review Success!");
			}
		};
		rq.open("POST", "/addreview", true);
		rq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		rq.send();
		document.body.removeChild(popup);
	}
	p2.appendChild(button);
	let span = document.createElement('span');
	span.appendChild(document.createTextNode("Add Review"));
	button.appendChild(span);
	//cancelbutton
	let p_cancel = document.createElement('p');
	content.appendChild(p_cancel);
	let cancelBtn = document.createElement('a');
	cancelBtn.href = '#';
	cancelBtn.className = 'cancel-btn';
	cancelBtn.onclick = () => {
		document.body.removeChild(popup);
	}
	p_cancel.append(cancelBtn);
	let span2 = document.createElement('span');
	span2.appendChild(document.createTextNode("Cancel"));
	cancelBtn.append(span2);
	document.body.appendChild(popup);
}

window.onload = () => {
	setEvents();
}
