package com.sandboxol.googlepay.a;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;

/* JADX INFO: compiled from: RechargeHistoryDataListViewBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f18243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected PageListViewModel f18244b;

    protected w(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f18243a = recyclerView;
    }
}
