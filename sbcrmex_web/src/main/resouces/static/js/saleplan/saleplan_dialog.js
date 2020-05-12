//var salechanceid = '${requestScope.cid}';// 接收销售机会ID
//var loginuid = '${sessionScope.logineduser.usersNo}';

$(function () {
    // 设定saleplanfrm上所有控件为不可编辑
    $("#saleplanfrm :input").each(function () {
        $(this).prop("disabled", true);
    });
    // alert(salechanceid);
    // alert(loginuid);
    // 完成开发计划
    $("#btn-ok").click(
        function () {
            var val = $(this).text();
            var ret = window.confirm("确认【" + val + "】操作");
            // alert(ret);
            if (ret == true) {
                var url = "/sale/sale_chance_end?optno=" + $("#optNo").val()
                    + "&status=3";
                $.getJSON(url, function (data) {
                    alert(data.msg);
                    if (data.msg == "ok") {
                        $JACK.n_success("本次销售机会以取得成功，客源信息以自动加入客户数据库。");
                        $("#sale_plan_dialog").modal('hide');
                    } else {
                        $JACK.n_danger("本次操作失败。");
                    }
                });

            }
        });
    $("#btn-fail").click(
        function () {
            var val = $(this).text();
            var ret = window.confirm("确认【" + val + "】操作");
            // alert(ret);
            if (ret == true) {
                var url = "/sale/sale_chance_end?optno=" + $("#optNo").val()
                    + "&status=2";
                $.getJSON(url, function (data) {
                    if (data.msg == "ok") {
                        $JACK.n_success("以终结了本次销售机会，还要多加努力！");
                        $("#sale_plan_dialog").modal('hide');
                    } else {
                        $JACK.n_danger("本次操作失败。");
                    }
                });
            }
        });


    /*
     * //加载销售机会数据 $.ajax( { url:"/sale/salchancget.do?optno="+salechanceid,
     * async:true, dataType:"json", success:function(json){
     * $("#optNo").val(json.optNo); $("#optSource").val(json.optSource);
     * $("#optCstName").val(json.optCstName); $("#optRate").val(json.optRate);
     * $("#optLkmName").val(json.optLkmName);
     * $("#optSummary").val(json.optSummary);
     * $("#optremark").val(json.optremark); $("#optLkmTel").val(json.optLkmTel);
     * $("#optLkmPosition").val(json.optLkmPosition);
     * $("#optDesc").val(json.optDesc);
     * $("#optCreateName").val(json.optCreateName);
     * $("#optCreateDate").val(json.optCreateDate);
     * $("#optDueUser").val(json.optDueUser);
     * $("#optStatus").val(json.optStatus);
     * //$("#optcreateuser").val(json.optcreateuser.userName);
     * $("#optdueuser").val(json.optdueuser.userName);
     * $("#optDueDate").val(json.optDueDate); } } );
     */

    $("#sale_plan_dialog").on("shown.bs.modal",
        function () {
            $("#sale_plan_item_tbl").bootstrapTable('destroy');

            // 加载计划项目数据
            $JACK.initTable("sale_plan_item_tbl", {
                url: "sale/sale_plan_pager.do",
                queryParams: function (params) {
                    // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    var temp = {
                        rows: params.limit, // 页面大小
                        page: (params.offset / params.limit) + 1, // 页码
                        sort: params.sort, // 排序列名
                        sortOrder: params.order, // 排位命令（desc，asc）
                        pla_chc_id: $("#optNo").val()
                    };
                    return temp;
                },
                columns: [
                    {
                        field: "planid",
                        title: "计划编号",
                        visible: true
                    },
                    {
                        field: "planchcid",
                        title: "机会编号",
                        visible: false
                    },
                    {
                        field: "plandate",
                        title: "制定日期",
                        editable: {
                            type: "date",
                            format: "yyyy/mm/dd"
                        }
                    },
                    {
                        field: "plantodo",
                        title: "计划内容",
                        editable: {
                            type: 'textarea',
                            validate: function (
                                value) {
                                if ($
                                    .trim(value) == '') {
                                    return '内容不能为空!';
                                }
                            }
                        }
                    },
                    {
                        field: "planresult",
                        title: "执行结果",
                        editable: {
                            type: "textarea"
                        }
                    },
                    {
                        field: "#",
                        title: "操作",
                        formatter: function (
                            value, row,
                            index) {
                            if (row.planstatus == 0)
                                return "<button id='btn' class='btn btn-xs btn-danger'>执行计划</button>";
                            else if (row.planstatus == 2)
                                return "<button id='btn1' class='btn  btn-xs btn-info'>保存</button>";
                            else if (row.planstatus == 1)
                                return "执行完成";

                        },
                        events: {
                            "click #btn": function (e, value, row, index) {
                                $.getJSON("/sale/sale_plan_exec.do",
                                    {planid: row.planid, planresult: row.planresult},
                                    function (data) {
                                        if (data.msg == 'ok') {
                                            $JACK.n_success("计划执行成功");
                                            $(
                                                "#sale_plan_item_tbl")
                                                .bootstrapTable(
                                                    "refresh");
                                        }
                                    });

                            },
                            "click #btn1": function (
                                e, value,
                                row, index) {
                                $
                                    .getJSON(
                                        "/sale/sale_plan_save.do",
                                        row,
                                        function (data) {
                                            if (data.msg == 'ok') {
                                                $JACK.n_success("新增成功");
                                                $("#sale_plan_item_tbl").bootstrapTable("refresh");
                                            }
                                        });
                            }
                        }
                    }]
            });

        })
})

// 增加新行
function addNewRow() {
    $("#sale_plan_item_tbl").bootstrapTable("insertRow",
        {
            index: $('#sale_plan_item_tbl').bootstrapTable(
                'getOptions').totalRows,
            row: {
                "planchcid": $("#optNo").val(),
                "plandate": $JACK.getNowFormatDate(),
                "plantodo": "",
                "planresult": "",
                "planstatus": "2"
            }
        });
}