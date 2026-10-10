package com.sandboxol.common.widget.rv.datarv;

import android.content.Context;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DataListModel<T> extends DefaultListModel<T> {
    public DataListModel(Context context, int i) {
        super(context, i);
    }

    public abstract void onLoad(OnResponseListener<List<T>> onResponseListener);
}
