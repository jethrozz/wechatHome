$("#classInfoBtn").bind('click', function(event) {
	var $modal = $('#classInfo');
	$("#class-title").text("xx级xx班");
	var content = "<tr><td>January</td><td>$100</td></tr>";
	$("#class-content").append(content)
	$modal.modal();
});

function showNotice(e) {
	var notice = $(e);
	var $modal = $("#notice");
	$("#notice-content").text(notice.attr("alt"));
	$modal.modal();
}
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
    $.get(url,function () {
        
    });
}
//作业详情
function showHomework(e){
    var homework = $(e);
   var hId = homework.attr("alt");
    var url = "/parent/getOneHomeworkById/"+hId;
    $.get(url,function () {
    });
}
//根据时间查询
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
                    // alert("提交成功");
                }
            },
            error:function(data,status,result){
                console.log(data);
            }
        });
    }
})

