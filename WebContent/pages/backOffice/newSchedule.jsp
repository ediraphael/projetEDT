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
		<s:textfield name="scheduleBean.dayStar" key="label.dayStart" size="20" />
		<s:fielderror theme="simple" fieldName="error.dayStart"/>
		<s:textfield name="scheduleBean.dayEnd" key="label.dayEnd" size="20" />
		<s:fielderror theme="simple" fieldName="error.dayEnd"/>
		<s:select name="scheduleBean.nameGroup" label="Group" list="arrayGroupName" />
		<s:fielderror theme="simple" fieldName="error.group"/>
		<s:textfield name="scheduleBean.comment" key="label.comment" size="20" />
		<s:fielderror theme="simple" fieldName="error.comment"/>

		<s:fielderror theme="simple" fieldName="error.confirmpassword"/>
		<s:submit method="execute" key="label.valide" align="center" />
	</s:form>
</body>
</html>