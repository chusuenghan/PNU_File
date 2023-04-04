<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BusRoute</title>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=uxcg7j4o6i"></script>
<style>
	body{
		width:80%;
		margin:0 auto;
	}
	#timeline{
		
	}
	#time_table{
		margin:0 auto;
	}
</style>
</head>
<body>
	<div id="timeline" style="width:100%;height:300px;border:1px solid black;">
		<table border="1px" id="time_table">
			<tr>
				<td>부산대</td>
				<td>밀양</td>
				<td>시간</td>
			</tr>
		</table>
	</div>
    <div id="map" style="width:50%;height:600px;margin:0 auto;"></div>
    <script>
	/* var mapDiv = document.getElementById('map'); // 'map'으로 선언해도 동일

	옵션 없이 지도 객체를 생성하면 서울 시청을 중심으로 하는 16 레벨의 지도가 생성됩니다.
	var map = new naver.maps.Map(mapDiv); */
	var curtLoca="";
	var BusanMy= new naver.maps.LatLng(35.47370833, 128.7707278);
	
	var map = new naver.maps.Map('map',{
			center : BusanMy,
			zoom:17
	});
	
	var marker = new naver.maps.Marker({
		position : BusanMy,
		map:map
	});
	
</script>
</body>
</html>