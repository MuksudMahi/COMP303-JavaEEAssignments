<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp" />
<body class="text-center">
	<div class="d-flex w-100 h-100 p-3 mx-auto flex-column">
		<jsp:include page="main_nav.jsp" />
		<main class="container">
			<!--Message area-->
			
			<c:if test="${message!=null}">
				<div class="alert alert-danger">
					${message}
				</div>
			</c:if>
			
			
			<div class="title-box text-center">
				<h3 class="title-a">Login</h3>
				<div class="line-mf"></div>
			</div>

			<div class="row">
				<div class="offset-md-4 col-md-4">
					<h1>Please Login</h1>
					<form action="/login" method="POST" autocomplete="off">
						<fieldset class="form-group">
							<label for="email"></label> <input type="email"
								class="form-control" name="email" placeholder="Enter email"
								id="email" required autofocus>
						</fieldset>


						<fieldset class="form-group">
							<label for="password"></label> <input type="password"
								class="form-control" name="password"
								placeholder="Enter password" id="password" required> or
							<a href="/register">Register here</a>
						</fieldset>

						<fieldset class="form-group text-right">
							<input type="submit" class="btn btn-success" value="Login">
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