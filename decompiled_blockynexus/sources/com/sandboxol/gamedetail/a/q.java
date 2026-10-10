package com.sandboxol.gamedetail.a;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentGameDetailIntroduceBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataRecyclerView f17863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.sandboxol.gamedetail.c.a.b.n f17864b;

    protected q(Object obj, View view, int i, DataRecyclerView dataRecyclerView) {
        super(obj, view, i);
        this.f17863a = dataRecyclerView;
    }

    public abstract void a(com.sandboxol.gamedetail.c.a.b.n nVar);
}
