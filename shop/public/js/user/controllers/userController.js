userModule.controller('userCtrl', ($scope, userFactory, SUCCESS, $window) => {
    $scope.user = {};
    $scope.data = {};
    $scope.err = {};
    $scope.doRegister = () => {
        //console.log(`Userid is ${$scope.userid}, and password is ${$scope.password}`);
        const promise = userFactory.register($scope.user);
        promise.then(data => {
            $scope.data = data;
        }, err => {
            $scope.err = err;
        })
    }
    $scope.doLogin = () => {
        const promise = userFactory.login($scope.user);
        promise.then( data => {
            console.log(data);
            if(data.data.status == SUCCESS){
                $window.location.href = '/dashboard.html';
            }
            else{
                $scope.data = data;
            }
        }, err => {
            $scope.err = err;
        })
    }
})