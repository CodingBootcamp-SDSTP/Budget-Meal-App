window.onload = () => {
	let search = document.getElementById("searchform");
	let login = document.getElementById("loginform");
	let create = document.getElementById("accountform");
	document.getElementById("search-btn").onclick = () => {
		let budget = document.getElementById("budget").value;
		let fave = document.getElementById("favefood").value;
		let loc = document.getElementById("location").value;
		let rq = new XMLHttpRequest();
			rq.onreadystatechange = () => {
			if(rq.readyState == 4) {
				let places = document.getElementById("foodplaces");
				document.getElementById("searchform").style.display = "none";
				places.style.display = "block";
				let foodPlace = rq.responseText;
				places.innerHTML = foodPlace;
			}
		};
		rq.open("GET", "/budgetmealapp/search?amount="+budget+"&food="+fave+"&location="+loc, true);
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
	// document.getElementById("login-btn").onclick = () => {
	// 	let rq = new XMLHttpRequest();
	// 	rq.onreadystatechange = () => {
	// 		if(rq.readyState == 4) {
	// 			alert("Successful login");
	// 		}
	// 	};
	// 	rq.open("GET", "/budgetmealapp/login?username="+username+"&password="+password+"&usertype="+type, true);
	// 	rq.setRequestHeader("Content-Type", "text/xml");
	// 	rq.send();
	// }
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
