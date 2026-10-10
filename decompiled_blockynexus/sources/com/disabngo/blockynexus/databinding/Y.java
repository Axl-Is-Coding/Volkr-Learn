package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.h.C0850a;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: ContentActivityTaskContentPageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Y extends X {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8046b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8047c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DataRecyclerView f8048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8049e;

    public Y(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f8046b, f8047c));
    }

    public void a(com.disabngo.blockynexus.view.dialog.activity.u uVar) {
        updateRegistration(0, uVar);
        this.f8018a = uVar;
        synchronized (this) {
            this.f8049e |= 1;
        }
        notifyPropertyChanged(294);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        C0850a c0850a;
        com.disabngo.blockynexus.view.dialog.activity.q qVar;
        synchronized (this) {
            j = this.f8049e;
            this.f8049e = 0L;
        }
        com.disabngo.blockynexus.view.dialog.activity.u uVar = this.f8018a;
        long j2 = j & 3;
        if (j2 == 0 || uVar == null) {
            c0850a = null;
            qVar = null;
        } else {
            C0850a c0850a2 = uVar.f11508b;
            qVar = uVar.f11507a;
            c0850a = c0850a2;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f8048d, c0850a, qVar, null, false, null, false, 100, false);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8049e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8049e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.dialog.activity.u) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (294 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.activity.u) obj);
        return true;
    }

    private Y(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f8049e = -1L;
        this.f8048d = (DataRecyclerView) objArr[0];
        this.f8048d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.activity.u uVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8049e |= 1;
        }
        return true;
    }
}
