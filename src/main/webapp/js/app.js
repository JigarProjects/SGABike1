/**
 * Created by Jigar on 4/9/2016.
 */
var app = angular.module('bike',['ngRoute']);

/*app.config(['$routeProvider','$locationProvider', function ($routeProvider,$locationProvider) {
        $routeProvider
            .when('bike', {templaeUrl:'./mainhtml/bike.html'})
            .when('user', {templaeUrl:'./mainhtml/user.html'})
            .otherwise( {redirectTo:'/index.html'});
        $locationProvider.html5Mode(true);
        //$locationProvider.html5mode({enabled:true, requireBase:false});
    }]);*/
app.config(
    function($routeProvider){
        $routeProvider
            .when('/bike', {
                templateUrl : 'mainhtml/bike.html'
            })
            .when('/user',{
                templateUrl : 'mainhtml/users.html'
            })
            .otherwise( {
                redirectTo:'/index.html'
            });
    }
);

app.controller('bikeCtrl',['$http',function($http){
    var bike = this;
    bike.products = [];
    $http.get('../webapi/bike').success(function(data){
        bike.products = data;
    });
}]);

