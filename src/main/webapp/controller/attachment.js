/**
 * Created by Jigar on 7/16/2016.
 */
app.controller('attachmentCtrl',['$http','$scope', '$uibModal','mpiService', function ($http, $scope, $uibModal, mpiService){
    
    $scope.searchBike = function () {
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'mainhtml/searchBike.html',
            controller: 'bikeCtrl',
            size:'lg'
        });
    };
    $scope.searchUser = function () {
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'mainhtml/searchUser.html',
            controller: 'SearchUserCtrl',
            size:'lg'
        });
    };
    $scope.attachBike = function () {
        console.log("from attachment service class "+mpiService.getSelectedBike());
        console.log("from attachment service class "+mpiService.getSelectedUser());
    }
}
]);

//LIST SPECIFIC USER
app.controller('SearchUserCtrl', ['$http','$scope','$uibModalInstance',function ($http,$scope, $uibModalInstance) {

    $scope.submit = function () {

        $http.post('./webapi/users/', $scope.bike);
        $uibModalInstance.close();
    }

}]);