$(function () {
    $("#btn_new_customer_linkman_submit").click(function () {
        save();
    })

    $("#customer_linkman_dialog").on("hidden.bs.modal", function () {
        //$("#customer_linkman_tbl").bootstrapTable('refresh');
        emptyFrm();
        //清空校验信息
        $("#frmlinkman").data("bootstrapValidator").resetForm(false);
    });

    $("#customer_linkman_dialog").on("shown.bs.modal", function () {

        //绑定校验规则
        $("#frmlinkman").bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                /*输入框不同状态,显示图片的样式*/
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                lkmName: {
                    validators: {
                        notEmpty: {
                            message: "用户名不能为空"
                        },
                        stringLength: {
                            min: 2,
                            max: 8,
                            message: "用户名至少2字符,最多8字符"
                        }
                    }
                },
                lkmPostion: {
                    validators: {
                        notEmpty: {
                            message: "职务不能为空"
                        },
                        stringLength: {
                            min: 2,
                            max: 8,
                            message: "职力至少${min}最多${max}"
                        }
                    }
                },
                lkmTel: {
                    validators: {
                        notEmpty: {
                            message: "联系电话不能空"
                        }
                    }
                },
                lkmMobile: {
                    validators: {}
                }

            }
        });//bootstrapValidator
    });


});//$

//清空表单控件数据
function emptyFrm() {
    $("#frmlinkman input textarea").each(function () {
        $(this).val("");
    })

    //document.getElementById("frmlinkman").reset();
}

function save() {
    //校验表单数据
    $("#frmlinkman").bootstrapValidator("validate");
    var ret = $("#frmlinkman").data("bootstrapValidator").isValid();
    //alert(ret);
    if (ret == false)
        return;
    //AJAX提交数据
    $.ajax({
        url: "/customerlinkman/linkman_add",
        method: "post",
        data: $("#frmlinkman").serialize(),
        success:
            function (json) {
                if (json.msg = "ok") {
                    $("#customer_linkman_tbl").bootstrapTable("refresh");
                    if (window.confirm("是否要继续增加联系人？")) {
                        emptyFrm();
                    } else {
                        $("#customer_linkman_dialog").modal("hide");
                    }
                }
            }
    });
}