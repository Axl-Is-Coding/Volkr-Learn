package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ee, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentGroupBannedBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0568ee extends AbstractC0557de {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8298b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8299c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FrameLayout f8300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataRecyclerView f8301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8302f;

    public C0568ee(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f8298b, f8299c));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0557de
    public void a(com.disabngo.blockynexus.e.b.A.m mVar) {
        updateRegistration(0, mVar);
        this.f8261a = mVar;
        synchronized (this) {
            this.f8302f |= 1;
        }
        notifyPropertyChanged(522);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.disabngo.blockynexus.e.b.A.i iVar;
        com.disabngo.blockynexus.e.b.A.j jVar;
        synchronized (this) {
            j = this.f8302f;
            this.f8302f = 0L;
        }
        com.disabngo.blockynexus.e.b.A.m mVar = this.f8261a;
        long j2 = j & 3;
        if (j2 == 0 || mVar == null) {
            iVar = null;
            jVar = null;
        } else {
            com.disabngo.blockynexus.e.b.A.j jVar2 = mVar.f9107e;
            iVar = mVar.f9106d;
            jVar = jVar2;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f8301e, iVar, jVar, null, false, null, false, 0, false);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8302f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8302f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.A.m) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (522 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.A.m) obj);
        return true;
    }

    private C0568ee(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f8302f = -1L;
        this.f8300d = (FrameLayout) objArr[0];
        this.f8300d.setTag(null);
        this.f8301e = (DataRecyclerView) objArr[1];
        this.f8301e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.A.m mVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8302f |= 1;
        }
        return true;
    }
}
