/**
 * Created by Jigar on 4/9/2016.
 */
var app = angular.module('bike', ['ngRoute','ngAnimate', 'ui.bootstrap','checklist-model']);

app.config(
    function ($routeProvider) {
        $routeProvider
            .when('/bike', {
                templateUrl: 'mainhtml/bike.html',
                controller: 'bikeCtrl'
            })
            .when('/user', {
                templateUrl: 'mainhtml/users.html'
            })
            .when('/create', {
                templateUrl: 'mainhtml/createbike.html'
            })
            .otherwise({
                redirectTo: '/index.html'
            });
    }
);



