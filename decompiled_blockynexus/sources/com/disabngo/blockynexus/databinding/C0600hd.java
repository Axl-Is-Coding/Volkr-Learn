package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.d.C0828a;
import com.disabngo.blockynexus.view.widget.ProgressWebView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.hd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentBannerBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0600hd extends AbstractC0589gd {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8403c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8404d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8405e;

    public C0600hd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f8403c, f8404d));
    }

    public void a(C0828a c0828a) {
        this.f8364b = c0828a;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f8405e;
            this.f8405e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8405e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8405e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((C0828a) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (284 != i) {
            return false;
        }
        a((C0828a) obj);
        return true;
    }

    private C0600hd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ProgressWebView) objArr[0]);
        this.f8405e = -1L;
        this.f8363a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(C0828a c0828a, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8405e |= 1;
        }
        return true;
    }
}
