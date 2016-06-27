app.controller('bikeCtrl',['$http',function($http){
    var self = this;
    self.products = [];
    $http.get('./webapi/bike').success(function(data){
        self.products = data;
    });
}]);

app.controller('bikeCreateCtrl',['$http',function($http){
    var self = this;
    self.bike = {};
    self.submit =  function(){
        $http.post('./webapi/bike',self.bike)
            ;
    }
} ] );