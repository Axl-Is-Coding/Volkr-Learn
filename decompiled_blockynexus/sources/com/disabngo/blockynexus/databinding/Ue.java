package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentQuestionBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ue extends Te {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7935b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7936c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7938e;

    public Ue(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f7935b, f7936c));
    }

    @Override // com.disabngo.blockynexus.databinding.Te
    public void a(com.disabngo.blockynexus.e.b.V.b bVar) {
        this.f7902a = bVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f7938e;
            this.f7938e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7938e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7938e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.V.b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (268 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.V.b) obj);
        return true;
    }

    private Ue(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f7938e = -1L;
        this.f7937d = (LinearLayout) objArr[0];
        this.f7937d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.V.b bVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7938e |= 1;
        }
        return true;
    }
}
