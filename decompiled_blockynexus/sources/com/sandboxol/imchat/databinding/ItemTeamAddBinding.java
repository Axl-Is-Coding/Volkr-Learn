package com.sandboxol.imchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.ui.fragment.team.TeamAddItemViewModel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ItemTeamAddBinding extends ViewDataBinding {
    protected TeamAddItemViewModel mTeamAddItemViewModel;

    protected ItemTeamAddBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ItemTeamAddBinding bind(View view) {
        return bind(view, e.a());
    }

    public static ItemTeamAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public TeamAddItemViewModel getTeamAddItemViewModel() {
        return this.mTeamAddItemViewModel;
    }

    public abstract void setTeamAddItemViewModel(TeamAddItemViewModel teamAddItemViewModel);

    @Deprecated
    public static ItemTeamAddBinding bind(View view, Object obj) {
        return (ItemTeamAddBinding) ViewDataBinding.bind(obj, view, R.layout.item_team_add);
    }

    @Deprecated
    public static ItemTeamAddBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemTeamAddBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_team_add, viewGroup, z, obj);
    }

    public static ItemTeamAddBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static ItemTeamAddBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemTeamAddBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_team_add, null, false, obj);
    }
}
