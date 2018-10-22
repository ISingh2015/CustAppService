function initialize() {
    var mapOptions = {
        center: new google.maps.LatLng(19.109827, 73.002925),
        zoom: 13,
        mapTypeId: google.maps.MapTypeId.HYBRID,
        scrollwheel: false,
        draggable: false,
        panControl: true,
        zoomControl: true,
        mapTypeControl: true,
        scaleControl: true,
        streetViewControl: true,
        overviewMapControl: true,
        rotateControl: true
    };
    var map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
    var marker = new google.maps.Marker({position: new google.maps.LatLng(19.109827, 73.002925)});
    marker.setMap(map);
}
google.maps.event.addDomListener(window, 'load', initialize);