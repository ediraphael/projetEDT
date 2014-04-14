<?xml version="1.0" encoding="iso-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<link rel="stylesheet" href="./css/pageCss/css/mainstyle.css" type="text/css" />
		<title><s:text name="title.show.group"/></title>
	</head>
	<body>
		<div id="wrap">
			<%@ include file="../other/applicationName.jsp" %>
			<%@ include file="../other/menuAdmin.jsp" %>
			<div id="content-top"></div>
			<div id="content-middle">
				<h1><s:text name="title.show.group"/></h1>
				<table>
					<tr>
						<th><s:text name="label.id"/></th>
						<th><s:text name="label.name"/></th>
						<th></th>
					</tr>
					<s:iterator value="listGroupBean" id="group">
						<tr>
							<s:url id="url" action="GetUser">
								<s:param name="id"><s:property value="id"/></s:param>
						    </s:url>
							<td><s:a href="%{url}"><s:property value="id"/></s:a></td>
							<td><s:a href="%{url}"><s:property value="name"/></s:a></td>
							<td style="width:25px;">
								<s:url id="url" action="DeleteGroup">
									<s:param name="id"><s:property value="id"/></s:param>
							    </s:url>
							    <s:a href="%{url}"><img src="./css/pageCss/images/btn_corbeille.png" alt="<s:text name="label.delete"/>" width="20px" /></s:a>
						    </td>
						</tr>
					</s:iterator>
				</table>
			<div class="clear"></div>
			</div>
			<div id="content-bottom"></div>
		</div>
	</body>
</html>