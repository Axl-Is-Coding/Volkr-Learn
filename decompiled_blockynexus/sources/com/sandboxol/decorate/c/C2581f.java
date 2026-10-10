package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentDressShopPageBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2581f extends AbstractC2580e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f17075b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f17076c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DataRecyclerView f17077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17078e;

    public C2581f(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f17075b, f17076c));
    }

    public void a(com.sandboxol.decorate.view.activity.dress.O o) {
        updateRegistration(0, o);
        this.f17074a = o;
        synchronized (this) {
            this.f17078e |= 1;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.F);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f17078e;
            this.f17078e = 0L;
        }
        com.sandboxol.decorate.view.activity.dress.N n = null;
        com.sandboxol.decorate.view.activity.dress.O o = this.f17074a;
        long j2 = j & 3;
        if (j2 != 0 && o != null) {
            n = o.f17245a;
        }
        com.sandboxol.decorate.view.activity.dress.N n2 = n;
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f17077d, null, n2, me.tatarka.bindingcollectionadapter2.k.a(4), false, null, false, 0, true);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17078e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17078e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.decorate.view.activity.dress.O) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.F != i) {
            return false;
        }
        a((com.sandboxol.decorate.view.activity.dress.O) obj);
        return true;
    }

    private C2581f(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f17078e = -1L;
        this.f17077d = (DataRecyclerView) objArr[0];
        this.f17077d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.decorate.view.activity.dress.O o, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.f17078e |= 1;
        }
        return true;
    }
}
