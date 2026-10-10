package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandbox.login.R;

/* JADX INFO: renamed from: com.sandbox.login.c.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogProtocolBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2434b extends AbstractC2433a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f15628d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f15629e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f15630f;
    private long g;

    static {
        f15629e.put(R.id.tvTitle, 1);
        f15629e.put(R.id.tvDetails, 2);
        f15629e.put(R.id.btnSure, 3);
    }

    public C2434b(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f15628d, f15629e));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.g;
            this.g = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 1L;
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

    private C2434b(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (View) objArr[3], (TextView) objArr[2], (TextView) objArr[1]);
        this.g = -1L;
        this.f15630f = (LinearLayout) objArr[0];
        this.f15630f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
