package com.sandboxol.vip.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.binding.adapter.PageLoadingViewBindingAdapters;
import com.sandboxol.common.widget.PageLoadingView;
import com.sandboxol.common.widget.rv.ListViewStyle;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: VipSubscribeVipListViewBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class z extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f19038c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f19039d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f19040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PageLoadingView f19041f;
    private long g;

    public z(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f19038c, f19039d));
    }

    private boolean onChangeViewModel(DataListViewModel dataListViewModel, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelItemViewModel(ObservableList observableList, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.g |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelViewStyle(ListViewStyle listViewStyle, int i) {
        if (i == com.sandboxol.vip.a.f18951a) {
            synchronized (this) {
                this.g |= 1;
            }
            return true;
        }
        if (i == com.sandboxol.vip.a.j) {
            synchronized (this) {
                this.g |= 8;
            }
            return true;
        }
        if (i != com.sandboxol.vip.a.i) {
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
        boolean z;
        String emptyText;
        boolean zIsRefreshing;
        me.tatarka.bindingcollectionadapter2.g gVar;
        ObservableList observableList;
        ListViewStyle listViewStyle;
        ObservableList itemViewModel;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        DataListViewModel dataListViewModel = this.f19037b;
        long j2 = j & 63;
        if (j2 != 0) {
            if (dataListViewModel != null) {
                listViewStyle = dataListViewModel.viewStyle;
                itemViewModel = dataListViewModel.getItemViewModel();
            } else {
                listViewStyle = null;
                itemViewModel = null;
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
            if (j2 != 0) {
                j |= z ? 128L : 64L;
            }
            z = !z;
            if ((j & 38) == 0 || dataListViewModel == null) {
                observableList = itemViewModel;
                gVar = null;
            } else {
                gVar = dataListViewModel.itemBinding;
                observableList = itemViewModel;
            }
        } else {
            z = false;
            emptyText = null;
            zIsRefreshing = false;
            gVar = null;
            observableList = null;
        }
        if ((63 & j) != 0) {
            PageLoadingViewBindingAdapters.initPageLoadingView(this.f19041f, emptyText, z, zIsRefreshing, z);
        }
        if ((j & 38) != 0) {
            me.tatarka.bindingcollectionadapter2.e.a(this.f19036a, gVar, observableList, null, null, null);
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
            return onChangeViewModel((DataListViewModel) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return onChangeViewModelItemViewModel((ObservableList) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.vip.a.f18952b != i) {
            return false;
        }
        setViewModel((DataListViewModel) obj);
        return true;
    }

    public void setViewModel(DataListViewModel dataListViewModel) {
        updateRegistration(1, dataListViewModel);
        this.f19037b = dataListViewModel;
        synchronized (this) {
            this.g |= 2;
        }
        notifyPropertyChanged(com.sandboxol.vip.a.f18952b);
        super.requestRebind();
    }

    private z(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (RecyclerView) objArr[2]);
        this.g = -1L;
        this.f19040e = (RelativeLayout) objArr[0];
        this.f19040e.setTag(null);
        this.f19041f = (PageLoadingView) objArr[1];
        this.f19041f.setTag(null);
        this.f19036a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
