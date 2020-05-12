$(function () {
    //刷新
    $("#btn_reload").click(function () {
        window.location.href = window.location.href;
    });

    //返回
    $("#btn_back").click(function () {
        window.history.go(-1);
    });
});

//绑定查询按钮事件
$("#btn_search").click(function () {
    $("#table").bootstrapTable("refresh");//刷新表格
});

//绑定查询重置事件
$("#btn_reset").click(function () {
    $("#user").val("");//清空
    $("#table").bootstrapTable("refresh");//刷新表格
});

//绑定层关闭事件
$("#userdiv").on("hidden.bs.modal", function () {
    //初始化控件
    document.getElementById("frmuser").reset();
});

//绑定资源层关闭事件
$("#userdiv").on("hidden.bs.modal", function () {
    //$("#resourcetree").
    //alert(55555);
});

function initRoleSelect() {
    //加载角色下拉列表控件
    $.post("role/role_list", function (json) {
        $("select[id='users_rid']").empty();//先清空
        var html = "<option value=''>请选择角色</option>";
        $("select[id='users_rid']").append(html);
        $(json).each(function () {
            html = "<option value='" + this.rid + "'>" + this.rname + "</option>";
            $("select[id='users_rid']").append(html);
        });

        ///////////////////////////////////////////////////////
        $("select[id='usersRid']").empty();//先清空
        var html = "<option value=''>请选择角色</option>";
        $("select[id='usersRid']").append(html);
        $(json).each(function () {
            html = "<option value='" + this.rid + "'>" + this.rname + "</option>";
            $("select[id='usersRid']").append(html);
        })

    }, "json");
}

$JACK.initTable("table", {
    url: "optlog/optlog_pager",
    //得到查询的参数
    queryParams: function (params) {
        //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        var temp = {
            rows: params.limit,                         //页面大小
            page: (params.offset / params.limit) + 1,   //页码
            sort: params.sort,      //排序列名
            sortOrder: params.order, //排位命令（desc，asc）
            user: $("#user").val(),
            date: $("#date").val()
        };
        return temp;
    },
    columns: [
        {
            field: "user",
            title: "操作者"
        },
        {
            field: "ip",
            title: "操作IP"
        },
        {
            field: "url",
            title: "请求资源"
        },
        {
            field: "data",
            title: "操作数据"
        },
        {
            field: "date",
            title: "操作日期"
        },
        {
            field: "ret",
            title: "操作结果"
        },

    ]
});

