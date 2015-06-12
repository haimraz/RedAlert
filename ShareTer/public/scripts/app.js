'use strict';
var ip = "10.0.0.1";
var missilesShobApp = angular.module('missilesShobApp', ['ngRoute', 'ngMap'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/main.html',
                controller: 'MainCtrl'
            })
            .when('/Shelters', {
                templateUrl: 'views/shelters.html',
                controller: 'ShelterCtl'
            })
           .when('/Falls', {
                templateUrl: 'views/falls.html',
                controller: 'FallCtl'
            })
            .when('/Team', {
                templateUrl: 'views/team.html',
                controller: 'TeamCtl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });