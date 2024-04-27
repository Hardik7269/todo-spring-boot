<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
	<title>Add TODO Here</title>
</head>
<body>

	<div class="container">
		<h1>Add TODO Here</h1>
		<form:form method="post" modelAttribute="todo">

			Description<form:input type="text" path="description" required="required" />
			<form:errors  path="description" cssClass="text-warning"/><br>
			<form:input type="hidden" path="id" ></form:input>
			<form:input type="hidden" path="done" ></form:input>
			<input type="submit" class="btn btn-success">
		</form:form>
	</div>
	<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>