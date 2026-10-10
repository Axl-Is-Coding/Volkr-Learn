package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.PageLoadingViewBindingAdapters;
import com.sandboxol.common.binding.adapter.RecyclerViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.AutoHorizontalRecyclerView;
import com.sandboxol.common.widget.PageLoadingView;
import com.sandboxol.common.widget.rv.ListViewStyle;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;

/* JADX INFO: compiled from: NoRefrshPageListViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Tj extends Sj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7917c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7918d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f7919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PageLoadingView f7920f;
    private long g;

    public Tj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f7917c, f7918d));
    }

    private boolean onChangeViewModel(PageListViewModel pageListViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelItemViewModel(ObservableList observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelViewStyle(ListViewStyle listViewStyle, int i) {
        if (i == 0) {
            synchronized (this) {
                this.g |= 1;
            }
            return true;
        }
        if (i == 246) {
            synchronized (this) {
                this.g |= 8;
            }
            return true;
        }
        if (i != 245) {
            return false;
        }
        synchronized (this) {
            this.g |= 16;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        String emptyText;
        boolean z;
        ReplyCommand<Integer> replyCommand;
        boolean zIsRefreshing;
        me.tatarka.bindingcollectionadapter2.g gVar;
        ObservableList observableList;
        ObservableList itemViewModel;
        ListViewStyle listViewStyle;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        PageListViewModel pageListViewModel = this.f7884b;
        long j3 = j & 63;
        if (j3 != 0) {
            if (pageListViewModel != null) {
                listViewStyle = pageListViewModel.viewStyle;
                itemViewModel = pageListViewModel.getItemViewModel();
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
            z = (itemViewModel != null ? itemViewModel.size() : 0) > 0;
            if (j3 != 0) {
                j |= z ? 128L : 64L;
            }
            z = !z;
            replyCommand = ((j & 34) == 0 || pageListViewModel == null) ? null : pageListViewModel.onLoadMoreCommand;
            if ((j & 38) == 0 || pageListViewModel == null) {
                observableList = itemViewModel;
                gVar = null;
            } else {
                gVar = pageListViewModel.itemBinding;
                observableList = itemViewModel;
            }
            j2 = 63;
        } else {
            j2 = 63;
            emptyText = null;
            z = false;
            replyCommand = null;
            zIsRefreshing = false;
            gVar = null;
            observableList = null;
        }
        if ((j & j2) != 0) {
            PageLoadingViewBindingAdapters.initPageLoadingView(this.f7920f, emptyText, z, zIsRefreshing, z);
        }
        if ((j & 34) != 0) {
            RecyclerViewBindingAdapters.onLoadMoreCommand(this.f7883a, replyCommand);
        }
        if ((j & 38) != 0) {
            me.tatarka.bindingcollectionadapter2.e.a(this.f7883a, gVar, observableList, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 32L;
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
        this.f7884b = pageListViewModel;
        synchronized (this) {
            this.g |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    private Tj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (AutoHorizontalRecyclerView) objArr[2]);
        this.g = -1L;
        this.f7919e = (RelativeLayout) objArr[0];
        this.f7919e.setTag(null);
        this.f7920f = (PageLoadingView) objArr[1];
        this.f7920f.setTag(null);
        this.f7883a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
