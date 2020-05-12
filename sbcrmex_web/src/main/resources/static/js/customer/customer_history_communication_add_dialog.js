$(function () {
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        // 执行一个laydate实例
        laydate.render({
            elem: '#frmcommunication #date', // 指定元素
            format: 'yyyy/MM/dd HH:mm:ss', // 自动生成的时间格式
            // min : laydate.now(), //设定最小日期为当前日期
            max: '2099/01/01 23:59:59', // 最大日期
            istime: true, // 必须填入时间
            istoday: true, // 是否是当天
            start: $JACK.getNowFormatDate()
            // 设置开始时间为当前时间
        });

    });
    $("#frmcommunication #date").val($JACK.getNowFormatDate());

    $("#communication_add_dialog").on("hide.bs.modal", function () {
        $("#communication_list_tbl").bootstrapTable("refresh");
    })

    // /////////////////////////////////////////////////////////////////////////////////////
    $("#btn_communication_add").click(
        function () {
            $('#frmcommunication').bootstrapValidator('validate');
            var formState = $('#frmcommunication').data(
                'bootstrapValidator').isValid();
            if (formState) {
                url = "/customer/ajax_customer_communication_add";
                $.ajax({
                    cache: false,
                    type: "post",
                    url: url,
                    data: $("#frmcommunication").serialize(),
                    async: true,
                    error: function (request) {
                        $JACK.n_danger("新增客户交往记录失败.");
                    },
                    success: function (data) {
                        var result = window.confirm("操作成功，是否继续增加？");
                        $JACK.n_success("操作成功。");

                        if (result == 1) {// 确认
                            initModal();
                        } else {
                            $("#communication_add_dialog").modal("hide");
                        }
                    }
                });
            }
        });
}) // $
