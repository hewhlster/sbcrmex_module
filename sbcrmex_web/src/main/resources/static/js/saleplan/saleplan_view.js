$(function () {

    //刷新
    $("#btn_reload").click(function () {
        $("#table").bootstrapTable('refresh');//刷新Table，Bootstrap Table 会自动执行重新查询
    });

    //返回
    $("#btn_back").click(function () {
        window.history.back(-1);
    });

    $("#btn_search").click(function () {
        $JACK.refreshTable("table");
        $("#table").bootstrapTable('refresh');//刷新Table，Bootstrap Table 会自动执行重新查询
    });
    $("#btn_reset").click(function () {
        $("#opt_CstName").val("");
        $("#opt_LkmName").val("");
        $JACK.refreshTable("table");
    });
});// end $

//加载销售机会数据
$JACK.initTable("table", {
    url: "/sale/sale_plan_pager",
    //得到查询的参数
    queryParams: function (params) {
        //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        var temp = {
            rows: params.limit,                         //页面大小
            page: (params.offset / params.limit) + 1,   //页码
            sort: params.sort,      //排序列名
            sortOrder: params.order, //排位命令（desc，asc）
            opt_Cst_Name: $("#opt_CstName").val(),
            opt_Lkm_Name: $("#opt_LkmName").val()
        };
        return temp;
    },
    columns: [
        {
            field: "id",
            title: "机会编号"
        },

        {
            field: "optCstName",
            title: "客源名称"
        },
        {
            field: "optLkmName",
            title: "联系人"
        },
        {
            field: "optLkmTel",
            title: "联系电话"
        },
        {
            field: "optSummary",
            title: "需求概要"
        },
        {
            field: "optCreateDate",
            title: "机会录入时间"
        },
        {
            field: "optStatus",
            title: "状态",
            formatter: function (value, row, index) {
                var ret = "";
                //0:没指派1：已指派2：关闭3：以完成
                switch (row.optStatus) {
                    //制定计划
                    case "1":
                        ret = "<font color=blue>正在开发</font>";
                        break;
                    //归档
                    case "2":
                    case "3":
                        ret = "<font color=red>以归档</font>";
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
                //0:没指派1：已指派2：关闭3：以完成
                switch (row.optStatus) {
                    //制定计划
                    case "1":
                        ret = '<button class="btn btn-xs btn-info" id="btn1">计划</button>';
                        break;
                    //归档
                    case "2":
                    case "3":
                        ret = '<button class="btn btn-xs  btn-success" id="btn2">查看详情</button>';
                        break;
                }
                return ret;
            },
            events: {
                "click #btn1": function (e, value, row, index) {
                    //window.location.href="/sale/sale_plan_detail_view?cid="+row.optNo;
                    showModal(1, row);
                },
                "click #btn2": function (e, value, row, index) {
                    //window.location.href="/sale/sale_plan_detail_view?cid="+row.optNo;
                    showModal(0, row);
                }
            }
        }
    ]
})

///////////////////////////////////////////////////////////////////////////////////////
function submitFrom() {
    $('#saleplanfrm').bootstrapValidator('validate');
    var formState = $('#saleplanfrm').data('bootstrapValidator').isValid();
    if (formState) {
        url = "/sale/saleplansaveordelete.do";
        $.ajax({
                cache: false,
                type: "post",
                url: url,
                data: $("#saleplanfrm").serialize(),
                async: true,
                error: function (request) {
                    alert("新增销售机会失败！！");
                },
                success: function (data) {
                    var result = window.confirm("操作成功，是否继续增加");
                    if (result == 1) {//确认
                        initFormData();
                    } else {
                        window.location.reload();
                    }
                }
            }
        );
    }
}


//type:显示方式 0：全打开 1：全禁用
function setDialogCompoentState(div, type) {
    if (type == 0) {
        $("#" + div).find("form").each(function () {
            $(this).find("input,select,textarea").each(function () {
                $(this).prop("disabled", false);
            });
        });
        $("#" + div).find("button[id='btn_saveorupdate']").prop("disabled", false);
        //$("#myModalLabel").text($("#myModalLabel").text()+"-新增");
    } else if (type == 1) {
        $("#" + div).find("form").each(function () {
            $(this).find("input,select,textarea,button").each(function () {
                $(this).prop("disabled", true);
            });
        })
        $("#" + div).find("button[id='btn_saveorupdate']").prop("disabled", true);
        //$("#myModalLabel").text($("#myModalLabel").text().replace("-详细","-详细"));
    }

}

//初始化模态窗口中的数据
function initFormData(row) {
    console.debug("saleplan=>row:");
    console.debug(row);
    $("#optNo").val(row.optNo);
    $("#optSource").val(row.optSource);
    $("#optCstName").val(row.optCstName);
    $("#optRate").val(row.optRate);
    $("#optLkmName").val(row.optLkmName);
    $("#optSummary").val(row.optSummary);
    $("#optremark").val(row.optremark);
    $("#optLkmTel").val(row.optLkmTel);
    $("#optLkmPosition").val(row.optLkmPosition);
    $("#optDesc").val(row.optDesc);
    $("#optCreateName").val(row.optCreateName);
    $("#optCreateDate").val(row.optCreateDate);
    //$("#optDueUser").val(row.optdueuser.usersName);
    $("#optStatus").val(row.optStatus);
    $("#optDueDate").val(row.optDueDate);

    //初始化日期控件
    //$("#optCreateDate").val(new Date().format("yyyy-MM-dd"));

    /*
    $.post("<%=basePath%>user/userlistrole.do",function(data){
         $("#optDueUser").empty();//先清空
         html="<option value=''>暂不指派</option>";
                $("#optDueUser").append(html);
                 $(data).each(function(){
             html="<option value='"+this.usersNo+"'>"+this.usersName+"</option>";
             $("#optDueUser").append(html);
         })
    },"json");
    //$("#optCreateDate").val(new now());
    //$("#optDueDate").val(new now());
    */
}


//显示模态窗口
//type:显示方式  0：查看 1:计划
//data:初始化数据
function showModal(type, data) {
    initFormData(data);
    $("#sale_plan_dialog").modal("show");
}

function closeOpt(id) {
    var result = window.confirm("确认删除");
    if (result == 1) {//确认
        $.post("/sale/saleclose.do?optno=" + id,
            function () {
                window.location.reload();
            });
    }
}

//////////////////////////////////////////////////////////////////////////////////////
function salePlanState(value, row, index) {
    //计划状态 0：正在执行 1：执行失败 2：执行失败
    var ret = "";
    switch (value) {
        case 0:
            ret = "正在执行";
            break;
        case 1:
            ret = "正在执行";

            break;
        case 2:
            ret = "执行失败";
            break;
    }
    return ret;
}


function stateFormatter(value, row, index) {
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
            ret = "以完成";
            break;
    }
    return ret;
}
	
	
	