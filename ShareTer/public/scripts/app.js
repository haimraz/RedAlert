'use strict';
var ip = "localhost";
var missilesShobApp = angular.module('missilesShobApp', ['ngRoute', 'ngMap'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'html/views/main.html',
                controller: 'MainCtrl'
            })
            .when('/Shelters', {
                templateUrl: 'html/views/shelters.html',
                controller: 'ShelterCtl'
            })
           .when('/Falls', {
                templateUrl: 'html/views/falls.html',
                controller: 'FallCtl'
            })
            .when('/Team', {
                templateUrl: 'html/views/team.html',
                controller: 'TeamCtl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });