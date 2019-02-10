app.directive("myDirective",function(){
    return{
        restrict:"EACM",
        replace: true,
        template: "<h1>I am a custom directive</h1>"
    }
});
/*app.directive("secondDirective",function(){
    return{
        template: "Second directive"
    }
})*/
