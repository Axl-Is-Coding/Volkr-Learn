package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.nb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogBuyGameBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0663nb extends AbstractC0652mb {
    private static final ViewDataBinding.b i = null;
    private static final SparseIntArray j = new SparseIntArray();
    private final LinearLayout k;
    private long l;

    static {
        j.put(R.id.tvTitle, 1);
        j.put(R.id.tvDetails, 2);
        j.put(R.id.vVideo, 3);
        j.put(R.id.btnVideo, 4);
        j.put(R.id.btnCancel, 5);
        j.put(R.id.btnSure, 6);
        j.put(R.id.ivCurrency, 7);
        j.put(R.id.tvBuy, 8);
    }

    public C0663nb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, i, j));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j2 = this.l;
            this.l = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 1L;
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

    private C0663nb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[5], (LinearLayout) objArr[6], (ImageView) objArr[4], (ImageView) objArr[7], (TextView) objArr[8], (TextView) objArr[2], (TextView) objArr[1], (View) objArr[3]);
        this.l = -1L;
        this.k = (LinearLayout) objArr[0];
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
