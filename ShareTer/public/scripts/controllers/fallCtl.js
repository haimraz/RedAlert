'use strict';
var map;
var infowindow = null;
missilesShobApp.controller('FallCtl', ['$scope', '$http', function ($scope, $http) {
    $scope.fall = new Object();
    $scope.falls = [];
    $scope.addFall = function () {
         var fallCopy = angular.copy($scope.fall)
            $scope.falls.push(fallCopy);
            var latlng = new google.maps.LatLng(fallCopy.x,fallCopy.y);
            var marker = new google.maps.Marker({
                position: latlng,
                map: map,
                animation: google.maps.Animation.DROP,
                title: fallCopy.name
            });
              var infowindow = new google.maps.InfoWindow({
                 content: '<h4>' + fallCopy.name + '</h4>'
            });
            google.maps.event.addListener(marker, 'click', function() {
                infowindow.open(map,marker);
            });
            $scope.fall = new Object();
        $http.post(ip + '/addFall', angular.toJson($scope.fall))
        success(function (data, status, headers, config) {
            alertify.success("add new shelter success", 5);
            var fallCopy = angular.copy($scope.fall)
            $scope.shelters.push(fallCopy);
            var latlng = new google.maps.LatLng(fallCopy.x,fallCopy.y);
            var marker = new google.maps.Marker({
                position: latlng,
                map: map,
                animation: google.maps.Animation.DROP,
                title: fallCopy.name
            });
              var infowindow = new google.maps.InfoWindow({
                 content: '<h4>' + fallCopy.name + '</h4>'
            });
            google.maps.event.addListener(marker, 'click', function() {
                infowindow.open(map,marker);
            });
            $scope.fall = new Object();
        }).error(function (error) {
            alertify.error("send new shelter failed", 5);
        });
    }

    $scope.initMap = function () {
        var mapOptions = {
            center: {
                lat: 32.0698,
                lng: 34.793
            },
            zoom: 8
        };
        map = new google.maps.Map(document.getElementById('fallMap'), mapOptions);
        google.maps.event.addDomListener(window, 'load', $scope.initMap);
    }
        $scope.initMap();
        google.maps.event.addListener(map, "rightclick", function (event) {
            var lat = event.latLng.lat();
            var lng = event.latLng.lng();
            $scope.fall.x = lat;
            $scope.fall.y = lng;
            $scope.$apply();
        });

    
    $http.get('/falls').success(function (data, status, headers, config) {
        alertify.success("Load falls success", 5);
        $scope.falls = data.falls;
    }).error(function (error) {
        alertify.error("Load falls failed", 5);
    });
 }]);