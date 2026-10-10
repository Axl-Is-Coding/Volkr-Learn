package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: renamed from: com.sandboxol.gamedetail.a.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentGameDetailRankPageBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2675d extends AbstractC2674c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f17823b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f17824c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PageRecyclerView f17825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17826e;

    public C2675d(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f17823b, f17824c));
    }

    public void a(com.sandboxol.gamedetail.c.a.c.m mVar) {
        updateRegistration(0, mVar);
        this.f17822a = mVar;
        synchronized (this) {
            this.f17826e |= 1;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.l);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.sandboxol.gamedetail.c.a.c.j jVar;
        com.sandboxol.gamedetail.c.a.c.l lVar;
        synchronized (this) {
            j = this.f17826e;
            this.f17826e = 0L;
        }
        com.sandboxol.gamedetail.c.a.c.m mVar = this.f17822a;
        long j2 = j & 3;
        if (j2 == 0 || mVar == null) {
            jVar = null;
            lVar = null;
        } else {
            com.sandboxol.gamedetail.c.a.c.l lVar2 = mVar.f18092a;
            jVar = mVar.f18093b;
            lVar = lVar2;
        }
        if (j2 != 0) {
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.f17825d, jVar, lVar, null, false, false, false, 0, 0, false, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17826e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17826e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.gamedetail.c.a.c.m) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.gamedetail.a.l != i) {
            return false;
        }
        a((com.sandboxol.gamedetail.c.a.c.m) obj);
        return true;
    }

    private C2675d(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f17826e = -1L;
        this.f17825d = (PageRecyclerView) objArr[0];
        this.f17825d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.gamedetail.c.a.c.m mVar, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.f17826e |= 1;
        }
        return true;
    }
}
