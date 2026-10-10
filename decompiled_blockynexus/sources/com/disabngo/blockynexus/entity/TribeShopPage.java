package com.disabngo.blockynexus.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TribeShopPage {
    private List<TribeShopPageList> data;
    private int pageNo;
    private int pageSize;
    private int totalPage;
    private int totalSize;

    public List<TribeShopPageList> getData() {
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

    public void setData(List<TribeShopPageList> list) {
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
