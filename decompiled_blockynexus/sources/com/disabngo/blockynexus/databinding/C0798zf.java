package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.zf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentTribalDonationInstructionsBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0798zf extends AbstractC0787yf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f9043b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f9044c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f9045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f9046e;

    public C0798zf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f9043b, f9044c));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0787yf
    public void a(com.disabngo.blockynexus.e.b.ka.g gVar) {
        this.f9017a = gVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f9046e;
            this.f9046e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9046e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9046e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.ka.g) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (330 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ka.g) obj);
        return true;
    }

    private C0798zf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f9046e = -1L;
        this.f9045d = (LinearLayout) objArr[0];
        this.f9045d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ka.g gVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f9046e |= 1;
        }
        return true;
    }
}
