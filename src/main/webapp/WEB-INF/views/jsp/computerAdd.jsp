<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Add new Computer</title>
</head>
<body>
  <a href="<c:url value="/computer-list" />" >List Computer</a><br />
  <h1>Add new Computer:</h1>
  <c:url value="/saveComputer" var="saveComputer"/>
  <form:form action="${saveComputer}" method="POST"
    modelAttribute="computer">
      Computer ID: <form:input path="computer_id" /> <br/> <br/>
      Computer Status: <br/>
      ON<form:radiobutton path="computer_status" value="ON"/>  
      OFF<form:radiobutton path="computer_status" value="OFF"/> <br/> <hr/>
    <button type="submit">Submit</button>
  </form:form>
</body>
