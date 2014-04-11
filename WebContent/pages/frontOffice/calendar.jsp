<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../css/jquery-ui-1.8.11.custom.css' />
	<link rel='stylesheet' type='text/css' href='../../css/jquery.weekcalendar.css' />
	<script type='text/javascript' src='../../javascript/jquery/jquery-1.4.4.min.js'></script>
	<script type='text/javascript' src='../../javascript/jquery/jquery-ui-1.8.11.custom.min.js'></script>
	
	<script type="text/javascript" src="../../javascript/calendar/date.js"></script>
	<script type='text/javascript' src='../../javascript/calendar/jquery.weekcalendar.js'></script>
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
	    { 	'id'		:	'1',
				'title' 	:	'Compilation',
				'start'		:	'2014-04-14 13:50:00',
				'end'		:	'2014-04-14 16:40:00',
				'comment':'<br />Lefevre<br />Cours magistral<br />H006<br />M1 Informatique'},
		
			{ 	'id'		:	'2',
				'title' 	:	'Web',
				'start'		:	'2014-04-15 13:50:00',
				'end'		:	'2014-04-15 16:40:00',
				'comment':'<br />Chhel<br />Travaux pratiques<br />H006<br />M1 Informatique'},
		
			{ 	'id'		:	'10',
				'title' 	:	'aaa',
				'start'		:	'2014-04-11 15:15:00',
				'end'		:	'2014-04-18 15:15:00',
				'comment':'aaaa<br />Lefevre<br />Cours magistral<br />H006<br />Enseignant'},
		
			{ 	'id'		:	'15',
				'title' 	:	'Compilation',
				'start'		:	'2014-04-14 13:50:00',
				'end'		:	'2014-04-14 16:40:00',
				'comment':'<br />Chhel<br />Cours magistral<br />H006<br />M1 Informatique'},

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
	<s:property value="#session.user.email" />
	<div id='calendar'></div>
</body>
</html>
