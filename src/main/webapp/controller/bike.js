app.controller('bikeCtrl',['$http',function($http){
    var bike = this;
    bike.products = [];
    $http.get('./webapi/bike').success(function(data){
        bike.products = data;
    });
}]);