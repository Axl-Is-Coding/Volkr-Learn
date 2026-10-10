package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.card.MaterialCardView;
import com.sandbox.login.R;

/* JADX INFO: compiled from: LoginActivityRoleMakeBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends AbstractC2444l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f15657c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f15658d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f15659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f15660f;

    static {
        f15658d.put(R.id.role_frg_con, 1);
    }

    public m(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f15657c, f15658d));
    }

    @Override // com.sandbox.login.c.AbstractC2444l
    public void a(com.sandbox.login.view.activity.makerole.b bVar) {
        this.f15656b = bVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f15660f;
            this.f15660f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15660f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15660f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandbox.login.view.activity.makerole.b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandbox.login.g.f15905b != i) {
            return false;
        }
        a((com.sandbox.login.view.activity.makerole.b) obj);
        return true;
    }

    private m(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (MaterialCardView) objArr[1]);
        this.f15660f = -1L;
        this.f15659e = (ConstraintLayout) objArr[0];
        this.f15659e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandbox.login.view.activity.makerole.b bVar, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.f15660f |= 1;
        }
        return true;
    }
}
