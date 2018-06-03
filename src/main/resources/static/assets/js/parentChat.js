goEasy = new GoEasy({
    appkey: "BS-5dbbce5c671147d5a2ab9de9e977c31b"
});
var me = $("#meOpenId").val();


//接收动态消息
goEasy.subscribe({
    channel: "wechatMSG",
    onMessage: function (message) {
        var data = message.content;
        var content = JSON.parse(data);
        var me = sessionStorage.getItem("userId");
        if(me != content.data.belongUser && me == content.data.pushUser) {
            var str = "您的好友发表了新动态";
            $("#tip").text(str);
            $("#tip").fadeIn(1500).fadeOut(3000);
        }
    }
});

