package org.fjh.util.higtchart;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Title: HighCharts.java<／p>
 * <p>
 * Description:用来包装highcarts图表控件显示用数据 <／p>
 * <p>
 * Copyright: Copyright (c) 2019<／p>
 *
 * @author 樊建华
 * @date 2019年8月6日
 */
public class HighCharts {
    // 标题
    private Title title = new Title();
    // x坐标
    private XAxis xAxis = new XAxis();
    // 数据序列
    private List<Serie> series = new ArrayList<Serie>();

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public XAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(XAxis xAxis) {
        this.xAxis = xAxis;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

}
