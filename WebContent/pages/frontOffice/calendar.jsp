<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
		<link rel="stylesheet" href="./css/pageCss/css/mainstyle.css" type="text/css" />
		<title><s:text name="title.calendar"/></title>
		<link rel="stylesheet" href="/ProjetEDT/css/smoothness/jquery-ui-1.10.4.custom.css"/>
		<link rel='stylesheet' type='text/css' href='/ProjetEDT/css/jquery-ui-1.8.11.custom.css' />
	<link rel='stylesheet' type='text/css' href='/ProjetEDT/css/jquery.weekcalendar.css' />
	<script type='text/javascript' src='/ProjetEDT/javascript/jquery/jquery-1.4.4.min.js'></script>
	<script type='text/javascript' src="/ProjetEDT/javascript/jquery/jquery-ui-1.10.4.custom.js"></script>
	<script type='text/javascript' src='/ProjetEDT/javascript/jquery/jquery-ui-1.8.11.custom.min.js'></script>
	<script type="text/javascript" src="/ProjetEDT/javascript/calendar/date.js"></script>
	<script type='text/javascript' src='/ProjetEDT/javascript/calendar/jquery.weekcalendar.js'></script>
	<s:set name="view" value="view"/>
	<s:if test="%{#view!='resume'}">
	<s:if test="%{#view=='compact'}">
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
					'end':'<s:property value="dayEnd"/>'
				},
			</s:iterator>
	    ]
	};
	</script>
	<script type='text/javascript'>
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
			defaultEventLength: 1,
	        timeslotsPerHour: 1,
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
			minDate: '<s:property value="dayMin"/>',
		    maxDate: '<s:property value="dayMax"/>',
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
	</s:if>
	<s:else>
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
	</script>
	<script type='text/javascript'>
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
			minDate: '<s:property value="dayMin"/>',
		    maxDate: '<s:property value="dayMax"/>',
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
	</s:else>
	</s:if>
	</head>
	<body>
		<div id="wrap">
			<%@ include file="../other/applicationName.jsp" %>
			<%@ include file="../other/menuAdmin.jsp" %>
			<div id="content-top"></div>
			<div id="content-middle">
				<h1><s:text name="title.calendar"/><s:property value="view"/></h1>
				<s:form action="ShowCalendar" method="post">
					<table>
						<tr>
							<td>Type</td>
							<td><s:radio label="Type" name="view" list="listView" value="defaultViewValue" /></td>
						</tr>
						<tr>
							<td><s:text name="label.group"/></td>				
							<td><s:select name="scheduleBean.nameGroup" list="arrayGroupName" /></td>
						</tr>
						<tr>
							<td><s:text name="label.dayStart"/></td>
							<td><s:textfield id="heure_debut" name="dayMin" key="label.dayStart" /></td>
						</tr>
						<tr>
							<td><s:text name="label.dayEnd"/></td>
							<td><s:textfield id="heure_fin" name="dayMax" key="label.dayEnd" /></td>
						</tr>
					</table>
					<s:submit key="label.valide"  cssClass="user_button"/>
				</s:form>
				<div id='calendar'></div>
			</div>
			<div id="content-bottom"></div>
		</div>
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