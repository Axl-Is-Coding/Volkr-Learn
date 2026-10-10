package com.sandboxol.videosubmit.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.common.binding.adapter.EditTextBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.videosubmit.BR;
import com.sandboxol.videosubmit.R;
import com.sandboxol.videosubmit.view.dialog.SignUpDialog;

/* JADX INFO: loaded from: classes4.dex */
public class VideosubmitDialogSignUpBindingImpl extends VideosubmitDialogSignUpBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final Button mboundView1;
    private final Button mboundView4;

    static {
        sViewsWithIds.put(R.id.v, 5);
        sViewsWithIds.put(R.id.tv_title, 6);
        sViewsWithIds.put(R.id.tv_tips, 7);
        sViewsWithIds.put(R.id.tv_yt_name, 8);
        sViewsWithIds.put(R.id.tv_fb_name, 9);
        sViewsWithIds.put(R.id.v_divide, 10);
        sViewsWithIds.put(R.id.iv_spinner, 11);
    }

    public VideosubmitDialogSignUpBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 12, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        ReplyCommand replyCommand3;
        ReplyCommand<String> replyCommand4;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SignUpDialog signUpDialog = this.mViewModel;
        long j2 = j & 3;
        if (j2 == 0 || signUpDialog == null) {
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
            replyCommand4 = null;
        } else {
            replyCommand2 = signUpDialog.onCloseCommand;
            replyCommand3 = signUpDialog.onCountryCommand;
            replyCommand4 = signUpDialog.onGetYtCommand;
            replyCommand = signUpDialog.onSubmitCommand;
        }
        if (j2 != 0) {
            EditTextBindingAdapters.editTextCommand(this.etYtName, null, null, replyCommand4);
            ViewBindingAdapters.clickCommand(this.mboundView1, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.mboundView4, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.spLanguageName, replyCommand3, false, 0);
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
        setViewModel((SignUpDialog) obj);
        return true;
    }

    @Override // com.sandboxol.videosubmit.databinding.VideosubmitDialogSignUpBinding
    public void setViewModel(SignUpDialog signUpDialog) {
        this.mViewModel = signUpDialog;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private VideosubmitDialogSignUpBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (EditText) objArr[2], (ImageView) objArr[11], (TextView) objArr[3], (TextView) objArr[9], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[8], (View) objArr[5], (View) objArr[10]);
        this.mDirtyFlags = -1L;
        this.etYtName.setTag(null);
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (Button) objArr[1];
        this.mboundView1.setTag(null);
        this.mboundView4 = (Button) objArr[4];
        this.mboundView4.setTag(null);
        this.spLanguageName.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
