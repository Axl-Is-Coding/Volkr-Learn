package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.sandbox.login.c.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: LoginAccountListLayoutBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2438f extends AbstractC2437e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f15638b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f15639c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f15640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataRecyclerView f15641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f15642f;

    public C2438f(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f15638b, f15639c));
    }

    public void a(com.sandbox.login.view.widget.account.g gVar) {
        updateRegistration(0, gVar);
        this.f15637a = gVar;
        synchronized (this) {
            this.f15642f |= 1;
        }
        notifyPropertyChanged(com.sandbox.login.g.f15905b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.sandbox.login.view.widget.account.d dVar;
        com.sandbox.login.view.widget.account.e eVar;
        synchronized (this) {
            j = this.f15642f;
            this.f15642f = 0L;
        }
        com.sandbox.login.view.widget.account.g gVar = this.f15637a;
        long j2 = j & 3;
        if (j2 == 0 || gVar == null) {
            dVar = null;
            eVar = null;
        } else {
            com.sandbox.login.view.widget.account.d dVar2 = gVar.f16009b;
            eVar = gVar.f16008a;
            dVar = dVar2;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f15641e, dVar, eVar, me.tatarka.bindingcollectionadapter2.k.a(1, false), true, null, false, 0, false);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15642f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15642f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandbox.login.view.widget.account.g) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandbox.login.g.f15905b != i) {
            return false;
        }
        a((com.sandbox.login.view.widget.account.g) obj);
        return true;
    }

    private C2438f(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f15642f = -1L;
        this.f15640d = (ConstraintLayout) objArr[0];
        this.f15640d.setTag(null);
        this.f15641e = (DataRecyclerView) objArr[1];
        this.f15641e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandbox.login.view.widget.account.g gVar, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.f15642f |= 1;
        }
        return true;
    }
}
