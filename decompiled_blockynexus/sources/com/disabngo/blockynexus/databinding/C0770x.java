package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityStartBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0770x extends AbstractC0759w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8953c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8954d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8955e;

    public C0770x(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f8953c, f8954d));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0759w
    public void a(com.disabngo.blockynexus.view.activity.start.q qVar) {
        this.f8926b = qVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f8955e;
            this.f8955e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8955e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8955e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.activity.start.q) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (379 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.start.q) obj);
        return true;
    }

    private C0770x(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (FrameLayout) objArr[0]);
        this.f8955e = -1L;
        this.f8925a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.start.q qVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8955e |= 1;
        }
        return true;
    }
}
