$(function () {
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        // 执行一个laydate实例
        laydate.render({
            elem: '#frmlostcustomercommunication #date', // 指定元素
            format: 'yyyy/MM/dd HH:mm:ss', // 自动生成的时间格式
            // min : laydate.now(), //设定最小日期为当前日期
            max: '2099/01/01 23:59:59', // 最大日期
            istime: true, // 必须填入时间
            istoday: true, // 是否是当天
            start: $JACK.getNowFormatDate()
            // 设置开始时间为当前时间
        });

    });

    $("#pause_lost_communication_add_dialog").on("hide.bs.modal", function () {
        // initModal();
        $("#pasue_lost_list_tbl").bootstrapTable("refresh");
    })

    $("#pause_lost_communication_add_dialog").on("show.bs.modal", function () {
        $("#frmlostcustomercommunication #date").val($JACK.getNowFormatDate());
        $("#frmlostcustomercommunication #cid").val($("#pasue_lost_list_tbl #cstno").val());
    })


    // /////////////////////////////////////////////////////////////////////////////////////
    $("#frmlostcustomercommunication #btn_add").click(
        function () {
            $('#frmlostcustomercommunication').bootstrapValidator('validate');
            var formState = $('#frmlostcustomercommunication').data(
                'bootstrapValidator').isValid();
            if (formState) {
                url = "/customer/add_record_lost_communication";
                $.ajax({
                    cache: false,
                    type: "post",
                    url: url,
                    data: $("#frmlostcustomercommunication").serialize(),
                    async: true,
                    dataType: "json",
                    error: function (request) {
                        $JACK.n_danger("新增客户沟通记录失败.");
                    },
                    success: function (data) {
                        console.debug(data.msg);
                        if (data.msg === 'ok') {
                            $JACK.n_success("操作成功。");

                            var result = window.confirm("操作成功，是否继续增加？");

                            if (result == 1) {// 确认
                                //initModal();
                            } else {
                                $("#pause_lost_communication_add_dialog").modal("hide");
                            }
                        } else {
                            $JACK.n_danger("新增客户沟通记录失败.");
                        }
                    }
                });
            }
        });
}) // $
