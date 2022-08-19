<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<form action="./login" method="post">

	<section class="container-fluid col-lg-6 mt-4">
		<div class="row">
			<div class="mb-3">
    			<label for="exampleInputEmail1" class="form-label">ID</label>
    			<input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username">
    			<div id="emailHelp" class="form-text">We'll never share your ID with anyone else.</div>
  			</div>
  			<div class="mb-3">
    		<label for="exampleInputPassword1" class="form-label">Password</label>
    		<input type="password" class="form-control" id="exampleInputPassword1" name="password">
  			</div>
  			<div class="mb-3 form-check">
    		<input type="checkbox" class="form-check-input" id="exampleCheck1">
    		<label class="form-check-label" for="exampleCheck1">Check me out</label>
  			</div>
  			<button type="submit" class="btn btn-primary">Submit</button>
			</div>
	</section>
	
    </form>
    <c:import url="../template/footer.jsp"></c:import>
</body>
</html>

<!-- <p>ID</p>
	<p><input type="text" value="RR" name="username">
	<input type="submit">
    <input type="reset">
    </p>
   <p>PW</p> <input type="password" value="WW" name="password"><br>

    <img src="/images/iu.jpg">

    <a href="/study_index.html">인덱스 절대경로</a>
    <a href="../study_index.html">인덱스 상대경로</a> -->