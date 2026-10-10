package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.databinding.d;
import com.sandboxol.center.BR;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.VipGcubeGiftOneButtonDialog;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogVipGcubeGiftOneButtonBindingImpl extends BaseDialogVipGcubeGiftOneButtonBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.tvTitle, 3);
        sViewsWithIds.put(R.id.view, 4);
    }

    public BaseDialogVipGcubeGiftOneButtonBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, sIncludes, sViewsWithIds));
    }

    private boolean onChangeVipGcubeGiftOneButtonDialogTextDetail(ObservableField<String> observableField, int i) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        VipGcubeGiftOneButtonDialog vipGcubeGiftOneButtonDialog = this.mVipGcubeGiftOneButtonDialog;
        long j2 = 7 & j;
        String str = null;
        if (j2 != 0) {
            replyCommand = ((j & 6) == 0 || vipGcubeGiftOneButtonDialog == null) ? null : vipGcubeGiftOneButtonDialog.onCloseClick;
            ObservableField<String> observableField = vipGcubeGiftOneButtonDialog != null ? vipGcubeGiftOneButtonDialog.textDetail : null;
            updateRegistration(0, observableField);
            if (observableField != null) {
                str = observableField.get();
            }
        } else {
            replyCommand = null;
        }
        if ((j & 6) != 0) {
            ViewBindingAdapters.clickCommand(this.btnSure, replyCommand, false, 0);
        }
        if (j2 != 0) {
            e.a(this.tvDetails, str);
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
        return onChangeVipGcubeGiftOneButtonDialogTextDetail((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.VipGcubeGiftOneButtonDialog != i) {
            return false;
        }
        setVipGcubeGiftOneButtonDialog((VipGcubeGiftOneButtonDialog) obj);
        return true;
    }

    @Override // com.sandboxol.center.databinding.BaseDialogVipGcubeGiftOneButtonBinding
    public void setVipGcubeGiftOneButtonDialog(VipGcubeGiftOneButtonDialog vipGcubeGiftOneButtonDialog) {
        this.mVipGcubeGiftOneButtonDialog = vipGcubeGiftOneButtonDialog;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.VipGcubeGiftOneButtonDialog);
        super.requestRebind();
    }

    private BaseDialogVipGcubeGiftOneButtonBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (Button) objArr[2], (TextView) objArr[1], (TextView) objArr[3], (View) objArr[4]);
        this.mDirtyFlags = -1L;
        this.btnSure.setTag(null);
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.tvDetails.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
