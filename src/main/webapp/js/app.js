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
            /*.when('/create', {
                templateUrl: 'mainhtml/createbike.html'
            })*/
            .when('/allocate', {
                templateUrl: 'mainhtml/AttachBike.html',
                controller: 'attachmentCtrl'
            })
            .otherwise({
                redirectTo: 'mainhtml/AttachBike.html'
            });
    }
);



