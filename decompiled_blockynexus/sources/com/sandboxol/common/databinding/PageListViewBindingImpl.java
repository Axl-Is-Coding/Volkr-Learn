package com.sandboxol.common.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.BR;
import com.sandboxol.common.binding.adapter.PageLoadingViewBindingAdapters;
import com.sandboxol.common.binding.adapter.SmartRefreshLayoutBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.PageLoadingView;
import com.sandboxol.common.widget.rv.ListViewStyle;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import me.tatarka.bindingcollectionadapter2.e;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: loaded from: classes3.dex */
public class PageListViewBindingImpl extends PageListViewBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final PageLoadingView mboundView1;
    private final SmartRefreshLayout mboundView2;

    public PageListViewBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, sIncludes, sViewsWithIds));
    }

    private boolean onChangeViewModel(PageListViewModel pageListViewModel, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelItemViewModel(ObservableList observableList, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelViewStyle(ListViewStyle listViewStyle, int i) {
        if (i == BR._all) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        if (i == BR.emptyText) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        if (i == BR.refreshing) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        if (i != BR.loadingMore) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        String emptyText;
        ReplyCommand replyCommand;
        ReplyCommand<Integer> replyCommand2;
        g gVar;
        ObservableList observableList;
        boolean z;
        boolean zIsRefreshing;
        boolean zIsLoadingMore;
        boolean z2;
        ObservableList observableList2;
        boolean z3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PageListViewModel pageListViewModel = this.mViewModel;
        if ((127 & j) != 0) {
            ListViewStyle listViewStyle = pageListViewModel != null ? pageListViewModel.viewStyle : null;
            updateRegistration(0, listViewStyle);
            zIsLoadingMore = ((j & 99) == 0 || listViewStyle == null) ? false : listViewStyle.isLoadingMore();
            long j3 = j & 95;
            if (j3 == 0 || listViewStyle == null) {
                emptyText = null;
                zIsRefreshing = false;
            } else {
                emptyText = listViewStyle.getEmptyText();
                zIsRefreshing = listViewStyle.isRefreshing();
            }
            if (j3 != 0) {
                ObservableList itemViewModel = pageListViewModel != null ? pageListViewModel.getItemViewModel() : null;
                updateRegistration(2, itemViewModel);
                z3 = (itemViewModel != null ? itemViewModel.size() : 0) > 0;
                if (j3 != 0) {
                    j |= z3 ? 256L : 128L;
                }
                observableList2 = itemViewModel;
                z2 = !z3;
            } else {
                observableList2 = null;
                z2 = false;
                z3 = false;
            }
            replyCommand2 = ((j & 99) == 0 || pageListViewModel == null) ? null : pageListViewModel.onLoadMoreCommand;
            replyCommand = ((j & 83) == 0 || pageListViewModel == null) ? null : pageListViewModel.onRefreshCommand;
            if ((j & 70) == 0 || pageListViewModel == null) {
                observableList = observableList2;
                gVar = null;
            } else {
                gVar = pageListViewModel.itemBinding;
                observableList = observableList2;
            }
            z = z3;
            j2 = 95;
        } else {
            j2 = 95;
            emptyText = null;
            replyCommand = null;
            replyCommand2 = null;
            gVar = null;
            observableList = null;
            z = false;
            zIsRefreshing = false;
            zIsLoadingMore = false;
            z2 = false;
        }
        if ((j2 & j) != 0) {
            PageLoadingViewBindingAdapters.initPageLoadingView(this.mboundView1, emptyText, z, zIsRefreshing, z2);
        }
        if ((j & 99) != 0) {
            SmartRefreshLayoutBindingAdapters.onLoadMoreCommand(this.mboundView2, replyCommand2, zIsLoadingMore);
        }
        if ((83 & j) != 0) {
            SmartRefreshLayoutBindingAdapters.onRefreshCommand(this.mboundView2, replyCommand, zIsRefreshing);
        }
        if ((j & 70) != 0) {
            e.a(this.rvData, gVar, observableList, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModelViewStyle((ListViewStyle) obj, i2);
        }
        if (i == 1) {
            return onChangeViewModel((PageListViewModel) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeViewModelItemViewModel((ObservableList) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.ViewModel != i) {
            return false;
        }
        setViewModel((PageListViewModel) obj);
        return true;
    }

    @Override // com.sandboxol.common.databinding.PageListViewBinding
    public void setViewModel(PageListViewModel pageListViewModel) {
        updateRegistration(1, pageListViewModel);
        this.mViewModel = pageListViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private PageListViewBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (RecyclerView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (RelativeLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (PageLoadingView) objArr[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (SmartRefreshLayout) objArr[2];
        this.mboundView2.setTag(null);
        this.rvData.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
