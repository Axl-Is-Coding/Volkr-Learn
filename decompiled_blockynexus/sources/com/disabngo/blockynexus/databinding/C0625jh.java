package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.jh, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemForBlankBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0625jh extends AbstractC0614ih {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8486b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8487c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final View f8488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8489e;

    public C0625jh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f8486b, f8487c));
    }

    public void a(com.disabngo.blockynexus.e.b.F.g gVar) {
        this.f8453a = gVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f8489e;
            this.f8489e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8489e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8489e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.F.g) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.F.g) obj);
        return true;
    }

    private C0625jh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f8489e = -1L;
        this.f8488d = (View) objArr[0];
        this.f8488d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.F.g gVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8489e |= 1;
        }
        return true;
    }
}
