package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: DialogAppFiveStarsBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class _a extends Za {
    private static final ViewDataBinding.b h = null;
    private static final SparseIntArray i = new SparseIntArray();
    private final LinearLayout j;
    private long k;

    static {
        i.put(R.id.tvTitle, 1);
        i.put(R.id.llCancel, 2);
        i.put(R.id.btnCancel, 3);
        i.put(R.id.llSend, 4);
        i.put(R.id.btnSend, 5);
        i.put(R.id.llFiveStar, 6);
        i.put(R.id.btnFiveStar, 7);
    }

    public _a(androidx.databinding.d dVar, View view) {
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

    private _a(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[3], (Button) objArr[7], (Button) objArr[5], (LinearLayout) objArr[2], (LinearLayout) objArr[6], (LinearLayout) objArr[4], (TextView) objArr[1]);
        this.k = -1L;
        this.j = (LinearLayout) objArr[0];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
