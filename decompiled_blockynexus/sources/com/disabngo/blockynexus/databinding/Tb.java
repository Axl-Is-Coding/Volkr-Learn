package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: DialogNoObbBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Tb extends Sb {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f7893d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f7894e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f7895f;
    private long g;

    static {
        f7894e.put(R.id.tvTitle, 1);
        f7894e.put(R.id.tvDetails, 2);
        f7894e.put(R.id.btnSure, 3);
    }

    public Tb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f7893d, f7894e));
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

    private Tb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[3], (TextView) objArr[2], (TextView) objArr[1]);
        this.g = -1L;
        this.f7895f = (LinearLayout) objArr[0];
        this.f7895f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
