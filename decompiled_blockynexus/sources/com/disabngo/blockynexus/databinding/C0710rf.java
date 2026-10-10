package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.rf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentSecretQuestionVerifyBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0710rf extends AbstractC0700qf {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8759c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8760d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f8761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f8762f;
    private final TextView g;
    private final EditText h;
    private final Button i;
    private final LinearLayout j;
    private final TextView k;
    private final Button l;
    private long m;

    public C0710rf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f8759c, f8760d));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0700qf
    public void a(com.disabngo.blockynexus.e.b.ha.i iVar) {
        updateRegistration(4, iVar);
        this.f8730b = iVar;
        synchronized (this) {
            this.m |= 16;
        }
        notifyPropertyChanged(279);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d8  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0710rf.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return c((ObservableField) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return d((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.ha.i) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (279 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ha.i) obj);
        return true;
    }

    private C0710rf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (EditText) objArr[7]);
        this.m = -1L;
        this.f8729a.setTag(null);
        this.f8761e = (LinearLayout) objArr[0];
        this.f8761e.setTag(null);
        this.f8762f = (LinearLayout) objArr[1];
        this.f8762f.setTag(null);
        this.g = (TextView) objArr[2];
        this.g.setTag(null);
        this.h = (EditText) objArr[3];
        this.h.setTag(null);
        this.i = (Button) objArr[4];
        this.i.setTag(null);
        this.j = (LinearLayout) objArr[5];
        this.j.setTag(null);
        this.k = (TextView) objArr[6];
        this.k.setTag(null);
        this.l = (Button) objArr[8];
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.ha.i iVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }
}
