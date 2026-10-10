package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentDressShopRecommendPageBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2583h extends AbstractC2582g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f17080b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f17081c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DataRecyclerView f17082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17083e;

    public C2583h(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f17080b, f17081c));
    }

    public void a(com.sandboxol.decorate.view.activity.dress.V v) {
        updateRegistration(0, v);
        this.f17079a = v;
        synchronized (this) {
            this.f17083e |= 1;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.z);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f17083e;
            this.f17083e = 0L;
        }
        com.sandboxol.decorate.view.activity.dress.V v = this.f17079a;
        com.sandboxol.decorate.view.activity.dress.U u = null;
        long j2 = j & 3;
        if (j2 != 0 && v != null) {
            u = v.f17258a;
        }
        com.sandboxol.decorate.view.activity.dress.U u2 = u;
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f17082d, null, u2, null, false, null, false, 0, true);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17083e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17083e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.decorate.view.activity.dress.V) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.z != i) {
            return false;
        }
        a((com.sandboxol.decorate.view.activity.dress.V) obj);
        return true;
    }

    private C2583h(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f17083e = -1L;
        this.f17082d = (DataRecyclerView) objArr[0];
        this.f17082d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.decorate.view.activity.dress.V v, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.f17083e |= 1;
        }
        return true;
    }
}
