package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sandbox.login.R;
import com.sandboxol.center.entity.AccountCenter;

/* JADX INFO: compiled from: LoginFragmentChangePasswordBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class w extends v {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f15690f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final LinearLayout h;
    private final TextView i;
    private final TextView j;
    private final LinearLayout k;
    private final Button l;
    private long m;

    static {
        g.put(R.id.til_password, 7);
        g.put(R.id.til_confirm_password, 8);
    }

    public w(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f15690f, g));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.m |= 32;
        }
        return true;
    }

    private boolean c(ObservableField<Long> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }

    @Override // com.sandbox.login.c.v
    public void a(com.sandbox.login.f.a.b.h hVar) {
        updateRegistration(2, hVar);
        this.f15689e = hVar;
        synchronized (this) {
            this.m |= 4;
        }
        notifyPropertyChanged(com.sandbox.login.g.f15905b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandbox.login.c.w.executeBindings():void");
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
            this.m = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((AccountCenter) obj, i2);
            case 1:
                return d((ObservableField) obj, i2);
            case 2:
                return a((com.sandbox.login.f.a.b.h) obj, i2);
            case 3:
                return c((ObservableField) obj, i2);
            case 4:
                return e((ObservableField) obj, i2);
            case 5:
                return b((ObservableField) obj, i2);
            case 6:
                return a((ObservableField<String>) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandbox.login.g.f15905b != i) {
            return false;
        }
        a((com.sandbox.login.f.a.b.h) obj);
        return true;
    }

    private w(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 7, (TextInputLayout) objArr[8], (TextInputLayout) objArr[7], (TextInputEditText) objArr[4], (TextInputEditText) objArr[3]);
        this.m = -1L;
        this.h = (LinearLayout) objArr[0];
        this.h.setTag(null);
        this.i = (TextView) objArr[1];
        this.i.setTag(null);
        this.j = (TextView) objArr[2];
        this.j.setTag(null);
        this.k = (LinearLayout) objArr[5];
        this.k.setTag(null);
        this.l = (Button) objArr[6];
        this.l.setTag(null);
        this.f15687c.setTag(null);
        this.f15688d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean a(com.sandbox.login.f.a.b.h hVar, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.m |= 64;
        }
        return true;
    }
}
