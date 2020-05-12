$(function () {
    // 刷新
    $("#btn_reload").click(function () {
        window.location.href = window.location.href;
    });

    // 返回
    $("#btn_back").click(function () {
        window.history.back(-1);
    });

    // 新建按钮
    $("#btn_new").click(function () {
        $("#customerdialog").modal();
    });

    $("#btn_search").click(function () {
        $("#table").bootstrapTable("refresh");
    });

    $("#btn_reset").click(function () {
        $("#cstName").val("");
        $("#table").bootstrapTable("refresh");
    });
});
// 加载表格数据

$JACK.initTable("product_tbl", {
    url: "product/pager",
    // 得到查询的参数
    queryParams: function (params) {
        // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        var temp = {
            rows: params.limit, // 页面大小
            page: (params.offset / params.limit) + 1, // 页码
            sort: params.sort, // 排序列名
            sortOrder: params.order, // 排位命令（desc，asc）
            pcode: $("#pcode").val(),
            pname: $("#pname").val()
        };
        return temp;
    },
    /*
     * onClickRow:function(row,$element,field){ alert(row.optNo);
     * $("#planchcid").val(row.optNo); },
     */
    columns: [{
        field: "pcode",
        title: "产品编码"
    }, {
        field: "pname",
        title: "品名"
    }, {
        field: "pprice",
        title: "单价"
    }]
});

// /////////////////////////////////////////////////////////////////////////////////////

