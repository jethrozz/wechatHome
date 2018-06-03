var stuId = $("#studentId").val();
var parentId = $("#parentId").val();
var calssesId = $("#calssesId").val();

$("#leaveBtn").bind('click', function(event) {
	var $modal = $('#leave');
	$modal.modal();
});


//请假
$("#leave_btn").click(function(){
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var type = $("#leave_type").val();
	var reson = $("#reason").val();

    var xmlHttpRequest;

    if(window.XMLHttpRequest){
    	xmlHttpRequest=new XMLHttpRequest();}else{xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlHttpRequest.open("GET","AjaxServlet",true);

   $.ajax({
        url:"/parent/leave_record",
        type:"get",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            reason:reson,
            type:type,
            startTime:startTime,
            endTime:endTime,
			time:datedifference(endTime,startTime)
        },
        success: function (data,stauts,result) {
            console.log(data);
            if(data.status == 0){
                alert("提交成功");
                var $modal = $('#leave');
                $modal.modal();
                $("#startTime").val("");
                $("#endTime").val("");
                $("#leave_type").val("");
                $("#reason").val("");
            }
        },
		error:function(data,status,result){
            console.log(data);
		}
    });

});
function datedifference(sDate1, sDate2) {    //sDate1和sDate2是2006-12-18格式
    var dateSpan,
        tempDate,
        iDays;
    sDate1 = Date.parse(sDate1);
    sDate2 = Date.parse(sDate2);
    dateSpan = sDate2 - sDate1;
    dateSpan = Math.abs(dateSpan);
    iDays = Math.floor(dateSpan / (24 * 3600 * 1000));
    return iDays
};

//当天作业
function showHomeIndex() {
    var calId = $("#calssesId").val();
    var url = "/parent/getHomeworkByClassId/"+calId;
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
    var url = "/parent/getOneHomeworkById/"+hId;
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
        var url = "/parent/getHomeworkByTime/"+calId;
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
                }
            },
            error:function(data,status,result){
                console.log(data);
            }
        });
    }
})
//请假记录
function showLeave() {

    $.ajax({
        url:"/student/getLeaveRecord",
        type:"get",
        async:false,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            stuId:stuId
        },
        success: function (data,stauts,result) {
            console.log(data);
            if(data.code == 0){
                var data = data.data;
                var str = "";
                for(var i = 0;i<data.length;i++){
                    str += "<tr >\n" +
                        "                <td>"+data[i].time+"</td>\n" +
                        "                <td>"+data[i].teacherName+"</td>\n" +
                        // "                <td>"+data[i].type+"</td>\n" +
                        "                <td>"+data[i].reason+"</td>\n" +
                        "                <td>"+data[i].status+"</td>\n" +
                        "            </tr>"
                }
                $("#leave_content").empty();
                $("#leave_content").append(str);
            }
        },
        error:function(data,status,result){
            console.log(data);
        }
    });
}

//时间查询请假记录
$(".leave_date_btn").click(function () {
    var date = $("#leave_date").val();

    if(date != ""){
        $.ajax({
            url:"/student/getLeaveRecord",
            type:"get",
            async:false,
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            data:{
                stuId:stuId,
                date:date
            },
            success: function (data,stauts,result) {
                console.log(data);
                if(data.code == 0){
                    var data = data.data;
                    var str = "";
                    for(var i = 0;i<data.length;i++){
                        str += "<tr >\n" +
                            "                <td>"+data[i].time+"</td>\n" +
                            "                <td>"+data[i].teacherName+"</td>\n" +
                            // "                <td>"+data[i].type+"</td>\n" +
                            "                <td>"+data[i].reason+"</td>\n" +
                            "                <td>"+data[i].status+"</td>\n" +
                            "            </tr>"
                    }
                    $("#leave_content").empty();
                    $("#leave_content").append(str);
                }
            },
            error:function(data,status,result){
                console.log(data);
            }
        });
    }
});

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
            }
        },
        error:function(data,status,result){
            console.log(data);
        }
    });
}
//获取班级教师
//班级教师详情
$("#classInfoBtn").bind('click', function(event) {
    var $modal = $('#classInfo');
    $.ajax({
        url:"/teacher/getTeacherByClaId",
        type:"get",
        async:false,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            claId:calssesId
        },
        success: function (data,stauts,result) {
            console.log(data);
            if(data.code == 0){
                var data = data.data;
                var content = "";
                for(var i=0;i<data.length;i++){
                    content += "<tr><td>"+data[i].username+"</td><td>"+data[i].subject+"</td></tr>";
                }
                $("#classTeacher").append(content)
                $modal.modal();
            }
        },
        error:function(data,status,result){
            console.log(data);
        }
    });
});