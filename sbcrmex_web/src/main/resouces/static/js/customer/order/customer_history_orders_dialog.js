$(function () {
    $("#customer_history_orders_dialog").on("hide.bs.modal", function () {
        // initModal();
        // 销毁表格数据
        $("#history_orders_tbl").bootstrapTable("destroy");
    })

    $("#customer_history_orders_dialog")
        .on(
            "shown.bs.modal",
            function () {
                // 加载表格数据
                $JACK
                    .initTable(
                        "history_orders_tbl",
                        {
                            url: "order/customer_history_orders_pager",
                            height: 300,
                            queryParams: function (params) {
                                // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                                var temp = {
                                    rows: params.limit, // 页面大小
                                    page: (params.offset / params.limit) + 1, // 页码
                                    sort: params.sort, // 排序列名
                                    sortOrder: params.order, // 排位命令（desc，asc）
                                    ocid: $("#customer_history_orders_dialog #cstno").val(),
                                };
                                return temp;
                            },
                            columns: [
                                {
                                    field: "id",
                                    title: "订单编号"
                                },
                                {
                                    field: "odate",
                                    title: "订单日期"
                                },
                                {
                                    field: "oaddr",
                                    title: "收货地址"
                                },
                                {
                                    field: "odSummary",
                                    title: "备注"
                                },
                                {
                                    field: "ostatus",
                                    title: "状态",
                                    formatter: function () {
                                        return '<button class="btn btn-xs btn-success" id="btn1">订单详情</button>';
                                    },
                                    events: {
                                        "click #btn1": function (
                                            e, value,
                                            row, index) {
                                            $JACK.showModal("order_detail_dialog", row, initOrderDetaildialog);
                                        }
                                    }
                                }]
                        })
            })
});// end $

