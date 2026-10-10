package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.x.C0935C;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentTribeMessageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Rf extends Qf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7840b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7841c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DataRecyclerView f7842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7843e;

    public Rf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f7840b, f7841c));
    }

    @Override // com.disabngo.blockynexus.databinding.Qf
    public void a(com.disabngo.blockynexus.e.b.pa.k kVar) {
        updateRegistration(0, kVar);
        this.f7811a = kVar;
        synchronized (this) {
            this.f7843e |= 1;
        }
        notifyPropertyChanged(457);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        C0935C c0935c;
        com.disabngo.blockynexus.e.b.pa.j jVar;
        synchronized (this) {
            j = this.f7843e;
            this.f7843e = 0L;
        }
        com.disabngo.blockynexus.e.b.pa.k kVar = this.f7811a;
        long j2 = j & 3;
        if (j2 == 0 || kVar == null) {
            c0935c = null;
            jVar = null;
        } else {
            C0935C c0935c2 = kVar.f10063a;
            jVar = kVar.f10064b;
            c0935c = c0935c2;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f7842d, c0935c, jVar, null, false, null, false, 0, false);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7843e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7843e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.pa.k) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (457 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.pa.k) obj);
        return true;
    }

    private Rf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f7843e = -1L;
        this.f7842d = (DataRecyclerView) objArr[0];
        this.f7842d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.pa.k kVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7843e |= 1;
        }
        return true;
    }
}
