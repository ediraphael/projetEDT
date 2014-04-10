<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><s:property value="getText('title.schedule')"/></title>
</head>
<body>
	<h1>R&eacute;server un horaire</h1>
	<s:form action="HoraireAction" method="post">
		<s:textfield name="scheduleBean.name" key="label.name" size="20" />
		<s:fielderror theme="simple" fieldName="error.name"/>
		
		<s:textfield name="scheduleBean.firstName" key="label.firstname" size="20" />
		<s:fielderror theme="simple" fieldName="error.name"/>
		<s:textfield name="scheduleBean.name" key="label.name" size="20" />
		<s:fielderror theme="simple" fieldName="error.name"/>
		<s:select name="scheduleBean.nameGroup" label="Group" list="arrayGroupName" />
		<s:fielderror theme="simple" fieldName="error.group"/>
		<s:password name="userBean.teacherPassword" key="label.password.teacher" size="20" />
			<s:fielderror theme="simple" fieldName="error.teacherpassword"/>
		<s:textfield name="userBean.email" key="label.email" size="20" />
		<s:fielderror theme="simple" fieldName="error.email"/>
		<s:password name="userBean.password" key="label.password" size="20" />
		<s:fielderror theme="simple" fieldName="error.password"/>
		<s:password name="userBean.confirmPassword" key="label.password.confirm" size="20" />
		<s:fielderror theme="simple" fieldName="error.confirmpassword"/>
		<s:submit method="execute" key="label.valide" align="center" />
	</s:form>
</body>
</html>