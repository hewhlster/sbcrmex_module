$(function () {
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        // 执行一个laydate实例
        laydate.render({
            elem: '#optDueDate', // 指定元素
            format: 'yyyy/MM/dd HH:mm:ss', // 自动生成的时间格式
            // min : laydate.now(), //设定最小日期为当前日期
            max: '2099/01/01 23:59:59', // 最大日期
            istime: true, // 必须填入时间
            istoday: true, // 是否是当天
            start: $JACK.getNowFormatDate()
            // 设置开始时间为当前时间
        });
        laydate.render({
            elem: '#optCreateDate', // 指定元素
            format: 'yyyy/MM/dd HH:mm:ss', // 自动生成的时间格式
            // min : laydate.now(), //设定最小日期为当前日期
            max: '2099/01/01 23:59:59', // 最大日期
            istime: true, // 必须填入时间
            istoday: true, // 是否是当天
            start: $JACK.getNowFormatDate()
            // 设置开始时间为当前时间
        });
    });

    $("#optCreateDate").val($JACK.getNowFormatDate());

    $("#btn_due_user").click(
        function () {
            // 显示选择创建人对话框
            $("#user_list_select_dialog").modal("show");
            // 绑定客户对话框隐藏事件处理方法
            $("#user_list_select_dialog").on(
                "hide.bs.modal",
                function () {
                    var rows = $("#user_list_select_table")
                        .bootstrapTable('getSelections');
                    // console.log("rows="+rows);
                    if (!(!rows || rows.length == 0)) {
                        $("#optDueUserValue").val(rows[0].usersName);
                        $("#optDueUser").val(rows[0].usersNo);
                    }
                });
        });

    $("#btn_select_customer").click(
        function () {
            // 显示选择客户对话框
            $("#customer_list_dialog").modal("show");
            // 绑定客户对话框隐藏事件处理方法
            $("#customer_list_dialog").on(
                "hide.bs.modal",
                function () {
                    var rows = $("#customer_list_table")
                        .bootstrapTable('getSelections');
                    // console.log("rows="+rows);
                    if (!(!rows || rows.length == 0)) {
                        $("#cname").val(rows[0].name);
                    }
                });
        });

    $("#salediv").on("shown.bs.modal", function () {
        // 绑定表单校验
        $("#frmsalechance").bootstrapValidator({
            message: 'This value is not valid',
            /* 输入框不同状态,显示图片的样式 */
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                optSource: {
                    validators: {
                        notEmpty: {
                            message: "机会来源不能空"
                        },
                        stringLength: {
                            min: 4,
                            max: 10,
                            message: "机会编号长度必须在4到10之间"
                        }
                    }
                }
            }
        });// end bootstrapValidator
    });

    $("#salediv").on("hide.bs.modal", function () {
        $("#frmsalechance").data("bootstrapValidator").resetForm(false);
    });

    $("#btn_saveorupdate").click(function () {
        // 校验表单
        $('#frmsalechance').bootstrapValidator('validate');
        var formState = $('#frmsalechance').data('bootstrapValidator').isValid();
        if (formState) {
            url = "sale/sale_chance_saveorupdate";
            var datas;
            var type = $("#saveOrupdate").val();// dialog模式标识

            // 根据DIALOG模式采用不同的方法提交数据
            // type:显示方式 0：新建 1：查看 2:编辑 3:指派
            if (type == 2 || type == 0) {
                datas = $("#frmsalechance").serialize();
            } else if (type == 3) {
                // 只提交部分数据
                datas = {
                    type: $("#saveOrupdate").val(),
                    optNo: $("#optNo").val(),
                    optCreateDate: $("#optCreateDate").val(),
                    optDueDate: $("#optDueDate").val()
                }
            }
            // 提交数据
            $.ajax({
                cache: false,
                type: "post",
                url: url,
                data: datas,
                async: true,
                error: function (request) {
                    alert("新增销售机会失败！！");
                },
                success: function (data) {
                    if (type == 3) {
                        window.alert("指派成功。");
                    } else if (type == 0) {
                        var result = window.confirm("操作成功，是否继续增加");
                        if (result == 1) {// 确认
                            initModal();
                            return;
                        }
                    } else if (type == 2) {
                        window.alert("编辑成功。");
                    }
                    $("#salediv").modal("hide");
                    $("#table").bootstrapTable("refresh");
                }
            });
        }
    });

})// $

function submitFrom() {
    $('#frmsalechance').bootstrapValidator('validate');
    var formState = $('#frmsalechance').data('bootstrapValidator').isValid();
    if (formState) {
        url = "/sale/sale_chance_saveorupdate";
        $.ajax({
            cache: false,
            type: "get",
            url: url,
            data: $("#frmsalechance").serialize(),
            async: true,
            error: function (request) {
                alert("新增销售机会失败！！");
            },
            success: function (data) {
                var result = window.confirm("操作成功，是否继续增加");
                if (result == 1) {// 确认
                    initModal();
                } else {
                    $("#salediv").hide();
                }
                $("#table").bootstrapTable("refresh");
            }
        });
    }
}

// 初始化模态窗口中的数据
function initModal(row) {
    if (row == null) {
        // 清空
        document.getElementById("frmsalechance").reset();
        // 初始化日期控件
        $("#frmsalechance #createdate").val($JACK.getNowFormatDate());
        $("#frmsalechance #optDueDate").val($JACK.getNowFormatDate());
    } else {
        $("#frmsalechance #id").val(row.id);
        $("#frmsalechance #source").val(row.source);
        $("#frmsalechance #cname").val(row.cname);
        $("#frmsalechance #optRate").val(row.optRate);
        $("#frmsalechance #lname").val(row.lname);
        $("#frmsalechance #summary").val(row.summary);
        $("#frmsalechance #memo").val(row.memo);
        $("#frmsalechance #tel1").val(row.tel1);
        //$("#frmsalechance #optLkmPosition").val(row.optLkmPosition);
        $("#frmsalechance #optDesc").val(row.optDesc);
        //$("#frmsalechance #createdate").val(row.optCreateName);
        //$("#frmsalechance #").val(row.optCreateDate);
        $("#frmsalechance #status").val(row.status);
        //没有指派
        if (row.duid != null) {
            $("#frmsalechance #optdueuser").val(row.optdueuser.userName);
            $("#frmsalechance #optDueDate").val(row.optDueDate);
        }
    }
}

// type:显示方式 0：全打开 1：全禁用
function setDialogCompoentState(div, type) {
    if (type == 0) {
        $("#" + div).find("form").each(function () {
            $(this).find("input,select,textarea").each(function () {
                $(this).prop("disabled", false);
                // $(this).removeAttr("readonly");
            });
        });
        $("#" + div).find("button[id='btn_saveorupdate']").prop("disabled",
            false);
        // $("#myModalLabel").text($("#myModalLabel").text()+"-新增");
    } else if (type == 1) {
        $("#" + div).find("form").each(function () {
            $(this).find("input,select,textarea,button").each(function () {
                $(this).prop("disabled", true);
                // $(this).attr("readonly","readonly");
            });
        })
        $("#" + div).find("button[id='btn_saveorupdate']").prop("disabled",
            true);
        // $("#myModalLabel").text($("#myModalLabel").text().replace("-详细","-详细"));
    }

}
