<jsp:include page="header.jsp" />

<body>
<body class="text-center">
	<div class="d-flex w-100 h-100 p-3 mx-auto flex-column">
		<jsp:include page="main_nav.jsp" />

		<main class="container">
			<!--Message area-->
			<div class="title-box text-center">
				<h3 class="title-a">Book Flight</h3>
				<div class="line-mf"></div>
			</div>

			<div class="row">
				<div class="offset-md-4 col-md-4">
					<h1>Flight Information</h1>
					<form action="/update?id=${flight.flightCode}" method="POST" autocomplete="off">
						<div class="row text-left">
							<label class="col-md-6">Departure date</label> <label
								class="col-md-6">Arrival date</label>
						</div>
						<div class="row">
							<fieldset class="form-group col-md-6">
								<input type="date" class="form-control" name="departure"
									value="${flight.departure}" required>
							</fieldset>

							<fieldset class="form-group col-md-6">
								<input type="date" class="form-control" name="arrival"
									value="${flight.arrival}" required>
							</fieldset>
						</div>
						<div class="row text-left">
							<label class="col-md-6">Departure city</label> <label
								class="col-md-6">Destination</label>
						</div>
						<div class="row">
							<fieldset class="form-group col-md-6">
								<input type="text" class="form-control" name="departureCity"
									value="${flight.departurCity}" disabled required>
							</fieldset>

							<fieldset class="form-group col-md-6">
								<input type="text" class="form-control" name="destination"
									value="${flight.destination}" disabled required>
							</fieldset>
						</div>
						<fieldset class="form-group text-left">
							<label for="airlineName">Airline</label>
								<input type="text" class="form-control" id="airlineName" name="airlineName"
									value="${flight.airlineName}" disabled required>
						</fieldset>

						<fieldset class="form-group text-left">
							<label for="fare">Fare</label>
								<input type="text" class="form-control" id="fare" name="fare"
									value="${flight.fare}" disabled required>
						</fieldset>


						<fieldset class="form-group text-left">
							<label for="price">Price</label>
								<input type="number" class="form-control" id="price" name="price"
									value="${flight.price}" disabled required>
						</fieldset>
						
						<fieldset class="form-group text-right">
							<input type="submit" class="btn btn-success" onclick="msg()" value="Update">
							<a href="/"> <input type="button" class="btn btn-warning"
								value="Cancel">
							</a>
						</fieldset>
					</form>
				</div>
			</div>

		</main>

		<jsp:include page="bottom_nav.jsp" />
	</div>
	<jsp:include page="footer.jsp" />