package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentNoticeBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Me extends Le {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7678b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7679c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f7680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7681e;

    public Me(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f7678b, f7679c));
    }

    @Override // com.disabngo.blockynexus.databinding.Le
    public void a(com.disabngo.blockynexus.e.b.R.b bVar) {
        this.f7646a = bVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f7681e;
            this.f7681e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7681e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7681e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.R.b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (277 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.R.b) obj);
        return true;
    }

    private Me(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f7681e = -1L;
        this.f7680d = (ConstraintLayout) objArr[0];
        this.f7680d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.R.b bVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7681e |= 1;
        }
        return true;
    }
}
