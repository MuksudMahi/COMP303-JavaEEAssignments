<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />
<body class="text-center">
	<div class="d-flex w-100 h-100 p-3 mx-auto flex-column">
		<jsp:include page="main_nav.jsp" />
		<main class="container">
			<!--Message area-->

			<c:if test="${message!=null}">
				<div class="alert alert-danger">${message}</div>
			</c:if>


			<div class="title-box text-center">
				<h3 class="title-a">Payment</h3>
				<div class="line-mf"></div>
			</div>

			<div class="row">
				<div class="offset-md-4 col-md-4">
					<h1>Enter Payment Info</h1>
					<form action="/pay" method="POST" autocomplete="off">
						<div class="row text-left">
							<label class="col-md-6">Card type</label>
						</div>
						<div class="row text-left">
							<fieldset class="form-group col-md-6">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="card"
										id="t1" checked> <label class="form-check-label"
										for="t1"> Debit/Credit </label>
								</div>
							</fieldset>

							<fieldset class="form-group col-md-6">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="card"
										id="t1"> <label class="form-check-label" for="t1">
										PayPal </label>
								</div>
							</fieldset>
						</div>

						<fieldset class="form-group text-left">
							<label for="cardno">Card no</label> <input type="number"
								class="form-control" name="carno" placeholder="Card number"
								id="cardno" required>
						</fieldset>
						<fieldset class="form-group text-left">
							<label for="cvv">CVV</label> <input type="number"
								class="form-control" name="cvv" placeholder="CVV"
								id="cvv" required>
						</fieldset>
						
						<fieldset class="form-group text-right">
							<input type="submit" class="btn btn-success" value="Pay">
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