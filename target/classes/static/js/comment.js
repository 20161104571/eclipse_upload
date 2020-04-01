    function btnReplyClick(elem) {
        var $ = layui.jquery;
        $(elem).parent('p').parent('.comment-parent').siblings('.replycontainer').toggleClass('layui-hide');
        if ($(elem).text() == '回复') {
            $(elem).text('收起')
        } else {
            $(elem).text('回复')
        }
    }
​
    $("#replyBtn").click(function(){
        var rid = $("#rid").val();
        var rame = $("#rname").val();
        var rdate = $("#rdate").val();
        //var lr_for_name = $("#lr_for_name").val();
        var rcontent = $("#rcontent").val();
        $.ajax({
            url: '<%=basePath%>/article/saveReply.do',
            type: 'POST',
            data: [{
                rid:rid,
 				rname:rname,
 				rdate:rdate,
 				rcontent:rcontent
            }],
            success: function(data){
                layer.open({
                    title: '提示信息',
                    content: '留言成功',
                    btn: ['确定'],
                    btn1: function(index){
                        $("body").html(data);
                    }
                });
            },
            error: function(){
                layer.open({
                    title: '提示信息',
                    content: '出现未知错误'
                });
            }
        });
    });
