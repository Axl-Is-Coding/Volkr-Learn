package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;

/* JADX INFO: compiled from: GroupVerificationListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Bg extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f7316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected PageListViewModel f7317b;

    protected Bg(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f7316a = recyclerView;
    }
}
