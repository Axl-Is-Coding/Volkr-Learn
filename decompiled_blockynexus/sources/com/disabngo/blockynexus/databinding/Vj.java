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
import com.sandboxol.common.widget.PageLoadingView;
import com.sandboxol.common.widget.rv.ListViewStyle;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: PartyHallDataListViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Vj extends Uj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7981c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7982d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f7983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PageLoadingView f7984f;
    private long g;

    public Vj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f7981c, f7982d));
    }

    private boolean onChangeViewModel(DataListViewModel dataListViewModel, int i) {
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
        boolean z;
        boolean z2;
        String emptyText;
        boolean zIsRefreshing;
        me.tatarka.bindingcollectionadapter2.g gVar;
        ObservableList observableList;
        ObservableList itemViewModel;
        ListViewStyle listViewStyle;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        DataListViewModel dataListViewModel = this.f7948b;
        long j2 = j & 63;
        if (j2 != 0) {
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
            if (j2 != 0) {
                j |= z3 ? 128L : 64L;
            }
            z2 = !z3;
            if ((j & 38) == 0 || dataListViewModel == null) {
                observableList = itemViewModel;
                z = z3;
                gVar = null;
            } else {
                gVar = dataListViewModel.itemBinding;
                observableList = itemViewModel;
                z = z3;
            }
        } else {
            z = false;
            z2 = false;
            emptyText = null;
            zIsRefreshing = false;
            gVar = null;
            observableList = null;
        }
        if ((63 & j) != 0) {
            PageLoadingViewBindingAdapters.initPageLoadingView(this.f7984f, emptyText, z, zIsRefreshing, z2);
        }
        if ((j & 38) != 0) {
            me.tatarka.bindingcollectionadapter2.e.a(this.f7947a, gVar, observableList, null, null, null);
        }
        if ((j & 32) != 0) {
            RecyclerViewBindingAdapters.setItemDecoration(this.f7947a, R.color.borderLineColor, 1, 0, 0);
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
        if (2 != i) {
            return false;
        }
        setViewModel((DataListViewModel) obj);
        return true;
    }

    public void setViewModel(DataListViewModel dataListViewModel) {
        updateRegistration(1, dataListViewModel);
        this.f7948b = dataListViewModel;
        synchronized (this) {
            this.g |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    private Vj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (RecyclerView) objArr[2]);
        this.g = -1L;
        this.f7983e = (RelativeLayout) objArr[0];
        this.f7983e.setTag(null);
        this.f7984f = (PageLoadingView) objArr[1];
        this.f7984f.setTag(null);
        this.f7947a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
