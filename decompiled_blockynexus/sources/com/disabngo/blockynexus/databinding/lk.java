package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: TribeNoListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class lk extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f8566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f8567b;

    protected lk(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f8566a = recyclerView;
    }
}
