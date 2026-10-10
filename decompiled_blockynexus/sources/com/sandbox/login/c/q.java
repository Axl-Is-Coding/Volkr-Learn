package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandbox.login.R;

/* JADX INFO: compiled from: LoginDialogAppRegisterFinishBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class q extends p {
    private static final ViewDataBinding.b h = null;
    private static final SparseIntArray i = new SparseIntArray();
    private final LinearLayout j;
    private long k;

    static {
        i.put(R.id.llContainer, 1);
        i.put(R.id.tvTitle, 2);
        i.put(R.id.tvUserId, 3);
        i.put(R.id.tvAccount, 4);
        i.put(R.id.tvPassword, 5);
        i.put(R.id.btnClose, 6);
        i.put(R.id.btnSave, 7);
    }

    public q(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, h, i));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.k;
            this.k = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    private q(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (TextView) objArr[6], (TextView) objArr[7], (LinearLayout) objArr[1], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[3]);
        this.k = -1L;
        this.j = (LinearLayout) objArr[0];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
