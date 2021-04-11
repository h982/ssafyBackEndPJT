$(document).ready(function() {
	// 도 / 시 선택
	$("#sel1").on("change", function() {
		sel1 = this.value;
		
		$.ajax({
            url: './res/addr.xml',
            type: 'GET',
            dataType: 'xml',
            global: false,
            success: function (response) {
              makeSel2List(response);
            },
            error: function (xhr, status, msg) {
              console.log('상태값 : ' + status + ' Http에러메시지 : ' + msg);
            }
        });
	});
	
	// 군 / 구 선택
	$("#sel2").on("change", function() {
		sel2 = this.value;
		
		$.ajax({
            url: './res/addr.xml',
            type: 'GET',
            dataType: 'xml',
            global: false,
            success: function (response) {
              makeSel3List(response);
            },
            error: function (xhr, status, msg) {
              console.log('상태값 : ' + status + ' Http에러메시지 : ' + msg);
            }
        });
	});
	
	// 읍 면 리 동 선택
	$("#sel3").on("change", function() {
		sel3 = this.value;
	});
	

});

//도 / 시
var sel1 = "";
// 군 / 구
var sel2 = "";
// 읍 / 면 / 리  / 동 / 로 / 가
var sel3 = "";

//도 / 시를 선택하면 보일 군 / 구 를 생성
function makeSel2List(data) {
	if (sel1 == "") {
		sel1 = "";
		sel2 = "";
		$('#sel2').empty();
		$("#sel2").append("<option>-</option>");
		sel3 = "";
		$('#sel3').empty();
		$("#sel3").append("<option>-</option>");
		return;
	}
	
	var selList = new Set();
	
	$('#sel2').empty();
	$("#sel2").append("<option>-</option>");
	
	var arr = ["군", "구"];
	$(data).find("item").each(function(index, item) {
		if ($(this).find("도").text().indexOf(sel1) > -1 || $(this).find("시").text().indexOf(sel1) > -1) {
			var temp = "";
			var cur = $(this);
			
			$.each(arr, function(idx, it) {
				if (cur.find(arr[idx]).text().length > 1) {
					if (temp.length > 1) {
    					temp += " ";
    				}
    				
    				temp += cur.find(it).text();
				}
			});
			
			if (temp.length > 1) {
				selList.add(temp);
			}
		}
	});
	
	for (var selVal of selList) {
		$("#sel2").append(`<option>${selVal}</option>`);
	}
}

//군 / 구를 선택하면 읍 면 리 동을 생성
function makeSel3List(data) {
	if (sel2 == "") {
		sel2 = "";
		sel3 = "";
		$('#sel3').empty();
		$("#sel3").append("<option>-</option>");
		return;
	}
	var studentList = ``;
	var selList = new Set();
	
	$('#sel3').empty();
	$("#sel3").append("<option>-</option>");
	
	var arr = ["읍", "면", "리", "동", "로", "가"];
	$(data).find("item").each(function(index, item) {
		if ($(this).find("도").text().indexOf(sel1) > -1 || $(this).find("시").text().indexOf(sel1) > -1) {
			if ($(this).find("군").text().indexOf(sel2) > -1 || $(this).find("구").text().indexOf(sel2) > -1) {
				var temp = "";
				var cur = $(this);
				
				$.each(arr, function(idx, it) {
					if (cur.find(arr[idx]).text().length > 1) {
						if (temp.length > 1) {
							temp += " ";
						}
						
						temp += cur.find(it).text();
					}
				});
				
				if (temp.length > 1) {
					selList.add(temp);
				}
			}
		}
	});
	
	for (var selVal of selList) {
		$("#sel3").append(`<option>${selVal}</option>`);
	}
}