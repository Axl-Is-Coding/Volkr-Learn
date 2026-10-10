package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.decorate.view.fragment.dress.oa;
import com.sandboxol.decorate.view.fragment.dress.pa;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentDressSuitPageBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2587l extends AbstractC2586k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f17090b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f17091c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DataRecyclerView f17092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17093e;

    public C2587l(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f17090b, f17091c));
    }

    public void a(pa paVar) {
        updateRegistration(0, paVar);
        this.f17089a = paVar;
        synchronized (this) {
            this.f17093e |= 1;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.A);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f17093e;
            this.f17093e = 0L;
        }
        pa paVar = this.f17089a;
        oa oaVar = null;
        long j2 = j & 3;
        if (j2 != 0 && paVar != null) {
            oaVar = paVar.f17452a;
        }
        oa oaVar2 = oaVar;
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f17092d, null, oaVar2, me.tatarka.bindingcollectionadapter2.k.a(4), false, null, false, 0, true);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17093e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17093e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((pa) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.A != i) {
            return false;
        }
        a((pa) obj);
        return true;
    }

    private C2587l(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f17093e = -1L;
        this.f17092d = (DataRecyclerView) objArr[0];
        this.f17092d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(pa paVar, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.f17093e |= 1;
        }
        return true;
    }
}
