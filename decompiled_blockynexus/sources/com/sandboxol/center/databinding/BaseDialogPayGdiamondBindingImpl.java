package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogPayGdiamondBindingImpl extends BaseDialogPayGdiamondBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.tvTitle, 1);
        sViewsWithIds.put(R.id.tvDetails, 2);
        sViewsWithIds.put(R.id.tvDetails1, 3);
        sViewsWithIds.put(R.id.cbWifi, 4);
        sViewsWithIds.put(R.id.vVideo, 5);
        sViewsWithIds.put(R.id.btnVideo, 6);
        sViewsWithIds.put(R.id.btnCancel, 7);
        sViewsWithIds.put(R.id.btnSure, 8);
    }

    public BaseDialogPayGdiamondBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
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

    private BaseDialogPayGdiamondBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[7], (Button) objArr[8], (ImageView) objArr[6], (CheckBox) objArr[4], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[1], (View) objArr[5]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (LinearLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
