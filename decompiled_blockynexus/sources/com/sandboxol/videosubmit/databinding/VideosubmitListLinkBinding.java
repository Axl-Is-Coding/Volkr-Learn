package com.sandboxol.videosubmit.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;
import com.sandboxol.videosubmit.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class VideosubmitListLinkBinding extends ViewDataBinding {
    protected DataListViewModel mViewModel;
    public final RecyclerView rvData;

    protected VideosubmitListLinkBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.rvData = recyclerView;
    }

    public static VideosubmitListLinkBinding bind(View view) {
        return bind(view, e.a());
    }

    public static VideosubmitListLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public DataListViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(DataListViewModel dataListViewModel);

    @Deprecated
    public static VideosubmitListLinkBinding bind(View view, Object obj) {
        return (VideosubmitListLinkBinding) ViewDataBinding.bind(obj, view, R.layout.videosubmit_list_link);
    }

    @Deprecated
    public static VideosubmitListLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (VideosubmitListLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_list_link, viewGroup, z, obj);
    }

    public static VideosubmitListLinkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static VideosubmitListLinkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (VideosubmitListLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.videosubmit_list_link, null, false, obj);
    }
}
