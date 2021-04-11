function moveMap(parmLat, parmLng) {
	//중심 위치를 클릭된 마커의 위치로 변경
	map.setCenter({lat : parmLat, lng : parmLng});
	
	map.setZoom(17);
}

var param = get_query();

//마커 생성
var marker;

var map;
function initMap() {
	$.ajax({
		url: 'https://maps.googleapis.com/maps/api/geocode/json?address='+ param["val1"] 
	+ "+" + param["val2"] + "+" +  param["val3"] + '&key=AIzaSyCz3QVtVvXhroXoNau5LoNUz2-fybgByws',
	type: 'GET',
	dataType: 'json',
	global: false,
	success: function (response) {
		var loc = {};
		loc["lat"] = response.results[0].geometry.location.lat;
		loc["lng"] = response.results[0].geometry.location.lng;
		map = new google.maps.Map(document.getElementById("map"), { 
			center: { 
				lat : loc.lat,
				lng : loc.lng
			},
			zoom: 16
		});
			
		$.ajax({
			url: './res/AptDealHistory.xml',
			type: 'GET',
			dataType: 'xml',
			success: function (res) {
				getData(res, function() {
					
					
					$(".main-section").slideDown(500);
				});
			},
			error: function (xhr, status, msg) {
				console.log('상태값 : ' + status + ' Http에러메시지 : ' + msg);
			}			
		});	
	},
	error: function (xhr, status, msg) {
		console.log('상태값 : ' + status + ' Http에러메시지 : ' + msg);
	}			
	});
}

// 주소의 parameter를 객체로 바꾸어 반환
function get_query(){
	var url = document.location.href;
	var qs = url.substring(url.indexOf('?') + 1).split('&');
	for(var i = 0, result = {}; i < qs.length; i++){
		qs[i] = qs[i].split('=');
		result[qs[i][0]] = decodeURIComponent(qs[i][1]);
	}
	return result;
}



function getData(data, func) {
	var uniqueName = new Set();
	var infoList = {};
	var idx = 0;
	
	$(data).find("item").each(function(index, item) {
		var dong = $(this).find("법정동").text();
		if (dong.indexOf(param["val3"]) > -1) {
			var info = {};
			var date = $(this).find("년").text() + ". " +
			$(this).find("월").text() + ". " +
			$(this).find("일").text();
			
			info["name"] = $(this).find("아파트").text();
			info["price"] = $(this).find("거래금액").text();
			info["dong"] = dong;
			info["area"] = $(this).find("전용면적").text();
			info["type"] = "아파트 매매";
			info["date"] = date;
			
			infoList[idx++] = info;
			uniqueName.add(info["name"]);
		}
	});
	
	//인포윈도우
	var infowindow = new google.maps.InfoWindow();

	for (var name of uniqueName) {
		$(".aside").append(`<a href="javascript:void(0);" class="apt_name pb-2"><h5>${name}</h5></a>`);
		
		(function(n) {
			$.ajax({
				url: 'https://maps.googleapis.com/maps/api/geocode/json?address='+ param["val1"] 
			+ "+" + param["val2"] + "+" + n + "+" + param["val3"] + '&key=AIzaSyCz3QVtVvXhroXoNau5LoNUz2-fybgByws',
			type: 'GET',
			dataType: 'json',
			success: function (data) {
				var pos = { lat: data.results[0].geometry.location.lat ,lng: data.results[0].geometry.location.lng };
				$(".apt_name").each(function(index, item) {
					if ($(this).children("h5").text() == n) {
						$(this).attr("href", `javascript:moveMap(${pos.lat}, ${pos.lng})`);
					}
				});

					marker = new google.maps.Marker({
				    position: pos,
				    map: map,
				    label: n
				  });
				google.maps.event.addListener(marker, 'click', (function(marker, i) {
					return function() {
						
						//html로 표시될 인포 윈도우의 내용
						infowindow.setContent(n);
						
						//인포윈도우가 표시될 위치
						infowindow.open(map, marker);
					}
				})(marker));
				
				if (marker) {
					marker.addListener('click', function() {
						
						//중심 위치를 클릭된 마커의 위치로 변경
						map.setCenter(this.getPosition());
						
						//마커 클릭 시의 줌 변화
						map.setZoom(14);
						
						var cur_n = infowindow.getContent(n);
						$(".aside").empty();
						$(".aside").append(`<h5 class="deal-info-all border-bottom pb-2">${n}</h5>`);
						
						$.each(infoList, function(index, item) {
							if (item.name == cur_n) {
								var div = `<div class="media margin-clear">
								<div class="media-body">
								<h6 class="media-heading">거래금액 : ${item.price}</h6>
								<h6 class="media-heading">전용면적 : ${item.area}</h6>
								<h6 class="media-heading">거래구분 : ${item.type}</h6>
								<p class="small my-3">
								<i class="fa fa-calendar pr-10">
								</i><span class="ml-2">${item.date}</span>
								</p>
								<hr>
								</div>
								</div>
									`;
								
								$(".aside").append(div);
							}
						});
						
						
					});
				}
			},
			error: function (xhr, status, msg) {
				console.log('상태값 : ' + status + ' Http에러메시지 : ' + msg);
			}			
			});
		})(name)
	}
	
	
	func();
}
