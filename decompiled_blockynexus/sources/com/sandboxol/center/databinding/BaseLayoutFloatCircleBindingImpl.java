package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.R;
import com.sandboxol.center.view.widget.CircleProgressView;

/* JADX INFO: loaded from: classes3.dex */
public class BaseLayoutFloatCircleBindingImpl extends BaseLayoutFloatCircleBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.cpv_progress, 1);
        sViewsWithIds.put(R.id.iv_pic_bg, 2);
        sViewsWithIds.put(R.id.iv_pic, 3);
        sViewsWithIds.put(R.id.tv_remaining_time_box, 4);
        sViewsWithIds.put(R.id.tv_available_count, 5);
    }

    public BaseLayoutFloatCircleBindingImpl(d dVar, View view) {
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

    private BaseLayoutFloatCircleBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (CircleProgressView) objArr[1], (ImageView) objArr[3], (ImageView) objArr[2], (TextView) objArr[5], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
