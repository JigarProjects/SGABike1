app.controller('bikeCtrl', ['$http','$scope', '$uibModal', function ($http, $scope, $uibModal) {
    var self = this;
    self.bikes = [];

    /*Fetches list of bikes*/
    $http.get('./webapi/bike').success(function (data) {
        self.bikes = data;
    });
    /*create bikes */
    $scope.open = function () {
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'mainhtml/createbike.html',
            controller: 'ModalInstanceCtrl',
            size:'lg'
        });
    };

    $scope.user = {
        bikes: []
    };


    $scope.delete = function(){
        console.log("in delete"+$scope.user.bikes+":");
        angular.forEach($scope.user.bikes, function(singlebike){
            $http.delete('./webapi/bike', singlebike);
        });
    };


}]);



app.controller('ModalInstanceCtrl', ['$http','$scope','$uibModalInstance',function ($http,$scope, $uibModalInstance) {
    var self = this;

    $scope.submit = function () {
        $http.post('./webapi/bike', $scope.bike);
        $uibModalInstance.close();
    }

}]);