package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.kc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogReportBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0631kc extends AbstractC0620jc {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = new SparseIntArray();
    private final LinearLayout l;
    private long m;

    static {
        k.put(R.id.tvTitle, 1);
        k.put(R.id.tvReason, 2);
        k.put(R.id.tvTime, 3);
        k.put(R.id.vVideo, 4);
        k.put(R.id.btnVideo, 5);
        k.put(R.id.btnCancel, 6);
        k.put(R.id.vLine1, 7);
        k.put(R.id.vLine2, 8);
        k.put(R.id.btnSure, 9);
    }

    public C0631kc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, j, k));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j2 = this.m;
            this.m = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 1L;
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

    private C0631kc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[6], (Button) objArr[9], (ImageView) objArr[5], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[1], (View) objArr[7], (View) objArr[8], (View) objArr[4]);
        this.m = -1L;
        this.l = (LinearLayout) objArr[0];
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
