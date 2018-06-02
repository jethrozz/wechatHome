goEasy = new GoEasy({
        appkey: "BS-5dbbce5c671147d5a2ab9de9e977c31b"
})
var userId = $("#parentId").val();
//接收请假的反馈消息
goEasy.subscribe({
    channel: "leave",
    onMessage: function (message) {
        var data = message.content;
        console.log(data);
        var res = JSON.parse(data);

        if(res.stauts == 0 && res.userId == userId){
            var $modal = $('#leave');
            $modal.modal();
            $("#startTime").val("");
            $("#endTime").val("");
            $("#leave_type").val("");
            $("#reason").val("");
        }
    }
});
//showHomeIndex
goEasy.subscribe({
    channel:"getHomeworkByClassIdParent",
    onMessage:function(message){
        var res = JSON.parse(message.content);
        if(res.stauts == 0 && res.userId == userId){
            var data = res.data;
            var str = "";
            for(var i = 0;i<data.length;i++){
                str += "<li><a class=\"am-text-truncate\" href=\"javascript:void(0);\" onclick=\"showHomework(this)\" alt=\""+data[i].id+"\">"+data[i].title+"</a></li>"
            }
            $("#hwork").empty();
            $("#hwork").append(str);
            console.log(data);
        }
    }
})
//getOneHomeworkByIdParent
goEasy.subscribe({
    channel:"getOneHomeworkByIdParent",
    onMessage:function(message){
        var res = JSON.parse(message.content);
        if(res.stauts == 0 && res.userId == userId){
            var $modal = $("#homework");
            var data = res.data;
            $("#homework-title").text(data.title)
            $("#homework-content").text(data.content);
            $modal.modal();
            console.log(data);
        }
    }
})
//getHomeworkByTimeParent
goEasy.subscribe({
    channel:"getHomeworkByTimeParent",
    onMessage:function(message){
        var res = JSON.parse(message.content);
        if(res.stauts == 0 && res.userId == userId){
            var res = JSON.parse(message.content);
            if(res.stauts == 0 && res.userId == userId){
                var data = res.data;
                var str = "";
                for(var i = 0;i<data.length;i++){
                    str += "<li><a class=\"am-text-truncate\" href=\"javascript:void(0);\" onclick=\"showHomework(this)\" alt=\""+data[i].id+"\">"+data[i].title+"</a></li>"
                }
                $("#hwork").empty();
                $("#hwork").append(str);
                console.log(data);
            }
        }
    }
})

