package com.sandboxol.common.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.common.R;

/* JADX INFO: loaded from: classes3.dex */
public class ActivitySingleTemplateBindingImpl extends ActivitySingleTemplateBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.tbTemplateBar, 1);
        sViewsWithIds.put(R.id.ibTemplateLeft, 2);
        sViewsWithIds.put(R.id.tvTemplateTitle, 3);
        sViewsWithIds.put(R.id.ibTemplateRight, 4);
        sViewsWithIds.put(R.id.ibTemplateSecondRight, 5);
        sViewsWithIds.put(R.id.iv_divide_line, 6);
        sViewsWithIds.put(R.id.flTemplateContainer, 7);
        sViewsWithIds.put(R.id.tvTip, 8);
    }

    public ActivitySingleTemplateBindingImpl(d dVar, View view) {
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

    private ActivitySingleTemplateBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (FrameLayout) objArr[7], (ImageButton) objArr[2], (ImageButton) objArr[4], (ImageButton) objArr[5], (ImageView) objArr[6], (Toolbar) objArr[1], (TextView) objArr[3], (TextView) objArr[8]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (RelativeLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
