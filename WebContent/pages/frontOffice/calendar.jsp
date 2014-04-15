<?xml version="1.0" encoding="iso-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<link rel="stylesheet" href="./css/pageCss/css/mainstyle.css" type="text/css" />
		<title><s:text name="title.new.schedule"/></title>
		<link rel="stylesheet" href="/ProjetEDT/css/smoothness/jquery-ui-1.10.4.custom.css"/>
		<link rel='stylesheet' type='text/css' href='/ProjetEDT/css/jquery-ui-1.8.11.custom.css' />
	<link rel='stylesheet' type='text/css' href='/ProjetEDT/css/jquery.weekcalendar.css' />
	<script type='text/javascript' src='/ProjetEDT/javascript/jquery/jquery-1.4.4.min.js'></script>
	<script type='text/javascript' src='/ProjetEDT/javascript/jquery/jquery-ui-1.8.11.custom.min.js'></script>
	
	<script type="text/javascript" src="/ProjetEDT/javascript/calendar/date.js"></script>
	<script type='text/javascript' src='/ProjetEDT/javascript/calendar/jquery.weekcalendar.js'></script>
	<script type='text/javascript'>
	var year = new Date().getFullYear();
	var month = new Date().getMonth();
	var day = new Date().getDate();
	var eventData = {
	  events : [
			<s:iterator value="listScheduleBean" id="schedule">
				{ 	'id':'<s:property value="id"/>',
					'title':'<s:property value="name"/>',
					'start':'<s:property value="dayStart"/>',
					'end':'<s:property value="dayEnd"/>',
					'comment':'<s:property value="comment"/><br /><s:property value="nameUserTeacher"/><br /><s:property value="nameSubject"/><br /><s:property value="nameClassroom"/><br /><s:property value="nameGroup"/>'
				},
			</s:iterator>
	    ]
	};
	
	$(document).ready(function() {
		$('#calendar').weekCalendar({
			timeslotsPerHour: 4,
			timeslotHeigh: 10,
			dateFormat: 'd M Y',
			use24Hour: true,
			hourLine: true,
			allowEventCreation:false,
			timeSeparator: ' à ',
			data: eventData,
			businessHours: {start: 0, end: 0, limitDisplay: false},
			height: function($calendar) {
				return $(window).height() - $('h1').outerHeight(true);
			},
			deletable: function(calEvent, element) {
				return false;
			},
			draggable: function(calEvent, element) {
				return false;
			},
			resizable: function(calEvent, element) {
				return false;
			},
			firstDayOfWeek: function(calendar) {
				return 1;
			},
			shortMonths: ['Jan', 'Fev', 'Mar', 'Avr', 'Mai', 'Jui', 'Jul', 'Aou', 'Sep', 'Oct', 'Nov', 'Dec'],
			longMonths: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
			shortDays: ['Dim', 'Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam'],
			longDays: ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'],
		});
	
		function displayMessage(message) {
		  $('#message').html(message).fadeIn();
		}
	
		$('<div id="message" class="ui-corner-all"></div>').prependTo($('body'));
	});
	</script>
	</head>
	<body>
		<div id="wrap">
			<%@ include file="../other/applicationName.jsp" %>
			<%@ include file="../other/menuAdmin.jsp" %>
			<div id="content-top"></div>
			<div id="content-middle">
				<s:form action="ShowCalendar" method="post">
					<s:text name="label.group"/>				
					<s:select name="scheduleBean.nameGroup" list="arrayGroupName" />
					<s:submit key="label.valide"  cssClass="user_button"/>
				</s:form>
				<div id='calendar'></div>
			</div>
			<div id="content-bottom"></div>
		</div>

	</body>
</html>