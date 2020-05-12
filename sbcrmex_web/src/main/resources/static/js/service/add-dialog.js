$(function () {

    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#svcCreateDate', //指定元素
            format: 'yyyy/MM/dd HH:mm:ss', //自动生成的时间格式
            //min : laydate.now(), //设定最小日期为当前日期
            max: '2099/01/01 23:59:59', //最大日期
            istime: true, //必须填入时间
            istoday: true, //是否是当天
            start: $JACK.getNowFormatDate() //设置开始时间为当前时间
        });
    });


    $("#btnsubmit").click(function () {
        //alert("btnsubmit");
        submitFrom();
    })

    $("#btn_customer").click(
        function () {
            //显示选择客户对话框
            $("#customer_list_dialog").modal("show");
            //绑定客户对话框隐藏事件处理方法
            $("#customer_list_dialog").on(
                "hide.bs.modal",
                function () {
                    var rows = $("#customer_list_table")
                        .bootstrapTable('getSelections');
                    //console.log("rows="+rows);
                    if (!(!rows || rows.length == 0)) {
                        $("#cstNo").val(rows[0].cstNo);
                        $("#cstNoValue").val(rows[0].cstName);
                    }
                });

            $("#customer_list_dialog").on("show.bs.modal", function () {
                //$("#customer_list_table").bootstrapTable('refresh');
            });
        });

    $("#btn_createno").click(function () {
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
                    $("#svcCreateNoValue").val(rows[0].usersName);
                    $("#svcCreateNo").val(rows[0].usersNo);
                }
            });

        $("#customer_list_dialog").on("show.bs.modal", function () {
            //$("#customer_list_table").bootstrapTable('refresh');
        });
    })
})

// 初始化模态窗口中的数据
function initFormData() {
    //$("#serviceAddForm")[0].reset();
    //document.getElementById("serviceAddForm").reset();
    $("#svcCreateDate").val($JACK.getNowFormatDate());

}

// type:显示方式 0：全打开 1：全禁用
function setDialogCompoentState(div, type) {
    if (type == 0) {
        $("#" + div).find("form").each(function () {
            $(this).find("input,select,textarea").each(function () {
                $(this).prop("disabled", false);
            });
        });
        $("#" + div).find("button[id='btn_saveorupdate']").prop("disabled",
            false);
        // $("#myModalLabel").text($("#myModalLabel").text()+"-新增");
    } else if (type == 1) {
        $("#" + div).find("form").each(function () {
            $(this).find("input,select,textarea,button").each(function () {
                $(this).prop("disabled", true);
            });
        })
        $("#" + div).find("button[id='btn_saveorupdate']").prop("disabled",
            true);
        // $("#myModalLabel").text($("#myModalLabel").text().replace("-详细","-详细"));
    }

}

// /////////////////////////////////////////////////////////////////////////////////////
function submitFrom() {
    $('#serviceAddForm').bootstrapValidator('validate');
    var formState = $('#serviceAddForm').data('bootstrapValidator').isValid();
    if (formState) {
        url = "service/add.do";
        $.ajax({
            cache: false,
            type: "post",
            url: url,
            data: $("#serviceAddForm").serialize(),
            //dataType:"json",
            //contentType:"application/json;charset=utf-8",
            error: function (request) {
                $JACK.n_danger("新增服务失败！！");
            },
            success: function (data) {
                $JACK.n_success("新增服务成功！！");

                var result = window.confirm("操作成功，是否继续增加");
                if (result == 1) {// 确认
                    initFormData();
                } else {
                    //$("#service_list_table").bootstrapTable('refresh');
                    $("#servicedialog").modal('hide');
                }
            }
        });
    }
}