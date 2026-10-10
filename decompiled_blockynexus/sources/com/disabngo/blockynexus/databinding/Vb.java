package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: DialogNoticeBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Vb extends Ub {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f7957e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f7958f = new SparseIntArray();
    private final LinearLayout g;
    private long h;

    static {
        f7958f.put(R.id.tvDialogTitle, 1);
        f7958f.put(R.id.tvTitle, 2);
        f7958f.put(R.id.tvDetails, 3);
        f7958f.put(R.id.btnSure, 4);
    }

    public Vb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f7957e, f7958f));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.h;
            this.h = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 1L;
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

    private Vb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[4], (TextView) objArr[3], (TextView) objArr[1], (TextView) objArr[2]);
        this.h = -1L;
        this.g = (LinearLayout) objArr[0];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
