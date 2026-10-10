package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemHelpDetailBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Lh extends Kh {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7654c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7655d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f7656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View f7657f;
    private final TextView g;
    private long h;

    public Lh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f7654c, f7655d));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 4;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.e.b.K.e eVar) {
        updateRegistration(0, eVar);
        this.f7622b = eVar;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a3  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Lh.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.K.e) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.K.e) obj);
        return true;
    }

    private Lh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (TextView) objArr[1]);
        this.h = -1L;
        this.f7656e = (ConstraintLayout) objArr[0];
        this.f7656e.setTag(null);
        this.f7657f = (View) objArr[2];
        this.f7657f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.f7621a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.K.e eVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.h |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.h |= 8;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }
}
