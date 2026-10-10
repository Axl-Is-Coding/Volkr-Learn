package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.c.C0824d;
import com.disabngo.blockynexus.e.b.c.C0826f;
import com.disabngo.blockynexus.e.b.c.C0827g;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentActivityBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class _c extends Zc {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8121c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8122d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f8123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8124f;

    public _c(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f8121c, f8122d));
    }

    @Override // com.disabngo.blockynexus.databinding.Zc
    public void a(C0827g c0827g) {
        updateRegistration(0, c0827g);
        this.f8088b = c0827g;
        synchronized (this) {
            this.f8124f |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        C0824d c0824d;
        C0826f c0826f;
        synchronized (this) {
            j = this.f8124f;
            this.f8124f = 0L;
        }
        C0827g c0827g = this.f8088b;
        long j2 = j & 3;
        if (j2 == 0 || c0827g == null) {
            c0824d = null;
            c0826f = null;
        } else {
            C0826f c0826f2 = c0827g.f9680b;
            c0824d = c0827g.f9681c;
            c0826f = c0826f2;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f8087a, c0824d, c0826f, null, false, null, false, 0, false);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8124f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8124f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((C0827g) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((C0827g) obj);
        return true;
    }

    private _c(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (DataRecyclerView) objArr[1]);
        this.f8124f = -1L;
        this.f8087a.setTag(null);
        this.f8123e = (ConstraintLayout) objArr[0];
        this.f8123e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(C0827g c0827g, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8124f |= 1;
        }
        return true;
    }
}
