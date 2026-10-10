package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.pagerv.PageListViewModel;

/* JADX INFO: compiled from: AppPartyCreatePageListViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class N extends M {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7696c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7697d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f7698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7699f;

    public N(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f7696c, f7697d));
    }

    private boolean onChangeViewModel(PageListViewModel pageListViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7699f |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelItemViewModel(ObservableList observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7699f |= 2;
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
            j = this.f7699f;
            this.f7699f = 0L;
        }
        PageListViewModel pageListViewModel = this.f7664b;
        long j2 = j & 7;
        ObservableList itemViewModel = null;
        if (j2 != 0) {
            if (pageListViewModel != null) {
                me.tatarka.bindingcollectionadapter2.g gVar3 = pageListViewModel.itemBinding;
                itemViewModel = pageListViewModel.getItemViewModel();
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
            me.tatarka.bindingcollectionadapter2.e.a(this.f7663a, gVar, observableList, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7699f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7699f = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModel((PageListViewModel) obj, i2);
        }
        if (i != 1) {
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
        updateRegistration(0, pageListViewModel);
        this.f7664b = pageListViewModel;
        synchronized (this) {
            this.f7699f |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    private N(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (RecyclerView) objArr[1]);
        this.f7699f = -1L;
        this.f7698e = (RelativeLayout) objArr[0];
        this.f7698e.setTag(null);
        this.f7663a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
