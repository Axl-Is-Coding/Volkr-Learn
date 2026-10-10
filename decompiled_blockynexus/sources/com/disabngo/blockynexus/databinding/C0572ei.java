package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ei, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemMakeFriendTribeDetailLabelBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0572ei extends AbstractC0561di {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8309c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8310d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8311e;

    public C0572ei(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f8309c, f8310d));
    }

    public void a(com.disabngo.blockynexus.e.b.O.r rVar) {
        updateRegistration(0, rVar);
        this.f8275b = rVar;
        synchronized (this) {
            this.f8311e |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f8311e;
            this.f8311e = 0L;
        }
        com.disabngo.blockynexus.e.b.O.r rVar = this.f8275b;
        String item = null;
        long j2 = j & 7;
        if (j2 != 0 && rVar != null) {
            item = rVar.getItem();
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f8274a, item);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8311e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8311e = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.O.r) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.O.r) obj);
        return true;
    }

    private C0572ei(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (TextView) objArr[0]);
        this.f8311e = -1L;
        this.f8274a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.O.r rVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.f8311e |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.f8311e |= 2;
        }
        return true;
    }
}
