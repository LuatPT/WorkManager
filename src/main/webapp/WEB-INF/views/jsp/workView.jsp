<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>View Work</title>
</head>
<body>
  <a href="<c:url value="/work-list" />" >List Work</a><br />
  
	<p>${work.work_id}</p>
	<p>${work.work_name}</p>
	<p>${work.work_start}</p>
	<p>${work.work_end}</p>
	<p>${work.work_percent}</p>
	<p>${work.work_status}</p>
	<p>${work.user_id}</p>
</body>
</html>