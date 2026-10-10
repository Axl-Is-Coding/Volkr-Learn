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
import com.sandboxol.videosubmit.view.dialog.LinkDialog;

/* JADX INFO: loaded from: classes4.dex */
public class VideosubmitDialogLinkBindingImpl extends VideosubmitDialogLinkBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final Button mboundView1;
    private final Button mboundView5;

    static {
        sViewsWithIds.put(R.id.v, 6);
        sViewsWithIds.put(R.id.tv_title, 7);
        sViewsWithIds.put(R.id.tv_tips, 8);
        sViewsWithIds.put(R.id.tv_id, 9);
        sViewsWithIds.put(R.id.tv_type, 10);
        sViewsWithIds.put(R.id.v_divide, 11);
        sViewsWithIds.put(R.id.iv_type_spinner, 12);
        sViewsWithIds.put(R.id.tv_game_name, 13);
        sViewsWithIds.put(R.id.v_game_name_divide, 14);
        sViewsWithIds.put(R.id.iv_game_name_spinner, 15);
    }

    public VideosubmitDialogLinkBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 16, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        ReplyCommand replyCommand3;
        ReplyCommand replyCommand4;
        ReplyCommand<String> replyCommand5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        LinkDialog linkDialog = this.mViewModel;
        long j2 = j & 3;
        if (j2 == 0 || linkDialog == null) {
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
            replyCommand4 = null;
            replyCommand5 = null;
        } else {
            replyCommand2 = linkDialog.onGameNamesCommand;
            replyCommand3 = linkDialog.onVideoTypeCommand;
            replyCommand4 = linkDialog.onSubmitCommand;
            replyCommand5 = linkDialog.onGetLinkCommand;
            replyCommand = linkDialog.onCloseCommand;
        }
        if (j2 != 0) {
            EditTextBindingAdapters.editTextCommand(this.etId, null, null, replyCommand5);
            ViewBindingAdapters.clickCommand(this.mboundView1, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.mboundView5, replyCommand4, false, 0);
            ViewBindingAdapters.clickCommand(this.spGameName, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.spType, replyCommand3, false, 0);
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
        setViewModel((LinkDialog) obj);
        return true;
    }

    @Override // com.sandboxol.videosubmit.databinding.VideosubmitDialogLinkBinding
    public void setViewModel(LinkDialog linkDialog) {
        this.mViewModel = linkDialog;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private VideosubmitDialogLinkBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (EditText) objArr[2], (ImageView) objArr[15], (ImageView) objArr[12], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[13], (TextView) objArr[9], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[10], (View) objArr[6], (View) objArr[11], (View) objArr[14]);
        this.mDirtyFlags = -1L;
        this.etId.setTag(null);
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (Button) objArr[1];
        this.mboundView1.setTag(null);
        this.mboundView5 = (Button) objArr[5];
        this.mboundView5.setTag(null);
        this.spGameName.setTag(null);
        this.spType.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
