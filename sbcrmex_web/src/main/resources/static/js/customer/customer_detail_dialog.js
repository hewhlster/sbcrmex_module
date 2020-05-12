$(function () {
    $("#customer_detail_dialog").on("shown.bs.modal", function () {

        //加载客户联系人信息
        initCustomerLinkman();
    });

    //绑定新建联系人事件
    $("#btn_new_customer_linkman").click(function () {
        $("#customer_linkman_dialog").modal("show");
    });

    //交往记录事件
    $("#btn-history-communication").click(function () {
        window.location.href = "customer/customer_history_communication_view?cid=${id}&cname=${cname}";
    });
    //历史订单事件

    $("#btn-history-order").click(function () {
        window.location.href = "customer/customer_history_order_view";
    });
    //编辑客户信息
    $("#btn_customer_edit").click(function () {
        $.post("/customer/customer_edit",
            $("#frmcustomer").serialize(),
            function (json) {
                if (json.msg == "ok")
                    alert("编辑成功。")
            }, "json");
    });

    /*	//加载客户基本信息
        function initCustomerBaseInfo(){
            $.post("customer/customer_detail?id="+'${id}',
                    function(json){
                    $("#cstNo").val(json.cstNo);
                    $("#cstName").val(json.cstName);
                    $("#cstRegion").val(json.cstRegion);
                    $("#cstManager").val(json.cstManager);
                    $("#lkmSex").val(json.lkmSex);
                    $("#cstSatisfy").val(json.cstSatisfy);
                    $("#cstAddr").val(json.cstAddr);
                    $("#cstWeb").val(json.cstWeb);
                    $("#cstRemark").val(json.cstRemark);
                    ///////////////////////////////////////
                    $("#cstCredit").val(json.cstCredit);
                    $("#cstLevel").val(json.cstLevel);
                    $("#cstStatus").val(json.cstStatus);
                    $("#cstTel").val(json.cstTel);
            },"json");

        }*/

    function initCustomerLinkman() {
        $("#frmlinkman #lkmCustNo").val($("#clientDetailFrm #cstNo").val());//客户编号，用于操作客户联系人
        $("#customer_linkman_tbl").bootstrapTable('destroy');

        $JACK.initTable("customer_linkman_tbl", {
            url: "customerlinkman/linkman_pager",
            height: 300,
            queryParams: function (params) {
                //这里的键的名字和控制器的变量名必须一直,这边改动,控制器也需要改成一样的
                var temp = {
                    rows: params.limit, //页面大小
                    page: (params.offset / params.limit) + 1, //页码
                    sort: params.sort, //排序列名
                    sortOrder: params.order, //排位命令（desc,asc）
                    cst_no: $("#clientDetailFrm #cstNo").val()
                };
                return temp;
            },
            columns: [{
                field: "name",
                title: "姓名"
            }, {
                field: "lkmPostion",
                title: "职位"
            }, {
                field: "gender",
                title: "性别"
            }, {
                field: "tel1",
                title: "电话"
            }, {
                field: "tel2",
                title: "手机"
            }, {
                field: "memo",
                title: "备注"
            }]
        });
    }

});//$