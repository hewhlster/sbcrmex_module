$(function () {
    $("#order_detail_dialog").on("shown.bs.modal", function () {
        $JACK.initTable("order_item_tbl", {
            url: "order/order_items_pager",
            height: 300,
            showFooter: true,//显示底部
            // 得到查询的参数
            queryParams: function (params) {
                // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                var temp = {
                    rows: params.limit, // 页面大小
                    page: (params.offset / params.limit) + 1, // 页码
                    sort: params.sort, // 排序列名
                    sortOrder: params.order, // 排位命令（desc，asc）
                    oid: $("#oid").val()
                };
                return temp;
            },
            columns: [{
                field: "pcode",
                title: "产品编码",
                footerFormatter: function (data) {
                    return "合计";
                }
            }, {
                field: "pname",
                title: "品名"
            }, {
                field: "count",
                title: "数量"
                ,
                footerFormatter: function (data) {
                    var sum = 0;
                    for (var i in data) {
                        sum = sum + data[i].count;
                    }
                    return "【" + sum + "】件";
                }
            }, {
                field: "pprice",
                title: "单价"
            }, {
                field: "",
                title: "总价",
                formatter: function (value, row, index) {
                    return row.count * row.pprice;
                },
                footerFormatter: function (data) {
                    var sum = 0;
                    for (var i in data) {
                        sum = sum + data[i].count * data[i].pprice;
                    }
                    return "【" + sum + "】元";
                }
            }]
        });
    });

    $("#order_detail_dialog").on("hidden.bs.modal", function () {
        $("#order_item_tbl").bootstrapTable('destroy');
    });

})// $

function initOrderDetaildialog(row) {
    $("#oid").val(row.id);
    $("#odate").val(row.odate);
    $("#ocstname").val(row.ocstname);
    $("#oaddr").val(row.oaddr);
    $("#ostatus").val(row.ostatus);
}

