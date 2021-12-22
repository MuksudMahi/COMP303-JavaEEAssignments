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
					<form action="/reserve" method="POST" autocomplete="off">
						<div class="row text-left">
							<label class="col-md-6">Departure date</label> <label
								class="col-md-6">Arrival date</label>
						</div>
						<div class="row">
							<fieldset class="form-group col-md-6">
								<input type="date" class="form-control" name="departure"
									placeholder="Departure date" required>
							</fieldset>

							<fieldset class="form-group col-md-6">
								<input type="date" class="form-control" name="arrival"
									placeholder="Arrival date" required>
							</fieldset>
						</div>
						<div class="row text-left">
							<label class="col-md-6">Departure city</label> <label
								class="col-md-6">Destination</label>
						</div>
						<div class="row">
							<fieldset class="form-group col-md-6">
								<input type="text" class="form-control" name="departureCity"
									placeholder="Departure city" required>
							</fieldset>

							<fieldset class="form-group col-md-6">
								<input type="text" class="form-control" name="destination"
									placeholder="Destination" required>
							</fieldset>
						</div>
						<fieldset class="form-group text-left">
							<label for="airlineName">Airline</label> <select
								class="form-control" id="airlineName" name="airlineName">
								<option value="" disabled selected hidden>Select
									airline</option>
								<option value="Air Canada">Air Canada</option>
								<option value="WestJet">WestJet</option>
								<option value="Canadian North">Canadian North</option>
								<option value="Sunwing Airlines">Sunwing Airlines</option>
								<option value="Swoop">Swoop</option>
							</select>
						</fieldset>

						<fieldset class="form-group text-left">
							<label for="fare">Fare</label> <select class="form-control"
								id="fare" name="fare">
								<option value="One-Way">One-Way</option>
								<option value="Round Trip">Round Trip</option>
							</select>
						</fieldset>


						<fieldset class="form-group text-left">
							<label for="price">Price</label> <select class="form-control"
								id="airlineName" name="price">
								<option value="" disabled selected hidden>Select price</option>
								<option value="1200">Business class ($1200)</option>
								<option value="1000">Economy class ($1000)</option>
							</select>
						</fieldset>

						<div class="row text-left">
							<label class="col-md-6">Passenger count</label>
						</div>
						<div class="row">
							<fieldset class="form-group col-md-6">
								<input type="number" class="form-control" name="adults"
									placeholder="Adult(s)" required>
							</fieldset>

							<fieldset class="form-group col-md-6">
								<input type="number" class="form-control" name="kids"
									placeholder="Kid(s)" required>
							</fieldset>
						</div>

						<fieldset class="form-group text-right">
							<input type="submit" class="btn btn-success" value="Book">
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