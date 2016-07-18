/**
 * Created by Jigar on 7/16/2016.
 */
app.controller('attachmentCtrl',['$http','$scope', '$uibModal', function ($http, $scope, $uibModal){
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
}
]);
/*
//LIST ALL THE USERS
app.controller('SearchBikeCtrl', ['$http','$scope','$uibModalInstance',function ($http,$scope, $uibModalInstance) {

    $scope.submit = function () {
        $http.post('./webapi/bike', $scope.bike);
        $uibModalInstance.close();
    }

}]);*/

//LIST SPECIFIC USER
app.controller('SearchUserCtrl', ['$http','$scope','$uibModalInstance',function ($http,$scope, $uibModalInstance) {

    $scope.submit = function () {
        $http.post('./webapi/users/', $scope.bike);
        $uibModalInstance.close();
    }

}]);