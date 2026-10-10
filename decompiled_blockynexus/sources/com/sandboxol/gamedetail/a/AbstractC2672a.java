package com.sandboxol.gamedetail.a;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;
import com.sandboxol.common.widget.rv.sbrv.SandboxRecyclerView;

/* JADX INFO: renamed from: com.sandboxol.gamedetail.a.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AuthorListListViewBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2672a extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SandboxRecyclerView f17816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DataListViewModel f17817b;

    protected AbstractC2672a(Object obj, View view, int i, SandboxRecyclerView sandboxRecyclerView) {
        super(obj, view, i);
        this.f17816a = sandboxRecyclerView;
    }
}
