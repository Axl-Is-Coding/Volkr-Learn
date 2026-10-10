package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.g.C0849a;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.nd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentCacheBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0665nd extends AbstractC0654md {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f8616e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f8617f = null;
    private final LinearLayout g;
    private final TextView h;
    private final TextView i;
    private final TextView j;
    private final Button k;
    private long l;

    public C0665nd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f8616e, f8617f));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 8;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }

    public void a(C0849a c0849a) {
        updateRegistration(1, c0849a);
        this.f8582d = c0849a;
        synchronized (this) {
            this.l |= 2;
        }
        notifyPropertyChanged(345);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009e  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0665nd.executeBindings():void");
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
            this.l = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return c((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((C0849a) obj, i2);
        }
        if (i == 2) {
            return d((ObservableField) obj, i2);
        }
        if (i == 3) {
            return b((ObservableField) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (345 != i) {
            return false;
        }
        a((C0849a) obj);
        return true;
    }

    private C0665nd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (CheckBox) objArr[6], (CheckBox) objArr[2], (CheckBox) objArr[4]);
        this.l = -1L;
        this.f8579a.setTag(null);
        this.f8580b.setTag(null);
        this.f8581c.setTag(null);
        this.g = (LinearLayout) objArr[0];
        this.g.setTag(null);
        this.h = (TextView) objArr[1];
        this.h.setTag(null);
        this.i = (TextView) objArr[3];
        this.i.setTag(null);
        this.j = (TextView) objArr[5];
        this.j.setTag(null);
        this.k = (Button) objArr[7];
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(C0849a c0849a, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 16;
        }
        return true;
    }
}
