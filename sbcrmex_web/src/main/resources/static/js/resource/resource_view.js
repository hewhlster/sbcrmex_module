//加载表格数据
$("#resource_tbl").bootstrapTreeTable({
    id: 'id', // 选取记录返回的值
    code: 'id',
    rootCodeValue: '6ac75256180a11e99cd73c970e47457', // 用于设置父子关系
    parentCode: 'pid', // 用于设置父子关系
    bordered: true,
    expandColumn: '1',
    expandAll: false,
    url: "/resource/pager",
    method: 'post',                     //请求方式（*）
    striped: true,                      //是否显示行间隔色
    ajaxParams: {
        aname: $("#aname").val(),
        aaction: $("#aaction").val()
    },
    columns: [{
        field: "#",
        title: "序号",
        width: '50px',
        formatter: function (item, index) {
            return tableIndex++;
        }
    },
        {
            field: 'name',
            title: '资源名称',
            width: '300px',

        }, {
            field: 'url',
            title: '资源编码'
        }, {
            field: 'gnum',
            title: '组内序号',
            width: '80px',
        }, {
            field: 'valid',
            title: '状态',
            width: '50px',
            formatter: function (item, index) {
                if (item.valid == 1) return '<span class="badge badge-warning">启用</span>';
                if (item.valid == 0) return '<span class="badge badge-success">禁用</span>';

            }
        }, {
            field: 'type',
            title: '类型',
            width: '70px',
            formatter: function (item, index) {
                //console.debug("-->"+item.type);
                if (item.type == 1) return '<span class="badge badge-warning">菜单</span>';
                if (item.type == 0) return '<span class="badge badge-success">功能</span>';
            }
        }, {
            field: 'icon',
            title: '图标',
            width: '70px',
            formatter: function (item, index) {
                //console.debug("<li class='" + row.icon + "'></li>");
                if (item.icon == null || item == "") {
                    return item.menuName;
                } else {
                    return '<i class="' + item.icon + '"></i>';
                }
            }
        }, {
            field: '',
            title: '操作',
            formatter: function (item, index) {
                return "<button class='btn btn-xs  btn-success' id='btn_edit'>编辑</button> " +
                    "<button class='btn btn-xs btn-warning' id='btn_delete'>删除</button> ";
            },
            events: {
                "click #btn_edit": function (e, value, row, index) {
                    $JACK.showModal("resourcediv", row, initModal, 1, null, hcallback);
                    //弹出编辑层
                    $("#resourcediv").modal();
                },
                "click #btn_delete": function (e, value, row, index) {
                    if (window.confirm("确认删除") == 1) {
                        $.post("/resource/delete?id=" + row.id, function (json) {
                            if (json.msg == "ok")
                                $JACK.n_success("删除成功");
                            $("#resource_tbl").bootstrapTable("refresh");//刷新表格
                        }, "json");
                    }
                }
            }
        }]
});


$(function () {
    //刷新
    $("#btn_reload").click(function () {
        window.location.href = window.location.href;
    });

    //返回
    $("#btn_back").click(function () {
        window.history.back(-1);
    });

    //绑定新增按钮事件
    $("#btn_new").click(function () {
        $JACK.showModal("resourcediv", null, null, 0, scallback, hcallback);
    })

    //绑定提交按钮事件
    $("#btn_submit").click(function () {
        saveOrUpdate();
    })

    //绑定查询按钮事件
    $("#btn_search").click(function () {
        $("#table").bootstrapTreeTable("refresh");//刷新表格
    })

    //绑定查询重置事件
    $("#btn_reset").click(function () {
        $("#aname").val("");//清空
        $("#aaction").val("");//清空

        $("#resource_tbl").bootstrapTreeTable("refresh");//刷新表格
    })

}) // $	
		