$(function () {
    // 刷新
    $("#btn_reload").click(function () {
        window.location.href = window.location.href;
    });

    // 返回
    $("#btn_back").click(function () {
        window.history.back(-1);
    });

    //新增
    $("#btn_new").click(function () {
        $JACK.showModal("sale_chance_div",null,initModal,$JACK.DIALOG_STATE_ADD,null,hcallback);
    });

    function hcallback(){
        $("#table").bootstrapTable('refresh');// 刷新Table，Bootstrap Table
    }

/*    $("#salediv").on("hidden.bs.modal", function () {
        setDialogCompoentState("salediv", 1);
        $("#table").bootstrapTable('refresh');// 刷新Table，Bootstrap Table
    });*/

    $("#btn_reset").click(function () {
        $("#opt_CstName").val("");
        $("#opt_LkmName").val("");
        $("#table").bootstrapTable("refresh");
    });

    function customSearch() {
        $("#table").bootstrapTable('refresh');// 刷新Table，Bootstrap Table
        // 会自动执行重新查询
    }


    $JACK.initTable("table", {
        url: "sale/sale_chance_pager",
        // 得到查询的参数
        queryParams: function (params) {
            // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                rows: params.limit, // 页面大小
                page: (params.offset / params.limit) + 1, // 页码
                sort: params.sort, // 排序列名
                sortOrder: params.order, // 排位命令（desc，asc）
                opt_Cst_Name: $("#opt_CstName").val(),
                opt_Lkm_Name: $("#opt_LkmName").val()
            };
            return temp;
        },
        columns: [
            {field: "id", title: "机会编号"},
            {
                field: "cname",
                title: "客源名称"
            },
            {
                field: "lname",
                title: "联系人"
            },
            {
                field: "ltel1",
                title: "联系电话"
            },
            {
                field: "caddr",
                title: "联系地址"
            },
            {
                field: "createdate",
                title: "机会录入时间"
            },
            {
                field: "status",
                title: "单子状态",
                formatter: function (value, index, row) {
                    var ret = "";
                    switch (value) {
                        case "0":
                            ret = "待指派";
                            break;
                        case "1":
                            ret = "以派单";
                            break;
                        case "2":
                            ret = "以关闭";
                            break;
                        case "3":
                            ret = "<font color=red>开发成功</font>";
                            break;
                    }
                    return ret;
                }
            },
            {
                field: "#",
                title: "操作",
                formatter: function (value, row, index) {
                    var ret = "";
                    // 0:没指派1：已指派2：关闭3：以完成
                    switch (row.status) {
                        case "0":
                            ret = "<button id='btn1' class='btn  btn-xs  btn-success' >编辑</button> ";
                            ret = ret
                                + "<button id='btn2'  class='btn btn-xs btn-warning' >指派</button> ";
                            ret = ret
                                + "<button id='btn3' class='btn  btn-xs  btn-info' >关闭</button>";
                            break;
                        case "1":
                        case "2":
                        case "3":
                            ret = "<button class='btn btn-xs btn-success' id='btn4'>详细</a>";
                            break;
                    }
                    return ret;
                },
                events: {

                    "click #btn1": function (e, value, row,
                                             index) {
                        $JACK.showModal("sale_chance_div",null,initModal,$JACK.DIALOG_STATE_EDIT,null,hcallback);
                    },
                    "click #btn2": function (e, value, row,
                                             index) {
                        showModal(3, undefined, row);
                    },
                    "click #btn3": function (e, value, row,
                                             index) {
                        closeOpt(row.optNo);
                    },
                    "click #btn4": function (e, value, row,
                                             index) {
                        $JACK.showModal("sale_chance_div",null,initModal,$JACK.DIALOG_STATE_DETAIL,null,hcallback);
                    }
                }
            }]
    });

}); // $

Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, // month
        "d+": this.getDate(), // day
        "h+": this.getHours(), // hour
        "m+": this.getMinutes(), // minute
        "s+": this.getSeconds(), // second
        "q+": Math.floor((this.getMonth() + 3) / 3), // quarter
        "S": this.getMilliseconds()
        // millisecond
    }
    if (/(y+)/.test(format))
        format = format.replace(RegExp.$1, (this.getFullYear() + "")
            .substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(format))
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
                : ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}

function closeOpt(id) {
    var result = window.confirm("确认关闭销售机会");
    if (result == 1) {// 确认
        $.post("/sale/sale_chance_close?optno=" + id,
            function (json) {
                $JACK.n_success(json.msg);
            });
    }
}

//显示模态窗口
// 0：新建 1:编辑 2：查看  3:指派
//optno：销售机会
function showModal(type, optno, row) {
    console.debug("showModal:row=>" + row);
    console.debug(row);

    this.type = type;

    initModal(row);
    var url = "";
    if (typeof(type) != 'undefined') {
        setDialogCompoentState("sale_chance_div", 0);//设定控件可用模式（全部可用）
        $("#saveOrupdate").val(type);//设定操作方式
        $("#type").val(type);//设定操作方式
        //$("#optNo").val(optNo);//设定编号
        if (type == 2) {//编辑
            setDialogCompoentState("sale_chance_div", 0);
            //$("#optNo").prop("disabled",true);
            //$("#optNo").attr("readonly","readonly");

        }
        else if (type == 3) {//派单
            setDialogCompoentState("sale_chance_div", 1);
            $("#optDueUser").prop("disabled", false);
            $("#optDueDate").prop("disabled", false);
            //$("#optDueUser").removeAttr("readonly");
            //$("#optDueDate").removeAttr("readonly");
            $("#btn_saveorupdate").prop("disabled", false);//开启保存按钮
        }
        else if (type == 1) {//详细
            setDialogCompoentState("sale_chance_div", 2);
            $("#btn_saveorupdate").prop("disabled", true);//禁用保存按钮
        }
    }

    $("#salediv").modal();
}
