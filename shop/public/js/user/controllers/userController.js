userModule.controller('userCtrl', ($scope, userFactory) => {
    $scope.user = {};
    $scope.doRegister = () => {
        //console.log(`Userid is ${$scope.userid}, and password is ${$scope.password}`);
        const promise = userFactory.register($scope.user);
        promise.then(data => {
            $scope.data = data;
        }, err => {
            $scope.err = err;
        })
    }
})