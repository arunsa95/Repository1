<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>,

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainee Management</title>
</head>
<body align="center" background="Penguins.jpg">
	<h1 align="center">Trainee Management</h1>
	<form:form action="addTrainee.obj" method="post" modelAttribute="add">
		<table align="center">
			<tr>
				<td>Trainee Id :<span style="color: red;">*</span></td>
				<td><form:input path="traineeId" /></td>
				<td style="color: red;"><form:errors path="traineeId" /></td>
			</tr>
			<tr>
				<td>Trainee Name :<span style="color: red;">*</span></td>
				<td><form:input path="traineeName" /></td>
				<td style="color: red;"><form:errors path="traineeName" /></td>
			</tr>
			<tr>
				<td>Trainee Domain :<span style="color: red;">*</span></td>
				<td><form:select path="traineeDomain" value="">
						<form:option value="" path="traineeDomain">Select</form:option>
						<form:option value="Java" path="traineeDomain">Java</form:option>
						<form:option value=".Net" path="traineeDomain">.Net</form:option>
						<form:option value="SAP" path="traineeDomain">SAP</form:option>
					</form:select></td>
				<td style="color: red;"><form:errors path="traineeDomain" /></td>
			</tr>

			<tr>
				<td>Trainee DateOf Birth :<span style="color: red;">*</span></td>
				<td><form:input path="traineeDob" /></td>
				<td style="color: red;"><form:errors path="traineeDob" /></td>
			</tr>
			<tr>
				<td colspan="5" align="center"><input type="submit"
					value="Add Trainee" /></td>
			</tr>

		</table>
		<table align="center">
			<tr>
				<td><a href="showHomePage.obj">Back to home page</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>