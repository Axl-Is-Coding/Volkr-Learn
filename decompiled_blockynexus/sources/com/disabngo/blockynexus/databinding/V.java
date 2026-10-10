package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;

/* JADX INFO: compiled from: CategoryPageListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class V extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f7949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected PageListViewModel f7950b;

    protected V(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f7949a = recyclerView;
    }
}
