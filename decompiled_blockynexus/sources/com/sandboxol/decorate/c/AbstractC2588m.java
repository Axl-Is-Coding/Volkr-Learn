package com.sandboxol.decorate.c;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DecorateListViewDressBuyBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2588m extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f17094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f17095b;

    protected AbstractC2588m(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f17094a = recyclerView;
    }
}
