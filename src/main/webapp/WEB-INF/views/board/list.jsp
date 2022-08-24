<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class = "container-fluid col-lg-8 mt-4">
		<h1>${board} List Page</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>NUM</th><th>TITLE</th><th>WRITER</th><th>REGDATE</th>
					<th>HIT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td><a href="detail.iu?num=${dto.num}">${dto.title}</a></td>
						<td>${dto.writer}</td>
						<td>${dto.regDate}</td>
						<td>${dto.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add.iu">${board} 등록</a>
	<nav aria-label="Page navigation example">
  		<ul class="pagination">
    		<li class="page-item"><a class="page-link" href="#">Previous</a></li>
    		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
  				<li class="page-item"><a class="page-link" href="./list.iu?page=${i}">${i}</a></li>
  			</c:forEach>
    		<li class="page-item"><a class="page-link" href="#">Next</a></li>
  		</ul>
	</nav>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>