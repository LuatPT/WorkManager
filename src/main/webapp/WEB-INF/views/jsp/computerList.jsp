<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Helo Spring MVC + JDBC</title>
<%-- <%@ page isELIgnored="false" %> --%>
<style>
table, th, td {
  border: 1px solid black;
}
td {
  padding-right: 30px;
}
</style>
</head>
<body>
  <c:url value="/computer-save" var="urlSave"/>
  <c:url value="/computer-view/" var="urlView"/>
  <c:url value="/computer-update/" var="urlUpdate"/>
  <c:url value="/computerDelete/" var="urlDelete"/>
  <h1>List computer:</h1>
  <a href="${urlSave}">Add computer</a>
  <br />
  <br />
  <table>
    <tr>
      <th>Id</th>
      <th>ON/OFF</th>
      <th>Bill ID</th>
      <th>View</th>
      <th>Edit</th>
      <th>Delete</th>
    </tr>
   <%--  <c:if test="${not empty listComputer}"> --%>
      <c:forEach var="computer" items="${listComputer}">
        <tr style="border: 1px black solid">
          <td>${computer.computer_id}</td>
          <td>${computer.computer_status}</td>
          <td>${computer.bill_id}</td>
          <td> <a href="${urlView}/${computer.computer_id}">View</a></td>
          <td> <a href="${urlUpdate}/${computer.computer_id}">Edit</a></td>
          <td> <a href="${urlDelete}/${computer.computer_id}">Delete</a></td>
        </tr>
      </c:forEach>
   <%--  </c:if>  --%>
  </table>
</body>
</html>