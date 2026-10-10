package com.sandbox.login.c;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sandbox.login.R;

/* JADX INFO: renamed from: com.sandbox.login.c.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: LoginActivityLoginBindingSw600dpImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2443k extends AbstractC2441i {
    private static final ViewDataBinding.b s = null;
    private static final SparseIntArray t = new SparseIntArray();
    private final CoordinatorLayout u;
    private final Group v;
    private final ImageView w;
    private final ImageView x;
    private long y;

    static {
        t.put(R.id.iv_banner, 14);
        t.put(R.id.inputNameLayout, 15);
        t.put(R.id.inputName, 16);
        t.put(R.id.line_left, 17);
        t.put(R.id.tv_tips_third_login, 18);
        t.put(R.id.line_right, 19);
        t.put(R.id.guideline, 20);
    }

    public C2443k(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 21, s, t));
    }

    private boolean b(ObservableField<Drawable> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.y |= 64;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.y |= 4;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.y |= 1;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.y |= 256;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.y |= 16;
        }
        return true;
    }

    private boolean g(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.y |= 128;
        }
        return true;
    }

    private boolean h(ObservableField<String> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.y |= 8;
        }
        return true;
    }

    @Override // com.sandbox.login.c.AbstractC2441i
    public void a(com.sandbox.login.view.activity.login.D d2) {
        updateRegistration(1, d2);
        this.r = d2;
        synchronized (this) {
            this.y |= 2;
        }
        notifyPropertyChanged(com.sandbox.login.g.f15905b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a5  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 789
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandbox.login.c.C2443k.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.y != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.y = 512L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return d((ObservableField) obj, i2);
            case 1:
                return a((com.sandbox.login.view.activity.login.D) obj, i2);
            case 2:
                return c((ObservableField) obj, i2);
            case 3:
                return h((ObservableField) obj, i2);
            case 4:
                return f((ObservableField) obj, i2);
            case 5:
                return a((ObservableField<String>) obj, i2);
            case 6:
                return b((ObservableField) obj, i2);
            case 7:
                return g((ObservableField) obj, i2);
            case 8:
                return e((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandbox.login.g.f15905b != i) {
            return false;
        }
        a((com.sandbox.login.view.activity.login.D) obj);
        return true;
    }

    private C2443k(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 9, (Button) objArr[5], (ImageView) objArr[11], (ImageView) objArr[10], (ImageView) objArr[12], (TextInputEditText) objArr[1], (TextInputEditText) objArr[4], (Guideline) objArr[20], (TextInputLayout) objArr[16], (ConstraintLayout) objArr[15], (TextInputLayout) objArr[3], (ImageView) objArr[14], (View) objArr[17], (View) objArr[19], (TextView) objArr[6], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[18]);
        this.y = -1L;
        this.f15649a.setTag(null);
        this.f15650b.setTag(null);
        this.f15651c.setTag(null);
        this.f15652d.setTag(null);
        this.f15653e.setTag(null);
        this.f15654f.setTag(null);
        this.j.setTag(null);
        this.u = (CoordinatorLayout) objArr[0];
        this.u.setTag(null);
        this.v = (Group) objArr[13];
        this.v.setTag(null);
        this.w = (ImageView) objArr[2];
        this.w.setTag(null);
        this.x = (ImageView) objArr[9];
        this.x.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandbox.login.view.activity.login.D d2, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.y |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.y |= 32;
        }
        return true;
    }
}
