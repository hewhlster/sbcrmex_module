$(function () {
    //绑定查询按钮事件
    $("#btn_search").click(function () {
        $JACK.refreshTable("ord_tbl");
    })

    $("#btn_reset").click(function () {
        $("#oid").val("");
        $JACK.refreshTable("ord_tbl");
    })

    $JACK.initTable("ord_tbl", {
        url: "order/customer_history_orders_pager",
        // 得到查询的参数
        queryParams: function (params) {
            // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                rows: params.limit, // 页面大小
                page: (params.offset / params.limit) + 1, // 页码
                sort: params.sort, // 排序列名
                sortOrder: params.order, // 排位命令（desc，asc）
                id: $("#oid").val()
            };
            return temp;
        },
        columns: [{
            field: "id",
            title: "订单编号"
        }, {
            field: "oname",
            title: "订单名称"
        }, {
            field: "odate",
            title: "日期"
        },
            {
                field: "ocstname",
                title: "客户"
            },
            {
                field: "oaddr",
                title: "收货地址"
            }, {
                field: "ostatus",
                title: "状态"
            },
            {
                field: "",
                title: "详细",
                formatter: function (value, row, index) {
                    return "<button id='btn_order_detail' class='btn  btn-xs  btn-success'>详细</button>";
                },
                events: {
                    "click #btn_order_detail": function (e, value, row, index) {
                        $JACK.showModal("order_detail_dialog", row, initOrderDetaildialog);
                        //$("#order_detail_dialog").modal('show');
                    }
                }
            }]
    });
}) //$

