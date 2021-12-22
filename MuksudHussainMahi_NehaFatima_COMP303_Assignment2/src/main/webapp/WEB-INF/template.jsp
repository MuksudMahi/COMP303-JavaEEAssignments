<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--Header section-->
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
	integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />


<!-- Custom styles for this template -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/app.css" />
</head>
<body class="text-center">
	<div class="d-flex w-100 h-100 p-3 mx-auto flex-column">
		<!--Main Navigation-->
		<nav class="navbar navbar-expand-lg navbar-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="/">Flight Booking</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="/"><i
								class="fas fa-home"></i> Home</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<main class="container">
			<!--Message area-->
			<div class="alert alert-danger">Some Message</div>
			<div class="title-box text-center">
				<h3 class="title-a">Login</h3>
				<div class="line-mf"></div>
			</div>

			<div class="row">
				<div class="offset-md-4 col-md-4">
					<h1>Please Login</h1>
					<form action="/login" method="GET" autocomplete="off">
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
	<!--Bottom nav-->
	<footer class="mastfoot mt-auto">
		<div class="inner">
			<h6 class="display-6 navbar-text">&copy;2021. All Rights
				Reserved.</h6>
		</div>
	</footer>
	</div>
	<!--Script section-->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>