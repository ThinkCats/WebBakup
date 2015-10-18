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
        beforeSend:function(){
            $('#loading').show();
        },
        success:function(data){
            console.log('user page:',data);
            setPageData(data,paraName,paraData);
            $('#loading').hide();
        },
        error:function(data){
            console.log('error :',data);
            $('#loading').hide();
        }
    });
}

function setPageData(data,paraName,paraData){
    $('#totalNum').html(data.total);
    $('#pageNum').html(data.pageNumber);
    $('#pageLimit').html(data.limit);
    setTableBody(data.list);
    setPage(data,paraName,paraData);
}

function setTableBody(data){
    var body = '';
    var i =0;
    for(var o in data){
        ++i;
        var field = data[o];
        body+='<tr>';
        body+='<td>'+ i +'</td>';
        body+='<td>'+ field.userName +'</td>';
        body+='<td>'+ field.userType +'</td>';
        body+='<td>'+ field.password +'</td>';
        body+='<td>' +
            '<a class="label label-success">编辑</a> ' +
            '<a class="label label-danger">删除</a> ' +
            '</td>';
        body+='</tr>';
    }
    if(body){
        $('#tbody').html(body);
    }else{
        $('#tbody').html('No data');
    }
}

function setPage(data,paraName,paraData){
    //ul
    var item = $('#pagination');
    item.find('li').remove();

    //previous
    var enablePre = data.hasPreviousPage ? '':'disabled';
    item.append('<li class='+enablePre+'><a href="javascript:void(0)" onclick="goPreOrNext(\''+paraName+'\',\''+paraData+'\',-1)" >&laquo;</a></li>');

    //page numbers
    var pageNo = data.navigatePageNumbers;
    for(var num in pageNo){
        if(pageNo[num] == data.pageNumber){
            item.append('<li class="active"><a href="#">'+ pageNo[num] +'</a></li>');
        }else{
            item.append('<li><a href="javascript:void(0)" onclick="loadUser(\''+paraName+'\',\''+paraData+'\','+pageNo[num]+',10)" >'
                        + pageNo[num] +'</a></li>');
        }
    }

    //next
    var enableNext = data.hasNextPage ? '':'disabled';
    item.append('<li class='+enableNext+'><a href="javascript:void(0)" onclick="goPreOrNext(\''+paraName+'\',\''+paraData+'\',1)">&raquo;</a></li>');
}

function goPreOrNext(paraName,paraData,flag){
    var nowPage = $('#pagination .active').text();
    loadUser(paraName,paraData,parseInt(nowPage)+parseInt(flag),10);
}