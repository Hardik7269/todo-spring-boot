<%@include file="comman/header.jspf"%>
<body>
	<%@ include file="comman/navigation.jspf"%>
	<div class="container">
		<h1>Add TODO Here</h1>
		<!-- 		modelAttribute provides the binding with the bean .. directly adding data to the object todo -->
		<form:form method="post" modelAttribute="todo">

			<fieldset class="mb-3">
				<form:label path="description">Description </form:label>
				<form:input type="text" path="description" required="required" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>

			<form:input type="hidden" path="id" />

			<form:input type="hidden" path="done" />

			<input type="submit" class="btn btn-success">
		</form:form>
	</div>
<%@ include file="comman/footer.jspf" %>
<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd',
	});
</script>