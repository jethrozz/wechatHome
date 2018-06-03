var stuId = $("#studentId").val();
var calssesId = $("#calssesId").val();

$("#changeBtn").bind('click', function(event) {
	var $modal = $('#changeInfo');
	$modal.modal();
});
//当天作业
function showHomeIndex() {
    var calId = $("#calssesId").val();
    var url = "/student/getHomeworkByClassId/"+calId;
    $.get(url,function (data) {
        var data = data.data;
        var str = "";
        for(var i = 0;i<data.length;i++){
            str += "<li><a class=\"am-text-truncate\" href=\"javascript:void(0);\" onclick=\"showHomework(this)\" alt=\""+data[i].id+"\">"+data[i].title+"</a></li>"
        }
        $("#hwork").empty();
        $("#hwork").append(str);
    });
}
//作业详情
function showHomework(e){
    var homework = $(e);
    var hId = homework.attr("alt");
    var url = "/student/getOneHomeworkById/"+hId;
    $.get(url,function (data) {
        var $modal = $("#homework");
        var data = data.data;
        $("#homework-title").text(data.title)
        $("#homework-content").text(data.content);
        $modal.modal();
    });
}
//根据时间查询作业
$("#hw_btn").click(function () {
    var date = $("#homeworkDate").val();
    if(date != ""){
        var calId = $("#calssesId").val();
        var url = "/student/getHomeworkByTime/"+calId;
        $.ajax({
            url:url,
            type:"get",
            async:false,
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            data:{
                date:date
            },
            success: function (data,stauts,result) {
                console.log(data);
                if(data.status == 0){
                    var data = data.data;
                    var str = "";
                    for(var i = 0;i<data.length;i++){
                        str += "<li><a class=\"am-text-truncate\" href=\"javascript:void(0);\" onclick=\"showHomework(this)\" alt=\""+data[i].id+"\">"+data[i].title+"</a></li>"
                    }
                    $("#hwork").empty();
                    $("#hwork").append(str);
                }else{
                    alert("暂无数据");
                }
            },
            error:function(data,status,result){
                console.log(data);
            }
        });
    }
})
//成绩
function score() {

    $.ajax({
        url:"/student/getOneStudentScore/"+stuId,
        type:"get",
        async:false,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{},
        success: function (data,stauts,result) {
            console.log(data);
            if(data.status == 0){
                var data = data.data;
                var str = "";
                for(var i = 0;i<data.length;i++){
                    str += "           <tr>\n" +
                        "                <td>"+data[i].subject+"</td>\n" +
                        "                <td>"+data[i].score+"</td>\n" +
                        "                <td>"+data[i].createTime+"</td>\n" +
                        "            </tr>";
                }
                $("#score").empty();
                $("#score").append(str);
            }else{
                alert("暂无数据");
            }
        },
        error:function(data,status,result){
            console.log(data);
        }
    })
}
//按时间查询成绩
$(".score_date_btn").click(function () {
    var start = $("#my-start").text();
    var end = $('#my-end').text();
    var term = $("#term").val();
    if(start != "" && end != ""){
        $.ajax({
            url:"/student/getOneStudentByTimeArange",
            type:"get",
            async:false,
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            data:{
                stuId:stuId,
                term:term,
                startTime:start,
                endTime:end
            },
            success: function (data,stauts,result) {
                console.log(data);
                if(data.status == 0){
                    var data = data.data;
                    var str = "";
                    for(var i = 0;i<data.length;i++){
                        str += "           <tr>\n" +
                            "                <td>"+data[i].subject+"</td>\n" +
                            "                <td>"+data[i].score+"</td>\n" +
                            "                <td>"+data[i].createTime+"</td>\n" +
                            "            </tr>";
                    }
                    $("#score").empty();
                    $("#score").append(str);
                }else{
                	alert("选择的日期范围下暂无数据");
				}
            },
            error:function(data,status,result){
                console.log(data);
            }
        })
    }
})

//所有通知
function notice() {
    $.ajax({
        url:"/teacher/getAllNotice",
        type:"get",
        async:false,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{},
        success: function (data,stauts,result) {
            console.log(data);
            if(data.code == 0){
                var data = data.data;
                var str = "";
                for(var i = 0;i<data.length;i++){
                    str += "<li><a  class=\"am-text-truncate\" href=\"javascript:void(0);\" onclick=\"showNotice(this)\" alt=\""+data[i].id+"\">"+data[i].title+"</a></li>";
                }
                $("#noticeList").empty();
                $("#noticeList").append(str);
            }else{
                alert("暂无数据");
            }
        },
        error:function(data,status,result){
            console.log(data);
        }
    });
}

//单个通知
function showNotice(e) {
    var notice = $(e);
    var $modal = $("#notice");

    $.ajax({
        url:"/student/getNotice",
        type:"get",
        async:false,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            id:notice.attr("alt")
        },
        success: function (data,stauts,result) {
            console.log(data);
            if(data.code == 0){
                var data = data.data;
                $("#notice-title").text(data.title);
                $("#notice-teacher").text(data.teacherName+"("+data.createTime+")");
                $("#notice-content").text(data.content);
                $modal.modal();
            }else{
                alert("暂无数据");
            }
        },
        error:function(data,status,result){
            console.log(data);
        }
    });
}
