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
		<s:textfield name="scheduleBean.dayStar" key="label.dayStart" size="20" />
		<s:fielderror theme="simple" fieldName="error.dayStart"/>
		<s:textfield name="scheduleBean.dayEnd" key="label.dayEnd" size="20" />
		<s:fielderror theme="simple" fieldName="error.dayEnd"/>
		<s:textfield name="scheduleBean.comment" key="label.comment" size="20" />
		<s:fielderror theme="simple" fieldName="error.comment"/>
		<s:select name="scheduleBean.nameGroup" key="label.group" list="arrayGroupName" />
		<s:fielderror theme="simple" fieldName="error.group"/>
		<s:select name="scheduleBean.nameClassroom" key="label.classroom" list="arrayClassroomName" />
		<s:fielderror theme="simple" fieldName="error.classroom"/>
		<s:select name="scheduleBean.nameUserTeacher" key="label.userTeacher" list="arrayUserTeacherName" />
		<s:fielderror theme="simple" fieldName="error.userTeacher"/>
		<s:select name="scheduleBean.nameSubject" key="label.subject" list="arraySubjectName" />
		<s:fielderror theme="simple" fieldName="error.userTeacher"/>
		<s:submit method="execute" key="label.valide" align="center" />
	</s:form>
</body>
</html>