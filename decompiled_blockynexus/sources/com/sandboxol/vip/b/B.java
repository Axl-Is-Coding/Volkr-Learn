package com.sandboxol.vip.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: VipTabItemBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class B extends A {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f18963b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f18964c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f18965d;

    public B(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f18963b, f18964c));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f18965d;
            this.f18965d = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f18965d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f18965d = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private B(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageView) objArr[0]);
        this.f18965d = -1L;
        this.f18962a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
