<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center" style="color: Yellow;">Trainee management</h1>
	<form:form action="updateTrainee.obj" method="post"
		modelAttribute="trainee">

		<table align="center">
			<tr>
				<td>Please Enter Trainee Id to Update:<span style="color: red">*</span></td>
				<td><form:input path="traineeId" /></td>
				<td style="color: red;"><form:errors path="traineeId" /></td>

				<td colspan="2"><input type="submit" name="submit"
					value="Search"></input></td>

			</tr>
		</table>
	</form:form>
	<c:if test="${isFirst==false}">
		<form:form action="modifyTrainee.obj" method="post"
			modelAttribute="tBean">
			<h2 align="center">Trainee Information</h2>

			<table border="1" align="center">
				<tr>
					<th bgcolor="bisque">Trainee Id</th>
					<td>${tBean.traineeId}</td>
				</tr>
				<tr>
					<td>Trainee Name :<span style="color: red;">*</span></td>
					<td><form:input value="${tBean.traineeName}"
							path="traineeName" /></td>
					<td style="color: red;"><form:errors path="traineeName" /></td>
				</tr>
				<tr>
					<td>Trainee Domain :<span style="color: red;">*</span></td>
					<td><form:input path="traineeDomain"
							value="${tBean.traineeDomain}"></form:input> <form:errors
							path="traineeDomain" /></td>
				</tr>

				<tr>
					<td>Trainee DateOf Birth :<span style="color: red;">*</span></td>
					<td><form:input path="traineeDob" value="${tBean.traineeDob}" /></td>
					<td style="color: red;"><form:errors path="traineeDob" /></td>
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

	<table border="1" align="left">

		<tr>
			<td><a href="showHomePage.obj">Back to Home page</a></td>
		</tr>
	</table>
</body>
</html>