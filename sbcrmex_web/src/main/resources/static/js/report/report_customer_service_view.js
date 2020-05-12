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
        $("#table").bootstrapTable("refresh");
    });

// 服务类型比率构成（百分比堆叠面积图）
    $.getJSON(
        "/report/service_compose_report",
        function (json) {
            var service_compose_chart = Highcharts.chart('service_compose_container', {
                chart: {
                    type: 'area'
                },

                subtitle: {
                    text: ''
                },
                xAxis: {
                    tickmarkPlacement: 'on',
                    title: {
                        enabled: false
                    }
                },
                yAxis: {
                    title: {
                        text: '百分比'
                    }
                },
                tooltip: {
                    pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.percentage:.1f}%</b> ({point.y:,.0f} 个)<br/>',
                    shared: true
                },
                plotOptions: {
                    area: {
                        stacking: 'percent',
                        lineColor: '#ffffff',
                        lineWidth: 1,
                        marker: {
                            lineWidth: 1,
                            lineColor: '#ffffff'
                        }
                    }
                }
            });
            //绑定数据
            service_compose_chart.setTitle({text: json.title.text});
            service_compose_chart.xAxis[0].setCategories(json.xAxis.categories);
            console.debug(json.series);
            //循环增加数据serie对象
            for (var index in json.series) {
                service_compose_chart.addSeries(json.series[index]);
            }

        })


    $.getJSON(
        "/report/service_satisfaction_report",
        function (json) {
//服务满意度（折线图）
            var service_satisfaction_chart = Highcharts.chart('service_satisfaction_container', {
                subtitle: {
                    text: ''
                },
                yAxis: {
                    title: {
                        text: '满意度'
                    }
                },
                xAxis: {
                    tickmarkPlacement: 'on',
                    title: {
                        enabled: false
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle'
                },
                responsive: {
                    rules: [{
                        condition: {
                            maxWidth: 500
                        },
                        chartOptions: {
                            legend: {
                                layout: 'horizontal',
                                align: 'center',
                                verticalAlign: 'bottom'
                            }
                        }
                    }]
                }
            });
//绑定数据
            service_satisfaction_chart.setTitle({text: json.title.text});
            service_satisfaction_chart.xAxis[0].setCategories(json.xAxis.categories);
            console.debug(json.series);
//循环增加数据serie对象
            for (var index in json.series) {
                service_satisfaction_chart.addSeries(json.series[index]);
            }
        })

//<!-- 服务完成度（堆叠柱状图）-->
    $.getJSON(
        "/report/service_completion_degree_report",
        function (json) {
            var service_completion_degree_chart = Highcharts.chart('service_completion_degree_container', {
                chart: {
                    type: 'column'
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: '完成的服务总数'
                    },
                    stackLabels: {  // 堆叠数据标签
                        enabled: true,
                        style: {
                            fontWeight: 'bold',
                            color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                        }
                    }
                },
                legend: {
                    align: 'right',
                    x: -30,
                    verticalAlign: 'top',
                    y: 25,
                    floating: true,
                    backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                    borderColor: '#CCC',
                    borderWidth: 1,
                    shadow: false
                },
                tooltip: {
                    formatter: function () {
                        return '<b>' + this.x + '</b><br/>' +
                            this.series.name + ': ' + this.y + '<br/>' +
                            '总数: ' + this.point.stackTotal;
                    }
                },
                plotOptions: {
                    column: {
                        stacking: 'normal',
                        dataLabels: {
                            enabled: true,
                            color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                            style: {
                                // 如果不需要数据标签阴影，可以将 textOutline 设置为 'none'
                                textOutline: '1px 1px black'
                            }
                        }
                    }
                }
            });
//绑定数据
            service_completion_degree_chart.setTitle({text: json.title.text});
            service_completion_degree_chart.xAxis[0].setCategories(json.xAxis.categories);
            console.debug(json.series);
//循环增加数据serie对象
            for (var index in json.series) {
                service_completion_degree_chart.addSeries(json.series[index]);
            }
        })
});//$
// /////////////////////////////////////////////////////////////////////////////////////