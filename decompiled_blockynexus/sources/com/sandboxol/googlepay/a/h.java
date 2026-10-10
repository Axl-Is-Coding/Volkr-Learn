package com.sandboxol.googlepay.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: compiled from: FragmentRechargeHistoryBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f18197b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f18198c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PageRecyclerView f18199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f18200e;

    public h(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f18197b, f18198c));
    }

    @Override // com.sandboxol.googlepay.a.g
    public void a(com.sandboxol.googlepay.c.a.c.f fVar) {
        updateRegistration(0, fVar);
        this.f18196a = fVar;
        synchronized (this) {
            this.f18200e |= 1;
        }
        notifyPropertyChanged(com.sandboxol.googlepay.a.f18176e);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.sandboxol.googlepay.c.a.c.d dVar;
        com.sandboxol.googlepay.c.a.c.e eVar;
        synchronized (this) {
            j = this.f18200e;
            this.f18200e = 0L;
        }
        com.sandboxol.googlepay.c.a.c.f fVar = this.f18196a;
        long j2 = j & 3;
        if (j2 == 0 || fVar == null) {
            dVar = null;
            eVar = null;
        } else {
            com.sandboxol.googlepay.c.a.c.d dVar2 = fVar.f18354c;
            eVar = fVar.f18353b;
            dVar = dVar2;
        }
        if (j2 != 0) {
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.f18199d, dVar, eVar, null, false, false, false, 0, 0, false, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f18200e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f18200e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.googlepay.c.a.c.f) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.googlepay.a.f18176e != i) {
            return false;
        }
        a((com.sandboxol.googlepay.c.a.c.f) obj);
        return true;
    }

    private h(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f18200e = -1L;
        this.f18199d = (PageRecyclerView) objArr[0];
        this.f18199d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.googlepay.c.a.c.f fVar, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.f18200e |= 1;
        }
        return true;
    }
}
