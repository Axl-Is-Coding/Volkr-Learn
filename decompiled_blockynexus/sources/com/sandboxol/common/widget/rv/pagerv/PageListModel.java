package com.sandboxol.common.widget.rv.pagerv;

import android.content.Context;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PageListModel<T> extends DefaultListModel<T> {
    public PageListModel(Context context, int i) {
        super(context, i);
    }

    public abstract void onLoad(int i, int i2, OnResponseListener<PageData<T>> onResponseListener);
}
