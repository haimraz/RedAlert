'use strict';
var ip = "localhost";
var missilesShobApp = angular.module('missilesShobApp', ['ngRoute', 'ngMap'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'html/views/Team.html',
                controller: 'TeamCtl'
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
             .when('/Alerts', {
                templateUrl: 'html/views/alert.html',
                controller: 'AlertCtl'
            })
            .otherwise({
                redirectTo: '/'
            });
});