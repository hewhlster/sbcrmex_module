$(function () {

    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#svcDealDate', //指定元素
            format: 'yyyy/MM/dd HH:mm:ss', //自动生成的时间格式
            //min : laydate.now(), //设定最小日期为当前日期
            max: '2099/01/01 23:59:59', //最大日期
            istime: true, //必须填入时间
            istoday: true, //是否是当天
            start: $JACK.getNowFormatDate() //设置开始时间为当前时间
        });
    });

    $("#svcDealDate").val($JACK.getNowFormatDate());

    $("#btn_service_feedback_submit").click(function () {
        serviceFeedback_submitFrom();
    })


    $("#btn_select_feedback_user").click(function () {
        //显示选择创建人对话框
        $("#user_list_select_dialog").modal("show");
        //绑定客户对话框隐藏事件处理方法
        $("#user_list_select_dialog").on(
            "hide.bs.modal",
            function () {
                var rows = $("#user_list_select_table")
                    .bootstrapTable('getSelections');
                console.log(rows);
                if (!(!rows || rows.length == 0)) {
                    $("#svcDealNoValue").val(rows[0].usersName);
                    $("#svcDealNo").val(rows[0].usersNo);
                }
            });
    })
})

// 初始化模态窗口中的数据
function initFormData(row) {
    console.log(row);
    $("#svcNo").val(row.svcNo);
    $("#svcNoDispaly").val(row.svcNo);


    $("#cstNoValue").val(row.cstNo);//
    $("#svcType").val(row.svcType);
    $("#svcSummary").val(row.svcSummary);
    $("#svcStatus").val(row.svcStatus);
    $("#svcDetails").val(row.svcDetails);
    $("#svcCreateNoValue").val(row.CreateNo);//
    $("#svcCreateDate").val(row.svcCreateDate);
    $("#svcDueNoValue").val(row.svcDueNo);
    $("#svcDueDate").val(row.svcDueDate);
    $("#svcDoValue").val(row.svcDo);
    $("#svcDoDate").val(row.svcDoDate);
    $("#svcDoContent").val(row.svcDoContent);


    //清空
    $("#svcDealNoValue").val("");
    //  $("#svcDealDate").val("");
    $("#svcDealResult").val("");
    //  $("#svcDealSatisfy").val("");
}

// /////////////////////////////////////////////////////////////////////////////////////
function serviceFeedback_submitFrom() {
    $('#serviceFeedbackForm').bootstrapValidator('validate');
    var formState = $('#serviceFeedbackForm').data('bootstrapValidator').isValid();
    if (formState) {
        url = "service/feedback.do";
        $.getJSON(
            url,
            $("#serviceFeedbackForm").serialize(),
            function (data) {
                if (data.msg != "ok") {// 确认
                    $JACK.n_danger("服务处理操作失败！！");
                } else {
                    $("#servicefeedbackdialog").modal('hide');
                    $("#service_list_feedback").bootstrapTable("refresh");
                }
            }
        );
    }
}