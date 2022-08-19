<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
		<form action="join" method="post">
			<section class="container-fluid col-lg-8 mt-4">
				<h1>Join Page</h1>
				<p>ID</p>
				<p><input class="form-control form-control-lg" type="text" placeholder="ID" aria-label=".form-control-lg example" name="username"></p>
				<p>PW</p>
				<p><input class="form-control form-control-lg" type="password" placeholder="PW" aria-label=".form-control-lg example" name="password"></p>
				<p>Name</p>
				<p><input class="form-control form-control-lg" type="text" placeholder="Name" aria-label=".form-control-lg example" name="name"></p>
				<p>Email</p>
				<p><input class="form-control form-control-lg" type="email" placeholder="Email" aria-label=".form-control-lg example" name="email"></p>
				<p>Phone</p>
				<p><input class="form-control form-control-lg" type="text" placeholder="Phone" aria-label=".form-control-lg example" name="phone"></p>
				<button type="submit" class="btn btn-primary">Submit</button>
			</section>
		</form>
</body>
</html>