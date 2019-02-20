app.filter("ngCase", function(){
            return function(x){
                var newText = "";
                for(let i=0; i<x.length; i++){
                    let char = x[i];
                    if(i%2 == 0){
                        char = char.toUpperCase();
                    }
                    else{
                        char = char.toLowerCase();
                    }
                    newText += char;
                }
                return newText;
            }
        })
