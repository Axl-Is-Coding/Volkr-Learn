package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;

/* JADX INFO: compiled from: TribePageListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class nk extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f8635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected PageListViewModel f8636b;

    protected nk(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f8635a = recyclerView;
    }
}
