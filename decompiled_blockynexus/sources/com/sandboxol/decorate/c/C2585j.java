package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentDressShopSuitPageBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2585j extends AbstractC2584i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f17085b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f17086c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DataRecyclerView f17087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17088e;

    public C2585j(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f17085b, f17086c));
    }

    public void a(com.sandboxol.decorate.view.activity.dress.Z z) {
        updateRegistration(0, z);
        this.f17084a = z;
        synchronized (this) {
            this.f17088e |= 1;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.u);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f17088e;
            this.f17088e = 0L;
        }
        com.sandboxol.decorate.view.activity.dress.Y y = null;
        com.sandboxol.decorate.view.activity.dress.Z z = this.f17084a;
        long j2 = j & 3;
        if (j2 != 0 && z != null) {
            y = z.f17269a;
        }
        com.sandboxol.decorate.view.activity.dress.Y y2 = y;
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f17087d, null, y2, me.tatarka.bindingcollectionadapter2.k.a(4), false, null, false, 0, true);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17088e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17088e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.decorate.view.activity.dress.Z) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.u != i) {
            return false;
        }
        a((com.sandboxol.decorate.view.activity.dress.Z) obj);
        return true;
    }

    private C2585j(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f17088e = -1L;
        this.f17087d = (DataRecyclerView) objArr[0];
        this.f17087d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.decorate.view.activity.dress.Z z, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.f17088e |= 1;
        }
        return true;
    }
}
