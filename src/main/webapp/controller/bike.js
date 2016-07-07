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

    $scope.selected =[];
    $scope.toggle = function (item, list) {
        var idx = list.indexOf(item);
        if (idx > -1) {
            //at this position remove item
            list.splice(idx, 1);
        }
        else {
            list.push(item);
        }
        console.log("toggle call call "+$scope.selected);
    };

    $scope.exists = function (item, list) {
        //is it in the list?
        console.log("exists call "+$scope.selected);
        return list.indexOf(item) > -1;
    };

    $scope.delete = function(){
        console.log("in delete "+$scope.selected+":");
        angular.forEach($scope.selected, function(deletebike){
            $http.delete('./webapi/bike/'+deletebike);
        });
        location.reload();
    };


}]);



app.controller('ModalInstanceCtrl', ['$http','$scope','$uibModalInstance',function ($http,$scope, $uibModalInstance) {
    var self = this;

    $scope.submit = function () {
        $http.post('./webapi/bike', $scope.bike);
        $uibModalInstance.close();
    }

}]);