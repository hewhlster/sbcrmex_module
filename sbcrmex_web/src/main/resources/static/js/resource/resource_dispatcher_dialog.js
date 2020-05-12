var curLocation = "";
var tableIndex = 1;

layui.use(['treeSelect', 'form', 'layer'], function () {
    var treeSelect = layui.treeSelect,
        form = layui.form,
        $ = layui.jquery,
        layer = layui.layer;

    treeSelect.render({
        // 选择器
        elem: '#apid',
        // 数据
        data: '/resource/resource_get_all',
        // 异步加载方式：get/post，默认get
        type: 'get',
        // 占位符
        placeholder: '修改默认提示信息',
        // 是否开启搜索功能：true/false，默认false
        search: false,
        // 一些可定制的样式
        style: {
            folder: {
                enable: false
            },
            line: {
                enable: true
            }
        },
        // 点击回调
        click: function (d) {
            console.log(d);
            //当前位置
            var node = d.current;//获取当前选中节点
            $("#apid").val(node.id);//保存结点ID到表单控件，作为更新或保存的主键
            var allNode = "";
            getParentNodes(node, allNode);
            var location = "";
            var nodeArrs = curLocation.split(">");
            for (var i = nodeArrs.length - 1; i >= 0; i--) {
                location += nodeArrs[i] + ">";
            }
            location = location.substring(0,
                location.lastIndexOf(">") - 1);
            $("#fullpath").html("<font color=red>" + location + "</font>");
        },
        // 加载完成后的回调函数
        success: function (d) {
            console.log(d);
            // 选中节点，根据id筛选
            //treeSelect.checkNode('tree', 3);
            console.log($('#tree').val());
            //获取zTree对象，可以调用zTree方法
            var treeObj = treeSelect.zTree('tree');
            console.log(treeObj);
            //刷新树结构
            treeSelect.refresh('tree');
        }
    });

    // 通过layer打开
    $('#layer').click(function () {
        layer.open({
            type: 1,
            title: 'Layer',
            content: $('.layui-container'),
            area: ['500px', '300px']
        });
    });

    $('#btnDestory').click(function () {
        treeSelect.destroy('tree');
    });

    $('#btnRevoke').click(function () {
        treeSelect.revokeNode('tree', function (d) {
            console.log(d);
            console.log(d.treeId);
        });
    });

});

function getParentNodes(node, allNode) {
    if (node != null) {
        allNode += ">" + node['name'];
        curNode = node.getParentNode();
        getParentNodes(curNode, allNode);
    } else { //根节点
        curLocation = allNode;
    }
}