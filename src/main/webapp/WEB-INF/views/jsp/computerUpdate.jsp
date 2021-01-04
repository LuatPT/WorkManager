<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Helo Spring MVC + JDBC</title>
</head>
<body>
  <a href="<c:url value="/computer-list" />">List Computer</a>
  <br />
  <h1>Edit Computer:</h1>
  <c:url value="/updateComputer" var="updateComputer" />
  <form:form action="${updateComputer}" method="POST" modelAttribute="computer">
      Computer ID: <form:input path="computer_id" /> <br/> <br/>
      Computer Status: <br/>
      ON<form:radiobutton path="computer_status" value="ON"/>  
      OFF<form:radiobutton path="computer_status" value="OFF"/>  <br/> <br/> <hr/>
      Bill ID: <form:input path="bill_id" /> <br/> <br/>
    <button type="submit">Submit</button>
  </form:form>
</body>
</html>