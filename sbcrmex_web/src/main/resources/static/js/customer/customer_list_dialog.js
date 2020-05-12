$(function () {
    $("#btn_customer_selection").click(function () {
        var rows = $("#customer_list_table").bootstrapTable('getSelections');
        // 判断是否选中行
        if (!rows || rows.length == 0) {
            $JACK.n_danger("请先选中一行！")
            return;
        }
        $("#customer_list_dialog").modal("hide");
    });

    $("#customer_list_dialog").on("shown.bs.modal", function () {
        // 加载表格数据

        $JACK.initTable("customer_list_table", {
            url: "customer/customer_pager",
            singleSelect: true, // 单选checkbox
            queryParams: function (params) {
                // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                var temp = {
                    rows: params.limit, // 页面大小
                    page: (params.offset / params.limit) + 1, // 页码
                    sort: params.sort, // 排序列名
                    sortOrder: params.order, // 排位命令（desc，asc）
                    status: 0
                };
                return temp;
            },
            columns: [{
                radio: true
            }, {
                field: "name",
                title: "客户名称"
            }, {
                field: "manager",
                title: "主要联系人"
            }, {
                field: "tel",
                title: "联系电话"
            }]
        });


    })

})// $

