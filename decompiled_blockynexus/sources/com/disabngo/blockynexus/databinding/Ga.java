package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: compiled from: ContentTribeShopPageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ga extends Fa {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7478b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7479c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PageRecyclerView f7480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7481e;

    public Ga(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f7478b, f7479c));
    }

    public void a(com.disabngo.blockynexus.view.activity.tribeshop.D d2) {
        updateRegistration(0, d2);
        this.f7438a = d2;
        synchronized (this) {
            this.f7481e |= 1;
        }
        notifyPropertyChanged(299);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7481e;
            this.f7481e = 0L;
        }
        com.disabngo.blockynexus.view.activity.tribeshop.D d2 = this.f7438a;
        com.disabngo.blockynexus.view.activity.tribeshop.C c2 = null;
        long j2 = j & 3;
        if (j2 != 0 && d2 != null) {
            c2 = d2.f11158a;
        }
        com.disabngo.blockynexus.view.activity.tribeshop.C c3 = c2;
        if (j2 != 0) {
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.f7480d, null, c3, me.tatarka.bindingcollectionadapter2.k.a(4), false, false, false, 0, 0, false, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7481e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7481e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.activity.tribeshop.D) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (299 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.tribeshop.D) obj);
        return true;
    }

    private Ga(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f7481e = -1L;
        this.f7480d = (PageRecyclerView) objArr[0];
        this.f7480d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.tribeshop.D d2, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7481e |= 1;
        }
        return true;
    }
}
