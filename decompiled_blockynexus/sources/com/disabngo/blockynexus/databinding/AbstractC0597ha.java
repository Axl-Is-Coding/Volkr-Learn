package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ha, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentFollowFriendsListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0597ha extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f8398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f8399b;

    protected AbstractC0597ha(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f8398a = recyclerView;
    }
}
