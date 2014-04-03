<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><s:property value="getText('title.schedule')"/></title>
</head>
<body>
	<h2>Struts 2 - Classroom Update </h2>
	<s:form action="ClassroomUpdate" method="post">
		<s:hidden name="classroomBean.id" value="%{classroomBean.id}"/>
		<s:textfield name="classroomBean.name" value="%{classroomBean.name}" key="label.name" size="20" />
		<s:fielderror theme="simple" fieldName="error.name"/>
		<s:submit method="update" key="label.valide" align="center" />
	</s:form>
</body>
</html>