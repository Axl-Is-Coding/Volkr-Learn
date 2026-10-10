package com.sandboxol.common.widget.rv.pagerv;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PageData<T> {
    private List<T> data;
    private int pageNo;
    private int pageSize;
    private int totalPage;
    private int totalSize;

    public List<T> getData() {
        return this.data;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public void setData(List<T> list) {
        this.data = list;
    }

    public void setPageNo(int i) {
        this.pageNo = i;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    public void setTotalPage(int i) {
        this.totalPage = i;
    }

    public void setTotalSize(int i) {
        this.totalSize = i;
    }
}
