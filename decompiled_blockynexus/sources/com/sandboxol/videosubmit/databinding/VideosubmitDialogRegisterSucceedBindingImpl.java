package com.sandboxol.videosubmit.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a.e;
import androidx.databinding.d;
import com.sandboxol.videosubmit.BR;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.dialog.RegisterSucceedDialog;

/* JADX INFO: loaded from: classes4.dex */
public class VideosubmitDialogRegisterSucceedBindingImpl extends VideosubmitDialogRegisterSucceedBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView1;

    static {
        sViewsWithIds.put(R.id.v, 2);
        sViewsWithIds.put(R.id.iv_success, 3);
        sViewsWithIds.put(R.id.tv_success_tips, 4);
    }

    public VideosubmitDialogRegisterSucceedBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, sIncludes, sViewsWithIds));
    }

    private boolean onChangeViewModelTimeText(ObservableField<String> observableField, int i) {
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
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        RegisterSucceedDialog registerSucceedDialog = this.mViewModel;
        long j2 = j & 7;
        String str = null;
        if (j2 != 0) {
            ObservableField<String> observableField = registerSucceedDialog != null ? registerSucceedDialog.timeText : null;
            updateRegistration(0, observableField);
            if (observableField != null) {
                str = observableField.get();
            }
        }
        if (j2 != 0) {
            e.a(this.mboundView1, str);
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
        return onChangeViewModelTimeText((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ViewModel != i) {
            return false;
        }
        setViewModel((RegisterSucceedDialog) obj);
        return true;
    }

    @Override // com.sandboxol.videosubmit.databinding.VideosubmitDialogRegisterSucceedBinding
    public void setViewModel(RegisterSucceedDialog registerSucceedDialog) {
        this.mViewModel = registerSucceedDialog;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private VideosubmitDialogRegisterSucceedBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ImageView) objArr[3], (TextView) objArr[4], (View) objArr[2]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (TextView) objArr[1];
        this.mboundView1.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
