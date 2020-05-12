//归档JS

$(function () {
    // 刷新
    $("#btn_reload").click(function () {
        $("#service_list_file").bootstrapTable("refresh");
    });

    // 返回
    $("#btn_back").click(function () {
        window.history.back(-1);
    });

    // 批量归档按钮
    $("#btn_service_batch_file").click(function () {
        var rows = $("#service_list_file").bootstrapTable('getSelections');
        // 判断是否选中行
        if (!rows || rows.length == 0) {
            $JACK.n_danger("请先选中一行！")
            return;
        }
        var sIds = new Array();
        for (index in rows) {
            sIds[index] = rows[index].svcNo;
        }
        console.log(sIds);
        //发送请求
        $.getJSON(
            "/service/batchfiles",
            {sids: sIds.toString()},
            function (json) {
                if (json.msg != "ok")
                    $JACK.n_danger("批量归档操作失败");
                else
                    $JACK.n_success("批量归档操作成功");
                $("#service_list_file").bootstrapTable("refresh");
            }
        );

    });

    $("#btn_search").click(function () {
        $("#service_list_file").bootstrapTable("refresh");
    });

    $("#servicedialog").on('hidden.bs.modal', function () {
        $("#service_list_file").bootstrapTable("refresh");
    });


    $("#btn_reset").click(function () {
        $("#cstName").val("");
        $("#service_list_file").bootstrapTable("refresh");
    });
});

//服务归档
function serviceFile(row) {
    //发送请求
    $.getJSON(
        "/service/batchfiles",
        {sids: row.svcNo},
        function (json) {
            if (json.msg != "ok")
                $JACK.n_danger("归档操作失败");
            else
                $JACK.n_success("归档操作成功");

            $("#service_list_file").bootstrapTable("refresh");
        }
    );
}

// 加载表格数据
$JACK.initTable("service_list_file", {
    url: "service/listpager.do",
    singleSelect: false, // 单选checkbox

    // 得到查询的参数
    queryParams: function (params) {
        // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        var temp = {
            rows: params.limit, // 页面大小
            page: (params.offset / params.limit) + 1, // 页码
            sort: params.sort, // 排序列名
            sortOrder: params.order, // 排位命令（desc，asc）
            opt_Cst_Name: $("#opt_CstName").val(),
            opt_Lkm_Name: $("#opt_LkmName").val(),
            status: 3
        };
        return temp;
    },
    /*
     * onClickRow:function(row,$element,field){
     * alert(row.optNo); $("#planchcid").val(row.optNo); },
     */
    columns: [
        {
            checkbox: true
        },
        {
            field: "svcNo",
            title: "服务编号"
        },
        {
            field: "",
            title: "客户",
            formatter: function (value, row, index) {
                var cstName = "";
                // 根据客户编号加载客户
                $
                    .ajax({
                        cache: true,
                        type: "Get",
                        url: "customer/customer_detail.do",
                        dataType: "json",
                        data: {
                            id: row.cstNo
                        },
                        async: false,
                        success: function (json) {
                            cstName = json.cstName;
                        }
                    });
                return cstName;
            }
        },
        {
            field: "svcSummary",
            title: "概要"
        },
        {
            field: "svcType",
            title: "服务类型",
            formatter: function (value, row, index) {
                return servcieTypeFormatter(value, row, index);
            }
        },
        {
            field: "",
            title: "创建人",
            formatter: function (value, row, index) {
                var createname = "";
                // 根据创建编号人查询其姓名
                $.ajax({
                    cache: true,
                    type: "Get",
                    url: "user/user_detail",
                    dataType: "json",
                    data: {
                        id: row.svcCreateNo
                    },
                    async: false,
                    success: function (json) {
                        createname = json.usersName;
                    }
                });
                return createname;
            }
        },
        {
            field: "svcCreateDate",
            title: "创建日期"
        },
        {
            field: "#",
            title: "操作",
            formatter: function (value, row, index) {
                ret = '<button class="btn btn-sm btn-success" id="btn_service_info">查看详细</button>' +
                    '&nbsp;<button class="btn btn-sm btn-success" id="btn_service_file">归档</button>';
                return ret;
            },
            events: {
                "click #btn_service_info": function (e, value, row,
                                                     index) {

                },
                "click #btn_service_file": function (e, value, row,
                                                     index) {
                    //归档操作
                    serviceFile(row);
                }
            }
        }]
});