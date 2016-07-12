<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="primo">
	<form>
		<input type="number" id="socioid" placeholder="id socio">
		<input type="submit" id="bottone" value="Schiacciami">
		</form>
	</div>
	<div id="secondo"></div>
	<div id="terzo" style="display:none">
	<table border = "1" style=" margin: 5px; border-collapse: collapse;">
	<tr><td id="firstName"></td><td id="lastName"></td><td id="sex"></td><td id="address"></td><td id="city"></td><td id="mobileNumber"></td></tr>
	</table>
	</div>
	<script>
	function loadData(url, callback) {

		console.log(document.querySelector("#socioid").value);
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				callback(xhr);
			}
		};
		xhr.open("GET", url, false);
		console.log("aperto");
		xhr.send();
			}	

	document.querySelector("#bottone").addEventListener('click', function(event){
		event.preventDefault();
		loadData('JsonServlet'+'?id='+ document.querySelector("#socioid").value, printHTML)
	}, false);
	
	function printHTML(xhttp) {
		
	document.querySelector("#terzo").setAttribute("style", "style=\"block\"");
	var obj = JSON.parse(xhttp.responseText);
	document.querySelector("#firstName").innerHTML = obj.firstName;
	document.querySelector("#lastName").innerHTML = obj.lastName;
	document.querySelector("#sex").innerHTML = obj.sex;
	document.querySelector("#address").innerHTML = obj.address;
	document.querySelector("#city").innerHTML = obj.city;
	document.querySelector("#mobileNumber").innerHTML = obj.mobileNumber;
	console.log(obj);
	}
			</script>
</body>
</html>