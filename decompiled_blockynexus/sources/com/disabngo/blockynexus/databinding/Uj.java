package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: PartyHallDataListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Uj extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f7947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f7948b;

    protected Uj(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f7947a = recyclerView;
    }
}
