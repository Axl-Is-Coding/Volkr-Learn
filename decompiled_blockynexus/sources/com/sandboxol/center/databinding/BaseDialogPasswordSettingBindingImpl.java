package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.BR;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.PasswordSettingDialog;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogPasswordSettingBindingImpl extends BaseDialogPasswordSettingBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.tvTitle, 4);
        sViewsWithIds.put(R.id.tvDetails, 5);
        sViewsWithIds.put(R.id.vVideo, 6);
        sViewsWithIds.put(R.id.btnVideo, 7);
    }

    public BaseDialogPasswordSettingBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, sIncludes, sViewsWithIds));
    }

    private boolean onChangePasswordSettingDialogIsSHowCheckTip(ObservableField<Boolean> observableField, int i) {
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
        ReplyCommand replyCommand;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PasswordSettingDialog passwordSettingDialog = this.mPasswordSettingDialog;
        long j2 = j & 7;
        ReplyCommand replyCommand2 = null;
        if (j2 != 0) {
            ObservableField<Boolean> observableField = passwordSettingDialog != null ? passwordSettingDialog.isSHowCheckTip : null;
            updateRegistration(0, observableField);
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            if (j2 != 0) {
                j |= zSafeUnbox ? 16L : 8L;
            }
            i = zSafeUnbox ? 8 : 0;
            if ((j & 6) == 0 || passwordSettingDialog == null) {
                replyCommand = null;
            } else {
                replyCommand2 = passwordSettingDialog.onCancelCommand;
                replyCommand = passwordSettingDialog.onConfirmCommand;
            }
        } else {
            replyCommand = null;
            i = 0;
        }
        if ((6 & j) != 0) {
            ViewBindingAdapters.clickCommand(this.btnCancel, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.btnSure, replyCommand, false, 0);
        }
        if ((j & 7) != 0) {
            this.cbTip.setVisibility(i);
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
        return onChangePasswordSettingDialogIsSHowCheckTip((ObservableField) obj, i2);
    }

    @Override // com.sandboxol.center.databinding.BaseDialogPasswordSettingBinding
    public void setPasswordSettingDialog(PasswordSettingDialog passwordSettingDialog) {
        this.mPasswordSettingDialog = passwordSettingDialog;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.PasswordSettingDialog);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.PasswordSettingDialog != i) {
            return false;
        }
        setPasswordSettingDialog((PasswordSettingDialog) obj);
        return true;
    }

    private BaseDialogPasswordSettingBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (Button) objArr[2], (Button) objArr[3], (ImageView) objArr[7], (CheckBox) objArr[1], (TextView) objArr[5], (TextView) objArr[4], (View) objArr[6]);
        this.mDirtyFlags = -1L;
        this.btnCancel.setTag(null);
        this.btnSure.setTag(null);
        this.cbTip.setTag(null);
        this.mboundView0 = (LinearLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
