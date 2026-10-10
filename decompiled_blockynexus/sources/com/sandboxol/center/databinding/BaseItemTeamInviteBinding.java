package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.center.R;
import com.sandboxol.center.view.dialog.teaminvite.TeamInviteItemViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseItemTeamInviteBinding extends ViewDataBinding {
    public final Button btnJoin;
    public final ImageView icHead;
    public final View line;
    protected TeamInviteItemViewModel mViewModel;
    public final TextView tvNickName;
    public final TextView tvStatus;

    protected BaseItemTeamInviteBinding(Object obj, View view, int i, Button button, ImageView imageView, View view2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.btnJoin = button;
        this.icHead = imageView;
        this.line = view2;
        this.tvNickName = textView;
        this.tvStatus = textView2;
    }

    public static BaseItemTeamInviteBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseItemTeamInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public TeamInviteItemViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(TeamInviteItemViewModel teamInviteItemViewModel);

    @Deprecated
    public static BaseItemTeamInviteBinding bind(View view, Object obj) {
        return (BaseItemTeamInviteBinding) ViewDataBinding.bind(obj, view, R.layout.base_item_team_invite);
    }

    @Deprecated
    public static BaseItemTeamInviteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseItemTeamInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_item_team_invite, viewGroup, z, obj);
    }

    public static BaseItemTeamInviteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseItemTeamInviteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseItemTeamInviteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_item_team_invite, null, false, obj);
    }
}
