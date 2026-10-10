package com.sandboxol.halloween.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: HalloweenRewardListLayoutBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class t extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f18639c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f18640d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f18641e;

    public t(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f18639c, f18640d));
    }

    private boolean onChangeViewModel(DataListViewModel dataListViewModel, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.f18641e |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelItemViewModel(ObservableList observableList, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.f18641e |= 2;
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
            j = this.f18641e;
            this.f18641e = 0L;
        }
        DataListViewModel dataListViewModel = this.f18638b;
        long j2 = j & 7;
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
            me.tatarka.bindingcollectionadapter2.e.a(this.f18637a, gVar, observableList, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f18641e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f18641e = 4L;
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
        if (com.sandboxol.halloween.a.f18578b != i) {
            return false;
        }
        setViewModel((DataListViewModel) obj);
        return true;
    }

    public void setViewModel(DataListViewModel dataListViewModel) {
        updateRegistration(0, dataListViewModel);
        this.f18638b = dataListViewModel;
        synchronized (this) {
            this.f18641e |= 1;
        }
        notifyPropertyChanged(com.sandboxol.halloween.a.f18578b);
        super.requestRebind();
    }

    private t(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (RecyclerView) objArr[0]);
        this.f18641e = -1L;
        this.f18637a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
