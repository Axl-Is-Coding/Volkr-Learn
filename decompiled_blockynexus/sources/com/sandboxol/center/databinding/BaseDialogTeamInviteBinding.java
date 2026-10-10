package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.teaminvite.TeamInviteDialog;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDialogTeamInviteBinding extends ViewDataBinding {
    public final ConstraintLayout constraintLayout;
    public final DataRecyclerView dataRecyclerView;
    protected TeamInviteDialog mTeamInviteDialog;
    public final TextView textView;

    protected BaseDialogTeamInviteBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, DataRecyclerView dataRecyclerView, TextView textView) {
        super(obj, view, i);
        this.constraintLayout = constraintLayout;
        this.dataRecyclerView = dataRecyclerView;
        this.textView = textView;
    }

    public static BaseDialogTeamInviteBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseDialogTeamInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public TeamInviteDialog getTeamInviteDialog() {
        return this.mTeamInviteDialog;
    }

    public abstract void setTeamInviteDialog(TeamInviteDialog teamInviteDialog);

    @Deprecated
    public static BaseDialogTeamInviteBinding bind(View view, Object obj) {
        return (BaseDialogTeamInviteBinding) ViewDataBinding.bind(obj, view, R.layout.base_dialog_team_invite);
    }

    @Deprecated
    public static BaseDialogTeamInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseDialogTeamInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_team_invite, viewGroup, z, obj);
    }

    public static BaseDialogTeamInviteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseDialogTeamInviteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseDialogTeamInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_dialog_team_invite, null, false, obj);
    }
}
