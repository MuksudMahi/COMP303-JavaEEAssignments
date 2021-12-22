<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />
<body class="text-center">
	<div class="d-flex w-100 h-100 p-3 mx-auto flex-column">
		<jsp:include page="main_nav.jsp" />
		<main class="container">
			<!--Message area-->

			<c:if test="${message!=null}">
				<div class="alert alert-success">${message}</div>
			</c:if>


			<div class="title-box text-center">
				<h3 class="title-a">Your Bookings</h3>
				<div class="line-mf"></div>
			</div>
			<table
				class="table table-sort table-striped table-hover table-arrows">
				<thead>
					<tr>
						<th scope="col">Departure</th>
						<th scope="col">Arrival</th>
						<th scope="col">Departure city</th>
						<th scope="col">Destination</th>
						<th scope="col">Airline</th>
						<th scope="col">Fare</th>
						<th scope="col">Price</th>
						<th scope="col">Total Passengers</th>
						<th scope="col">Reservation Date</th>

						<th scope="col"></th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach items="${flights}" var="flight">
							<tr>
								<td>${flight.departure}</td>
								<td>${flight.arrival}</td>
								<td>${flight.departurCity}</td>
								<td>${flight.destination}</td>
								<td>${flight.airlineName}</td>
								<td>${flight.fare}</td>
								<td>${flight.price}</td>
								<td>${flight.reservation.totalPassenger}</td>
								<td>${flight.reservation.reservationDate}</td>

								<td><a href="/edit?id=${flight.flightCode}"
									class="btn btn-primary btn-sm"> <i
										class="fas fa-pencil-alt"></i> Change
								</a></td>
								<td><a href="/cancel?id=${flight.flightCode}"
									class="btn btn-danger btn-sm" onclick="dlt('${flight.reservation.reservationDate}',event)"> <i class="fas fa-trash-alt"></i>
										Cancel
								</a></td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
		</main>

		<jsp:include page="bottom_nav.jsp" />
	</div>
	<jsp:include page="footer.jsp" />