package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: compiled from: FragmentNewFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ke extends Je {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7609b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7610c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PageRecyclerView f7611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7612e;

    public Ke(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f7609b, f7610c));
    }

    @Override // com.disabngo.blockynexus.databinding.Je
    public void a(com.disabngo.blockynexus.e.b.Q.j jVar) {
        updateRegistration(0, jVar);
        this.f7585a = jVar;
        synchronized (this) {
            this.f7612e |= 1;
        }
        notifyPropertyChanged(441);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.disabngo.blockynexus.e.b.Q.i iVar;
        com.disabngo.blockynexus.e.b.Q.h hVar;
        synchronized (this) {
            j = this.f7612e;
            this.f7612e = 0L;
        }
        com.disabngo.blockynexus.e.b.Q.j jVar = this.f7585a;
        long j2 = j & 3;
        if (j2 == 0 || jVar == null) {
            iVar = null;
            hVar = null;
        } else {
            com.disabngo.blockynexus.e.b.Q.i iVar2 = jVar.f9408c;
            hVar = jVar.f9407b;
            iVar = iVar2;
        }
        if (j2 != 0) {
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.f7611d, iVar, hVar, null, false, false, false, 0, 0, false, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7612e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7612e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.Q.j) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (441 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.Q.j) obj);
        return true;
    }

    private Ke(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f7612e = -1L;
        this.f7611d = (PageRecyclerView) objArr[0];
        this.f7611d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.Q.j jVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7612e |= 1;
        }
        return true;
    }
}
