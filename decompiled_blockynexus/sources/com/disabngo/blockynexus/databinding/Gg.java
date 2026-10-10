package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemActivitySignUpBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Gg extends Fg {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7497c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7498d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f7499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f7500f;
    private final TextView g;
    private final TextView h;
    private final View i;
    private final ImageView j;
    private final ImageView k;
    private long l;

    public Gg(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f7497c, f7498d));
    }

    @Override // com.disabngo.blockynexus.databinding.Fg
    public void a(com.disabngo.blockynexus.view.dialog.a.e eVar) {
        updateRegistration(0, eVar);
        this.f7456b = eVar;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bf  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Gg.executeBindings():void");
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
            return a((com.disabngo.blockynexus.view.dialog.a.e) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.a.e) obj);
        return true;
    }

    private Gg(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageView) objArr[3]);
        this.l = -1L;
        this.f7455a.setTag(null);
        this.f7499e = (RelativeLayout) objArr[0];
        this.f7499e.setTag(null);
        this.f7500f = (ImageView) objArr[1];
        this.f7500f.setTag(null);
        this.g = (TextView) objArr[2];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (View) objArr[5];
        this.i.setTag(null);
        this.j = (ImageView) objArr[6];
        this.j.setTag(null);
        this.k = (ImageView) objArr[7];
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.a.e eVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.l |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }
}
