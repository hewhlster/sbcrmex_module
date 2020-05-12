$(function () {

    //alert($JACK.getNowFormatDate());

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

//暂缓流失
function customerHistoryPasueLostDialog(cstno, cstname) {
    //cstno:客户编号
    $("#pasue_lost_list_tbl #cstno").val(cstno)
    console.debug("sss-cid===>" + $("#pasue_lost_list_tbl #cstno").val());

    $("#lost_list_dialog #cstName").val(cstname)

    $("#lost_list_dialog").modal('show');

}

//查看详情
function customerHistoryLostDetailDialog(cstno, cstname) {
    $("#lost_list_dialog #cstName").val(cstname);

    $("#lost_list_dialog #myModalLabel").text("流失详情");
    $("#lost_list_dialog #btn_pause_lost_customer_communication_new").css("display", "none");

    $("#lost_list_dialog").modal('show');

}

//确认流失
function confirmLostCustomer(cstno, cstname) {
    if (confirm("流失后不会再向客户提供服务。\n\n确认,将客户【" + cstname + "】认定为流失。") == 1) {
        $.getJSON(
            "/customer/confirm_lost",
            {cid: cstno},
            function (data) {
                if (data.msg == 'ok') {
                    $JACK.refreshTable("cst_lost_tbl");
                } else {
                    $JACK.n_danger("操作失败。");
                }
            }
        );
    }
}


//
//状态
//加载表格数据
$JACK.initTable("cst_lost_tbl", {
    url: "customer/customer_lost_pager",
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
            field: "CST_NO",
            title: "客户编号"
        },
        {
            field: "last_ord_date",
            title: "最后一次下单日期"
        },
        {
            field: "CST_NAME",
            title: "客户名称"
        },
        {
            field: "CST_MANAGER",
            title: "主要联系人"
        },
        {
            field: "CST_TEL",
            title: "联系电话"
        },
        {
            field: "CST_ADDR",
            title: "公司地址"
        },
        {
            field: "CST_STATUS",
            title: "状态",
            formatter: function (value, row, index) {
                if (value == '0') return '<span class="badge badge-success">预警</span>';
                if (value == '1') return '<span class="badge badge-warning">以流失</span>';
            }
        },
        {
            field: "",
            title: "操作",
            formatter: function (value, row, index) {
                if (row.CST_STATUS == '0') return '<button class="btn btn-xs btn-warning" id="btn1">暂缓流失</button> ' +
                    '<button class="btn btn-xs btn-success" id="btn2">确认流失</button>';
                if (row.CST_STATUS == '1') return '<button class="btn btn-xs btn-info" id="btn3">查看详情</button>';

            },
            events: {
                "click #btn1": function (e, value, row, index) {
                    customerHistoryPasueLostDialog(row.CST_NO, row.CST_NAME);
                },
                "click #btn2": function (e, value, row, index) {
                    confirmLostCustomer(row.CST_NO, row.CST_NAME);
                },
                "click #btn3": function (e, value, row, index) {
                    customerHistoryLostDetailDialog(row.CST_NO, row.CST_NAME);
                }
            }
        }]
});
