<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Delete</th>
		</tr>
	<s:iterator value="listGroupBean" id="group">
		<tr>
			<td><s:property value="id"/></td>
			<td><s:property value="name"/></td>
			<td>
				<s:url id="url" action="GroupDelete">
					<s:param name="id"><s:property value="id"/></s:param>
			    </s:url>
			    <s:a href="%{url}"><s:property value="getText('action.delete')"/></s:a>
		    </td>
		</tr>
	</s:iterator>
	</table>
</body>
</html>