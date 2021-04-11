let map;
function initMap() {
	map = new google.maps.Map(document.getElementById("map"), {
		center : {
			lat : 37.5013068,
			lng : 127.037471
		},
		zoom : 11.5
	});
}

