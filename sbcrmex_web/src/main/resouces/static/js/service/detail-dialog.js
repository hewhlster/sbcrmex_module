$(function () {

    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#svcDoDate', //指定元素
            format: 'yyyy/MM/dd HH:mm:ss', //自动生成的时间格式
            //min : laydate.now(), //设定最小日期为当前日期
            max: '2099/01/01 23:59:59', //最大日期
            istime: true, //必须填入时间
            istoday: true, //是否是当天
            start: $JACK.getNowFormatDate() //设置开始时间为当前时间
        });
    });

    $("#svcDoDate").val($JACK.getNowFormatDate());

    $("#btn_service_detail_submit").click(function () {
        serviceDetail_submitFrom();
    })


    $("#btn_select_do_user").click(function () {
        //显示选择创建人对话框
        $("#user_list_select_dialog").modal("show");
        //绑定客户对话框隐藏事件处理方法
        $("#user_list_select_dialog").on(
            "hide.bs.modal",
            function () {
                var rows = $("#user_list_select_table")
                    .bootstrapTable('getSelections');
                //console.log("rows="+rows);
                if (!(!rows || rows.length == 0)) {
                    $("#svcDoNoValue").val(rows[0].usersName);
                    $("#svcDoNo").val(rows[0].usersNo);
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

    //清空
    $("#svcDoContent").val("");
    $("#svcDoNoValue").val("");
    $("#svcDoDate").val("");
}

// /////////////////////////////////////////////////////////////////////////////////////
function serviceDetail_submitFrom() {
    $('#serviceDetailForm').bootstrapValidator('validate');
    var formState = $('#serviceDetailForm').data('bootstrapValidator').isValid();
    if (formState) {
        url = "service/detail.do";
        $.getJSON(
            url,
            $("#serviceDetailForm").serialize(),
            function (data) {
                if (data.msg != "ok") {// 确认
                    $JACK.n_success("服务处理操作成功！！");
                } else {
                    $JACK.n_danger("服务处理操作失败！！");

                    $("#servicedetaildialog").modal('hide');
                    $("#service_list_detail").bootstrapTable("refresh");
                }
            }
        );
    }
}