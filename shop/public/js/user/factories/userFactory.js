userModule.factory('userFactory', ($http, $q, REGISTER_URL, LOGIN_URL) => {
    return{
        register(userObject){
            let defer = $q.defer();
            $http.post(REGISTER_URL, userObject).then(data => {
                defer.resolve(data);
            }, err => {
                defer.reject(err);
            })
            return defer.promise;
        },
        login(userObject){
            let defer = $q.defer();
            $http.post(LOGIN_URL,userObject).then( data => {
                defer.resolve(data);
            }, err => {
                defer.reject(err);
            });
            return defer.promise;
        }
    }
})