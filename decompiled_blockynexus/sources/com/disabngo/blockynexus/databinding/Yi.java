package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemScrapRuleTextBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Yi extends Xi {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8072b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8073c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f8074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f8075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8076f;

    public Yi(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f8072b, f8073c));
    }

    public void a(com.disabngo.blockynexus.view.dialog.h.c cVar) {
        updateRegistration(0, cVar);
        this.f8041a = cVar;
        synchronized (this) {
            this.f8076f |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f8076f;
            this.f8076f = 0L;
        }
        com.disabngo.blockynexus.view.dialog.h.c cVar = this.f8041a;
        String item = null;
        long j2 = j & 7;
        if (j2 != 0 && cVar != null) {
            item = cVar.getItem();
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f8075e, item);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8076f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8076f = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.dialog.h.c) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.h.c) obj);
        return true;
    }

    private Yi(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f8076f = -1L;
        this.f8074d = (ConstraintLayout) objArr[0];
        this.f8074d.setTag(null);
        this.f8075e = (TextView) objArr[1];
        this.f8075e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.h.c cVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.f8076f |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.f8076f |= 2;
        }
        return true;
    }
}
