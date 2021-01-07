<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="../css/login.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
</head>
<body>
	<div class="row">
		<div class="wrapper col-md-6">
	  	<c:url value="/register" var="register"/>
	  	<form:form action="${register}" method="POST" modelAttribute="user" class="form-signin">       
	      <h2 class="form-signin-heading">Please register</h2>
	      <p>${statusRegister}</p>
	      <form:input type="text" class="form-control" path="user_name" placeholder="User name..." required="" autofocus="" ></form:input>
	      <form:input type="password" class="form-control" path="password" placeholder="Password..." required=""></form:input>
	      <form:button class="btn btn-lg btn-primary btn-block" type="submit">Register</form:button>   
	    </form:form>
	  </div>
	  <div class="wrapper col-md-6">
	  	<c:url value="/login" var="login"/>
	  	<form:form action="${login}" method="POST" modelAttribute="user" class="form-signin">       
	      <h2 class="form-signin-heading">Please login</h2>
	      <p>${statusLogin}</p>
	      <form:input type="text" class="form-control" path="user_name" placeholder="User name..." required="" autofocus="" ></form:input>
	      <form:input type="password" class="form-control" path="password" placeholder="Password..." required=""></form:input>
	      <form:button class="btn btn-lg btn-primary btn-block" type="submit">Login</form:button>   
	    </form:form>
	  </div>
	</div>
</body>
</html>