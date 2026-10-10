package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.PageLoadingViewBindingAdapters;
import com.sandboxol.common.binding.adapter.RecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.SmartRefreshLayoutBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.PageLoadingView;
import com.sandboxol.common.widget.rv.ListViewStyle;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: TribePageListViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class ok extends nk {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8671c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8672d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f8673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PageLoadingView f8674f;
    private final SmartRefreshLayout g;
    private long h;

    public ok(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8671c, f8672d));
    }

    private boolean onChangeViewModel(PageListViewModel pageListViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelItemViewModel(ObservableList observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelViewStyle(ListViewStyle listViewStyle, int i) {
        if (i == 0) {
            synchronized (this) {
                this.h |= 1;
            }
            return true;
        }
        if (i == 246) {
            synchronized (this) {
                this.h |= 8;
            }
            return true;
        }
        if (i == 245) {
            synchronized (this) {
                this.h |= 16;
            }
            return true;
        }
        if (i != 247) {
            return false;
        }
        synchronized (this) {
            this.h |= 32;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        ReplyCommand<Integer> replyCommand;
        ReplyCommand replyCommand2;
        me.tatarka.bindingcollectionadapter2.g gVar;
        ObservableList observableList;
        boolean zIsRefreshing;
        boolean z;
        boolean z2;
        boolean z3;
        String emptyText;
        ObservableList observableList2;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        PageListViewModel pageListViewModel = this.f8636b;
        if ((127 & j) != 0) {
            ListViewStyle listViewStyle = pageListViewModel != null ? pageListViewModel.viewStyle : null;
            updateRegistration(0, listViewStyle);
            boolean zIsLoadingMore = ((j & 99) == 0 || listViewStyle == null) ? false : listViewStyle.isLoadingMore();
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
                z2 = (itemViewModel != null ? itemViewModel.size() : 0) > 0;
                if (j3 != 0) {
                    j |= z2 ? 256L : 128L;
                }
                ObservableList observableList3 = itemViewModel;
                z3 = !z2;
                observableList2 = observableList3;
            } else {
                observableList2 = null;
                z2 = false;
                z3 = false;
            }
            ReplyCommand replyCommand3 = ((j & 83) == 0 || pageListViewModel == null) ? null : pageListViewModel.onRefreshCommand;
            me.tatarka.bindingcollectionadapter2.g gVar2 = ((j & 70) == 0 || pageListViewModel == null) ? null : pageListViewModel.itemBinding;
            if ((j & 99) == 0 || pageListViewModel == null) {
                gVar = gVar2;
                observableList = observableList2;
                str = emptyText;
                j2 = 95;
                replyCommand2 = replyCommand3;
                z = zIsLoadingMore;
                replyCommand = null;
            } else {
                gVar = gVar2;
                observableList = observableList2;
                j2 = 95;
                replyCommand2 = replyCommand3;
                z = zIsLoadingMore;
                replyCommand = pageListViewModel.onLoadMoreCommand;
                str = emptyText;
            }
        } else {
            j2 = 95;
            str = null;
            replyCommand = null;
            replyCommand2 = null;
            gVar = null;
            observableList = null;
            zIsRefreshing = false;
            z = false;
            z2 = false;
            z3 = false;
        }
        if ((j & j2) != 0) {
            PageLoadingViewBindingAdapters.initPageLoadingView(this.f8674f, str, z2, zIsRefreshing, z3);
        }
        if ((j & 99) != 0) {
            SmartRefreshLayoutBindingAdapters.onLoadMoreCommand(this.g, replyCommand, z);
        }
        if ((83 & j) != 0) {
            SmartRefreshLayoutBindingAdapters.onRefreshCommand(this.g, replyCommand2, zIsRefreshing);
        }
        if ((64 & j) != 0) {
            RecyclerViewBindingAdapters.setItemDecoration(this.f8635a, R.color.borderLineColor, 1, 64, 0);
        }
        if ((j & 70) != 0) {
            me.tatarka.bindingcollectionadapter2.e.a(this.f8635a, gVar, observableList, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 64L;
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
        if (2 != i) {
            return false;
        }
        setViewModel((PageListViewModel) obj);
        return true;
    }

    public void setViewModel(PageListViewModel pageListViewModel) {
        updateRegistration(1, pageListViewModel);
        this.f8636b = pageListViewModel;
        synchronized (this) {
            this.h |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    private ok(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (RecyclerView) objArr[3]);
        this.h = -1L;
        this.f8673e = (RelativeLayout) objArr[0];
        this.f8673e.setTag(null);
        this.f8674f = (PageLoadingView) objArr[1];
        this.f8674f.setTag(null);
        this.g = (SmartRefreshLayout) objArr[2];
        this.g.setTag(null);
        this.f8635a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
