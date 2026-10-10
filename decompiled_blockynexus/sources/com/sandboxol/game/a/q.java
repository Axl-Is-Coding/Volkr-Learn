package com.sandboxol.game.a;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: DialogScrapAnimListViewBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f17708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f17709b;

    protected q(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f17708a = recyclerView;
    }
}
