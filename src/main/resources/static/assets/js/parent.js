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