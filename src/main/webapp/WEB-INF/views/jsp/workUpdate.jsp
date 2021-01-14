<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Update Work</title>
</head>
<body>
  <a href="<c:url value="/showListWork" />">List Work</a>
  <br />
  <h1>Edit Work:</h1>
  <c:url value="/doUpdateWork" var="doUpdateWork" />
  <form:form action="${doUpdateWork}" method="POST" modelAttribute="work">
      Work ID: <form:input path="work_id" /> <br/> <br/>
      Work Name: <form:input path="work_name" /> <br/> 
      Work Start: <form:input path="work_start" class="date" type="date" /> <br/> 
      Work End: <form:input path="work_end" class="date" type="date"/> <br/> 
      Work Percent: <form:input path="work_percent" /> <br/> 
      Work Status: <br/>
      In progress<form:radiobutton path="work_status" value="In Progress"/>  
      Done<form:radiobutton path="work_status" value="Done"/> <br/> <hr/>
    <button type="submit">Submit</button>
  </form:form>
</body>
</html>