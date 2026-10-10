package com.sandboxol.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.R;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PageListViewBinding extends ViewDataBinding {
    protected PageListViewModel mViewModel;
    public final RecyclerView rvData;

    protected PageListViewBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.rvData = recyclerView;
    }

    public static PageListViewBinding bind(View view) {
        return bind(view, e.a());
    }

    public static PageListViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, e.a());
    }

    public PageListViewModel getViewModel() {
        return this.mViewModel;
    }

    public abstract void setViewModel(PageListViewModel pageListViewModel);

    @Deprecated
    public static PageListViewBinding bind(View view, Object obj) {
        return (PageListViewBinding) ViewDataBinding.bind(obj, view, R.layout.page_list_view);
    }

    @Deprecated
    public static PageListViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PageListViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.page_list_view, viewGroup, z, obj);
    }

    public static PageListViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, e.a());
    }

    @Deprecated
    public static PageListViewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PageListViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.page_list_view, null, false, obj);
    }
}
