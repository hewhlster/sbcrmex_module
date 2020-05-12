$(function () {
    // 刷新
    $("#btn_reload").click(function () {
        window.location.href = window.location.href;
    });

    // 返回
    $("#btn_back").click(function () {
        window.history.go(-1);
    });
    // 新建按钮
    $("#btn_customer_new").click(function () {
        $("#customerdialog").modal('show');
    });

    $("#btn_search").click(function () {
        $("#table").bootstrapTable("refresh");
    });

    $("#btn_reset").click(function () {
        $("#cstName").val("");
        $("#table").bootstrapTable("refresh");
    });

});// end $


function showModal(row) {
    initModal(row);
    $("#customer_detail_dialog").modal('show');
}

//交往记录
function customerHistoryCommunicationDialog(row) {
    //cstno:客户编号
    $("#communication_list_tbl #id").val(row.id)
    console.debug("sss-cid===>" + $("#communication_list_tbl #id").val());
    $("#communication_list_dialog #cstName").val(row.name);
}

//历史订单
function customerOrdersDialog(row) {
    //cstno:客户编号
    $("#customer_history_orders_dialog #cstno").val(row.cstNo)
    $("#customer_history_orders_dialog #cstName").val(row.cstName);
}


function initModal(row) {
    if (row != null) {
        $("#clientDetailFrm #id").val(row.id);
        $("#clientDetailFrm #code").val(row.code);
        $("#clientDetailFrm #name").val(row.name);
        $("#clientDetailFrm #cstRegion").val(row.cstRegion);
        $("#clientDetailFrm #manager").val(row.manager);
        $("#clientDetailFrm #gender").val(row.gender);
        $("#clientDetailFrm #cstSatisfy").val(row.cstSatisfy);
        $("#clientDetailFrm #addr").val(row.addr);
        $("#clientDetailFrm #web").val(row.web);
        $("#clientDetailFrm #memo").val(row.memo);
        $("#clientDetailFrm #cstCredit").val(row.cstCredit);
        $("#clientDetailFrm #level").val(row.level);
        $("#clientDetailFrm #status").val(row.status);
        $("#clientDetailFrm #tel").val(row.tel);
    }
}

// 加载表格数据
$JACK.initTable("table", {
    url: "customer/customer_pager",
    height: 600,
    queryParams: function (params) {
        // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        var temp = {
            rows: params.limit, // 页面大小
            page: (params.offset / params.limit) + 1, // 页码
            sort: params.sort, // 排序列名
            sortOrder: params.order, // 排位命令（desc，asc）
            CST_NAME: $("#cstName").val(),
            CST_MANAGER: $("#cstManager").val()
        };
        return temp;
    },
    columns: [
        {
            field: "id",
            title: "",
            visible: false
        },
        {
            field: "code",
            title: "客户编号"
        },
        {
            field: "name",
            title: "客户名称"
        },
        {
            field: "manager",
            title: "主要联系人"
        },
        {
            field: "tel",
            title: "联系电话"
        },
        {
            field: "addr",
            title: "公司地址"
        },
        {
            field: "",
            title: "操作",
            formatter: function () {
                return '<button class="btn btn-xs btn-success" id="btn1">查看详情</button>' +
                    '  <button class="btn btn-xs btn-warning" id="btn2">历史订单</button>' +
                    '  <button class="btn btn-xs btn-info" id="btn3">往来记录</button>';
            },
            events: {
                "click #btn1": function (e, value, row,
                                         index) {
                    //showModal(row);
                    $JACK.showModal("customer_detail_dialog", row, initModal);
                },
                "click #btn2": function (e, value, row,
                                         index) {
                    $JACK.showModal("customer_history_orders_dialog", row, customerOrdersDialog);
                }
                ,
                "click #btn3": function (e, value, row,
                                         index) {
                    $JACK.showModal("communication_list_dialog", row, customerHistoryCommunicationDialog);
                }
            }
        }]
});
