package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: ItemDressBlankBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class B extends A {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f16987c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f16988d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f16989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f16990f;

    static {
        f16988d.put(R.id.bgView, 1);
    }

    public B(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f16987c, f16988d));
    }

    public void a(com.sandboxol.decorate.view.fragment.dress.Z z) {
        this.f16986b = z;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f16990f;
            this.f16990f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f16990f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f16990f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.decorate.view.fragment.dress.Z) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.H != i) {
            return false;
        }
        a((com.sandboxol.decorate.view.fragment.dress.Z) obj);
        return true;
    }

    private B(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (View) objArr[1]);
        this.f16990f = -1L;
        this.f16989e = (ConstraintLayout) objArr[0];
        this.f16989e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.decorate.view.fragment.dress.Z z, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.f16990f |= 1;
        }
        return true;
    }
}
