package com.sandboxol.imchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public class ItemTeamMemberBindingImpl extends ItemTeamMemberBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;

    static {
        sViewsWithIds.put(R.id.ivHead, 1);
        sViewsWithIds.put(R.id.tv_playing, 2);
        sViewsWithIds.put(R.id.ivRemove, 3);
        sViewsWithIds.put(R.id.tvNickName, 4);
    }

    public ItemTeamMemberBindingImpl(d dVar, View view) {
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

    private ItemTeamMemberBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageView) objArr[1], (ImageView) objArr[3], (RelativeLayout) objArr[0], (TextView) objArr[4], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.rlGroup.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
