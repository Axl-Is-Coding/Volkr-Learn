package com.sandboxol.imchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.ui.fragment.team.TeamViewModel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FragmentTeamBinding extends ViewDataBinding {
    public final CheckBox cbPartyMember;
    public final CheckBox cbPartyMember2;
    public final ImageView ivLoading;
    public final LinearLayout llGroup;
    protected TeamViewModel mTeamViewModel;
    public final RelativeLayout rlGroup;
    public final RecyclerView rvTeam;

    protected FragmentTeamBinding(Object obj, View view, int i, CheckBox checkBox, CheckBox checkBox2, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout, RecyclerView recyclerView) {
        super(obj, view, i);
        this.cbPartyMember = checkBox;
        this.cbPartyMember2 = checkBox2;
        this.ivLoading = imageView;
        this.llGroup = linearLayout;
        this.rlGroup = relativeLayout;
        this.rvTeam = recyclerView;
    }

    public static FragmentTeamBinding bind(View view) {
        return bind(view, e.a());
    }

    public static FragmentTeamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public TeamViewModel getTeamViewModel() {
        return this.mTeamViewModel;
    }

    public abstract void setTeamViewModel(TeamViewModel teamViewModel);

    @Deprecated
    public static FragmentTeamBinding bind(View view, Object obj) {
        return (FragmentTeamBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_team);
    }

    @Deprecated
    public static FragmentTeamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_team, viewGroup, z, obj);
    }

    public static FragmentTeamBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static FragmentTeamBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_team, null, false, obj);
    }
}
