package com.sandboxol.halloween.b;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: HalloweenFragmentTasksBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class n extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f18620b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f18621c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f18622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataRecyclerView f18623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f18624f;

    public n(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f18620b, f18621c));
    }

    @Override // com.sandboxol.halloween.b.m
    public void a(com.sandboxol.halloween.view.fragment.tasks.j jVar) {
        updateRegistration(0, jVar);
        this.f18619a = jVar;
        synchronized (this) {
            this.f18624f |= 1;
        }
        notifyPropertyChanged(com.sandboxol.halloween.a.f18578b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f18624f;
            this.f18624f = 0L;
        }
        com.sandboxol.halloween.view.fragment.tasks.f fVar = null;
        com.sandboxol.halloween.view.fragment.tasks.j jVar = this.f18619a;
        long j2 = j & 3;
        if (j2 != 0 && jVar != null) {
            fVar = jVar.f18750b;
        }
        com.sandboxol.halloween.view.fragment.tasks.f fVar2 = fVar;
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f18623e, null, fVar2, me.tatarka.bindingcollectionadapter2.k.a(1, false), true, null, false, 0, false);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f18624f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f18624f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.halloween.view.fragment.tasks.j) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.halloween.a.f18578b != i) {
            return false;
        }
        a((com.sandboxol.halloween.view.fragment.tasks.j) obj);
        return true;
    }

    private n(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f18624f = -1L;
        this.f18622d = (ConstraintLayout) objArr[0];
        this.f18622d.setTag(null);
        this.f18623e = (DataRecyclerView) objArr[1];
        this.f18623e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.halloween.view.fragment.tasks.j jVar, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.f18624f |= 1;
        }
        return true;
    }
}
