<jsp:include page="header.jsp" />
<body class="text-center">
	<div class="d-flex w-100 h-100 p-3 mx-auto flex-column">
		<jsp:include page="main_nav.jsp" />
		<main class="container">
			<!--Message area-->

			<div class="title-box text-center">
				<h3 class="title-a">Profile</h3>
				<div class="line-mf"></div>
			</div>

			<div class="row">
				<div class="offset-md-3 col-md-6">
					<h1>Information</h1>
					<form action="/update-user?id=${user.custId }" method="POST">
						<fieldset class="form-group">
							<label for="email"></label>
							<input type="email" class="form-control" name="email"
								value="${user.email}" disabled id="email"/>
						</fieldset>
						
						<fieldset class="form-group">
							<label for="firstName"></label>
							<input type="text" class="form-control" name="firstName"
								value="${user.firstName}" disabled id="firstName" />
						</fieldset>

						<fieldset class="form-group">
							<label for="lastName"></label>
							<input type="text" class="form-control" name="lastName"
								value="${user.lastName}" disabled id="lastName" />
						</fieldset>

						<fieldset class="form-group">
							<label for="phoneNumber"></label>
							<input type="text" class="form-control" name="phoneNumber"
								value="${user.phoneNumber}" id="phoneNumber" required/>
						</fieldset>

						<fieldset class="form-group">
							<label for="address"></label>
							<input type="text" class="form-control" name="address"
								value="${user.address}" id="address" required/>
						</fieldset>

						<fieldset class="form-group">
							<label for="city"></label>
							<input type="text" class="form-control" name="city"
								value="${user.city}" id="city" required/>
						</fieldset>

						<fieldset class="form-group">
							<label for="postalCode"></label>
							<input type="text" class="form-control" name="postalCode"
								value="${user.postalCode}" id="postalCode" required/>
						</fieldset>

						<fieldset class="form-group">
							<label for="country"></label>
							<input type="text" class="form-control" name="country"
								value="${user.country}" id="country" required/>
						</fieldset>

						<fieldset class="form-group text-right">
							<input type="submit" class="btn btn-success" onclick="conf(event)"value="Update">
						</fieldset>

					</form>
				</div>
			</div>
		</main>

		<jsp:include page="bottom_nav.jsp" />
	</div>
	<jsp:include page="footer.jsp" />