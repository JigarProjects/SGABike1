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

    //date-picker begins
    $scope.today = function() {
        $scope.start = new Date();
        $scope.end = new Date();
    };

    $scope.today();

    $scope.clear = function() {
        $scope.start = null;
        $scope.end = null;
    };

    $scope.inlineOptions = {
        customClass: getDayClass,
        minDate: new Date(),
        showWeeks: true
    };

    $scope.dateOptions = {
        dateDisabled: disabled,
        formatYear: 'yy',
        maxDate: new Date(2020, 5, 22),
        // minDate: new Date(),
        startingDay: 1
    };

    // Disable weekend selection
    function disabled(data) {
        // var date = data.date,
        // mode = data.mode;
        // return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
    }

    $scope.toggleMin = function() {
        $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
        $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
    };

    $scope.startDate = function() {
        $scope.popup1.opened = true;
    };

    $scope.endDate = function() {
        $scope.popup2.opened = true;
    };

    $scope.setDate = function(year, month, day) {
        $scope.start = new Date(year, month, day);
        $scope.end = new Date(year, month, day);
    };

    $scope.format = 'EEEE, MMMM, d, y';

    $scope.altInputFormats = ['M!/d!/yyyy'];

    $scope.popup1 = {
        opened: false
    };

    $scope.popup2 = {
        opened: false
    };

    var tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);

    var afterTomorrow = new Date();
    afterTomorrow.setDate(tomorrow.getDate() + 1);

    $scope.events = [
        {
            date: tomorrow,
            status: 'full'
        },
        {
            date: afterTomorrow,
            status: 'partially'
        }
    ];

    function getDayClass(data) {
        var date = data.date,
            mode = data.mode;
        if (mode === 'day') {
            var dayToCheck = new Date(date).setHours(0,0,0,0);
            for (var i = 0; i < $scope.events.length; i++) {
                var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);
                if (dayToCheck === currentDay) {
                    return $scope.events[i].status;
                }
            }
        }
        return '';
    }
    //date-picker ends

    /*$scope.startTime = new Date();
     $scope.endTime = new Date();*/

    $scope.hstep = 1;
    $scope.mstep = 5;

    $scope.options = {
        hstep: [1, 2, 3],
        mstep: [1, 5, 10, 15, 25, 30]
    };

    $scope.ismeridian = true;
    $scope.toggleMode = function() {
        $scope.ismeridian = ! $scope.ismeridian;
    };

    $scope.alertUpdate = function() {
        console.log("Start Time: " + $scope.start);
        console.log("End Time: " + $scope.end);
    };

    $scope.clear = function() {
        scope.start = null;
        $scope.end = null;
    };

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