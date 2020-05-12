$(function () {

})

// 初始化模态窗口中的数据
function initServiceInfoFormData(row) {
    console.log(row);
    $("#serviceinfofrm #id").val(row.id);
    //$("#serviceinfofrm #svcNoDispaly").val(row.svcNo);

    //$("#serviceinfofrm #cstNoValue").val(row.cstNoValue);//
    $("#serviceinfofrm #type").val(row.type);
    $("#serviceinfofrm #summay").val(row.svcSummary);
    $("#serviceinfofrm #status").val(row.svcStatus);
    $("#serviceinfofrm #detail").val(row.svcDetails);
    $("#serviceinfofrm #cuser.name").val(row.cuser.name);//
    $("#serviceinfofrm #createdate").val(row.createdate);
    /*
   $("#serviceinfofrm #duser.name").val(row.duser.name);

   $("#serviceinfofrm #svcDueDate").val(row.svcDueDate);
   $("#serviceinfofrm #svcDoValue").val(row.svcDo);
   $("#serviceinfofrm #svcDoDate").val(row.svcDoDate);
   $("#serviceinfofrm #svcDoContent").val(row.svcDoContent);
   */

    // 回访信息
    /*
    $("#serviceinfofrm #fauser.user").val(row.fauser.user);
    $("#serviceinfofrm #fdcreatetime").val(row.fdcreatetime);
    $("#serviceinfofrm #fresult").val(row.fresult);
    $("#serviceinfofrm #fsatisfy").val(row.fsatisfy);
    */
}
