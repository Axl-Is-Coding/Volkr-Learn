package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.binding.adapter.RecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: LoginDataListViewBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f15663c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f15664d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f15665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f15666f;

    public o(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f15663c, f15664d));
    }

    private boolean onChangeViewModel(DataListViewModel dataListViewModel, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.f15666f |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelItemViewModel(ObservableList observableList, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.f15666f |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        me.tatarka.bindingcollectionadapter2.g gVar;
        ObservableList observableList;
        me.tatarka.bindingcollectionadapter2.g gVar2;
        synchronized (this) {
            j = this.f15666f;
            this.f15666f = 0L;
        }
        DataListViewModel dataListViewModel = this.f15662b;
        long j2 = 7 & j;
        ObservableList itemViewModel = null;
        if (j2 != 0) {
            if (dataListViewModel != null) {
                me.tatarka.bindingcollectionadapter2.g gVar3 = dataListViewModel.itemBinding;
                itemViewModel = dataListViewModel.getItemViewModel();
                gVar2 = gVar3;
            } else {
                gVar2 = null;
            }
            updateRegistration(1, itemViewModel);
            gVar = gVar2;
            observableList = itemViewModel;
        } else {
            gVar = null;
            observableList = null;
        }
        if (j2 != 0) {
            me.tatarka.bindingcollectionadapter2.e.a(this.f15661a, gVar, observableList, null, null, null);
        }
        if ((j & 4) != 0) {
            RecyclerViewBindingAdapters.setItemDecoration(this.f15661a, 0, 1, 0, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15666f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15666f = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModel((DataListViewModel) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeViewModelItemViewModel((ObservableList) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandbox.login.g.f15905b != i) {
            return false;
        }
        setViewModel((DataListViewModel) obj);
        return true;
    }

    public void setViewModel(DataListViewModel dataListViewModel) {
        updateRegistration(0, dataListViewModel);
        this.f15662b = dataListViewModel;
        synchronized (this) {
            this.f15666f |= 1;
        }
        notifyPropertyChanged(com.sandbox.login.g.f15905b);
        super.requestRebind();
    }

    private o(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (RecyclerView) objArr[1]);
        this.f15666f = -1L;
        this.f15665e = (RelativeLayout) objArr[0];
        this.f15665e.setTag(null);
        this.f15661a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
