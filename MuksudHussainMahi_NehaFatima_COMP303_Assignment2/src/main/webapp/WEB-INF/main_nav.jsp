
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--Main Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="/">Flight Booking</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<c:choose>
					<c:when test="${title=='Home'}">
						<li class="nav-item active">
					</c:when>
					<c:otherwise>
						<li class="nav-item">
					</c:otherwise>
				</c:choose>
				<a class="nav-link" href="/"><i class="fas fa-home"></i>Home</a>
				</li>

				<c:choose>
					<c:when test="${title=='Book Flight'}">
						<li class="nav-item active">
					</c:when>
					<c:otherwise>
						<li class="nav-item">
					</c:otherwise>
				</c:choose>
				<a class="nav-link" href="/book-flight"><i
					class="fa-solid fa-plane"></i>Book Flight</a>
				</li>

				<c:choose>
					<c:when test="${title=='Manage' && user!=null}">
						<li class="nav-item active"><a class="nav-link"
							href="/bookings"><i class="fa-solid fa-gear"></i>Manage
								Bookings</a>
					</c:when>
					<c:when test="${user!=null}">
						<li class="nav-item"><a class="nav-link" href="/bookings"><i
								class="fa-solid fa-gear"></i>Manage Bookings</a>
					</c:when>
				</c:choose>
				</li>

				<c:choose>
					<c:when test="${title=='Profile' && user!=null}">
						<li class="nav-item active"><a class="nav-link"
							href="/profile"><i class="fa-solid fa-user"></i>Profile</a>
					</c:when>
					<c:when test="${user!=null}">
						<li class="nav-item"><a class="nav-link" href="/profile"><i class="fa-solid fa-user"></i>Profile</a>
					</c:when>
				</c:choose>
				</li>

				<c:choose>
					<c:when test="${title=='Login' && user==null}">
						<li class="nav-item active"><a class="nav-link"
							href="/signin"><i class="fa-solid fa-right-to-bracket"></i>Login</a>
					</c:when>
					<c:when test="${user==null}">
						<li class="nav-item"><a class="nav-link" href="/signin"><i
								class="fa-solid fa-right-to-bracket"></i>Login</a>
					</c:when>
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="/logout"><i
								class="fa-solid fa-right-from-bracket"></i>Logout</a>
					</c:otherwise>
				</c:choose>
				</li>




			</ul>
		</div>
	</div>
</nav>