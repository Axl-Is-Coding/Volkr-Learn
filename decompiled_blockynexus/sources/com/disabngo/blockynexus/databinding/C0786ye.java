package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ye, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentInboxBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0786ye extends AbstractC0775xe {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f9013b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f9014c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DataRecyclerView f9015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f9016e;

    public C0786ye(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f9013b, f9014c));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0775xe
    public void a(com.disabngo.blockynexus.e.b.L.k kVar) {
        updateRegistration(0, kVar);
        this.f8972a = kVar;
        synchronized (this) {
            this.f9016e |= 1;
        }
        notifyPropertyChanged(444);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9016e;
            this.f9016e = 0L;
        }
        com.disabngo.blockynexus.e.b.L.k kVar = this.f8972a;
        com.disabngo.blockynexus.e.b.L.f fVar = null;
        long j2 = j & 3;
        if (j2 != 0 && kVar != null) {
            fVar = kVar.f9346b;
        }
        com.disabngo.blockynexus.e.b.L.f fVar2 = fVar;
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f9015d, null, fVar2, null, false, null, false, 0, false);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9016e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9016e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.L.k) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (444 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.L.k) obj);
        return true;
    }

    private C0786ye(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f9016e = -1L;
        this.f9015d = (DataRecyclerView) objArr[0];
        this.f9015d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.L.k kVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f9016e |= 1;
        }
        return true;
    }
}
