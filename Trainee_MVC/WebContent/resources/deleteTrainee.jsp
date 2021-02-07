<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainee Management</title>
</head>
<body background="Hydrangeas.jpg">
	<h1 align="center" style="color: Yellow;">Trainee management</h1>
	<form:form action="deleteTrainee.obj" method="post"
		modelAttribute="del">

		<table align="center">
			<tr>
				<td>Please Enter Trainee Id:<span style="color: red">*</span></td>
				<td><form:input path="traineeId" /></td>
				<td style="color: red;"><form:errors path="traineeId" /></td>

				<td colspan="2"><input type="submit" name="submit"
					value="Delete"></input></td>

			</tr>
		</table>
	</form:form>

	<c:if test="${isFirst==false}">
		<form:form action="delTrainee.obj" method="post"
			modelAttribute="tBean">
			<h2 align="center">Trainee Information</h2>

			<table border="1" align="center">
				<tr>
					<th bgcolor="bisque">Trainee Id</th>
					<th bgcolor="bisque">Trainee Name</th>
					<th bgcolor="bisque">Trainee Domain</th>
					<th bgcolor="bisque">Trainee DOB</th>
				</tr>
				<tr>
					<td>${tBean.traineeId}</td>
					<td>${tBean.traineeName}</td>
					<td>${tBean.traineeDomain}</td>
					<td>${tBean.traineeDob}</td>
				</tr>
				<tr>
					<form:hidden path="traineeId" value="${tBean.traineeId }" />
				</tr>
				<tr>
					<td><input type="submit" value="Delete Trainee"></td>
				</tr>
			</table>

		</form:form>

	</c:if>

	<tr>
		<a href="showHomePage.obj">Back to Home page</a>
	</tr>
</body>
</html>