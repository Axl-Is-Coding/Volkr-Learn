package com.sandboxol.common.binding.adapter;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.sandboxol.common.widget.rv.IListLayout;
import com.sandboxol.common.widget.rv.helper.ItemEnterOrExitVisibleHelper;
import com.sandboxol.common.widget.rv.pagerv.PageListLayout;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;
import me.tatarka.bindingcollectionadapter2.k;

/* JADX INFO: loaded from: classes3.dex */
public class PageRecyclerViewBindingAdapters {
    public static void setPageRecyclerView(PageRecyclerView pageRecyclerView, IListLayout iListLayout, PageListModel pageListModel, k.a aVar, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, ItemEnterOrExitVisibleHelper.OnScrollStatusListener onScrollStatusListener) {
        if (iListLayout == null) {
            pageRecyclerView.setListLayout(new PageListLayout());
        } else {
            pageRecyclerView.setListLayout(iListLayout);
        }
        if (i != 0) {
            pageRecyclerView.setModel(pageListModel, z, i);
        } else {
            pageRecyclerView.setModel(pageListModel, z);
        }
        if (aVar == null) {
            pageRecyclerView.setLayoutFactory(me.tatarka.bindingcollectionadapter2.k.a());
        } else {
            pageRecyclerView.setLayoutFactory(aVar);
        }
        if (i2 != 0) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(i2, 1);
            staggeredGridLayoutManager.a(0);
            pageRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        }
        if (onScrollStatusListener != null) {
            pageRecyclerView.setItemListener(onScrollStatusListener);
        }
        pageRecyclerView.setNestedScrollingEnabled(z2);
        pageRecyclerView.disableSetItem(z4);
    }
}
