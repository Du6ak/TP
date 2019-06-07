<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet + JSP + Hibernate</title>

<style type="text/css">
	body{
	
		background-image: url(https://png.pngtree.com/back_origin_pic/00/15/01/6d4b71070f6fc86532b8135ba7046309.jpg);
		background-position: center center;
		background-size: cover;
		background-color: #464646;
		text-align: center;
	}
	table {
		align: center;
        vertical-align: middle;
		margin: auto;
		min-width: 40%; 
		border: 1px solid #CCC;
		border-collapse: collapse; 
	}
	table tr{line-height: 30px;}
	table tr th { background: #000033; color: #FFF;}
	table tr td { border:1px solid #CCC; margin: 5px;}
	input[type=text], input[type=email], input[type=tel]{
		min-width: 60%;
	}
	input[type=submit], a{
		background: green;
		padding: 5px;
		margin: 5px;
		color: #FFF;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body ><!-- background="https://png.pngtree.com/back_origin_pic/00/15/01/6d4b71070f6fc86532b8135ba7046309.jpg" -->
	<h1>Servlet + JSP + Hibernate</h1>
	<c:url value="/student/register" var="registerUrl" />
	<form action="${registerUrl}" method="post">
		<table>
			<c:if test="${student.id ne null}">
				<tr valign="center" align="center">
				<td>Student ID:</td>
					<td><input type="text" name="id" value="${student.id}" readonly="readonly"></td>
				</tr>
			</c:if>
			<tr valign="center" align="center">
				<td>First Name:</td>
				<td><input type="text" name="firstName" value="${student.firstName}" required></td>
			</tr>
			<tr valign="center" align="center">
				<td>Last Name:</td>
				<td><input type="text" name="lastName" value="${student.lastName}" required></td>
			</tr>
			<tr valign="center" align="center">
				<td>Email:</td>
				<td><input type="email" name="email" value="${student.email}" required></td>
			</tr>
			<tr valign="center" align="center">
				<td>Mobile:</td>
				<td><input type="tel" pattern="[789][0-9]{9}" name="mobile" value="${student.mobile}" required></td>
			</tr>

			<c:if test="${student.id ne null}">
				<tr valign="center" align="center">
					<td colspan="2"><input type="submit" value="Update"></td>
				</tr>
			</c:if>
			<c:if test="${student.id eq null}">
				<tr valign="center" align="center">
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</c:if>
		</table>
	</form>
	<br>
	<h1>List of Students</h1>
	<table bgcolor="#FFFFF">
		<tr valign="center" align="center">
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${studentList}" var="student">
			<tr valign="center" align="center">
				<td>${student.id}</td>
				<td>${student.firstName}</td>
				<td>${student.lastName}</td>
				<td>${student.email}</td>
				<td>${student.mobile}</td>
				
				<td>
					<form action="<c:url value="/student/update"/>" method="post">
						<input type="hidden" name="studId" value="${student.id}">
						<input type="submit" value="Update">
					</form>
				<td>
					<form action="<c:url value="/student/delete"/>" method="post">
						<input type="hidden" name="studId" value="${student.id}">
						<input style="background: #F00;" type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>