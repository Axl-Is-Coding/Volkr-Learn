package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.db, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogAppUnbindPhoneBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0554db extends AbstractC0542cb {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final LinearLayout i;
    private long j;

    static {
        h.put(R.id.tvTitle, 1);
        h.put(R.id.tvPhoneNum, 2);
        h.put(R.id.etCode, 3);
        h.put(R.id.btnGetCode, 4);
        h.put(R.id.btnCancel, 5);
        h.put(R.id.btnSure, 6);
    }

    public C0554db(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, g, h));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.j;
            this.j = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 1L;
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

    private C0554db(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[5], (Button) objArr[4], (Button) objArr[6], (EditText) objArr[3], (TextView) objArr[2], (TextView) objArr[1]);
        this.j = -1L;
        this.i = (LinearLayout) objArr[0];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
