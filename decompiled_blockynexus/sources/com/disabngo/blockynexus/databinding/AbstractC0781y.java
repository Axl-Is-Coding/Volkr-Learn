package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityTaskListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0781y extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f9000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f9001b;

    protected AbstractC0781y(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f9000a = recyclerView;
    }
}
