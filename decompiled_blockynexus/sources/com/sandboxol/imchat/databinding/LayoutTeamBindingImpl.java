package com.sandboxol.imchat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.sandboxol.common.binding.adapter.PageLoadingViewBindingAdapters;
import com.sandboxol.common.widget.PageLoadingView;
import com.sandboxol.common.widget.rv.ListViewStyle;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;
import com.sandboxol.common.widget.rv.sbrv.SandboxRecyclerView;
import com.sandboxol.imchat.BR;
import me.tatarka.bindingcollectionadapter2.e;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutTeamBindingImpl extends LayoutTeamBinding {
    private static final ViewDataBinding.b sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;
    private final PageLoadingView mboundView2;

    public LayoutTeamBindingImpl(d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, sIncludes, sViewsWithIds));
    }

    private boolean onChangeViewModel(DataListViewModel dataListViewModel, int i) {
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
        if (i != BR.refreshing) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        String emptyText;
        boolean zIsRefreshing;
        g gVar;
        ObservableList observableList;
        ListViewStyle listViewStyle;
        ObservableList itemViewModel;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        DataListViewModel dataListViewModel = this.mViewModel;
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
            PageLoadingViewBindingAdapters.initPageLoadingView(this.mboundView2, emptyText, z, zIsRefreshing, z);
        }
        if ((j & 38) != 0) {
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
            this.mDirtyFlags = 32L;
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
        if (BR.ViewModel != i) {
            return false;
        }
        setViewModel((DataListViewModel) obj);
        return true;
    }

    @Override // com.sandboxol.imchat.databinding.LayoutTeamBinding
    public void setViewModel(DataListViewModel dataListViewModel) {
        updateRegistration(1, dataListViewModel);
        this.mViewModel = dataListViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    private LayoutTeamBindingImpl(d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (SandboxRecyclerView) objArr[1]);
        this.mDirtyFlags = -1L;
        this.mboundView0 = (RelativeLayout) objArr[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (PageLoadingView) objArr[2];
        this.mboundView2.setTag(null);
        this.rvData.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
