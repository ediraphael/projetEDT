<?xml version="1.0" encoding="iso-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<s:head theme="simple" />
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title><s:text name="title.home"/></title>
	</head>
	<body>
		<h1><s:text name="title.home"/></h1>
		<s:property value="#session.user.email" />
		<div>
			<s:a action="Login"><s:text name="label.login"/></s:a>
			<s:a action="InscriptionForm"><s:text name="label.register"/></s:a>
			<s:a action="ShowCalendar"><s:text name="label.view_calendar"/></s:a>
		</div>
	</body>
</html>
