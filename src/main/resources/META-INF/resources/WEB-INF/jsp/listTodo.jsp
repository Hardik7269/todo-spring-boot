<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
 	</head>
	<body>
		Welcome ${name}
		<hr>
		<h1>Your Todos</h1>
	
		<table>
			<thead>
				<th>Id</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>is Done?</th>
			</thead>	
			<tbody>
				<c:forEach items="${todos}" var="todos">
				<tr>
					<td>${todos.id}</td>
					<td>${todos.description}</td>
					<td>${todos.targetDate}</td>
					<td>${todos.done}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>