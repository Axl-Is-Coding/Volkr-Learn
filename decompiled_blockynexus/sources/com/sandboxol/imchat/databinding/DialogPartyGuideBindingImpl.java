package com.sandboxol.imchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.imchat.BR;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.ui.dialog.PartyGuideDialog;

/* JADX INFO: loaded from: classes4.dex */
public class DialogPartyGuideBindingImpl extends DialogPartyGuideBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayout mboundView1;

    static {
        sViewsWithIds.put(R.id.ivLoading, 2);
        sViewsWithIds.put(R.id.view, 3);
    }

    public DialogPartyGuideBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PartyGuideDialog partyGuideDialog = this.mPartyGuideDialog;
        ReplyCommand replyCommand = null;
        long j2 = j & 3;
        if (j2 != 0 && partyGuideDialog != null) {
            replyCommand = partyGuideDialog.onClickClose;
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

    @Override // com.sandboxol.imchat.databinding.DialogPartyGuideBinding
    public void setPartyGuideDialog(PartyGuideDialog partyGuideDialog) {
        this.mPartyGuideDialog = partyGuideDialog;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.PartyGuideDialog);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.PartyGuideDialog != i) {
            return false;
        }
        setPartyGuideDialog((PartyGuideDialog) obj);
        return true;
    }

    private DialogPartyGuideBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageView) objArr[2], (View) objArr[3]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (LinearLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (LinearLayout) objArr[1];
        this.mboundView1.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
