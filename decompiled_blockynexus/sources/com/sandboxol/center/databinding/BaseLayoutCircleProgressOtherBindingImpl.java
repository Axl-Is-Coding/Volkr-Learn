package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.R;
import com.sandboxol.center.view.widget.CustomCircleProgressView;

/* JADX INFO: loaded from: classes3.dex */
public class BaseLayoutCircleProgressOtherBindingImpl extends BaseLayoutCircleProgressOtherBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.v_shadow, 1);
        sViewsWithIds.put(R.id.tv_percent, 2);
        sViewsWithIds.put(R.id.cpv_progress, 3);
        sViewsWithIds.put(R.id.iv_tick, 4);
        sViewsWithIds.put(R.id.iv_ring, 5);
    }

    public BaseLayoutCircleProgressOtherBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, sIncludes, sViewsWithIds));
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

    private BaseLayoutCircleProgressOtherBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (CustomCircleProgressView) objArr[3], (ImageView) objArr[5], (ImageView) objArr[4], (TextView) objArr[2], (View) objArr[1]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
