package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public class BaseLayoutIvScrapLevelBindingImpl extends BaseLayoutIvScrapLevelBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.bg_main, 1);
        sViewsWithIds.put(R.id.iv_scrap_pic, 2);
        sViewsWithIds.put(R.id.bg_scrap_outline, 3);
        sViewsWithIds.put(R.id.iv_scrap_level_vip, 4);
        sViewsWithIds.put(R.id.iv_scrap_level, 5);
        sViewsWithIds.put(R.id.v_scrap_shadow, 6);
        sViewsWithIds.put(R.id.iv_scrap_done, 7);
        sViewsWithIds.put(R.id.iv_scrap_lock, 8);
        sViewsWithIds.put(R.id.iv_scrap_text, 9);
        sViewsWithIds.put(R.id.iv_scrap_game_text, 10);
    }

    public BaseLayoutIvScrapLevelBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, sIncludes, sViewsWithIds));
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

    private BaseLayoutIvScrapLevelBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (View) objArr[1], (View) objArr[3], (ImageView) objArr[7], (TextView) objArr[10], (ImageView) objArr[5], (ImageView) objArr[4], (ImageView) objArr[8], (ImageView) objArr[2], (TextView) objArr[9], (View) objArr[6]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
