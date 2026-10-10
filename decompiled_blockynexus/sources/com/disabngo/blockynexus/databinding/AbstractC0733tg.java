package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.AutoHorizontalRecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.tg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GameRecentDataListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0733tg extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AutoHorizontalRecyclerView f8841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f8842b;

    protected AbstractC0733tg(Object obj, View view, int i, AutoHorizontalRecyclerView autoHorizontalRecyclerView) {
        super(obj, view, i);
        this.f8841a = autoHorizontalRecyclerView;
    }
}
