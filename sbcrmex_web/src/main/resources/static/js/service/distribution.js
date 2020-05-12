$(function () {
    // 刷新
    $("#btn_reload").click(function () {
        window.location.href = window.location.href;
    });

    // 返回
    $("#btn_back").click(function () {
        window.history.back(-1);
    });

    $("#btn_search").click(function () {
        $("#service_distribution_list").bootstrapTable("refresh");
    });

    $("#btn_reset").click(function () {
        $("opt_svcNo").val("");
        $("#service_distribution_list").bootstrapTable("refresh");
    });
});

// 加载表格数据
$JACK.initTable("service_distribution_list", {
    url: "service/pager",
    // 得到查询的参数
    queryParams: function (params) {
        // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        var temp = {
            rows: params.limit, // 页面大小
            page: (params.offset / params.limit) + 1, // 页码
            sort: params.sort, // 排序列名
            sortOrder: params.order, // 排位命令（desc，asc）
            status: 0,
            // 状态固定为0
            // 其它查询参数再加
        };
        return temp;
    },
    /*
     * onClickRow:function(row,$element,field){ alert(row.optNo);
     * $("#planchcid").val(row.optNo); },
     */
    columns: [
        {
            field: "id",
            title: "服务编号"
        },
        {
            field: "customer.name",
            title: "客户"

        },
        {
            field: "summary",
            title: "概要"
        },
        {
            field: "svrType",
            title: "服务类型",
            formatter: function (value, row, index) {
                return servcieTypeFormatter(value, row, index);
            }
        },
        {
            field: "cuser.name",
            title: "创建人"

        },
        {
            field: "createdate",
            title: "创建日期"
        },
        {
            field: "status",
            title: "状态",
            formatter: function (value, row, index) {
                return servcieStatusFormatter(value, row, index);
            }
        },
        {
            field: "#",
            title: "分配",
            formatter: function (value, row, index) {
                return "<button class='btn btn-xs btn-success' id='btn_service_distribution'>操作</button>";
            },
            events: {
                "click #btn_service_distribution": function (e, value, row, index) {
                    console.log("click #btn_service_distribution");
                    //显示选择创建人对话框
                    $("#user_list_select_dialog").modal("show");
                    //绑定客户对话框隐藏事件处理方法
                    $("#user_list_select_dialog").on("hide.bs.modal",
                        function () {
                            var rows = $("#user_list_select_dialog").bootstrapTable('getSelections');
                            console.log(rows);
                            if (!(!rows || rows.length == 0)) {
                                //提交数据
                                $.getJSON("/service/distribution",
                                    {
                                        svcNo: row.svcNo,
                                        svcDueNo: rows[0].usersNo
                                    },
                                    function (json) {
                                        console.log(row.svcNo);
                                        if (json.msg == "ok") {
                                            $JACK.n_success("任务分配成功");
                                            $("#service_distribution_list").bootstrapTable("refresh");
                                        } else {
                                            $JACK.n_danger("任务分配失败");
                                        }
                                    })
                            }
                        });
                }
            }
        }]
});

