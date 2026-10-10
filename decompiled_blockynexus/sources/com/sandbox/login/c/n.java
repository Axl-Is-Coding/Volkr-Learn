package com.sandbox.login.c;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: LoginDataListViewBinding.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class n extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f15661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f15662b;

    protected n(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f15661a = recyclerView;
    }
}
