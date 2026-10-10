package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.AutoHorizontalRecyclerView;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;

/* JADX INFO: compiled from: NoRefrshPageListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Sj extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AutoHorizontalRecyclerView f7883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected PageListViewModel f7884b;

    protected Sj(Object obj, View view, int i, AutoHorizontalRecyclerView autoHorizontalRecyclerView) {
        super(obj, view, i);
        this.f7883a = autoHorizontalRecyclerView;
    }
}
