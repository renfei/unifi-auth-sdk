package net.renfei.unifiauth.sdk.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询响应对象
 *
 * @author renfei
 */
@Schema(title = "分页查询响应对象")
public class ListData<T> implements Serializable {
    private static final long serialVersionUID = -3316408227872898096L;
    @Schema(description = "当前页码")
    protected int pageNum = 1;
    @Schema(description = "每页容量")
    protected int pageSize = 10;
    @Schema(description = "起始行")
    protected long startRow = 0;
    @Schema(description = "结束行")
    protected long endRow = 0;
    @Schema(description = "总数量")
    protected long total = 0;
    @Schema(description = "总页数")
    protected int pages = 0;
    @Schema(description = "数据负载")
    protected List<T> data;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getStartRow() {
        return startRow;
    }

    public void setStartRow(long startRow) {
        this.startRow = startRow;
    }

    public long getEndRow() {
        return endRow;
    }

    public void setEndRow(long endRow) {
        this.endRow = endRow;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListData{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", startRow=" + startRow +
                ", endRow=" + endRow +
                ", total=" + total +
                ", pages=" + pages +
                ", data=" + data +
                '}';
    }
}
