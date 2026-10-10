package com.sandboxol.center.entity;

import com.sandboxol.common.widget.rv.pagerv.PageData;

/* JADX INFO: loaded from: classes3.dex */
public class RankInfo<T> {
    private PageData<T> pageInfo;
    private long remainTime;

    public PageData<T> getPageData() {
        return this.pageInfo;
    }

    public long getRemainTime() {
        return this.remainTime;
    }

    public void setPageData(PageData<T> pageData) {
        this.pageInfo = pageData;
    }

    public void setRemainTime(long j) {
        this.remainTime = j;
    }
}
