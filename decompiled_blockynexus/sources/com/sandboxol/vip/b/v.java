package com.sandboxol.vip.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.sandboxol.common.widget.rv.datarv.DataListViewModel;

/* JADX INFO: compiled from: VipListLayoutMorePrivilegeBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class v extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f19028c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f19029d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f19030e;

    public v(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f19028c, f19029d));
    }

    private boolean onChangeViewModel(DataListViewModel dataListViewModel, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.f19030e |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelItemViewModel(ObservableList observableList, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.f19030e |= 2;
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
            j = this.f19030e;
            this.f19030e = 0L;
        }
        DataListViewModel dataListViewModel = this.f19027b;
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
            me.tatarka.bindingcollectionadapter2.e.a(this.f19026a, gVar, observableList, null, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f19030e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f19030e = 4L;
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
        if (com.sandboxol.vip.a.f18952b != i) {
            return false;
        }
        setViewModel((DataListViewModel) obj);
        return true;
    }

    public void setViewModel(DataListViewModel dataListViewModel) {
        updateRegistration(0, dataListViewModel);
        this.f19027b = dataListViewModel;
        synchronized (this) {
            this.f19030e |= 1;
        }
        notifyPropertyChanged(com.sandboxol.vip.a.f18952b);
        super.requestRebind();
    }

    private v(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (RecyclerView) objArr[0]);
        this.f19030e = -1L;
        this.f19026a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
