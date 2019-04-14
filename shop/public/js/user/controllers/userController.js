userModule.controller('userCtrl', $scope => {
    $scope.doRegister = () => {
        console.log(`Userid is ${$scope.userid}, and password is ${$scope.password}`);
    }
})