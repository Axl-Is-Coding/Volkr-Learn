package com.sandboxol.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.center.R;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseTeamInviteDataListViewBinding extends ViewDataBinding {
    protected DataListViewModel mViewModel;
    public final RecyclerView rvData;

    protected BaseTeamInviteDataListViewBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.rvData = recyclerView;
    }

    public static BaseTeamInviteDataListViewBinding bind(View view) {
        return bind(view, e.a());
    }

    public static BaseTeamInviteDataListViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public DataListViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(DataListViewModel dataListViewModel);

    @Deprecated
    public static BaseTeamInviteDataListViewBinding bind(View view, Object obj) {
        return (BaseTeamInviteDataListViewBinding) ViewDataBinding.bind(obj, view, R.layout.base_team_invite_data_list_view);
    }

    @Deprecated
    public static BaseTeamInviteDataListViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (BaseTeamInviteDataListViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_team_invite_data_list_view, viewGroup, z, obj);
    }

    public static BaseTeamInviteDataListViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static BaseTeamInviteDataListViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (BaseTeamInviteDataListViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.base_team_invite_data_list_view, null, false, obj);
    }
}
