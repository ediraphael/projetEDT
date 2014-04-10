<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title><s:property value="getText('title.admin')"/></title>
</head>
<body>
<h1><s:property value="getText('title.admin')"/></h1>
<s:actionerror />
<a href="<s:url action='/'/>"><s:property value="getText('module.user')"/></a>
<a href="<s:url action='GroupShow'/>"><s:property value="getText('module.group')"/></a>
<a href="<s:url action='ShowClassroom'/>"><s:property value="getText('module.classroom')"/></a>
<a href="<s:url action='/'/>"><s:property value="getText('module.schedule')"/></a>
<a href="<s:url action='/'/>"><s:property value="getText('module.calendar')"/></a>




</body>
</html>

module.user=Utilisateurs
module.group=Groupes
module.classroom=Salles
module.schedule=Horaires
module.calendar=Calendrier