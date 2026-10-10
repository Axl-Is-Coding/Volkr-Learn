package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentGameDetailIntroduceBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class r extends q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f17865c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f17866d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17867e;

    public r(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f17865c, f17866d));
    }

    @Override // com.sandboxol.gamedetail.a.q
    public void a(com.sandboxol.gamedetail.c.a.b.n nVar) {
        updateRegistration(0, nVar);
        this.f17864b = nVar;
        synchronized (this) {
            this.f17867e |= 1;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.f17773f);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.sandboxol.gamedetail.c.a.b.e eVar;
        com.sandboxol.gamedetail.c.a.b.h hVar;
        synchronized (this) {
            j = this.f17867e;
            this.f17867e = 0L;
        }
        com.sandboxol.gamedetail.c.a.b.n nVar = this.f17864b;
        long j2 = j & 3;
        if (j2 == 0 || nVar == null) {
            eVar = null;
            hVar = null;
        } else {
            com.sandboxol.gamedetail.c.a.b.e eVar2 = nVar.f18076b;
            hVar = nVar.f18075a;
            eVar = eVar2;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f17863a, eVar, hVar, null, false, null, false, 0, false);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17867e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17867e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.gamedetail.c.a.b.n) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.gamedetail.a.f17773f != i) {
            return false;
        }
        a((com.sandboxol.gamedetail.c.a.b.n) obj);
        return true;
    }

    private r(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (DataRecyclerView) objArr[0]);
        this.f17867e = -1L;
        this.f17863a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.gamedetail.c.a.b.n nVar, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.f17867e |= 1;
        }
        return true;
    }
}
