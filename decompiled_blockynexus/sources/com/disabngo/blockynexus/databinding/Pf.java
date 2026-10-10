package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.x.C0935C;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentTribeMemberManageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Pf extends Of {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7771b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7772c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataRecyclerView f7774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7775f;

    public Pf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f7771b, f7772c));
    }

    @Override // com.disabngo.blockynexus.databinding.Of
    public void a(com.disabngo.blockynexus.e.b.oa.b bVar) {
        updateRegistration(0, bVar);
        this.f7744a = bVar;
        synchronized (this) {
            this.f7775f |= 1;
        }
        notifyPropertyChanged(317);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        C0935C c0935c;
        com.disabngo.blockynexus.view.fragment.tribehas.L l;
        synchronized (this) {
            j = this.f7775f;
            this.f7775f = 0L;
        }
        com.disabngo.blockynexus.e.b.oa.b bVar = this.f7744a;
        long j2 = j & 3;
        if (j2 == 0 || bVar == null) {
            c0935c = null;
            l = null;
        } else {
            C0935C c0935c2 = bVar.f10028b;
            l = bVar.f10029c;
            c0935c = c0935c2;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f7774e, c0935c, l, null, false, null, false, 0, false);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7775f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7775f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.oa.b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (317 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.oa.b) obj);
        return true;
    }

    private Pf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f7775f = -1L;
        this.f7773d = (LinearLayout) objArr[0];
        this.f7773d.setTag(null);
        this.f7774e = (DataRecyclerView) objArr[1];
        this.f7774e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.oa.b bVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7775f |= 1;
        }
        return true;
    }
}
