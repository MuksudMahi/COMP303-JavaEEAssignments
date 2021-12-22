<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/water.css@2/out/water.css">
	 <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet"/>
<title>Summary</title>
</head>
<body>

<h3>Welcome ${flightObj.firstName}</h3>

<h3>Your flight reservation details are as follows:</h3>
<ul>
<li><b>Phone Number:</b> ${flightObj.phone}</li>
<li><b>Email Address:</b> ${flightObj.email}</li>
<li><b>Address:</b> ${flightObj.streetAddress}</li>
</ul>
<p><b>Departure Date:</b> ${flightObj.departure}</p>
<p><b>Departure Time:</b> ${flightObj.departureTime}</p>
<p><b>Departing From:</b> ${flightObj.dCity}, ${flightObj.dCountry}</p>
<p><b>Destination:</b> ${flightObj.rCity}, ${flightObj.rCity}</p>
<p><b>Return Date:</b> ${flightObj.returnn}</p>
<p><b>Return Time:</b> ${flightObj.returnTime}</p>
<br>
<p><b>Airline:</b> ${flightObj.airline}</p>
<p><b>Fare:</b> ${flightObj.fare}</p>
<p><b>Number of Passengers:</b> ${flightObj.adults} Adult(s), ${flightObj.kids} Kid(s)</p>
<p><b>Amount paid:</b>  $${fare}</p>
<div align="center">
<h3>Your online reservation completed.</h3>
<h3>Have a relaxing time in the sky and enjoy your trip.</h3>
</div>
</body>
</html>