package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandbox.login.R;

/* JADX INFO: compiled from: LoginReloginTipDialogBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class L extends K {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f15621c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f15622d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f15623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f15624f;

    static {
        f15622d.put(R.id.tipText, 1);
        f15622d.put(R.id.btnReLogin, 2);
    }

    public L(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f15621c, f15622d));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f15624f;
            this.f15624f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15624f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15624f = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private L(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (TextView) objArr[2], (TextView) objArr[1]);
        this.f15624f = -1L;
        this.f15623e = (ConstraintLayout) objArr[0];
        this.f15623e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
