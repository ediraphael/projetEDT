<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Struts 2 - Classroom </title>
</head>
<body>
<h2>Struts 2 - Classroom </h2>
<s:actionerror />
<s:form action="ClassroomAction" method="post">
	<s:textfield name="classroomBean.name" key="label.name" size="20" />
	<s:fielderror theme="simple" fieldName="error.name"/>
	<s:submit method="execute" key="label.valide" align="center" />
</s:form>
</body>
</html>