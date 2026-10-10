package com.sandboxol.common.base.model;

import android.content.Context;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: loaded from: classes3.dex */
public interface IDefaultModel<T> extends IModel {
    void loadData(Context context, OnResponseListener<T> onResponseListener);
}
