var msg = "${msg}";

$(function () {
    //绑定校验规则
    $("#frmlogin").bootstrapValidator({
        message: 'This value is not valid',
        /*输入框不同状态,显示图片的样式*/
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            usersCode: {
                validators: {
                    notEmpty: {
                        message: "帐号不能为空"
                    },
                    stringLength: {
                        min: 6,
                        max: 20,
                        message: "用户编号为20位"
                    }
                }
            },
            usersPassword: {
                validators: {
                    notEmpty: {
                        message: "密码不能为空"
                    },
                    stringLength: {
                        min: 6,
                        max: 12,
                        message: "密码长度介于6到12之间"
                    }
                }
            }
        }
    }); // end bootstarpValidator


    //////////////////////////
    //if (msg.length > 0)
    //	$("#msgdiv").modal();
    /////////////////////////

    $("#msgdiv").on("hidden.bs.modal", function () {
        //window.location.href = $("#url").val();
    });

    $("#btn_login").click(function () {
        $("#frmlogin").submit(function(){
        //先校验表单，通过再提交
        $("#frmlogin").bootstrapValidator("validate");
            var isvalid = $("#frmlogin").data("bootstrapValidator").isValid();
            if (isvalid == false) {
                return false;
    /*            $.post("/auth/login",
                    $("#frmlogin").serialize(), function (json) {
                        $("#msgdiv #pmsg").html("");//先清空
                        $("#msgdiv #pmsg").html(json.msg);
                        $("#url").val(json.url);
                        if (json.msg != "ok") {
                            $("#msgdiv").modal('show');
                            //$JACK.n_danger(json.msg);
                        } else {
                            window.location.href = json.url;
                        }
                    },"json");*/
            }
        }
    )
    }
)

    $("#error").click(function () {
        alert("请联系管理员：18961297987");
    });
});// end $