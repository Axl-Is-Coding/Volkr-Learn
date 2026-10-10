package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemAppVideoDetailMoreTopBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Yg extends Xg {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8065b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8066c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextView f8067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8068e;

    public Yg(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f8065b, f8066c));
    }

    public void a(com.disabngo.blockynexus.view.activity.videodetail.x xVar) {
        this.f8035a = xVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f8068e;
            this.f8068e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8068e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8068e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.activity.videodetail.x) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (1 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.videodetail.x) obj);
        return true;
    }

    private Yg(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f8068e = -1L;
        this.f8067d = (TextView) objArr[0];
        this.f8067d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.videodetail.x xVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8068e |= 1;
        }
        return true;
    }
}
