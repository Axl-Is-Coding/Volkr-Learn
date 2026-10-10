package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.pb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogChangeNicknameBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0685pb extends AbstractC0674ob {
    private static final ViewDataBinding.b h = null;
    private static final SparseIntArray i = new SparseIntArray();
    private final LinearLayout j;
    private long k;

    static {
        i.put(R.id.tvTitle, 1);
        i.put(R.id.llDiamond, 2);
        i.put(R.id.tvDiamond, 3);
        i.put(R.id.vVideo, 4);
        i.put(R.id.btnVideo, 5);
        i.put(R.id.btnCancel, 6);
        i.put(R.id.btnSure, 7);
    }

    public C0685pb(androidx.databinding.d dVar, View view) {
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

    private C0685pb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[6], (Button) objArr[7], (ImageView) objArr[5], (LinearLayout) objArr[2], (TextView) objArr[3], (TextView) objArr[1], (View) objArr[4]);
        this.k = -1L;
        this.j = (LinearLayout) objArr[0];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
