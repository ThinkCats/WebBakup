/**
 * Created by juepei on 2015/10/16.
 */



function loadUser(paraName,paraData,pageNum,pageLength){
    if(!pageNum){
        pageNum = 1;
    }
    if(!pageLength){
        pageLength = 10;
    }
    var json = {};
    json[paraName] = paraData;
    json["pageNum"] = pageNum;
    json["pageLength"] = pageLength;
    $.ajax({
        url:"/user/page",
        data:json,
        type:"post",
        dataType:"json",
        success:function(data){
            console.log('user page:',data);
        },
        error:function(data){
            console.log('error :',data);
        }
    });
}