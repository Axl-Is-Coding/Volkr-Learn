package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.view.widget.CenterButton;
import com.sandboxol.gamedetail.R;

/* JADX INFO: compiled from: ItemGameDetailShopBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class N extends M {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f17814e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f17815f = new SparseIntArray();
    private final ConstraintLayout g;
    private final AppCompatImageView h;
    private final AppCompatImageView i;
    private final CenterButton j;
    private final AppCompatButton k;
    private long l;

    static {
        f17815f.put(R.id.appCompatImageView, 7);
    }

    public N(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f17814e, f17815f));
    }

    public void a(com.sandboxol.gamedetail.c.a.d.h hVar) {
        updateRegistration(0, hVar);
        this.f17813d = hVar;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.f17769b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00ea  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.gamedetail.a.N.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.sandboxol.gamedetail.c.a.d.h) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.gamedetail.a.f17769b != i) {
            return false;
        }
        a((com.sandboxol.gamedetail.c.a.d.h) obj);
        return true;
    }

    private N(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (AppCompatImageView) objArr[7], (AppCompatTextView) objArr[4], (AppCompatTextView) objArr[2]);
        this.l = -1L;
        this.f17811b.setTag(null);
        this.f17812c.setTag(null);
        this.g = (ConstraintLayout) objArr[0];
        this.g.setTag(null);
        this.h = (AppCompatImageView) objArr[1];
        this.h.setTag(null);
        this.i = (AppCompatImageView) objArr[3];
        this.i.setTag(null);
        this.j = (CenterButton) objArr[5];
        this.j.setTag(null);
        this.k = (AppCompatButton) objArr[6];
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.gamedetail.c.a.d.h hVar, int i) {
        if (i == com.sandboxol.gamedetail.a.f17768a) {
            synchronized (this) {
                this.l |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.gamedetail.a.m) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }
}
