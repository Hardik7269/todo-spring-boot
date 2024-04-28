<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>Your Todos</h1>

		<table class="table">
			<thead>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th></th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todos">
					<tr>
						<td>${todos.description}</td>
						<td>${todos.targetDate}</td>
						<td>${todos.done}</td>
						<td><a href="delete-todo?id=${todos.id}" class="btn btn-warning">Delete</a></td>
						<td><a href="update-todo?id=${todos.id}" class="btn btn-success">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>
	</div>
	<script type="text/javascript"
		src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>