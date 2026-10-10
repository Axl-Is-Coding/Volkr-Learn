package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ActivityThirdProxyActivityBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class B extends A {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7295b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7296c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f7297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7298e;

    public B(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f7295b, f7296c));
    }

    @Override // com.disabngo.blockynexus.databinding.A
    public void a(com.disabngo.blockynexus.view.activity.thirdproxy.c cVar) {
        this.f7254a = cVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f7298e;
            this.f7298e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7298e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7298e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.activity.thirdproxy.c) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.thirdproxy.c) obj);
        return true;
    }

    private B(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f7298e = -1L;
        this.f7297d = (ConstraintLayout) objArr[0];
        this.f7297d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.thirdproxy.c cVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7298e |= 1;
        }
        return true;
    }
}
