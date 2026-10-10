package com.sandboxol.gamedetail.a;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;

/* JADX INFO: compiled from: GameDetailRankPageListViewBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f17884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected PageListViewModel f17885b;

    protected y(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f17884a = recyclerView;
    }
}
