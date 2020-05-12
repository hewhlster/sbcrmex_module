$(function () {
    // 刷新
    $("#btn_reload").click(function () {
        $("#service_list_table").bootstrapTable("refresh");
    });

    // 返回
    $("#btn_back").click(function () {
        window.history.back(-1);
    });

    // 新建按钮
    $("#btn_service_new").click(function () {
        $("#servicedialog").modal('show');
    });

    $("#btn_search").click(function () {
        $("#service_list_table").bootstrapTable("refresh");
    });

    $("#serviceinfodialog").on('hidden.bs.modal', function () {
        $("#service_list_table").bootstrapTable("refresh");
    });

    $("#btn_reset").click(function () {
        $("#cstName").val("");
        $("#service_list_table").bootstrapTable("refresh");
    });


// 加载表格数据
    $JACK.initTable("service_list_table", {
        url: "service/pager",
        // 得到查询的参数
        queryParams: function (params) {
            // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                rows: params.limit, // 页面大小
                page: (params.offset / params.limit) + 1, // 页码
                sort: params.sort, // 排序列名
                sortOrder: params.order, // 排位命令（desc，asc）
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
                field: "type",
                title: "服务类型",
                formatter: function (value, row, index) {
                    return servcieTypeFormatter(row.type);
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
                    return servcieStatusFormatter(row.status);
                }
            },
            {
                field: "opt",
                title: "操作",
                formatter: function (value, row, index) {
                    ret = '<button class="btn btn-xs btn-success" id="btn_service_info">查看详细</button>';
                    return ret;
                },
                events: {
                    "click #btn_service_info": function (e, value, row,
                                                         index) {
                        console.log(value + "  " + index);
                        //initServiceInfoFormData(row);
                        //$("#serviceinfodialog").modal("show");
                        $JACK.showModal("serviceinfodialog", row, initServiceInfoFormData);
                    }
                }
            }]
    });
}) // $
