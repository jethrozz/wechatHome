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
	var endTime = $("endTime").val();
	var type = $("#leave_type").val();
	var reson = $("#reason").val();


    $.ajax({
        url:"/parent/leave_record",
        type:"post",
        async:true,
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        data:{
            reason:reson,
            type:type,
            startTime:startTime,
            endTime:endTime
        },
        success: function (data,stauts,result) {
            console.log(data);
            if(data.status == 0){
                
            }
        }
    });

});