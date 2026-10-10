package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.BR;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.ActivityGuideDialog;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogActivityGuideBindingImpl extends BaseDialogActivityGuideBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.v, 3);
        sViewsWithIds.put(R.id.iv, 4);
        sViewsWithIds.put(R.id.divider, 5);
    }

    public BaseDialogActivityGuideBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ActivityGuideDialog activityGuideDialog = this.mViewModel;
        long j2 = j & 3;
        ReplyCommand replyCommand2 = null;
        if (j2 == 0 || activityGuideDialog == null) {
            replyCommand = null;
        } else {
            replyCommand2 = activityGuideDialog.onDismiss;
            replyCommand = activityGuideDialog.onSignNowCommand;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.btnSignUp, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.ivClose, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.mboundView0, replyCommand2, false, 0);
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

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ViewModel != i) {
            return false;
        }
        setViewModel((ActivityGuideDialog) obj);
        return true;
    }

    @Override // com.sandboxol.center.databinding.BaseDialogActivityGuideBinding
    public void setViewModel(ActivityGuideDialog activityGuideDialog) {
        this.mViewModel = activityGuideDialog;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private BaseDialogActivityGuideBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[1], (View) objArr[5], (ImageView) objArr[4], (ImageView) objArr[2], (View) objArr[3]);
        this.mDirtyFlags = -1L;
        this.btnSignUp.setTag(null);
        this.ivClose.setTag(null);
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
