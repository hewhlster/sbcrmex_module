package org.fjh.util;

import java.util.List;
import java.util.Map;

public class Page<T> {
    private String url;// 请求URL
    private Integer currentpage = 1;// 当前页码
    private Integer pagerows = 10;//每页的默认记录数
    private Integer pages;// 总页数
    private Map<String, Object> params;// 查询参数
    private List<T> data; // 返回的记录


    public Integer getPagerows() {
        return pagerows;
    }

    public void setPagerows(Integer pagerows) {
        this.pagerows = pagerows;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(Integer currentpage) {
        this.currentpage = currentpage;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
