package com.sandboxol.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.R;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DataListViewBinding extends ViewDataBinding {
    protected DataListViewModel mViewModel;
    public final RecyclerView rvData;

    protected DataListViewBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.rvData = recyclerView;
    }

    public static DataListViewBinding bind(View view) {
        return bind(view, e.a());
    }

    public static DataListViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public DataListViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(DataListViewModel dataListViewModel);

    @Deprecated
    public static DataListViewBinding bind(View view, Object obj) {
        return (DataListViewBinding) ViewDataBinding.bind(obj, view, R.layout.data_list_view);
    }

    @Deprecated
    public static DataListViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DataListViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.data_list_view, viewGroup, z, obj);
    }

    public static DataListViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static DataListViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DataListViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.data_list_view, null, false, obj);
    }
}
