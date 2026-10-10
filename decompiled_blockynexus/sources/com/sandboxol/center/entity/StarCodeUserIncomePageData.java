package com.sandboxol.center.entity;

import com.sandboxol.common.widget.rv.pagerv.PageData;

/* JADX INFO: loaded from: classes3.dex */
public class StarCodeUserIncomePageData<T> {
    private PageData<T> data;
    private double todayProfit;

    public PageData<T> getData() {
        return this.data;
    }

    public double getTodayProfit() {
        return this.todayProfit;
    }

    public void setData(PageData<T> pageData) {
        this.data = pageData;
    }

    public void setTodayProfit(int i) {
        this.todayProfit = i;
    }
}
