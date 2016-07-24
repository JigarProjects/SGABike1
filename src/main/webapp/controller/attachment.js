/**
 * Created by Jigar on 7/16/2016.
 */
app.controller('attachmentCtrl',['$http','$scope', '$uibModal','mpiService', function ($http, $scope, $uibModal, mpiService){

    //for search all attachments
    $scope.searchAttachments = function(){
        $http.get('./webapi/attachment').success(function (data) {
            $scope.foundAttachments = data;
            console.log("Found attached data "+$scope.foundAttachments+":");
        });
    };

    $scope.searchAttachments();

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
        angular.forEach($scope.selected, function(deleteAttachment){
            $http.delete('./webapi/attachment/'+deleteAttachment);
        });
        //location.reload();
    };
}
]);


app.controller('createAttachmentCtrl', ['$http','$scope','$uibModal','mpiService',function ($http,$scope, $uibModal,mpiService) {

    $scope.attachment = {};
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
        $scope.attachment.userID = mpiService.getSelectedUser();
        $scope.attachment.bikeID = mpiService.getSelectedBike();
        $http.post('./webapi/attachment', $scope.attachment);
    };

}]);