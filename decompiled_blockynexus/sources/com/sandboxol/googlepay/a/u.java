package com.sandboxol.googlepay.a;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: RechargeDataListViewBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f18237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f18238b;

    protected u(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f18237a = recyclerView;
    }
}
