'use strict';
var map;
var infowindow = null;
missilesShobApp.controller('ShelterCtl', ['$scope', '$http', function ($scope, $http) {
    $scope.shelter = new Object();
    $scope.shelters = [];
    $scope.addShelter = function () {
          var shelterCopy = angular.copy($scope.shelter)
            $scope.shelters.push(shelterCopy);
            var latlng = new google.maps.LatLng(shelterCopy.x,shelterCopy.y);
            var marker = new google.maps.Marker({
                position: latlng,
                map: map,
                animation: google.maps.Animation.DROP,
                title: shelterCopy.name
            });
         var infowindow = new google.maps.InfoWindow({
            content: contentString
        });
         google.maps.event.addListener(marker, 'click', function() {
            infowindow.open(map,marker);
        });
        $http.post(ip + '/addShelter', angular.toJson($scope.shelter))
        success(function (data, status, headers, config) {
            alertify.success("add new shelter success", 5);
            var shelterCopy = angular.copy($scope.shelter)
            $scope.shelters.push(shelterCopy);
            var latlng = new google.maps.LatLng(shelterCopy.x,shelterCopy.y);
            var marker = new google.maps.Marker({
                position: latlng,
                map: map,
                animation: google.maps.Animation.DROP,
                title: shelterCopy.name
            });
            $scope.shelter = new Object();
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
        map = new google.maps.Map(document.getElementById('shelMap'), mapOptions);
        google.maps.event.addDomListener(window, 'load', $scope.initMap);
    }
        $scope.initMap();
        google.maps.event.addListener(map, "rightclick", function (event) {
            var lat = event.latLng.lat();
            var lng = event.latLng.lng();
            $scope.shelter.x = lat;
            $scope.shelter.y = lng;
            $scope.$apply();
        });


    //addListener();
    $http.get(ip + '/shelters').success(function (data, status, headers, config) {
        alertify.success("Load shelters success", 5);
        $scope.shelters = data.shelters;
    }).error(function (error) {
        alertify.error("Load shelters failed", 5);
    });
 }]);