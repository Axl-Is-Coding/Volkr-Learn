package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.k.C0863c;
import com.disabngo.blockynexus.e.b.k.C0864d;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.td, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentCashHelpBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0730td extends AbstractC0719sd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8827b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8828c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f8829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataRecyclerView f8830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8831f;

    public C0730td(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f8827b, f8828c));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0719sd
    public void a(C0864d c0864d) {
        updateRegistration(0, c0864d);
        this.f8792a = c0864d;
        synchronized (this) {
            this.f8831f |= 1;
        }
        notifyPropertyChanged(384);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.disabngo.blockynexus.e.b.i.f fVar;
        C0863c c0863c;
        synchronized (this) {
            j = this.f8831f;
            this.f8831f = 0L;
        }
        C0864d c0864d = this.f8792a;
        long j2 = j & 3;
        if (j2 == 0 || c0864d == null) {
            fVar = null;
            c0863c = null;
        } else {
            com.disabngo.blockynexus.e.b.i.f fVar2 = c0864d.f9867b;
            c0863c = c0864d.f9866a;
            fVar = fVar2;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f8830e, fVar, c0863c, null, false, null, false, 0, false);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8831f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8831f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((C0864d) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (384 != i) {
            return false;
        }
        a((C0864d) obj);
        return true;
    }

    private C0730td(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f8831f = -1L;
        this.f8829d = (ConstraintLayout) objArr[0];
        this.f8829d.setTag(null);
        this.f8830e = (DataRecyclerView) objArr[1];
        this.f8830e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(C0864d c0864d, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8831f |= 1;
        }
        return true;
    }
}
