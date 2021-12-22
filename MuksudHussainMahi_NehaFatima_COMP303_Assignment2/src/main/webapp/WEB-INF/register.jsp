<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<h3 class="title-a">Register</h3>
				<div class="line-mf"></div>
			</div>

			<div class="row">
				<div class="offset-md-3 col-md-6">
					<h1>Please Register</h1>
					<form:form action="/register-user" method="POST" modelAttribute="objPassenger">
						<fieldset class="form-group">
							<label for="email"></label>
							<form:input type="email" class="form-control" path="email"
								placeholder="Enter email" id="email"/>
						</fieldset>


						<fieldset class="form-group">
							<label for="password"></label>
							<form:input type="password" class="form-control" path="password"
								placeholder="Enter password" id="password"/>
						</fieldset>


						<fieldset class="form-group">
							<label for="firstName"></label>
							<form:input type="text" class="form-control" path="firstName"
								placeholder="Enter firstname" id="firstName" />
						</fieldset>

						<fieldset class="form-group">
							<label for="lastName"></label>
							<form:input type="text" class="form-control" path="lastName"
								placeholder="Enter lastname" id="lastName" />
						</fieldset>

						<fieldset class="form-group">
							<label for="phoneNumber"></label>
							<form:input type="text" class="form-control" path="phoneNumber"
								placeholder="Enter phone number" id="phoneNumber"/>
						</fieldset>

						<fieldset class="form-group">
							<label for="address"></label>
							<form:input type="text" class="form-control" path="address"
								placeholder="Enter address" id="address"/>
						</fieldset>

						<fieldset class="form-group">
							<label for="city"></label>
							<form:input type="text" class="form-control" path="city"
								placeholder="Enter city" id="city"/>
						</fieldset>

						<fieldset class="form-group">
							<label for="postalCode"></label>
							<form:input type="text" class="form-control" path="postalCode"
								placeholder="Enter city" id="postalCode"/>
						</fieldset>

						<fieldset class="form-group">
							<label for="country"></label>
							<form:input type="text" class="form-control" path="country"
								placeholder="Enter city" id="country"/>
						</fieldset>

						<fieldset class="form-group text-right">
							<input type="submit" class="btn btn-success" value="Register
							">
							<a href="/"> <input type="button" class="btn btn-warning"
								value="Cancel">
							</a>
						</fieldset>

					</form:form>
				</div>
			</div>
		</main>

		<jsp:include page="bottom_nav.jsp" />
	</div>
	<jsp:include page="footer.jsp" />