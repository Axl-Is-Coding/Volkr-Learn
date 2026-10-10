package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemAuthorListDialogBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class D extends C {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f17781b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f17782c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f17783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f17784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f17785f;
    private final LinearLayout g;
    private final Button h;
    private final TextView i;
    private final View j;
    private long k;

    public D(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f17781b, f17782c));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }

    public void a(com.sandboxol.gamedetail.view.dialog.a.f fVar) {
        updateRegistration(0, fVar);
        this.f17780a = fVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.f17769b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e9  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.gamedetail.a.D.executeBindings():void");
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
            this.k = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.sandboxol.gamedetail.view.dialog.a.f) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return c((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.gamedetail.a.f17769b != i) {
            return false;
        }
        a((com.sandboxol.gamedetail.view.dialog.a.f) obj);
        return true;
    }

    private D(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4);
        this.k = -1L;
        this.f17783d = (LinearLayout) objArr[0];
        this.f17783d.setTag(null);
        this.f17784e = (ImageView) objArr[1];
        this.f17784e.setTag(null);
        this.f17785f = (TextView) objArr[2];
        this.f17785f.setTag(null);
        this.g = (LinearLayout) objArr[3];
        this.g.setTag(null);
        this.h = (Button) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.j = (View) objArr[6];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.gamedetail.view.dialog.a.f fVar, int i) {
        if (i == com.sandboxol.gamedetail.a.f17768a) {
            synchronized (this) {
                this.k |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.gamedetail.a.m) {
            return false;
        }
        synchronized (this) {
            this.k |= 16;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.k |= 8;
        }
        return true;
    }
}
