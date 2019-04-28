const dashboardModule = angular.module('dashboardModule', ['app']);
dashboardModule.constant('DASHBOARD_URL', 'http://localhost:3000/dashboard');
dashboardModule.run( ($http, DASHBOARD_URL, $window) => {
    $http.get(DASHBOARD_URL).then( data => {
        if(data.data.status == 'E'){
            $window.location.href = '/login.html';
        }
    }, err => {
        $window.location.href = '/login.html';
    })
})