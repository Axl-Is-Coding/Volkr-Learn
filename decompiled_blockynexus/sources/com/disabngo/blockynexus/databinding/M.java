package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;

/* JADX INFO: compiled from: AppPartyCreatePageListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class M extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f7663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected PageListViewModel f7664b;

    protected M(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f7663a = recyclerView;
    }
}
