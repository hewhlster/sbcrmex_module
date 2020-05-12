$(function () {
    //刷新
    $("#btn_reload").click(function () {
        window.location.href = window.location.href;
    });

    //返回
    $("#btn_back").click(function () {
        window.history.go(-1);
    });

    //绑定新增按钮事件
    $("#btn_new").click(function () {
        $JACK.showModal("userdiv", null, initModal, 0, scallback, hcallback);
    })
    //绑定提交按钮事件
    $("#btn_user_submit").click(function () {
        saveOrUpdate();
    })

    //绑定查询按钮事件
    $("#btn_search").click(function () {
        $("#table").bootstrapTable("refresh");//刷新表格
    })

    //绑定查询重置事件
    $("#btn_reset").click(function () {
        $("#users_Name").val("");//清空
        $("#users_rid").val("");//清空

        $("#table").bootstrapTable("refresh");//刷新表格
    })

});

//$


function saveOrUpdate() {
    var url = "";
    var dialog_state = $("#dialog-state").val();
    if (dialog_state == $JACK.DIALOG_STATE_ADD)
        url = "/user/user_add";
    else if (dialog_state == $JACK.DIALOG_STATE_EDIT)
        url = "/user/user_update";
    $.ajax({
        url: url,
        method: "post",
        data: $("#frmuser").serialize(),
        success: function (json) {
            if (json.msg == "ok")
                $JACK.n_success("操作成功.");
            else {
                var j = $.parseJSON(json);
                $JACK.n_success(j.msg);
            }
            $("#userdiv").modal("hide");
            $("#table").bootstrapTable("refresh");//刷新表格
        }
    });
}

function initModal(row) {
    if (row == null) {
        //清空
        document.getElementById("frmuser").reset();
    } else {
        //加载行数据
        $("#frmuser input[id='name']").val(row.name);
        //$("#usersPassword").val(row.usersPassword);
        $("#gender").val(row.gender);
        $("#tel").val(row.tel);
        $("#addr").val(row.addr);
        $("#remark").val(row.remark);
        $("#state").val(row.state);
        $("#frmuser select[id='rid']").val(row.rid);
        $("#code").val(row.code);
        $("#id").val(row.id);
    }
}


//绑定层关闭事件
function hcallback() {
    //初始化控件
    document.getElementById("frmuser").reset();
    $("#userdiv").removeData("bs.modal");
};

//绑定资源层关闭事件
function scallback() {
    initRoleSelect();//初始化角色下拉列表
}

function initRoleSelect() {
    //加载角色下拉列表控件
    $.getJSON("/role/role_list", function (json) {
        $("select[id='rid']").empty();//先清空
        var html = "<option value=''>请选择角色</option>";
        $("select[id='rid']").append(html);
        $(json).each(function () {
            html = "<option value='" + this.id + "'>" + this.name + "</option>";
            console.debug(html);
            $("select[id='rid']").append(html);
        });
    }, "json");
}

//加载用户表格信息
$JACK.initTable("table", {
    url: "user/user_pager",
    //得到查询的参数
    queryParams: function (params) {
        //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        var temp = {
            rows: params.limit,                         //页面大小
            page: (params.offset / params.limit) + 1,   //页码
            sort: params.sort,      //排序列名
            sortOrder: params.order, //排位命令（desc，asc）
            name: $("#name").val(),
            rid: $("#rid").val()
        };
        return temp;
    },
    columns: [
        {
            field: "code",
            title: "编号"
        },
        {
            field: "name",
            title: "姓名"
        },
        {
            field: "gender ",
            title: "性别",
            formatter: function (value, row, index) {
                if (row.usersGender == 0)
                    return "男";
                else
                    return "女";
            }
        },
        {
            field: "role.name",
            title: "角色"
        },
        {
            field: "tel",
            title: "联系电话"
        },
        {
            field: "addr",
            title: "地址"
        },

        {
            field: "state",
            title: "状态",
            formatter: function (value, row, index) {
                if (row.state == 1) return '<span class="badge badge-warning">禁用</span>';
                if (row.state == 0) return '<span class="badge badge-success">正常</span>';
            }
        },
        {
            field: '',
            title: '操作',
            formatter: function (value, row, index) {
                return "<button class='btn  btn-xs  btn-success' id='btn_edit'>编辑</button> " +
                    "<button class='btn btn-xs btn-warning' id='btn_delete'>删除</button> "
            },
            events: {
                "click #btn_edit": function (e, value, row, index) {
                    $JACK.showModal("userdiv", row, initModal, $JACK.DIALOG_STATE_EDIT, scallback, hcallback);
                },
                "click #btn_delete": function (e, value, row, index) {
                    if (window.confirm("确认删除") == 1) {
                        $.getJSON("/user/user_delete?id=" + row.id,
                            function (json) {
                                if (json.msg === "ok") {
                                    $JACK.n_success("删除成功");
                                    $("#table").bootstrapTable("refresh");//刷新表格
                                } else {
                                    $JACK.n_info($.parseJSON(json).msg);
                                }
                            }, "json");
                    }
                }
            }
        }
    ]
});
        	 
