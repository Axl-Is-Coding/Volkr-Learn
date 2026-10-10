package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: AppDiskGameManageListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class I extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f7538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f7539b;

    protected I(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f7538a = recyclerView;
    }
}
