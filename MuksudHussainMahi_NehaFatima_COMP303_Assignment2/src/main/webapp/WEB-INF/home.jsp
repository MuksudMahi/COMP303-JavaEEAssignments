<jsp:include page="header.jsp" />
  <body class="text-center  bg-home">
    <div class="d-flex w-100 h-100 p-3 mx-auto flex-column">
	<jsp:include page="main_nav.jsp" />
	<main role="main" class="inner cover">
		<h1 class="cover-heading">Online Flight Booking</h1>
		<p class="lead">Welcome to our website</p>
		<p class="lead">Book your flight from anywhere</p>
		<p class="lead">Click below to book a flight</p>
		<!--Button to take to home page-->
		<p class="lead">
			<a href="/book-flight" class="btn btn-info">Book Flight</a>
		</p>
	</main>
	<jsp:include page="bottom_nav.jsp" />
</div>
<jsp:include page="footer.jsp" />