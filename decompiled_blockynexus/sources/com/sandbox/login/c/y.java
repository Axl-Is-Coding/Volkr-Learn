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

/* JADX INFO: compiled from: LoginFragmentConfirmPasswordBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class y extends x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f15694d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f15695e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f15696f;
    private final TextView g;
    private final TextView h;
    private final Button i;
    private long j;

    static {
        f15695e.put(R.id.tilPassword, 5);
    }

    public y(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f15694d, f15695e));
    }

    private boolean b(ObservableField<Long> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.j |= 8;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }

    @Override // com.sandbox.login.c.x
    public void a(com.sandbox.login.f.a.c.g gVar) {
        updateRegistration(2, gVar);
        this.f15693c = gVar;
        synchronized (this) {
            this.j |= 4;
        }
        notifyPropertyChanged(com.sandbox.login.g.f15905b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandbox.login.c.y.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 1) {
            return c((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((com.sandbox.login.f.a.c.g) obj, i2);
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
        if (com.sandbox.login.g.f15905b != i) {
            return false;
        }
        a((com.sandbox.login.f.a.c.g) obj);
        return true;
    }

    private y(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (TextInputLayout) objArr[5], (TextInputEditText) objArr[3]);
        this.j = -1L;
        this.f15696f = (LinearLayout) objArr[0];
        this.f15696f.setTag(null);
        this.g = (TextView) objArr[1];
        this.g.setTag(null);
        this.h = (TextView) objArr[2];
        this.h.setTag(null);
        this.i = (Button) objArr[4];
        this.i.setTag(null);
        this.f15692b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    private boolean a(com.sandbox.login.f.a.c.g gVar, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.j |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.j |= 16;
        }
        return true;
    }
}
