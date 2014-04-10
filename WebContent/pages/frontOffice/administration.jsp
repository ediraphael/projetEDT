<?xml version="1.0" encoding="iso-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<s:head theme="simple" />
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title><s:text name="title.admin"/></title>
	</head>
	<body>
		<h1><s:text name="title.admin"/></h1>
		<s:actionerror />
		<div>
			<s:a action="ShowUser"><s:text name="module.user"/></s:a>
			<s:a action="ShowGroup"><s:text name="module.group"/></s:a>
			<s:a action="ShowClassroom"><s:text name="module.classroom"/></s:a>
			<s:a action="ShowSchedule"><s:text name="module.schedule"/></s:a>
			<s:a action="ShowCalendar"><s:text name="module.calendar"/></s:a>
		</div>
	</body>
</html>
