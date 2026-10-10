package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.xf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentTribalCurrencyDescriptionBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0776xf extends AbstractC0765wf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8973b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8974c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8976e;

    public C0776xf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f8973b, f8974c));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0765wf
    public void a(com.disabngo.blockynexus.view.activity.tribeshop.x xVar) {
        this.f8934a = xVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f8976e;
            this.f8976e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8976e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8976e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.activity.tribeshop.x) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (506 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.tribeshop.x) obj);
        return true;
    }

    private C0776xf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f8976e = -1L;
        this.f8975d = (LinearLayout) objArr[0];
        this.f8975d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.tribeshop.x xVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8976e |= 1;
        }
        return true;
    }
}
