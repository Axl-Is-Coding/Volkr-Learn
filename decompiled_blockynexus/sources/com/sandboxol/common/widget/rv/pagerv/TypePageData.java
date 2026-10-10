package com.sandboxol.common.widget.rv.pagerv;

/* JADX INFO: loaded from: classes3.dex */
public class TypePageData<T> {
    private PageData<T> pageInfo;
    private long typeId;

    public PageData<T> getPageInfo() {
        return this.pageInfo;
    }

    public long getTypeId() {
        return this.typeId;
    }

    public void setPageInfo(PageData<T> pageData) {
        this.pageInfo = pageData;
    }

    public void setTypeId(long j) {
        this.typeId = j;
    }
}
