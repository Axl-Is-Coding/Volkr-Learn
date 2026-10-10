package com.disabngo.blockynexus.databinding;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.c.C0827g;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentActivityBinding.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class Zc extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataRecyclerView f8087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected C0827g f8088b;

    protected Zc(Object obj, View view, int i, DataRecyclerView dataRecyclerView) {
        super(obj, view, i);
        this.f8087a = dataRecyclerView;
    }

    public abstract void a(C0827g c0827g);
}
