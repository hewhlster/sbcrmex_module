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
    $("#btn_customer_communication_new").click(function () {

        $("#frmcommunication #cid").val($("#communication_list_tbl #cstno").val());

        console.debug("cid===>" + $("#frmcommunication #cid").val());
        $("#communication_add_dialog").modal();
    });

    $("#btn_search").click(function () {
        $("#table").bootstrapTable("refresh");
    });

    $("#btn_reset").click(function () {
        $("#addr").val();
        $("#table").bootstrapTable("refresh");
    });

    $("#communication_list_dialog").on("shown.bs.modal", function () {
        $("#communication_list_tbl").bootstrapTable('destroy');

        // 加载表格数据
        $JACK.initTable("communication_list_tbl", {
            url: "customer/customer_communication_pager",
            height: 300,
            // 得到查询的参数
            queryParams: function (params) {
                // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                var temp = {
                    rows: params.limit, // 页面大小
                    page: (params.offset / params.limit) + 1, // 页码
                    sort: params.sort, // 排序列名
                    sortOrder: params.order, // 排位命令（desc，asc）
                    cid: $("#communication_list_tbl #cstno").val(),
                    addr: $("#addr").val(),
                };
                return temp;
            },
            columns: [
                {
                    field: "id",
                    title: "编号"
                },
                {
                    field: "user.usersName",
                    title: "发起者"
                }, {
                    field: "date",
                    title: "日期"
                }, {
                    field: "addr",
                    title: "地点"
                }, {
                    field: "memo",
                    title: "交流内容"
                }]
        });


    })

    // 初始化模态窗口中的数据
    function initModal() {
        document.getElementById("frmcommunication").reset();
    }

    // type:显示方式 0：全打开 1：全禁用
    function setDialogCompoentState(div, type) {
        if (type == 0) {
            $("#" + div).find("form").each(function () {
                $(this).find("input,select,textarea").each(function () {
                    $(this).prop("disabled", false);
                });
            });
            $("#" + div).find("button[id='btn_saveorupdate']").prop("disabled",
                false);
            // $("#myModalLabel").text($("#myModalLabel").text()+"-新增");
        } else if (type == 1) {
            $("#" + div).find("form").each(function () {
                $(this).find("input,select,textarea,button").each(function () {
                    $(this).prop("disabled", true);
                });
            })
            $("#" + div).find("button[id='btn_saveorupdate']").prop("disabled",
                true);
            // $("#myModalLabel").text($("#myModalLabel").text().replace("-详细","-详细"));
        }

    }

    // 显示模态窗口
    // type:显示方式 0：新建 1：查看 2:编辑 3:指派
    // optno：销售机会
    function showModal(type, optno) {

        $("#saleplandiv").modal();
    }
})