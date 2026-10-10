package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.se, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentGroupVertificationBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0720se extends AbstractC0709re {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8793b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8794c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PageRecyclerView f8795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8796e;

    public C0720se(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f8793b, f8794c));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0709re
    public void a(com.disabngo.blockynexus.e.b.H.l lVar) {
        updateRegistration(0, lVar);
        this.f8758a = lVar;
        synchronized (this) {
            this.f8796e |= 1;
        }
        notifyPropertyChanged(263);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.disabngo.blockynexus.e.b.H.k kVar;
        com.disabngo.blockynexus.e.b.H.i iVar;
        synchronized (this) {
            j = this.f8796e;
            this.f8796e = 0L;
        }
        com.disabngo.blockynexus.e.b.H.l lVar = this.f8758a;
        long j2 = j & 3;
        if (j2 == 0 || lVar == null) {
            kVar = null;
            iVar = null;
        } else {
            com.disabngo.blockynexus.e.b.H.i iVar2 = lVar.f9308b;
            kVar = lVar.f9309c;
            iVar = iVar2;
        }
        if (j2 != 0) {
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.f8795d, kVar, iVar, null, false, false, false, 0, 0, false, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8796e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8796e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.H.l) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (263 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.H.l) obj);
        return true;
    }

    private C0720se(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f8796e = -1L;
        this.f8795d = (PageRecyclerView) objArr[0];
        this.f8795d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.H.l lVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8796e |= 1;
        }
        return true;
    }
}
