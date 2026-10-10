package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.PageLoadingViewBindingAdapters;
import com.sandboxol.common.widget.PageLoadingView;
import com.sandboxol.common.widget.rv.ListViewStyle;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;
import com.sandboxol.common.widget.rv.sbrv.SandboxRecyclerView;

/* JADX INFO: compiled from: RecommendGameListViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Zj extends Yj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8111c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8112d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f8113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PageLoadingView f8114f;
    private long g;

    public Zj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f8111c, f8112d));
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
        boolean z3;
        String emptyText;
        me.tatarka.bindingcollectionadapter2.g gVar;
        ObservableList observableList;
        ListViewStyle listViewStyle;
        ObservableList itemViewModel;
        boolean zIsRefreshing;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        DataListViewModel dataListViewModel = this.f8078b;
        long j2 = j & 63;
        int i = 0;
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
            boolean z4 = (itemViewModel != null ? itemViewModel.size() : 0) > 0;
            if (j2 != 0) {
                j |= z4 ? 128L : 64L;
            }
            if ((j & 38) != 0) {
                j |= z4 ? 512L : 256L;
            }
            boolean z5 = !z4;
            long j3 = j & 38;
            if (j3 != 0 && !z4) {
                i = 4;
            }
            if (j3 == 0 || dataListViewModel == null) {
                z3 = z5;
                z2 = zIsRefreshing;
                observableList = itemViewModel;
                z = z4;
                gVar = null;
            } else {
                z3 = z5;
                z2 = zIsRefreshing;
                observableList = itemViewModel;
                gVar = dataListViewModel.itemBinding;
                z = z4;
            }
        } else {
            z = false;
            z2 = false;
            z3 = false;
            emptyText = null;
            gVar = null;
            observableList = null;
        }
        if ((38 & j) != 0) {
            this.f8113e.setVisibility(i);
            me.tatarka.bindingcollectionadapter2.e.a(this.f8077a, gVar, observableList, null, null, null);
        }
        if ((j & 63) != 0) {
            PageLoadingViewBindingAdapters.initPageLoadingView(this.f8114f, emptyText, z, z2, z3);
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
        this.f8078b = dataListViewModel;
        synchronized (this) {
            this.g |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    private Zj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (SandboxRecyclerView) objArr[1]);
        this.g = -1L;
        this.f8113e = (RelativeLayout) objArr[0];
        this.f8113e.setTag(null);
        this.f8114f = (PageLoadingView) objArr[2];
        this.f8114f.setTag(null);
        this.f8077a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
