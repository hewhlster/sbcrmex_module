$(function () {

});// $


function scallback() {
    if (!$("#resourcediv #state").val())
        $("#resourcediv #state").val("0")
}

function hcallback() {
    $("#resourcediv #state").val(0)
}

function saveOrUpdate() {
    var state = $("#resourcediv #state").val();
    var url = "";
    if (state == 0)
        url = "/resource/add";
    else if (state == 1)
        url = "/resource/update";

    $.ajax({
        url: url,
        method: "post",
        data: $("#frmresource").serialize(),
        success: function (json) {
            if (json.msg == "ok")
                $JACK.n_success("操作成功.");

            $("#resourcediv").modal("hide");
            $("#resource_tbl").bootstrapTable("refresh");//刷新表格
        }
    });
}

function initModal(row) {
    if (row == null) {
        $("#myModalLabel").html("资源-【新增】");

        $("#frmresource")[0].reset();
        $("#fullpath").html("");
    } else {
        $("#myModalLabel").html("资源-【编辑】");

        //加载行数据
        $("#id").val(row.id);
        $("#frmresource input[id='name']").val(row.name);
        $("#frmresource #url").val(row.url);
        $("#gnum").val(row.gnum);
        $("#pid").val(row.pid);

        //$("#frmresource input[name='avalid']").removeAttr("checked");
        //$("#frmresource input[name='avalid']:eq("+row.avalid+")").prop("checked",true);

        //$("#frmresource input[name='adisplay']").removeAttr("checked");
        //$("#frmresource input[name='avalid']:eq("+row.adisplay+")").prop("checked",true);


        $("#frmresource input[name='valid']").removeAttr("checked");
        if (row.valid == 0)
            $("#frmresource input[name='valid']:eq(0)").prop("checked", true);
        else
            $("#frmresource input[name='valid']:eq(1)").prop("checked", true);

        $("#frmresource input[name='valid']").removeAttr("checked");
        if (row.type == 0)
            $("#frmresource input[name='type']:eq(0)").prop("checked", true);
        else
            $("#frmresource input[name='type']:eq(1)").prop("checked", true);

        //if(row.alevel!=1)
        layui.treeSelect.checkNode('tree', row.id);

    }
}
