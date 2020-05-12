$(function () {
    // 新建按钮
    $("#btn_pause_lost_customer_communication_new").click(function () {
        $("#pause_lost_communication_add_dialog").modal('show');
    });

    $("#btn_search").click(function () {
        $("#pasue_lost_list_tbl").bootstrapTable("refresh");
    });

    $("#btn_reset").click(function () {
        $("#cstName").val("");
        $("#pasue_lost_list_tbl").bootstrapTable("refresh");
    });

    $("#lost_list_dialog").on("hide.bs.modal", function () {
        // initModal();
        $("#lost_list_dialog #btn_pause_lost_customer_communication_new").css("display", "");

        // 销毁表格数据
        $("#pasue_lost_list_tbl").bootstrapTable("destroy");
    })

    $("#lost_list_dialog").on(
        "show.bs.modal",
        function () {
            // 加载表格数据
            $JACK.initTable("pasue_lost_list_tbl", {
                url: "/customer/customer_pasue_lost_communication_pager",
                queryParams: function (params) {
                    // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    var temp = {
                        rows: params.limit, // 页面大小
                        page: (params.offset / params.limit) + 1, // 页码
                        sort: params.sort, // 排序列名
                        sortOrder: params.order, // 排位命令（desc，asc）
                        cid: $(
                            "#pasue_lost_list_tbl #cstno")
                            .val(),
                    };
                    return temp;
                },
                columns: [
                    {
                        field: "id",
                        title: "编号"
                    },
                    {
                        field: "date",
                        title: "沟通日期"
                    },
                    {
                        field: "addr",
                        title: "沟通地点"
                    },
                    {
                        field: "memo",
                        title: "采取措施"
                    }
                ]
            });
        })
});// end $
