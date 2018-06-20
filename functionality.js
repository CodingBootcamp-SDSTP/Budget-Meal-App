function setEvents() {
	let rq = new XMLHttpRequest();
	document.body.addEventListener("click", e => {
		if(e.target && e.target.matches("button#search-btn")) {
			let budget = document.getElementById("budget").value;
			let food = document.getElementById("food").value;
			let loc = document.getElementById("location").value;
				rq.onreadystatechange = () => {
				if(rq.readyState == 4) {
					let places = document.getElementById("foodplaces");
					document.getElementById("searchform").style.display = "none";
					places.style.display = "block";
					let foodPlace = rq.responseText;
					let parser = new DOMParser();
					let xmlDoc = parser.parseFromString(foodPlace, "text/xml");
					let photo = xmlDoc.getElementsByTagName("foodplace")[0].childNodes[0].textContent;
					let name = xmlDoc.getElementsByTagName("foodplace")[0].childNodes[1].textContent;
					let add = xmlDoc.getElementsByTagName("foodplace")[0].childNodes[2].textContent;
					let menu = xmlDoc.getElementsByTagName("foodplace")[0].childNodes[3].textContent;
					let price = xmlDoc.getElementsByTagName("foodplace")[0].childNodes[4].textContent;
					places.innerHTML = "<div id='fp'><div><img src=\""+photo+"\" alt=\""+name+" image\" width='300px' height='300px' id='fpphoto'></div><p>Name: " + name + "</p><p>Address: "+add+"</p><p> Menu: "+menu+"</p><p>Price: "+price+"</p></div>";
				}
			};
			rq.open("GET", "/budgetmealapp/search?amount="+budget+"&food="+food+"&location="+loc, true);
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
			rq.open("POST", "/budgetmealapp/addfoodplace", true);
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
			rq.open("POST", "/budgetmealapp/addperson", true);
			rq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			rq.send("firstname="+fname+"&lastname="+lname+"&age="+age+"&username="+un+"&password="+pw+"&email="+
				email+"&location="+loc+"&food="+food+"&place="+en+"&usertype="+user);
		}
	});
}

window.onload = () => {
	setEvents();
}

