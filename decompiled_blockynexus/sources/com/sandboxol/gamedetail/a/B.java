package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.binding.adapter.PageLoadingViewBindingAdapters;
import com.sandboxol.common.binding.adapter.SmartRefreshLayoutBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.PageLoadingView;
import com.sandboxol.common.widget.rv.ListViewStyle;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: GameDetailShopListViewBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class B extends A {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f17776c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f17777d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f17778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PageLoadingView f17779f;
    private final SmartRefreshLayout g;
    private long h;

    public B(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f17776c, f17777d));
    }

    private boolean onChangeViewModel(DataListViewModel dataListViewModel, int i) {
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
        if (i != com.sandboxol.gamedetail.a.n) {
            return false;
        }
        synchronized (this) {
            this.h |= 16;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        boolean z;
        String emptyText;
        boolean z2;
        ReplyCommand replyCommand;
        boolean zIsRefreshing;
        me.tatarka.bindingcollectionadapter2.g gVar;
        ObservableList observableList;
        ObservableList itemViewModel;
        ListViewStyle listViewStyle;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        DataListViewModel dataListViewModel = this.f17775b;
        long j3 = j & 63;
        if (j3 != 0) {
            if (dataListViewModel != null) {
                listViewStyle = dataListViewModel.viewStyle;
                itemViewModel = dataListViewModel.getItemViewModel();
            } else {
                itemViewModel = null;
                listViewStyle = null;
            }
            updateRegistration(0, listViewStyle);
            updateRegistration(2, itemViewModel);
            if (listViewStyle != null) {
                emptyText = listViewStyle.getEmptyText();
                zIsRefreshing = listViewStyle.isRefreshing();
            } else {
                emptyText = null;
                zIsRefreshing = false;
            }
            boolean z3 = (itemViewModel != null ? itemViewModel.size() : 0) > 0;
            if (j3 != 0) {
                j |= z3 ? 128L : 64L;
            }
            z2 = !z3;
            replyCommand = ((j & 51) == 0 || dataListViewModel == null) ? null : dataListViewModel.onRefreshCommand;
            if ((j & 38) == 0 || dataListViewModel == null) {
                observableList = itemViewModel;
                z = z3;
                gVar = null;
            } else {
                gVar = dataListViewModel.itemBinding;
                observableList = itemViewModel;
                z = z3;
            }
            j2 = 63;
        } else {
            j2 = 63;
            z = false;
            emptyText = null;
            z2 = false;
            replyCommand = null;
            zIsRefreshing = false;
            gVar = null;
            observableList = null;
        }
        if ((j & j2) != 0) {
            PageLoadingViewBindingAdapters.initPageLoadingView(this.f17779f, emptyText, z, zIsRefreshing, z2);
        }
        if ((32 & j) != 0) {
            SmartRefreshLayoutBindingAdapters.onLoadMore(this.g, false);
        }
        if ((j & 51) != 0) {
            SmartRefreshLayoutBindingAdapters.onRefreshCommand(this.g, replyCommand, zIsRefreshing);
        }
        if ((j & 38) != 0) {
            me.tatarka.bindingcollectionadapter2.e.a(this.f17774a, gVar, observableList, null, null, null);
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
            this.h = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModelViewStyle((ListViewStyle) obj, i2);
        }
        if (i == 1) {
            return onChangeViewModel((DataListViewModel) obj, i2);
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
        setViewModel((DataListViewModel) obj);
        return true;
    }

    public void setViewModel(DataListViewModel dataListViewModel) {
        updateRegistration(1, dataListViewModel);
        this.f17775b = dataListViewModel;
        synchronized (this) {
            this.h |= 2;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.f17769b);
        super.requestRebind();
    }

    private B(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (RecyclerView) objArr[3]);
        this.h = -1L;
        this.f17778e = (RelativeLayout) objArr[0];
        this.f17778e.setTag(null);
        this.f17779f = (PageLoadingView) objArr[1];
        this.f17779f.setTag(null);
        this.g = (SmartRefreshLayout) objArr[2];
        this.g.setTag(null);
        this.f17774a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
