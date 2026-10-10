package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: TribeInviteFriendListViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class jk extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f8500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f8501b;

    protected jk(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f8500a = recyclerView;
    }
}
