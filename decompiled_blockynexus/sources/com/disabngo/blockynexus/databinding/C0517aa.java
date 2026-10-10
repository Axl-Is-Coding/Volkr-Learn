package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.aa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentAppVideoRecommendPageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0517aa extends Z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8148b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8149c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PageRecyclerView f8150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8151e;

    public C0517aa(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f8148b, f8149c));
    }

    public void a(com.disabngo.blockynexus.e.b.xa.p pVar) {
        updateRegistration(0, pVar);
        this.f8079a = pVar;
        synchronized (this) {
            this.f8151e |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.disabngo.blockynexus.e.b.xa.h hVar;
        com.disabngo.blockynexus.e.b.xa.n nVar;
        synchronized (this) {
            j = this.f8151e;
            this.f8151e = 0L;
        }
        com.disabngo.blockynexus.e.b.xa.p pVar = this.f8079a;
        long j2 = j & 3;
        if (j2 == 0 || pVar == null) {
            hVar = null;
            nVar = null;
        } else {
            com.disabngo.blockynexus.e.b.xa.h hVar2 = pVar.f10344b;
            nVar = pVar.f10343a;
            hVar = hVar2;
        }
        if (j2 != 0) {
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.f8150d, hVar, nVar, me.tatarka.bindingcollectionadapter2.k.a(2), false, false, false, 0, 0, false, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8151e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8151e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.xa.p) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (1 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.xa.p) obj);
        return true;
    }

    private C0517aa(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f8151e = -1L;
        this.f8150d = (PageRecyclerView) objArr[0];
        this.f8150d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.xa.p pVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8151e |= 1;
        }
        return true;
    }
}
