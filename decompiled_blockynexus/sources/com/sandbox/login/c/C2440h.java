package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.sandbox.login.c.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: LoginAccountRecordItemBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2440h extends AbstractC2439g {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = null;
    private final ConstraintLayout i;
    private final ImageView j;
    private long k;

    public C2440h(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, g, h));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }

    public void a(com.sandbox.login.f.a.e.m mVar) {
        updateRegistration(0, mVar);
        this.f15648f = mVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(com.sandbox.login.g.f15905b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c2  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandbox.login.c.C2440h.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.sandbox.login.f.a.e.m) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandbox.login.g.f15905b != i) {
            return false;
        }
        a((com.sandbox.login.f.a.e.m) obj);
        return true;
    }

    private C2440h(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (View) objArr[1], (ImageView) objArr[6], (TextView) objArr[5], (TextView) objArr[4], (ImageView) objArr[2]);
        this.k = -1L;
        this.f15643a.setTag(null);
        this.f15644b.setTag(null);
        this.i = (ConstraintLayout) objArr[0];
        this.i.setTag(null);
        this.j = (ImageView) objArr[3];
        this.j.setTag(null);
        this.f15645c.setTag(null);
        this.f15646d.setTag(null);
        this.f15647e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandbox.login.f.a.e.m mVar, int i) {
        if (i == com.sandbox.login.g.f15904a) {
            synchronized (this) {
                this.k |= 1;
            }
            return true;
        }
        if (i != com.sandbox.login.g.f15908e) {
            return false;
        }
        synchronized (this) {
            this.k |= 8;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
