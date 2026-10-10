package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: DialogNewBottomMenuBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Pb extends Ob {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7762c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7763d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f7764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7765f;

    static {
        f7763d.put(R.id.vClick, 1);
        f7763d.put(R.id.ll_dialog, 2);
    }

    public Pb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f7762c, f7763d));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f7765f;
            this.f7765f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7765f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7765f = 1L;
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

    private Pb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (LinearLayout) objArr[2], (View) objArr[1]);
        this.f7765f = -1L;
        this.f7764e = (LinearLayout) objArr[0];
        this.f7764e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
