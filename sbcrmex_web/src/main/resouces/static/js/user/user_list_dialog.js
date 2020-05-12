$(function () {
    $("#btn_user_selection").click(function () {
        var rows = $("#user_list_select_table").bootstrapTable('getSelections');
        // 判断是否选中行
        if (!rows || rows.length == 0) {
            $JACK.n_danger("请先选中一行！")
            return;
        }
        $("#user_list_select_dialog").modal("hide");
    });

    $("#user_list_select_dialog").on("shown.bs.modal", function () {
        // 加载表格数据
        $JACK.initTable("user_list_select_table", {
            url: "user/user_pager",
            height: 300,
            singleSelect: true, // 单选checkbox
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
            columns: [{
                radio: true
            }, {
                field: "code",
                title: "编号"
            }, {
                field: "name",
                title: "姓名"
            }, {
                field: "gender ",
                title: "性别",
                formatter: function (value, row, index) {
                    if (row.usersGender == 0)
                        return "男";
                    else
                        return "女";
                }
            }, {
                field: "role.rname",
                title: "角色"
            }, {
                field: "tel",
                title: "联系电话"
            }]
        });
    })

})// $

