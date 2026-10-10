package com.sandboxol.gamedetail.a;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: GameDetailListViewBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f17879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f17880b;

    protected w(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f17879a = recyclerView;
    }
}
