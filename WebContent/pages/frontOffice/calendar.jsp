<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../css/jquery-ui-1.8.11.custom.css' />
	<link rel='stylesheet' type='text/css' href='../../css/jquery.weekcalendar.css' />
	<script type='text/javascript' src='../../javascript/jquery-1.4.4.min.js'></script>
	<script type='text/javascript' src='../../javascript/jquery-ui-1.8.11.custom.min.js'></script>
	
	<script type="text/javascript" src="../../javascript/date.js"></script>
	<script type='text/javascript' src='../../javascript/jquery.weekcalendar.js'></script>
	<script type='text/javascript'>
	var year = new Date().getFullYear();
	var month = new Date().getMonth();
	var day = new Date().getDate();
	var eventData = {
	  events : [
	    {'id':1, 'start': new Date(year, month, day, 12), 'end': new Date(year, month, day, 13, 35),'title':'Lunch with Mike','comment':'coucou je suis un commentaire'},
	    {'id':2, 'start': new Date(year, month, day, 14), 'end': new Date(year, month, day, 14, 45),'title':'Dev Meeting'},
	    {'id':3, 'start': new Date(year, month, day + 1, 18), 'end': new Date(year, month, day + 1, 18, 45),'title':'Hair cut'},
	    {'id':4, 'start': new Date(year, month, day - 1, 8), 'end': new Date(year, month, day - 1, 9, 30),'title':'Team breakfast'},
	    {'id':5, 'start': new Date(year, month, day + 1, 14), 'end': new Date(year, month, day + 1, 15),'title':'Product showcase'}
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
	<p>Bienvenue sur l'appli EDT avec Struts 2 =) </p>
	<s:property value="#session.user.email" />
	<div id='calendar'></div>
</body>
</html>
