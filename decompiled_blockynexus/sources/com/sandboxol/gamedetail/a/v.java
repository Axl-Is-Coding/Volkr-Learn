package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentGameDetailShopBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class v extends u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f17875b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f17876c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DataRecyclerView f17877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17878e;

    public v(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f17875b, f17876c));
    }

    @Override // com.sandboxol.gamedetail.a.u
    public void a(com.sandboxol.gamedetail.c.a.d.j jVar) {
        updateRegistration(0, jVar);
        this.f17874a = jVar;
        synchronized (this) {
            this.f17878e |= 1;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.f17772e);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.sandboxol.gamedetail.c.a.d.e eVar;
        com.sandboxol.gamedetail.c.a.d.i iVar;
        synchronized (this) {
            j = this.f17878e;
            this.f17878e = 0L;
        }
        com.sandboxol.gamedetail.c.a.d.j jVar = this.f17874a;
        long j2 = j & 3;
        if (j2 == 0 || jVar == null) {
            eVar = null;
            iVar = null;
        } else {
            com.sandboxol.gamedetail.c.a.d.e eVar2 = jVar.f18111b;
            iVar = jVar.f18110a;
            eVar = eVar2;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f17877d, eVar, iVar, me.tatarka.bindingcollectionadapter2.k.a(3), false, null, false, 0, false);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17878e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17878e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.gamedetail.c.a.d.j) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.gamedetail.a.f17772e != i) {
            return false;
        }
        a((com.sandboxol.gamedetail.c.a.d.j) obj);
        return true;
    }

    private v(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f17878e = -1L;
        this.f17877d = (DataRecyclerView) objArr[0];
        this.f17877d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.gamedetail.c.a.d.j jVar, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.f17878e |= 1;
        }
        return true;
    }
}
