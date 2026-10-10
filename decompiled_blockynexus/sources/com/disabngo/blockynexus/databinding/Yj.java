package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;
import com.sandboxol.common.widget.rv.sbrv.SandboxRecyclerView;

/* JADX INFO: compiled from: RecommendGameListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Yj extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SandboxRecyclerView f8077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f8078b;

    protected Yj(Object obj, View view, int i, SandboxRecyclerView sandboxRecyclerView) {
        super(obj, view, i);
        this.f8077a = sandboxRecyclerView;
    }
}
