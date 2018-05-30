$("#changeBtn").bind('click', function(event) {
	var $modal = $('#changeInfo');
	$modal.modal();
});

function showNotice(e) {
	var notice = $(e);
	var $modal = $("#notice");
	$("#notice-content").text(notice.attr("alt"));
	$modal.modal();
	// body...
}

function showHomework(e){
	var homework = $(e);
	var $modal = $("#homework");
	$("#homework-title").text("数学作业")
	$("#homework-content").text(homework.attr("alt"));
	$modal.modal();
}