$(function () {
    // 刷新
    $("#btn_reload").click(function () {
        window.location.href = window.location.href;
    });

    // 返回
    $("#btn_back").click(function () {
        window.history.back(-1);
    });

    $("#btn_search").click(function () {
        $("#table").bootstrapTable("refresh");
    });

    $("#btn_reset").click(function () {
        $("#cstName").val("");
        $("#table").bootstrapTable("refresh");
    });

    // 加载表格数据
    $JACK.initTable("report_customer_compose_tbl", {
        url: "report/cutomer_compose_pager",
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
        /*
         * onClickRow:function(row,$element,field){ alert(row.optNo);
         * $("#planchcid").val(row.optNo); },
         */
        columns: [{
            field: "ctid",
            title: "编号"
        }, {
            field: "tname",
            title: "客户类型"
        }, {
            field: "cnt",
            title: "数量"
        }]
    });

});// $


datas = [
    {name: "中型客户", "data": [10, 10], stack: "add"},
    {name: "大客户", "data": [1, 2], stack: "add"},
    {name: "优质客户", "data": [4, 6], stack: "add"},
    {name: "中型客户", "data": [3, 9], stack: "lose"},
    {name: "大客户", "data": [8, 12], stack: "lose"},
    {name: "优质客户", "data": [9, 7], stack: "lose"},
];

compose_datas = [{"tname": "中型客户", "y": 0.3333333333333333}, {
    "tname": "大客户",
    "y": 0.3333333333333333
}, {"tname": "优质客户", "y": 0.3333333333333333}];


/*$.ajax({
				url:"/report/cutomer_compose_data",
				dataType:"json",
				contentType:"application/json",
				success:function(jsons) {*/
/*
 * 数据格式
 *	[{"tname":"中型客户","y":0.3333333333333333},{"tname":"大客户","y":0.3333333333333333},{"tname":"优质客户","y":0.3333333333333333}]
 */
var customer_compose_chart = Highcharts
    .chart(
        'customer_compose_container',
        {
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'pie'
            },
            title: {
                text: '客户组成分析'
            },
            tooltip: {
                pointFormat: '{series.tname}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.tname}</b>: {point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor)
                                || 'black'
                        }
                    }
                }
            },
            series: [{
                data: compose_datas
            }]
        });


$(function () {


    var customer_lose_chart = Highcharts
        .chart(
            'customer_lose_container',
            {
                chart: {
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: false,
                    type: 'column'
                },
                title: {
                    text: '增加、流失的客户'
                },
                subtitle: {
                    text: '2019/1-2019/8'
                },
                xAxis: {
                    categories: [
                        '一月', '二月'
                    ],
                    crosshair: true
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: '客户数'
                    },
                    stackLabels: {  // 堆叠数据标签
                        enabled: true,
                        style: {
                            fontWeight: 'bold',
                            color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                        }
                    }
                },
                tooltip: {
                    formatter: function () {
                        return '<b>' + this.x + '</b><br/>' +
                            this.series.name + ': ' + this.y + '<br/>' +
                            '总量: ' + this.point.stackTotal;
                    }
                },
                plotOptions: {
                    column: {
                        stacking: 'normal'
                    }
                },
                series: datas
            });

    //chart.series.push(datas);

    for (var index in datas) {
        //chart.series[index].setData(datas[index]);
        console.debug(datas[index]);
    }

});


source_datas = [
    {name: "销售机会转化而来", data: [10, 90]},
    {name: "手工录入", data: [44, 9]}
];


var customer_source_chart = Highcharts
    .chart(
        'customer_source_container',
        {
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false,
                type: 'bar'
            },
            title: {
                text: '客户来源'
            },
            tooltip: {
                valueSuffix: ' 个'
            },
            xAxis: {
                categories: ['一月', '二月'],
                title: {
                    text: null
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: '客户数量',
                    align: 'high'
                },
                labels: {
                    overflow: 'justify'
                }
            },
            plotOptions: {
                bar: {
                    dataLabels: {
                        enabled: true,
                        allowOverlap: true // 允许数据标签重叠
                    }
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -40,
                y: 100,
                floating: true,
                borderWidth: 1,
                backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
                shadow: true
            },
            series: source_datas
        });


// /////////////////////////////////////////////////////////////////////////////////////