var saveorupdate = 0;//保存或更新 0 保存 1更新

function showModal() {
    saveorupdate = 0;
    $("#rolediv").modal();
}

function saveOrUpdate() {
    var url = "";
    if (saveorupdate == 0)
        url = "/role/role_add";
    else if (saveorupdate == 1)
        url = "/role/role_update";

    $.ajax({
        url: url,
        method: "post",
        data: $("#frmroledialog").serialize(),
        success: function (json) {
            if (json.msg == "ok")
                $JACK.n_success("操作成功。");
            else
                $JACK.n_danger("操作失败！！");


            $("#rolediv").modal("hide");
            $("#table").bootstrapTable("refresh");//刷新表格
        }
    });
}

function initModal(row) {
    if (row == null) {
        //清空
        //$("#frmroledialog input").each(function(){
        //	$(this).val("");
        //})
        $("#frmroledialog")[0].reset();
    } else {
        //加载行数据
        $("#frmroledialog #id").val(row.id);
        $("#frmroledialog input[id='name']").val(row.name);
        $("#frmroledialog #memo").val(row.memo);
    }
}

//加载表格数据
$JACK.initTable("table", {
    url: "role/role_pager",
    //得到查询的参数
    queryParams: function (params) {
        //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
        var temp = {
            rows: params.limit,                         //页面大小
            page: (params.offset / params.limit) + 1,   //页码
            sort: params.sort,      //排序列名
            sortOrder: params.order, //排位命令（desc，asc）
            rname: $("#name").val()
        };
        return temp;
    },
    columns: [
        {
            field: 'name',
            title: '角色名称'
        }, {
            field: 'memo',
            title: '职责'
        }, {
            field: 'createdate',
            title: '创建时间'
        },
        {
            field: 'updatedate',
            title: '更新时间'
        }, {
            field: '',
            title: '操作',
            formatter: function (value, row, index) {
                return "<button class='btn  btn-xs  btn-success' id='btn_edit'>编辑</button> " +
                    "<button class='btn btn-xs btn-warning' id='btn_delete'>删除</button> " +
                    "<button class='btn  btn-xs  btn-info' id='btn_edit_role'>编辑权限</button> ";
            },
            events: {
                "click #btn_edit": function (e, value, row, index) {
                    saveorupdate = 1;
                    initModal(row);
                    //弹出编辑层
                    $("#rolediv").modal();
                },
                "click #btn_delete": function (e, value, row, index) {
                    if (window.confirm("确认删除") == 1) {
                        $.post("/role/role_delete?id=" + row.id, function (json) {
                            if (json.msg == "ok") {
                                $JACK.n_success("删除成功");
                                $("#table").bootstrapTable("refresh");//刷新表格
                            } else {
                                $JACK.n_success(json.msg);
                            }

                            $("#roleresourcedialog").modal("hide");
                        }, "json");
                    }
                },
                "click #btn_edit_role": function (e, value, row, index) {
                    $("#role_id").val(row.id);//保存角色ID
                    //弹出权限层
                    $("#roleresourcedialog").modal();
                }
            }
        }]
});


//绑定新增按钮事件
$("#btn_new").click(function () {
    showModal();
})

//绑定角色提交按钮事件
$("#btn_role_submit").click(function () {
    saveOrUpdate();
})

//绑定角色资源提交按钮事件
$("#btn_role_resource_submit").click(function () {
    /********************************************************************
     bootstart treeView代码以删除
     var ids="";
     var tempNodeId;
     var checkeds=$("#resourcetree").treeview("getChecked");
     for(var index in checkeds){
				ids=ids+"&rids="+checkeds[index].id;
				tempNodeId=checkeds[index].nodeId;
			}
     //如果没有根元素ID，就将其加入

     //加入根结点数据
     var rootId = getRoot(tempNodeId);
     if( ids.indexOf(rootId)==-1)
     ids=ids+"&rids="+rootId;

     var url="/role/role_resoure_update.do?id="
     + $("#role_id").val() + ids;

     alert(url);
     $.get(url, function(json) {
					if (json.msg = "ok") {
						alert("操作成功");
						$("#roleresourcedialog").modal("hide");
					}
				}, "json");
     **********************************************************************/

        //ztree代码
        //得到所有选中结点
    var checkedNodes = zTreeObj.getCheckedNodes(true);
    var ids = "";
    for (var index in checkedNodes) {
        ids = ids + "&rids=" + checkedNodes[index].id;
    }
    var url = "/role/role_resoure_update?id=" + $("#role_id").val() + ids;

    //alert(url);
    $.getJSON(url, function (json) {
        if (json.msg == "ok") {
            $JACK.n_success("操作成功");
            $("#roleresourcedialog").modal("hide");
        }
    });
});//btn_role_resource_submit


//绑定查询按钮事件
$("#btn_search").click(function () {
    $("#table").bootstrapTable("refresh");//刷新表格
})

//绑定查询重置事件
$("#btn_reset").click(function () {
    $("#name").val("");//清空
    $("#table").bootstrapTable("refresh");//刷新表格
})

//绑定层关闭事件
$("#rolediv").on("hidden.bs.modal", function () {
    //清空控件
    //$("#frmroledialog input textarea").each(function(){
    //	$(this).val();
    //})
    $("#frmroledialog")[0].reset();
});


//绑定资源层显示事件
/*************************************************************************
 //以删除
 $("#roleresourcedialog").on("show.bs.modal",function(){
			//alert(333);
			$.ajax({
				url:"/resource/get.do?id="+$("#role_id").val(),
				type:"post",
				data:"",
				success:function(json){
					//alert(json.list);
					//加tree数据
					$("#resourcetree").treeview({
						 	data: json,         // 数据源
			                showCheckbox: true,   //是否显示复选框
			                highlightSelected: true,    //是否高亮选中
			                multiSelect: false,    //多选
			                levels : 4,
			                enableLinks : false,//必须在节点属性给出href属性
			                color: "#010A0E",
			                showTags:true,
			                onNodeChecked : function (event,node) {
			                    var selectNodes = getChildNodeIdArr(node); //获取所有子节点
			                    if (selectNodes) { //子节点不为空，则选中所有子节点
			                        $('#resourcetree').treeview('checkNode', [selectNodes, { silent: true }]);
			                    }
			                },
			                onNodeUnchecked : function(event, node) { //取消选中节点
			                    var selectNodes = getChildNodeIdArr(node); //获取所有子节点
			                    if (selectNodes) { //子节点不为空，则取消选中所有子节点
			                        $('#resourcetree').treeview('uncheckNode', [selectNodes, { silent: true }]);
			                    }
			                },
			                
			                onNodeExpanded : function(event, data) {
			                        
			                },
			                    
			                onNodeSelected: function (event, data) {
			                    //alert(data.nodeId);
			                }
						
					});//end treeview
				}
			});//end ajax
		});// end on
 *********************************************************************************/

//绑定资源层关闭事件
$("#roleresourcedialog").on("hidden.bs.modal", function () {
    //$("#resourcetree").
    //alert(55555);
});

// bootstarp treeview换成ztree
var zTreeObj;//树变量
$("#roleresourcedialog").on("show.bs.modal", function () {
    $.ajax({
        url: "/role/get_resource_by_rid?rid=" + $("#role_id").val(),
        type: "post",
        dataType: "json",
        success: function (json) {
            //ztree的一些配置
            setting = {
                view: {
                    selectedMulti: true
                },
                data: {
                    key: {
                        children: "children",
                        name: "name",
                        checked: "isChecked"
                    }
                },
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "parentid",
                    rootPId: 0
                },
                check: {
                    enable: true,
                    chkStyle: "checkbox"
                }
            };

            //json = JSON.parse(json);	//格式转换以适应ztree
            //生成ztree对象
            zTreeObj = $.fn.zTree.init($("#resourcetree"), setting, json);
        }
    });//ajax
})//roleresourcedialog

//得到根结点对应id（20190312）
/*function getRoot(nodeId) {
    var node = $("#resourcetree").treeview("getParent", nodeId);
    if (node.nodeId == 0)//根结点
        return node.id;
    else
        return getRoot(node.nodeId);
}


//选中/取消父节点时选中/取消所有子节点
function getChildNodeIdArr(node) {
    var ts = [];
    if (node.nodes) {
        for (x in node.nodes) {
            ts.push(node.nodes[x].nodeId);
            if (node.nodes[x].nodes) {
                var getNodeDieDai = getChildNodeIdArr(node.nodes[x]);
                for (j in getNodeDieDai) {
                    ts.push(getNodeDieDai[j]);
                }
            }
        }
    } else {
        ts.push(node.nodeId);
    }
    return ts;
}
//选中所有子节点时选中父节点
function setParentNodeCheck(node) {
    var parentNode = $("#resourcetree").treeview("getNode", node.parentId);
    if (parentNode.nodes) {
        var checkedCount = 0;
        for (x in parentNode.nodes) {
            if (parentNode.nodes[x].state.checked) {
                checkedCount++;
            } else {
                break;
            }
        }
        if (checkedCount === parentNode.nodes.length) {
            $("#resourcetree").treeview("checkNode", parentNode.nodeId);
            setParentNodeCheck(parentNode);
        }
    }
}
*/
