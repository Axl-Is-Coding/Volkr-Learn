package com.sandboxol.imchat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;
import com.sandboxol.common.widget.rv.sbrv.SandboxRecyclerView;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutTeamBinding extends ViewDataBinding {
    protected DataListViewModel mViewModel;
    public final SandboxRecyclerView rvData;

    protected LayoutTeamBinding(Object obj, View view, int i, SandboxRecyclerView sandboxRecyclerView) {
        super(obj, view, i);
        this.rvData = sandboxRecyclerView;
    }

    public static LayoutTeamBinding bind(View view) {
        return bind(view, e.a());
    }

    public static LayoutTeamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public DataListViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(DataListViewModel dataListViewModel);

    @Deprecated
    public static LayoutTeamBinding bind(View view, Object obj) {
        return (LayoutTeamBinding) ViewDataBinding.bind(obj, view, R.layout.layout_team);
    }

    @Deprecated
    public static LayoutTeamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_team, viewGroup, z, obj);
    }

    public static LayoutTeamBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static LayoutTeamBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_team, null, false, obj);
    }
}
