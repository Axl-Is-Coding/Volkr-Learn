package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;

/* JADX INFO: compiled from: NewFriendListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Qj extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f7822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected PageListViewModel f7823b;

    protected Qj(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f7822a = recyclerView;
    }
}
