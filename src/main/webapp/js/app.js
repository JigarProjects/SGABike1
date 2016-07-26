/**
 * Created by Jigar on 4/9/2016.
 */
var app = angular.module('bike', ['ngRoute','ngAnimate', 'ui.bootstrap']);
app.config(
    function ($routeProvider) {
        $routeProvider
            .when('/bike', {
                templateUrl: 'mainhtml/bike.html',
                controller: 'bikeCtrl'
            })
            .when('/user', {
                templateUrl: 'mainhtml/Users.html',
                controller: 'userCtrl'
            })
            .when('/allocate', {
                templateUrl: 'mainhtml/ListAttachment.html',
                controller: 'attachmentCtrl'
            })
            .when('/attachallocate', {
                templateUrl: 'mainhtml/CreateAttachment.html',
                controller: 'attachmentCtrl'
            })
            .otherwise({
                redirectTo: 'mainhtml/CreateAttachment.html'
            });
    }
);



