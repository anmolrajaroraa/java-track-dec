//$(document).ready(function(){
    $(function(){
        $(":button").dblclick(function(){
            //$(this).hide();
            //$("p").hide();
            //$("h1.first").hide();
            //$("#first").hide();
            $("*").hide();
            //$("p:first").hide();
            //$("ul li:first").hide();
            //$("ul li:first-child").hide();
            //$("[href]").hide();
            //$("a[target!='_blank']").hide();
            //$("tr:even").hide();
        });

        $("p").mouseup(function(){
            alert("You exited from some paragraph");
        });
        
        $("p").hover(function(){
            $(this).css("background-color","yellow");
        },function(){
            $(this).css("background-color","white");
        });
        
        /*$("input").focus(function(){
            $(this).css("background-color","#ddd");
        });
        $("input").blur(function(){
            $(this).css("background-color","white");
        });*/
        
        $("p").on("click",function(){
            $(this).hide();
        });

        $("input").on({
            mouseenter : function(){
                $(this).css("background-color","#ddd")
            },
            mouseleave : function(){
                $(this).css("background-color","#1bde32");
            },
            focus : function(){
                $(this).css("border","5px yellow solid");
            }
        })

    })
