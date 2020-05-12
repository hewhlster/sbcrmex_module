//提交更改按钮
$("#btnsubmit").click(function () {
    $("#clientAddForm").bootstrapValidator();
    var isValid = $("#clientAddForm").data("bootstrapValidator").isValid();
    if (isValid == true) {
        //校验通过
        $.ajax({
            url: "/customer/customer_add",
            method: "post",
            data: $("#clientAddForm").serialize(),
            success: function (json) {
                if (json.msg == "ok") {
                    if (true == window.confirm("是否继续增加客户")) {
                        //初始化表单控件

                    }
                } else {
                    //关闭窗口
                    $("#customerdialog").modal("hide");
                }
                //刷新表格
                $("#table").bootstrapTable("refresh");
            }
        })
    }
});