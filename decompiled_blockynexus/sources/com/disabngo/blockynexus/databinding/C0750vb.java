package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.vb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogEdittextBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0750vb extends AbstractC0739ub {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f8895f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final RelativeLayout h;
    private long i;

    static {
        g.put(R.id.v_bg, 1);
        g.put(R.id.tv_title, 2);
        g.put(R.id.et_msg, 3);
        g.put(R.id.btn_cancel, 4);
        g.put(R.id.btn_confirm, 5);
    }

    public C0750vb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f8895f, g));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.i;
            this.i = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i = 1L;
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

    private C0750vb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[4], (Button) objArr[5], (EditText) objArr[3], (TextView) objArr[2], (View) objArr[1]);
        this.i = -1L;
        this.h = (RelativeLayout) objArr[0];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
