/**
 * Created by Jigar on 7/17/2016.
 */
app.factory(
    'mpiService', function () {
        var selectedBike;
        var selectedUser;

        return {
            setSelectedBike : function (passedBike) {
                selectedBike = passedBike;
            },

            getSelectedBike : function (){
                return selectedBike;
            },

            setSelectedUser : function (passedUser) {
                selectedUser = passedUser;
            },

            getSelectedUser : function (){
                return selectedUser;
            }

        };

    }
);