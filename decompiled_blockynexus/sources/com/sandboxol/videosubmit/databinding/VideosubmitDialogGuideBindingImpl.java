package com.sandboxol.videosubmit.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.videosubmit.BR;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.dialog.GuideDialog;

/* JADX INFO: loaded from: classes4.dex */
public class VideosubmitDialogGuideBindingImpl extends VideosubmitDialogGuideBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        sViewsWithIds.put(R.id.v, 4);
        sViewsWithIds.put(R.id.divider, 5);
    }

    public VideosubmitDialogGuideBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, sIncludes, sViewsWithIds));
    }

    private boolean onChangeViewModelBackgroundUrl(ObservableField<String> observableField, int i) {
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
        ReplyCommand replyCommand2;
        String str;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        GuideDialog guideDialog = this.mViewModel;
        long j2 = 7 & j;
        if (j2 != 0) {
            int i2 = R.mipmap.videosubmit_bg_guide_content;
            if ((j & 6) == 0 || guideDialog == null) {
                replyCommand = null;
                replyCommand2 = null;
            } else {
                replyCommand = guideDialog.onDismiss;
                replyCommand2 = guideDialog.onSignNowCommand;
            }
            ObservableField<String> observableField = guideDialog != null ? guideDialog.backgroundUrl : null;
            updateRegistration(0, observableField);
            str = observableField != null ? observableField.get() : null;
            i = i2;
        } else {
            replyCommand = null;
            replyCommand2 = null;
            str = null;
            i = 0;
        }
        if ((j & 6) != 0) {
            ViewBindingAdapters.clickCommand(this.btnSignUp, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.ivClose, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.mboundView0, replyCommand, false, 0);
        }
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.iv, 0, str, i, i, false, false, false, false, WheelView.DividerConfig.FILL, null);
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
        return onChangeViewModelBackgroundUrl((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ViewModel != i) {
            return false;
        }
        setViewModel((GuideDialog) obj);
        return true;
    }

    @Override // com.sandboxol.videosubmit.databinding.VideosubmitDialogGuideBinding
    public void setViewModel(GuideDialog guideDialog) {
        this.mViewModel = guideDialog;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private VideosubmitDialogGuideBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (Button) objArr[2], (View) objArr[5], (ImageView) objArr[1], (ImageView) objArr[3], (View) objArr[4]);
        this.mDirtyFlags = -1L;
        this.btnSignUp.setTag(null);
        this.iv.setTag(null);
        this.ivClose.setTag(null);
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
