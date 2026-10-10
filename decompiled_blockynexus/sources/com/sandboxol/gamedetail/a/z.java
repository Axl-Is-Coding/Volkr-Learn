package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.center.R;
import com.sandboxol.common.binding.adapter.PageLoadingViewBindingAdapters;
import com.sandboxol.common.binding.adapter.RecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.SmartRefreshLayoutBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.PageLoadingView;
import com.sandboxol.common.widget.rv.ListViewStyle;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: GameDetailRankPageListViewBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class z extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f17886c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f17887d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f17888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PageLoadingView f17889f;
    private final SmartRefreshLayout g;
    private long h;

    public z(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f17886c, f17887d));
    }

    private boolean onChangeViewModel(PageListViewModel pageListViewModel, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelItemViewModel(ObservableList observableList, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.h |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelViewStyle(ListViewStyle listViewStyle, int i) {
        if (i == com.sandboxol.gamedetail.a.f17768a) {
            synchronized (this) {
                this.h |= 1;
            }
            return true;
        }
        if (i == com.sandboxol.gamedetail.a.o) {
            synchronized (this) {
                this.h |= 8;
            }
            return true;
        }
        if (i == com.sandboxol.gamedetail.a.n) {
            synchronized (this) {
                this.h |= 16;
            }
            return true;
        }
        if (i != com.sandboxol.gamedetail.a.p) {
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
        String str;
        ReplyCommand<Integer> replyCommand;
        ReplyCommand replyCommand2;
        me.tatarka.bindingcollectionadapter2.g gVar;
        ObservableList observableList;
        boolean z;
        boolean z2;
        boolean zIsRefreshing;
        boolean zIsLoadingMore;
        String emptyText;
        ObservableList observableList2;
        boolean z3;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        PageListViewModel pageListViewModel = this.f17885b;
        int i = (j & 64) != 0 ? R.color.base_border_line : 0;
        if ((127 & j) != 0) {
            ListViewStyle listViewStyle = pageListViewModel != null ? pageListViewModel.viewStyle : null;
            updateRegistration(0, listViewStyle);
            zIsLoadingMore = ((j & 99) == 0 || listViewStyle == null) ? false : listViewStyle.isLoadingMore();
            long j2 = j & 95;
            if (j2 == 0 || listViewStyle == null) {
                emptyText = null;
                zIsRefreshing = false;
            } else {
                emptyText = listViewStyle.getEmptyText();
                zIsRefreshing = listViewStyle.isRefreshing();
            }
            if (j2 != 0) {
                ObservableList itemViewModel = pageListViewModel != null ? pageListViewModel.getItemViewModel() : null;
                updateRegistration(2, itemViewModel);
                z3 = (itemViewModel != null ? itemViewModel.size() : 0) > 0;
                if (j2 != 0) {
                    j |= z3 ? 256L : 128L;
                }
                ObservableList observableList3 = itemViewModel;
                z2 = !z3;
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
                replyCommand = null;
                str = emptyText;
                replyCommand2 = replyCommand3;
            } else {
                gVar = gVar2;
                observableList = observableList2;
                replyCommand = pageListViewModel.onLoadMoreCommand;
                replyCommand2 = replyCommand3;
                str = emptyText;
            }
            z = z3;
        } else {
            str = null;
            replyCommand = null;
            replyCommand2 = null;
            gVar = null;
            observableList = null;
            z = false;
            z2 = false;
            zIsRefreshing = false;
            zIsLoadingMore = false;
        }
        if ((j & 95) != 0) {
            PageLoadingViewBindingAdapters.initPageLoadingView(this.f17889f, str, z, zIsRefreshing, z2);
        }
        if ((j & 99) != 0) {
            SmartRefreshLayoutBindingAdapters.onLoadMoreCommand(this.g, replyCommand, zIsLoadingMore);
        }
        if ((j & 83) != 0) {
            SmartRefreshLayoutBindingAdapters.onRefreshCommand(this.g, replyCommand2, zIsRefreshing);
        }
        if ((64 & j) != 0) {
            RecyclerViewBindingAdapters.setItemDecoration(this.f17884a, i, 1, 12, 12);
        }
        if ((j & 70) != 0) {
            me.tatarka.bindingcollectionadapter2.e.a(this.f17884a, gVar, observableList, null, null, null);
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
        if (com.sandboxol.gamedetail.a.f17769b != i) {
            return false;
        }
        setViewModel((PageListViewModel) obj);
        return true;
    }

    public void setViewModel(PageListViewModel pageListViewModel) {
        updateRegistration(1, pageListViewModel);
        this.f17885b = pageListViewModel;
        synchronized (this) {
            this.h |= 2;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.f17769b);
        super.requestRebind();
    }

    private z(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (RecyclerView) objArr[3]);
        this.h = -1L;
        this.f17888e = (RelativeLayout) objArr[0];
        this.f17888e.setTag(null);
        this.f17889f = (PageLoadingView) objArr[1];
        this.f17889f.setTag(null);
        this.g = (SmartRefreshLayout) objArr[2];
        this.g.setTag(null);
        this.f17884a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
