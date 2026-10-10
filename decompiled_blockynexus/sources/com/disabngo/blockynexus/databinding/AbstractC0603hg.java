package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.hg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FriendListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0603hg extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f8412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f8413b;

    protected AbstractC0603hg(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f8412a = recyclerView;
    }
}
