<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Work List</title>
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
  <c:url value="/work-save" var="urlSave"/>
  <c:url value="/work-view/" var="urlView"/>
  <c:url value="/work-update/" var="urlUpdate"/>
  <c:url value="/workDelete/" var="urlDelete"/>
  <h1>List work:</h1>
  <a href="${urlSave}">Add work</a>
  <br />
  <br />
  <table>
    <tr>
      <th>Work Name</th>
      <th>Work Start</th>
      <th>Work End</th>
      <th>Work Status</th>
      <th>View</th>
      <th>Edit</th>
      <th>Delete</th>
    </tr>
   <%--  <c:if test="${not empty listWork}"> --%>
      <c:forEach var="work" items="${listWork}">
        <tr style="border: 1px black solid">
          <td>${work.work_name}</td>
          <td>${work.work_start}</td>
          <td>${work.work_end}</td>
          <td>${work.work_status}</td>
          <td> <a href="${urlView}/${work.work_id}">View</a></td>
          <td> <a href="${urlUpdate}/${work.work_id}">Edit</a></td>
          <td> <a href="${urlDelete}/${work.work_id}">Delete</a></td>
        </tr>
      </c:forEach>
   <%--  </c:if>  --%>
  </table>
</body>
</html>