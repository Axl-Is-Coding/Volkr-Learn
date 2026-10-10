package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.BR;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.AdsGameRewardDialog;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogAdsGameRewardBindingImpl extends BaseDialogAdsGameRewardBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final Button mboundView1;

    static {
        sViewsWithIds.put(R.id.ivFlash, 2);
        sViewsWithIds.put(R.id.ll_reward, 3);
    }

    public BaseDialogAdsGameRewardBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        AdsGameRewardDialog adsGameRewardDialog = this.mAdsGameRewardDialog;
        ReplyCommand replyCommand = null;
        long j2 = j & 3;
        if (j2 != 0 && adsGameRewardDialog != null) {
            replyCommand = adsGameRewardDialog.onConfirmClickCommand;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.mboundView1, replyCommand, false, 0);
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
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.sandboxol.center.databinding.BaseDialogAdsGameRewardBinding
    public void setAdsGameRewardDialog(AdsGameRewardDialog adsGameRewardDialog) {
        this.mAdsGameRewardDialog = adsGameRewardDialog;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.AdsGameRewardDialog);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.AdsGameRewardDialog != i) {
            return false;
        }
        setAdsGameRewardDialog((AdsGameRewardDialog) obj);
        return true;
    }

    private BaseDialogAdsGameRewardBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageView) objArr[2], (LinearLayout) objArr[3], (RelativeLayout) objArr[0]);
        this.mDirtyFlags = -1L;
        this.mboundView1 = (Button) objArr[1];
        this.mboundView1.setTag(null);
        this.rlBg.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
