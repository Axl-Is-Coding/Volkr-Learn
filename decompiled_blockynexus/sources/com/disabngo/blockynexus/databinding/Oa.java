package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: DialogActivityShareBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Oa extends Na {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final LinearLayout i;
    private long j;

    static {
        h.put(R.id.ivTwitter, 1);
        h.put(R.id.ivWhatsapp, 2);
        h.put(R.id.ivDiscord, 3);
        h.put(R.id.ivLine, 4);
        h.put(R.id.ivSystem, 5);
        h.put(R.id.tvCancel, 6);
    }

    public Oa(androidx.databinding.d dVar, View view) {
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

    private Oa(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageView) objArr[3], (ImageView) objArr[4], (ImageView) objArr[5], (ImageView) objArr[1], (ImageView) objArr[2], (TextView) objArr[6]);
        this.j = -1L;
        this.i = (LinearLayout) objArr[0];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
