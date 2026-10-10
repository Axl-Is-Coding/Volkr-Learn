package com.sandboxol.imchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.common.widget.RoundImageView;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public class ItemChatInviteTeamBindingImpl extends ItemChatInviteTeamBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.ivLeftPoint, 1);
        sViewsWithIds.put(R.id.ivRightPoint, 2);
        sViewsWithIds.put(R.id.ivBgImg, 3);
        sViewsWithIds.put(R.id.ivBg, 4);
        sViewsWithIds.put(R.id.tvCaptain, 5);
        sViewsWithIds.put(R.id.ivGoto, 6);
        sViewsWithIds.put(R.id.ivChat, 7);
        sViewsWithIds.put(R.id.tvTitle, 8);
        sViewsWithIds.put(R.id.tvGame, 9);
        sViewsWithIds.put(R.id.ivKickOut, 10);
        sViewsWithIds.put(R.id.rlNotExit, 11);
    }

    public ItemChatInviteTeamBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 12, sIncludes, sViewsWithIds));
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

    private ItemChatInviteTeamBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageView) objArr[4], (ImageView) objArr[3], (ImageView) objArr[7], (ImageView) objArr[6], (RoundImageView) objArr[10], (ImageView) objArr[1], (ImageView) objArr[2], (RelativeLayout) objArr[11], (TextView) objArr[5], (TextView) objArr[9], (TextView) objArr[8]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (FrameLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
