package org.fjh.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 作用：
 * 版本信息：
 * 日期：2019年1月2日-上午11:46:12
 * 版权:樊建华
 */

public class PageEntity<T> implements Serializable {
    /**
     * 樊建华
     */
    private static final long serialVersionUID = -1483236701409832824L;

    private String url;// 请求URL

    private Integer pageNumber = 1;//初始化加载第一页，默认第一页,并记录
    private Integer pageSize = 10;
    private String sortOrder = "asc";
    private Map<String, Object> params;// 查询参数
    private Integer total; //总记录
    private Integer pages;// 总页数
    private List<T> rows;  //数据

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageEntity [url=" + url + ", pageNumber=" + pageNumber + ", pageSize=" + pageSize + ", sortOrder="
                + sortOrder + ", params=" + params + ", total=" + total + ", pages=" + pages + ", rows=" + rows + "]";
    }


}

