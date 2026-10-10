package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.decorate.view.fragment.dress.ia;
import com.sandboxol.decorate.view.fragment.dress.ja;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentDressPageBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2577b extends AbstractC2576a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f17064b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f17065c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DataRecyclerView f17066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17067e;

    public C2577b(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f17064b, f17065c));
    }

    public void a(ja jaVar) {
        updateRegistration(0, jaVar);
        this.f17063a = jaVar;
        synchronized (this) {
            this.f17067e |= 1;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.r);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f17067e;
            this.f17067e = 0L;
        }
        ja jaVar = this.f17063a;
        ia iaVar = null;
        long j2 = j & 3;
        if (j2 != 0 && jaVar != null) {
            iaVar = jaVar.f17434a;
        }
        ia iaVar2 = iaVar;
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f17066d, null, iaVar2, me.tatarka.bindingcollectionadapter2.k.a(4), false, null, false, 0, true);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17067e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17067e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((ja) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.r != i) {
            return false;
        }
        a((ja) obj);
        return true;
    }

    private C2577b(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f17067e = -1L;
        this.f17066d = (DataRecyclerView) objArr[0];
        this.f17066d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ja jaVar, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.f17067e |= 1;
        }
        return true;
    }
}
