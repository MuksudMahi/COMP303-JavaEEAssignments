/**
 * 
 */
function msg() {
	alert("Updated");
}

function msgSuccess() {
	alert("Updated");
}

function conf(event)
{
	if(!confirm('Are you sure?'))
		event.preventDefault();
	//window.location.assign('/');
}

function dlt(s, event) {
var a=new Date(s).getTime();
var b=new Date().getTime();
var c=(b-a)/(1000*3600*24);
	if (c > 14) {
		alert("Cannot cancel after 14 days");
		event.preventDefault();
		//window.location.assign('/');
		//console.log("Greater");
		return;
	}
	else if(!confirm('Are you sure?')) {
		event.preventDefault();
		//window.location.assign('/');
	}
}
