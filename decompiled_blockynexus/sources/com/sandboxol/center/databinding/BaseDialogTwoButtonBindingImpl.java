package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogTwoButtonBindingImpl extends BaseDialogTwoButtonBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.tvTitle, 1);
        sViewsWithIds.put(R.id.tvDetails, 2);
        sViewsWithIds.put(R.id.vVideo, 3);
        sViewsWithIds.put(R.id.btnVideo, 4);
        sViewsWithIds.put(R.id.btnCancel, 5);
        sViewsWithIds.put(R.id.btnSure, 6);
    }

    public BaseDialogTwoButtonBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, sIncludes, sViewsWithIds));
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

    private BaseDialogTwoButtonBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[5], (Button) objArr[6], (ImageView) objArr[4], (TextView) objArr[2], (TextView) objArr[1], (View) objArr[3]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (LinearLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
