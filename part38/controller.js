app.controller('myCtrl',function($scope){
    $scope.firstname = "John";
    $scope.lastname = "Smith";
    $scope.changeName = function(){
        $scope.firstname = "Emily";
    }
    $scope.arr = ["Mike", "John" ,"Emily"]
    /*$scope.persons = [
        {name:"John", country:"Norway"},
        {name:"Emily", country:"Sweden"},
        {name:"Mike", country:"Finland"}
    ]*/
})
