<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Struts 2 - Login </title>
</head>
<body>
<h2>Struts 2 - Login </h2>
<s:actionerror />
<s:form action="LoginAction" method="post">
	<s:textfield name="userBean.email" key="label.email" size="20" />
	<s:password name="userBean.password" key="label.password" size="20" />
	<s:submit method="execute" key="label.valide" align="center" />
</s:form>
</body>
</html>

