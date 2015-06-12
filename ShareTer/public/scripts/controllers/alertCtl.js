'use strict';
var map;
var infowindow = null;
missilesShobApp.controller('alertCtl', ['$scope', '$http', function ($scope, $http) {
    $scope.alert = new Object();
    $scope.alerts = [];
    $scope.addalert = function () {
        $scope.alert = new Object();
        $http.post(ip + '/addalert', angular.toJson($scope.alert))
        success(function (data, status, headers, config) {
            alertify.success("add new alert success", 5);
            var alertCopy = angular.copy($scope.alert)
            $scope.shelters.push(alertCopy);
            $scope.alert = new Object();
        }).error(function (error) {
            alertify.error("send new alert failed", 5);
        });
    }

    
    $http.get('/alerts').success(function (data, status, headers, config) {
        alertify.success("Load alerts success", 5);
        $scope.alerts = data.alerts;
    }).error(function (error) {
        alertify.error("Load alerts failed", 5);
    });
 }]);