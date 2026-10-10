package com.sandboxol.center.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.center.BR;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.teaminvite.TeamInviteDialog;
import com.sandboxol.center.view.dialog.teaminvite.TeamInviteListLayout;
import com.sandboxol.center.view.dialog.teaminvite.TeamInviteListModel;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public class BaseDialogTeamInviteBindingImpl extends BaseDialogTeamInviteBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final LinearLayout mboundView2;
    private final Button mboundView3;

    static {
        sViewsWithIds.put(R.id.constraintLayout, 4);
        sViewsWithIds.put(R.id.textView, 5);
    }

    public BaseDialogTeamInviteBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTeamInviteDialogFriendSize(ObservableField<Integer> observableField, int i) {
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
        int i;
        int i2;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        TeamInviteListLayout teamInviteListLayout;
        TeamInviteListModel teamInviteListModel;
        TeamInviteListLayout teamInviteListLayout2;
        TeamInviteListModel teamInviteListModel2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        TeamInviteDialog teamInviteDialog = this.mTeamInviteDialog;
        long j4 = j & 7;
        if (j4 != 0) {
            if ((j & 6) == 0 || teamInviteDialog == null) {
                teamInviteListLayout2 = null;
                teamInviteListModel2 = null;
                replyCommand = null;
                replyCommand2 = null;
            } else {
                ReplyCommand replyCommand3 = teamInviteDialog.onCancelClick;
                replyCommand2 = teamInviteDialog.onAddFriendClick;
                TeamInviteListLayout teamInviteListLayout3 = teamInviteDialog.listLayout;
                teamInviteListModel2 = teamInviteDialog.teamInviteListModel;
                teamInviteListLayout2 = teamInviteListLayout3;
                replyCommand = replyCommand3;
            }
            ObservableField<Integer> observableField = teamInviteDialog != null ? teamInviteDialog.friendSize : null;
            updateRegistration(0, observableField);
            boolean z = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null) > 0;
            if (j4 != 0) {
                if (z) {
                    j2 = j | 16;
                    j3 = 64;
                } else {
                    j2 = j | 8;
                    j3 = 32;
                }
                j = j2 | j3;
            }
            i2 = z ? 0 : 8;
            i = z ? 8 : 0;
            teamInviteListLayout = teamInviteListLayout2;
            teamInviteListModel = teamInviteListModel2;
        } else {
            i = 0;
            i2 = 0;
            replyCommand = null;
            replyCommand2 = null;
            teamInviteListLayout = null;
            teamInviteListModel = null;
        }
        if ((7 & j) != 0) {
            this.dataRecyclerView.setVisibility(i2);
            this.mboundView2.setVisibility(i);
        }
        if ((j & 6) != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.dataRecyclerView, teamInviteListLayout, teamInviteListModel, null, false, null, false, 0, false);
            ViewBindingAdapters.clickCommand(this.mboundView0, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.mboundView3, replyCommand2, false, 0);
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
        return onChangeTeamInviteDialogFriendSize((ObservableField) obj, i2);
    }

    @Override // com.sandboxol.center.databinding.BaseDialogTeamInviteBinding
    public void setTeamInviteDialog(TeamInviteDialog teamInviteDialog) {
        this.mTeamInviteDialog = teamInviteDialog;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.TeamInviteDialog);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.TeamInviteDialog != i) {
            return false;
        }
        setTeamInviteDialog((TeamInviteDialog) obj);
        return true;
    }

    private BaseDialogTeamInviteBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ConstraintLayout) objArr[4], (DataRecyclerView) objArr[1], (TextView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.dataRecyclerView.setTag(null);
        this.mboundView0 = (ConstraintLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (LinearLayout) objArr[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (Button) objArr[3];
        this.mboundView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
