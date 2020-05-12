$(function () {
    // 刷新
    $("#btn_reload").click(function () {
        $("#service_list_detail").bootstrapTable("refresh");
    });

    // 返回
    $("#btn_back").click(function () {
        window.history.back(-1);
    });


    $("#btn_search").click(function () {
        $("#service_list_detail").bootstrapTable("refresh");
    });

    $("#servicedialog").on('hidden.bs.modal', function () {
        $("#service_list_detail").bootstrapTable("refresh");
    });


    $("#btn_reset").click(function () {
        $("#cstName").val("");
        $("#table").bootstrapTable("refresh");
    });
});

// 显示模态窗口
// type:显示方式 0：新建 1：查看 2:编辑 3:指派
// optno：销售机会
function showModal(type, optno) {
    $("#servicedialog").modal();
}

// 加载表格数据
$JACK.initTable("service_list_detail", {
    url: "service/pager",
    // 得到查询的参数
    queryParams: function (params) {
        // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        var temp = {
            rows: params.limit, // 页面大小
            page: (params.offset / params.limit) + 1, // 页码
            sort: params.sort, // 排序列名
            sortOrder: params.order, // 排位命令（desc，asc）
            SVC_NO: $("#opt_svcNo").val(),
            SVC_STATUS: 1
        };
        return temp;
    },
    /*
     * onClickRow:function(row,$element,field){
     * alert(row.optNo); $("#planchcid").val(row.optNo); },
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
            title: "操作",
            formatter: function (value, row, index) {
                ret = '<button class="btn btn-sm btn-success" id="btn_service_detail">处理</button>';
                return ret;
            },
            events: {
                "click #btn_service_detail": function (e, value, row,
                                                       index) {
                    initFormData(row);
                    $("#servicedetaildialog").modal("show");
                }
            }
        }]
});