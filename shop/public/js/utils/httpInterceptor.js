app.factory('authInterceptor', () => {
    return{
        request : function(config){ //config or clone is a duplicate of request object
            console.log('Interceptor called');
            config.headers['auth-token'] = localStorage.tokenid;
            return config;
        },
        requestError : function(config){
            return config;
        },
        response: function(res){
            return res;
        },
        responseError: function(res){
            return res;
        }
    }
})