package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.decorate.R;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogLeaveDressShopBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2596v extends AbstractC2595u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f17121d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f17122e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f17123f;
    private long g;

    static {
        f17122e.put(R.id.tvDetails, 1);
        f17122e.put(R.id.btnCancel, 2);
        f17122e.put(R.id.btnSure, 3);
    }

    public C2596v(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f17121d, f17122e));
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

    private C2596v(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[2], (Button) objArr[3], (TextView) objArr[1]);
        this.g = -1L;
        this.f17123f = (LinearLayout) objArr[0];
        this.f17123f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
