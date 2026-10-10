package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.center.BR;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.adsturntable.AdsTurntableDialog;
import com.sandboxol.center.view.widget.CenterButton;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogAdsTurntableBindingImpl extends BaseDialogAdsTurntableBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final Button mboundView1;
    private final CenterButton mboundView2;

    static {
        sViewsWithIds.put(R.id.view13, 3);
        sViewsWithIds.put(R.id.view14, 4);
        sViewsWithIds.put(R.id.textvSelect, 5);
        sViewsWithIds.put(R.id.rvReward, 6);
        sViewsWithIds.put(R.id.vSelect, 7);
        sViewsWithIds.put(R.id.view17, 8);
        sViewsWithIds.put(R.id.view16, 9);
    }

    public BaseDialogAdsTurntableBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, sIncludes, sViewsWithIds));
    }

    private boolean onChangeAdsTurntableDialogCanWatch(ObservableField<Boolean> observableField, int i) {
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
        boolean zSafeUnbox;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        AdsTurntableDialog adsTurntableDialog = this.mAdsTurntableDialog;
        long j2 = 7 & j;
        ReplyCommand replyCommand2 = null;
        if (j2 != 0) {
            ObservableField<Boolean> observableField = adsTurntableDialog != null ? adsTurntableDialog.canWatch : null;
            updateRegistration(0, observableField);
            zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            if ((j & 6) == 0 || adsTurntableDialog == null) {
                replyCommand = null;
            } else {
                replyCommand2 = adsTurntableDialog.onCancelCommand;
                replyCommand = adsTurntableDialog.onWatchAdsCommand;
            }
        } else {
            replyCommand = null;
            zSafeUnbox = false;
        }
        if ((j & 6) != 0) {
            ViewBindingAdapters.clickCommand(this.mboundView1, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.mboundView2, replyCommand, false, 0);
        }
        if (j2 != 0) {
            this.mboundView2.setEnabled(zSafeUnbox);
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
        return onChangeAdsTurntableDialogCanWatch((ObservableField) obj, i2);
    }

    @Override // com.sandboxol.center.databinding.BaseDialogAdsTurntableBinding
    public void setAdsTurntableDialog(AdsTurntableDialog adsTurntableDialog) {
        this.mAdsTurntableDialog = adsTurntableDialog;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.AdsTurntableDialog);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.AdsTurntableDialog != i) {
            return false;
        }
        setAdsTurntableDialog((AdsTurntableDialog) obj);
        return true;
    }

    private BaseDialogAdsTurntableBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (RecyclerView) objArr[6], (TextView) objArr[5], (View) objArr[7], (View) objArr[3], (View) objArr[4], (View) objArr[9], (View) objArr[8]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (Button) objArr[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (CenterButton) objArr[2];
        this.mboundView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
