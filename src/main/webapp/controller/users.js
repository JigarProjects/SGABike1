/**
 * Created by Jigar on 7/10/2016.
 */
app.controller('userCtrl', ['$http','$scope', '$uibModal','mpiService', function ($http, $scope, $uibModal) {
    var self = this;
    $scope.users = [];

    $http.get('./webapi/users').success(function (data) {
        $scope.users = data;
    });

    $scope.open = function () {
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'mainhtml/CreateUser.html',
            controller: 'createUserCtrl',
            size:'lg'
        });
    };

    $scope.update = function(userToUpdate){
        var modalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'mainhtml/UpdateUser.html',
            controller: 'UpdateUserCtrl',
            size:'lg',
            resolve: {
                editUser: function () {
                    return userToUpdate;
                }
            }
        });
    };

    $scope.selected =[];
    $scope.toggle = function (item, list) {
        var idx = list.indexOf(item);
        if (idx > -1) {
            list.splice(idx, 1);
        }
        else {
            list.push(item);
        }
        console.log("toggle call call "+$scope.selected);
    };

    $scope.exists = function (item, list) {
        return list.indexOf(item) > -1;
    };

    $scope.delete = function(){
        console.log("in delete "+$scope.selected+":");
        angular.forEach($scope.selected, function(deleteuser){
            $http.delete('./webapi/users/'+deleteuser);
        });
        location.reload();
    };

}]);



app.controller('createUserCtrl', ['$http','$scope','$uibModalInstance',function ($http,$scope, $uibModalInstance) {

    $scope.submit = function () {
        $http.post('./webapi/users', $scope.user);
        $uibModalInstance.close();
    }

}]);

app.controller('UpdateUserCtrl', ['$http','$scope','$uibModalInstance','editUser',function ($http,$scope, $uibModalInstance, editUser) {

    $scope.edituser = editUser;
    $scope.update = function () {
        $http.put('./webapi/users/'+editUser.id, $scope.edituser);
        $uibModalInstance.close();
    }

}]);

app.controller('SearchUserCtrl',['$http','$scope','$uibModalInstance','mpiService',function ($http,$scope, $uibModalInstance,mpiService){

    $scope.searchUser = function(){
        $http.get('./webapi/users/'+$scope.userId).success(function (userToAttach) {
            console.log("in selection "+userToAttach.userid+":");
            mpiService.setSelectedUser( userToAttach.id );
        });
    }
}]);