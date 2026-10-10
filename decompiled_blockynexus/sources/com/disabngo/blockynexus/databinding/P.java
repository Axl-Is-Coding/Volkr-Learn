package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: compiled from: AppScrapPageContentBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class P extends O {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7755c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7756d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f7757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7758f;

    public P(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f7755c, f7756d));
    }

    public void a(com.disabngo.blockynexus.e.b.da.p pVar) {
        updateRegistration(0, pVar);
        this.f7730b = pVar;
        synchronized (this) {
            this.f7758f |= 1;
        }
        notifyPropertyChanged(460);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7758f;
            this.f7758f = 0L;
        }
        com.disabngo.blockynexus.e.b.da.l lVar = null;
        com.disabngo.blockynexus.e.b.da.p pVar = this.f7730b;
        long j2 = j & 3;
        if (j2 != 0 && pVar != null) {
            lVar = pVar.f9721a;
        }
        com.disabngo.blockynexus.e.b.da.l lVar2 = lVar;
        if (j2 != 0) {
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.f7729a, null, lVar2, me.tatarka.bindingcollectionadapter2.k.a(4), true, false, false, 0, 0, false, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7758f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7758f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.da.p) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (460 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.da.p) obj);
        return true;
    }

    private P(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (PageRecyclerView) objArr[1]);
        this.f7758f = -1L;
        this.f7757e = (ConstraintLayout) objArr[0];
        this.f7757e.setTag(null);
        this.f7729a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.da.p pVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7758f |= 1;
        }
        return true;
    }
}
