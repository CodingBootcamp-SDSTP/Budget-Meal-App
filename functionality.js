window.onload = () => {
	let search = document.getElementById("searchform");
	let login = document.getElementById("loginform");
	let create = document.getElementById("accountform");
	document.getElementById("search-btn").onclick = () => {
		let budget = document.getElementById("budget").value;
		let food = document.getElementById("food").value;
		let loc = document.getElementById("location").value;
		let rq = new XMLHttpRequest();
			rq.onreadystatechange = () => {
			if(rq.readyState == 4) {
				let places = document.getElementById("foodplaces");
				document.getElementById("searchform").style.display = "none";
				places.style.display = "block";
				let foodPlace = rq.responseText;
				let parser = new DOMParser();
				let xmlDoc = parser.parseFromString(foodPlace, "text/xml");
				console.log(xmlDoc);
				let name = xmlDoc.getElementsByTagName("foodplace")[0].childNodes[0].textContent;
				let address = xmlDoc.getElementsByTagName("foodplace")[0].childNodes[1].textContent;
				let menu = xmlDoc.getElementsByTagName("foodplace")[0].childNodes[2].textContent;
				let price = xmlDoc.getElementsByTagName("foodplace")[0].childNodes[3].textContent;
				let photo = xmlDoc.getElementsByTagName("foodplace")[0].childNodes[4].textContent;
				console.log(name, address, menu, price);
				places.innerHTML = "<div id='fp'><div><img src=\""+photo+"\" alt=\""+name+" image\" width='300px' height='300px' id='fpphoto'></div><p>Name: " + name + "</p><p>Address: "+address+"</p><p> Menu: "+menu+"</p><p>Price: "+price+"</p></div>";
			}
		};
		rq.open("GET", "/budgetmealapp/search?amount="+budget+"&food="+food+"&location="+loc, true);
		rq.setRequestHeader("Content-Type", "text/xml");
		rq.send();
	}
	document.getElementById("account-btn").onclick = () => {
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
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = () => {
			if(rq.readyState == 4) {
				alert("Account created!");
			}
		};
		rq.open("POST", "/budgetmealapp/addperson", true);
		rq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		rq.send("firstname="+fname+"&lastname="+lname+"&age="+age+"&username="+un+"&password="+pw+"&email="+
			email+"&location="+loc+"&food="+food+"&place="+en+"&usertype="+user);
	}
	document.getElementById("post-btn").onclick = () => {
		let name = document.getElementById("fname").value;
		let address = document.getElementById("lname").value;
		let menu = document.getElementById("age").value;
		let price = document.getElementById("user").value;
		let photo = document.getElementById("fpphoto").value;
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = () => {
			if(rq.readyState == 4) {
				alert("FoodPlace added!");
			}
		};
		rq.open("POST", "/budgetmealapp/addfoodplace", true);
		rq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		rq.send("fpname="+name+"&fpaddress="+address+"&fpmenu="+menu+"&fpprice="+price+"&fpphoto="+photo);
	}
	document.getElementById("addreview-btn").onclick = () => {
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = () => {
			if(rq.readyState == 4) {
				alert("Review added!");
			}
		};
		rq.open("POST", "/budgetmealapp/addreview", true);
		rq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		rq.send();
	}
	document.getElementById("cancel-btn").onclick = () => {
		location.href = "/budgetmealapp";
	}
	document.getElementById("login-btn").onclick = () => {
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = () => {
			if(rq.readyState == 4) {
				alert("Successful login");
			}
		};
		rq.open("GET", "/budgetmealapp/login?username="+username+"&password="+password+"&usertype="+type, true);
		rq.setRequestHeader("Content-Type", "text/xml");
		rq.send();
	}
	document.getElementById("signin").onclick = () => {
			search.style.display = "none";
			create.style.display = "none";
			login.style.display = "block";
	}
	document.getElementById("create").onclick = () => {
			search.style.display = "none";
			create.style.display = "block";
			login.style.display = "none";
	}
	document.getElementById("create-btn").onclick = () => {
		search.style.display = "none";
		create.style.display = "block";
		login.style.display = "none";
	}
}
