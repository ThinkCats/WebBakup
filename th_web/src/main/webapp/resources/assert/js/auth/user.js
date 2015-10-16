/**
 * Created by juepei on 2015/10/16.
 */

$(document).ready(function(){

});

function loadUser(){
    var pageNum =
    $.ajax({
        url:"",
        data:{
            "pageNum":"",
            "limit":""
        },
        type:"post",
        dataType:"json",
        success:function(data){

        }
    });
}