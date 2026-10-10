package com.sandboxol.common.widget.rv.pagerv;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TopCountAdapter<T> extends me.tatarka.bindingcollectionadapter2.d<T> {
    private int topCount;

    public TopCountAdapter(Context context, int i) {
        this.topCount = i;
    }

    @Override // me.tatarka.bindingcollectionadapter2.d, androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(RecyclerView.w wVar, int i, List<Object> list) {
        super.onBindViewHolder(wVar, i, list);
        if (i < this.topCount) {
            ((StaggeredGridLayoutManager.LayoutParams) wVar.itemView.getLayoutParams()).a(true);
        }
    }
}
