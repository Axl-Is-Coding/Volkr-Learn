package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ya, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentRankOverallTypePageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0782ya extends AbstractC0771xa {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f9002b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f9003c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f9004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataRecyclerView f9005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f9006f;

    public C0782ya(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f9002b, f9003c));
    }

    public void a(com.disabngo.blockynexus.view.activity.overviewrank.j jVar) {
        this.f8956a = jVar;
        synchronized (this) {
            this.f9006f |= 1;
        }
        notifyPropertyChanged(386);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.disabngo.blockynexus.view.activity.overviewrank.g gVar;
        com.disabngo.blockynexus.view.activity.overviewrank.i iVar;
        synchronized (this) {
            j = this.f9006f;
            this.f9006f = 0L;
        }
        com.disabngo.blockynexus.view.activity.overviewrank.j jVar = this.f8956a;
        long j2 = j & 3;
        if (j2 == 0 || jVar == null) {
            gVar = null;
            iVar = null;
        } else {
            com.disabngo.blockynexus.view.activity.overviewrank.i iVar2 = jVar.f11053d;
            gVar = jVar.f11054e;
            iVar = iVar2;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f9005e, gVar, iVar, me.tatarka.bindingcollectionadapter2.k.a(2), false, null, false, 0, false);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9006f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9006f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (386 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.overviewrank.j) obj);
        return true;
    }

    private C0782ya(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0);
        this.f9006f = -1L;
        this.f9004d = (ConstraintLayout) objArr[0];
        this.f9004d.setTag(null);
        this.f9005e = (DataRecyclerView) objArr[1];
        this.f9005e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
