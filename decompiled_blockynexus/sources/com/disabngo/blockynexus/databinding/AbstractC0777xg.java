package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.xg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GroupDataListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0777xg extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f8977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected PageListViewModel f8978b;

    protected AbstractC0777xg(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f8977a = recyclerView;
    }
}
