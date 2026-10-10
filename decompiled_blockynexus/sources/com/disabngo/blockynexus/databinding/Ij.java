package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: ListOverViewRankTypeBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Ij extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f7560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f7561b;

    protected Ij(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f7560a = recyclerView;
    }
}
