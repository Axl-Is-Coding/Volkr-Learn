package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.databinding.d;
import com.sandboxol.center.BR;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.CampaignOneButtonDialog;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogCampaignOneBtnBindingImpl extends BaseDialogCampaignOneBtnBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final TextView mboundView1;
    private final Button mboundView2;

    static {
        sViewsWithIds.put(R.id.rl_dialog, 3);
    }

    public BaseDialogCampaignOneBtnBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, sIncludes, sViewsWithIds));
    }

    private boolean onChangeCampaignOneButtonDialogBetResult(ObservableField<String> observableField, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        CampaignOneButtonDialog campaignOneButtonDialog = this.mCampaignOneButtonDialog;
        long j2 = 7 & j;
        ReplyCommand replyCommand = null;
        if (j2 != 0) {
            ObservableField<String> observableField = campaignOneButtonDialog != null ? campaignOneButtonDialog.betResult : null;
            updateRegistration(0, observableField);
            str = observableField != null ? observableField.get() : null;
            if ((j & 6) != 0 && campaignOneButtonDialog != null) {
                replyCommand = campaignOneButtonDialog.onConfirmClickCommand;
            }
        } else {
            str = null;
        }
        if (j2 != 0) {
            e.a(this.mboundView1, str);
        }
        if ((j & 6) != 0) {
            ViewBindingAdapters.clickCommand(this.mboundView2, replyCommand, false, 0);
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
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeCampaignOneButtonDialogBetResult((ObservableField) obj, i2);
    }

    @Override // com.sandboxol.center.databinding.BaseDialogCampaignOneBtnBinding
    public void setCampaignOneButtonDialog(CampaignOneButtonDialog campaignOneButtonDialog) {
        this.mCampaignOneButtonDialog = campaignOneButtonDialog;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.CampaignOneButtonDialog);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.CampaignOneButtonDialog != i) {
            return false;
        }
        setCampaignOneButtonDialog((CampaignOneButtonDialog) obj);
        return true;
    }

    private BaseDialogCampaignOneBtnBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (RelativeLayout) objArr[0], (LinearLayout) objArr[3]);
        this.mDirtyFlags = -1L;
        this.mboundView1 = (TextView) objArr[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (Button) objArr[2];
        this.mboundView2.setTag(null);
        this.rlBg.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
