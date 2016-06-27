/**
 * Created by Jigar on 4/9/2016.
 */
var app = angular.module('bike',['ngRoute']);

app.config(
    function($routeProvider){
        $routeProvider
            .when('/bike', {
                templateUrl : 'mainhtml/bike.html',
                controller: 'bikeCtrl'
            })
            .when('/user',{
                templateUrl : 'mainhtml/users.html'
            })
            .when('/create',{
                templateUrl : 'mainhtml/CreateBike.html'
            })
            .otherwise( {
                redirectTo:'/index.html'
            });
    }
);



