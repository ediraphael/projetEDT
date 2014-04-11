<?xml version="1.0" encoding="iso-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<s:head theme="simple" />
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<title><s:text name="title.show.schedule"/></title>
	</head>
	<body>
		<h1><s:text name="title.show.schedule"/></h1>
		<table>
			<tr>
				<th><s:text name="label.id"/></th>
				<th><s:text name="label.name"/></th>
				<th><s:text name="label.dayStart"/></th>
				<th><s:text name="label.dayEnd"/></th>
				<th><s:text name="label.comment"/></th>
				<th><s:text name="label.userTeacher"/></th>
				<th><s:text name="label.subject"/></th>
				<th><s:text name="label.classroom"/></th>
				<th><s:text name="label.group"/></th>
				<th></th>
				<th></th>
			</tr>
			<s:iterator value="listScheduleBean" id="schedule">
				<tr>
					<td><s:property value="id"/></td>
					<td><s:property value="name"/></td>
					<td><s:property value="dayStart"/></td>
					<td><s:property value="dayEnd"/></td>
					<td><s:property value="comment"/></td>
					<td><s:property value="nameUserTeacher"/></td>
					<td><s:property value="nameSubject"/></td>
					<td><s:property value="nameClassroom"/></td>
					<td><s:property value="nameGroup"/></td>
					<td>
						<s:url id="url" action="GetSchedule">
							<s:param name="id"><s:property value="id"/></s:param>
					    </s:url>
					    <s:a href="%{url}"><s:text name="label.update"/></s:a>
					</td>
					<td>
						<s:url id="url" action="DeleteSchedule">
							<s:param name="id"><s:property value="id"/></s:param>
					    </s:url>
					    <s:a href="%{url}"><s:text name="label.delete"/></s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>