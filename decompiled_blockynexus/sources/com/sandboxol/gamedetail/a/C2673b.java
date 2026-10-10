package com.sandboxol.gamedetail.a;

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

/* JADX INFO: renamed from: com.sandboxol.gamedetail.a.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AuthorListListViewBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2673b extends AbstractC2672a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f17818c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f17819d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f17820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PageLoadingView f17821f;
    private long g;

    public C2673b(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f17818c, f17819d));
    }

    private boolean onChangeViewModel(DataListViewModel dataListViewModel, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelItemViewModel(ObservableList observableList, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.g |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelViewStyle(ListViewStyle listViewStyle, int i) {
        if (i == com.sandboxol.gamedetail.a.f17768a) {
            synchronized (this) {
                this.g |= 1;
            }
            return true;
        }
        if (i == com.sandboxol.gamedetail.a.o) {
            synchronized (this) {
                this.g |= 8;
            }
            return true;
        }
        if (i != com.sandboxol.gamedetail.a.n) {
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
        DataListViewModel dataListViewModel = this.f17817b;
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
            PageLoadingViewBindingAdapters.initPageLoadingView(this.f17821f, emptyText, z, zIsRefreshing, z);
        }
        if ((j & 38) != 0) {
            me.tatarka.bindingcollectionadapter2.e.a(this.f17816a, gVar, observableList, null, null, null);
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
        if (com.sandboxol.gamedetail.a.f17769b != i) {
            return false;
        }
        setViewModel((DataListViewModel) obj);
        return true;
    }

    public void setViewModel(DataListViewModel dataListViewModel) {
        updateRegistration(1, dataListViewModel);
        this.f17817b = dataListViewModel;
        synchronized (this) {
            this.g |= 2;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.f17769b);
        super.requestRebind();
    }

    private C2673b(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (SandboxRecyclerView) objArr[1]);
        this.g = -1L;
        this.f17820e = (RelativeLayout) objArr[0];
        this.f17820e.setTag(null);
        this.f17821f = (PageLoadingView) objArr[2];
        this.f17821f.setTag(null);
        this.f17816a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
