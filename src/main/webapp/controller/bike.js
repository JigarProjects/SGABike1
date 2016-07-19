app.controller('bikeCtrl', ['$http','$scope', '$uibModal','mpiService', function ($http, $scope, $uibModal,mpiService) {
    
    $scope.bikes = [];
    //THis controller has variable selectedBike coming from searchBike.html

    /*Fetches list of bikes*/
    $http.get('./webapi/bike').success(function (data) {
        $scope.bikes = data;
    });
    /*create bikes */
    $scope.open = function () {
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'mainhtml/CreateBike.html',
            controller: 'CreateBikeCtrl',
            size:'lg'
        });
    };

    $scope.update = function(bikeToUpdate){
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'mainhtml/UpdateBike.html',
            controller: 'UpdateBikeCtrl',
            size:'lg',
            resolve: {
                editBike: function () {
                    return bikeToUpdate;
                }
            }
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
        //console.log("exists call "+$scope.selected);
        return list.indexOf(item) > -1;
    };

    $scope.delete = function(){
        console.log("in delete "+$scope.selected+":");
        angular.forEach($scope.selected, function(deletebike){
            $http.delete('./webapi/bike/'+deletebike);
        });
        location.reload();
    };

    $scope.selectedbike = function(){
        //pass this bike to attachment controller
        mpiService.setSelectedBike( $scope.searchedBike );
        console.log("in selection "+$scope.searchedBike+":");
    };
}]);



app.controller('CreateBikeCtrl', ['$http','$scope','$uibModalInstance',function ($http,$scope, $uibModalInstance) {

    $scope.submit = function () {
        $http.post('./webapi/bike', $scope.bike);
        $uibModalInstance.close();
    }

}]);

app.controller('UpdateBikeCtrl', ['$http','$scope','$uibModalInstance','editBike',function ($http,$scope, $uibModalInstance, editBike) {

    $scope.editbike = editBike;
    $scope.update = function () {
        $http.put('./webapi/bike/'+editBike.id, $scope.editbike);
        $uibModalInstance.close();
    }

}]);