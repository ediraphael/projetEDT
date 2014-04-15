<?xml version="1.0" encoding="iso-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<s:head theme="simple" />
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title><s:text name="title.new.schedule"/></title>
		<link rel="stylesheet" href="/ProjetEDT/css/smoothness/jquery-ui-1.10.4.custom.css"/>
		<script type='text/javascript' src="/ProjetEDT/javascript/jquery/jquery-1.10.2.js"></script>
		<script type='text/javascript' src="/ProjetEDT/javascript/jquery/jquery-ui-1.10.4.custom.js"></script>
	</head>
	<body>
		<h1><s:text name="title.new.schedule"/></h1>
		<s:form action="ScheduleAction" method="post">
			<s:textfield name="scheduleBean.name" key="label.name" size="20" />
			<s:fielderror theme="simple" fieldName="error.name"/>
			<s:textfield id="heure_debut" name="scheduleBean.dayStart" key="label.dayStart" size="20" />
			<s:fielderror theme="simple" fieldName="error.dayStart"/>
			<s:textfield id="heure_fin" name="scheduleBean.dayEnd" key="label.dayEnd" size="20" />
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
			<s:submit key="label.valide" />
		</s:form>
	<script>
	 $(function() {
		$( "#heure_debut" ).datetimepicker({
			dateFormat: "yy-mm-dd",
			timeFormat:  "HH:mm:ss"
		});
		$( "#heure_fin" ).datetimepicker({
			dateFormat: "yy-mm-dd",
			timeFormat:  "HH:mm:ss"
		});
	 });
	</script>
	</body>
</html>