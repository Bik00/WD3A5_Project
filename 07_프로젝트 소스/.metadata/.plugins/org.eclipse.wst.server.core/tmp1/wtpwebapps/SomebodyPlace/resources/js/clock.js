var dayarray = new Array("월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일");
var montharray = new Array("1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월");

function getthedate() {
	var mydate = new Date();
	var year = mydate.getYear();
	if (year < 1000) {
		year += 1900
	}
	var day = mydate.getDay()
	var month = mydate.getMonth()
	var daym = mydate.getDate()
	if (daym < 10)
		daym = "0" + daym
	var hours = mydate.getHours()
	var minutes = mydate.getMinutes()
	var seconds = mydate.getSeconds()
	var dn = "오전"
	if (hours >= 12)
		dn = "오후"
	if (hours > 12) {
		hours = hours - 12
	}
	if (hours == 0)
		hours = 12
	if (minutes <= 9)
		minutes = "0" + minutes
	if (seconds <= 9)
		seconds = "0" + seconds
		// change font size here
	var cdate = "<font face='Arial'><b><h1>현재 시각은 <br>" + year+"년 "+ montharray[month] +" "+ daym +"일 "
	 + dn + " "+ hours+ ":" + minutes + ":" + seconds + " 입니다.</b></font></h1>"
	if (document.all)
		document.all.clock.innerHTML = cdate
	else if (document.getElementById)
		document.getElementById("clock").innerHTML = cdate
	else
		document.write(cdate)
}
if (!document.all && !document.getElementById)
	getthedate()
function goforit() {
	if (document.all || document.getElementById)
		setInterval("getthedate()", 1000)
}