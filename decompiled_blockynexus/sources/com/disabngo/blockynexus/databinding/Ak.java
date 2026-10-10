package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: WindowDiscoverComplexRankingBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ak extends zk {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7290b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7291c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataRecyclerView f7293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7294f;

    public Ak(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f7290b, f7291c));
    }

    public void a(com.disabngo.blockynexus.view.widget.gameRank.d dVar) {
        updateRegistration(0, dVar);
        this.f9056a = dVar;
        synchronized (this) {
            this.f7294f |= 1;
        }
        notifyPropertyChanged(412);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.disabngo.blockynexus.view.widget.gameRank.c cVar;
        com.disabngo.blockynexus.view.widget.gameRank.a.d dVar;
        synchronized (this) {
            j = this.f7294f;
            this.f7294f = 0L;
        }
        com.disabngo.blockynexus.view.widget.gameRank.d dVar2 = this.f9056a;
        long j2 = j & 3;
        if (j2 == 0 || dVar2 == null) {
            cVar = null;
            dVar = null;
        } else {
            com.disabngo.blockynexus.view.widget.gameRank.a.d dVar3 = dVar2.f12098d;
            cVar = dVar2.f12097c;
            dVar = dVar3;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f7293e, cVar, dVar, me.tatarka.bindingcollectionadapter2.k.a(1, false), true, null, false, 0, false);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7294f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7294f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.widget.gameRank.d) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (412 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.widget.gameRank.d) obj);
        return true;
    }

    private Ak(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f7294f = -1L;
        this.f7292d = (LinearLayout) objArr[0];
        this.f7292d.setTag(null);
        this.f7293e = (DataRecyclerView) objArr[1];
        this.f7293e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.widget.gameRank.d dVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7294f |= 1;
        }
        return true;
    }
}
