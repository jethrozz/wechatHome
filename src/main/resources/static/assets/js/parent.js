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
function showHomework(e){
	var homework = $(e);
	var $modal = $("#homework");
	$("#homework-title").text("数学作业")
	$("#homework-content").text(homework.attr("alt"));
	$modal.modal();
}

$("#leave_btn").click(function(){
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var type = $("#leave_type").val();
	var reson = $("#reason").val();
	console.log(startTime);
    console.log(endTime);
    console.log(type);
    console.log(reson)
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