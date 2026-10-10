package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogAppFiveStarsBindingImpl extends BaseDialogAppFiveStarsBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.tvTitle, 1);
        sViewsWithIds.put(R.id.btnCancel, 2);
        sViewsWithIds.put(R.id.btnSend, 3);
        sViewsWithIds.put(R.id.btnFiveStar, 4);
    }

    public BaseDialogAppFiveStarsBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, sIncludes, sViewsWithIds));
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

    private BaseDialogAppFiveStarsBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[2], (Button) objArr[4], (Button) objArr[3], (TextView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (LinearLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
