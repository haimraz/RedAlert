'use strict';

missilesShobApp.controller('FallCtl', ['$scope', '$http', function ($scope, $http) {
    $scope.citiesIds = [];
    $scope.addedCitiesIds = [];
    $scope.notificationTitle = "";

    $http.get(ip + '/cities').success(function (data, status, headers, config) {
        alertify.success("Load falls success", 5);
        $scope.citiesIds = Object.keys(data);
        $scope.newCityId = $scope.citiesIds[200];
        $scope.cities = data;
    }).error(function (error) {
        alertify.error("Load falls failed", 5);
    });

    $scope.sendNotification = function () {

        var addedCities = angular.copy($scope.addedCitiesIds);
        var title = angular.copy($scope.notificationTitle);
        var request = {
            cities: addedCities,
            title: title
        };
        $http.post(ip + '/sendNotification', request).
        success(function (data, status, headers, config) {
            $scope.addedCitiesIds = [];
            $scope.notificationTitle = "";
            alertify.success("send new fall success", 5);
        }).error(function (error) {
            alertify.error("send new fall failed", 5);
        });
    }
 }]);