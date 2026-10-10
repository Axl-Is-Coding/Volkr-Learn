package com.sandboxol.vip.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.AccountCenter;

/* JADX INFO: compiled from: VipContentPageVipTypeBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class d extends c {
    private static final ViewDataBinding.b o = null;
    private static final SparseIntArray p = null;
    private final ConstraintLayout q;
    private final TextView r;
    private final TextView s;
    private long t;

    public d(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 16, o, p));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 256;
        }
        return true;
    }

    private boolean c(ObservableField<Long> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 4;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 2;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 64;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 32;
        }
        return true;
    }

    private boolean g(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 16;
        }
        return true;
    }

    public void a(com.sandboxol.vip.view.fragment.main.q qVar) {
        updateRegistration(7, qVar);
        this.n = qVar;
        synchronized (this) {
            this.t |= 128;
        }
        notifyPropertyChanged(com.sandboxol.vip.a.f18956f);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:202:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 976
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.vip.b.d.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.t != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.t = 1024L;
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
                return c((ObservableField) obj, i2);
            case 3:
                return a((ObservableField<String>) obj, i2);
            case 4:
                return g((ObservableField) obj, i2);
            case 5:
                return f((ObservableField) obj, i2);
            case 6:
                return e((ObservableField) obj, i2);
            case 7:
                return a((com.sandboxol.vip.view.fragment.main.q) obj, i2);
            case 8:
                return b((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.vip.a.f18956f != i) {
            return false;
        }
        a((com.sandboxol.vip.view.fragment.main.q) obj);
        return true;
    }

    private d(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 9, (ImageView) objArr[8], (ImageView) objArr[13], (TextView) objArr[10], (TextView) objArr[9], (TextView) objArr[14], (ImageView) objArr[3], (ImageView) objArr[4], (ImageView) objArr[5], (ImageView) objArr[6], (TextView) objArr[15], (TextView) objArr[2], (View) objArr[1], (View) objArr[11]);
        this.t = -1L;
        this.f18972a.setTag(null);
        this.f18973b.setTag(null);
        this.q = (ConstraintLayout) objArr[0];
        this.q.setTag(null);
        this.r = (TextView) objArr[12];
        this.r.setTag(null);
        this.s = (TextView) objArr[7];
        this.s.setTag(null);
        this.f18974c.setTag(null);
        this.f18975d.setTag(null);
        this.f18976e.setTag(null);
        this.f18977f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 8;
        }
        return true;
    }

    private boolean a(com.sandboxol.vip.view.fragment.main.q qVar, int i) {
        if (i == com.sandboxol.vip.a.f18951a) {
            synchronized (this) {
                this.t |= 128;
            }
            return true;
        }
        if (i != com.sandboxol.vip.a.h) {
            return false;
        }
        synchronized (this) {
            this.t |= 512;
        }
        return true;
    }
}
