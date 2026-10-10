package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.router.moduleInfo.decorate.LimitedTimes;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.view.fragment.dress.la;

/* JADX INFO: compiled from: ItemNewDressSuitBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class aa extends Z {
    private static final ViewDataBinding.b p = null;
    private static final SparseIntArray q = new SparseIntArray();
    private final ConstraintLayout r;
    private final ImageView s;
    private long t;

    static {
        q.put(R.id.bgView, 15);
    }

    public aa(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 16, p, q));
    }

    public void a(la laVar) {
        updateRegistration(4, laVar);
        this.o = laVar;
        synchronized (this) {
            this.t |= 16;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.v);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03ab A[PHI: r2
      0x03ab: PHI (r2v2 long) = (r2v1 long), (r2v12 long) binds: [B:217:0x0390, B:226:0x03a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0138 A[PHI: r2
      0x0138: PHI (r2v18 long) = (r2v17 long), (r2v33 long) binds: [B:54:0x0109, B:67:0x0132] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013f  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.decorate.c.aa.executeBindings():void");
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
            this.t = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableList<Long>) obj, i2);
        }
        if (i == 1) {
            return a((LimitedTimes) obj, i2);
        }
        if (i == 2) {
            return a((SuitDressInfo) obj, i2);
        }
        if (i == 3) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return a((la) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.v != i) {
            return false;
        }
        a((la) obj);
        return true;
    }

    private aa(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (View) objArr[12], (View) objArr[13], (View) objArr[15], (View) objArr[4], (ImageView) objArr[5], (ImageView) objArr[8], (ImageView) objArr[11], (View) objArr[2], (View) objArr[3], (TextView) objArr[10], (TextView) objArr[6], (TextView) objArr[9], (TextView) objArr[1], (TextView) objArr[7]);
        this.t = -1L;
        this.f17057a.setTag(null);
        this.f17058b.setTag(null);
        this.f17060d.setTag(null);
        this.f17061e.setTag(null);
        this.f17062f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.r = (ConstraintLayout) objArr[0];
        this.r.setTag(null);
        this.s = (ImageView) objArr[14];
        this.s.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableList<Long> observableList, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.t |= 1;
        }
        return true;
    }

    private boolean a(LimitedTimes limitedTimes, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.t |= 2;
        }
        return true;
    }

    private boolean a(SuitDressInfo suitDressInfo, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.t |= 4;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.l) {
            synchronized (this) {
                this.t |= 32;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.h) {
            return false;
        }
        synchronized (this) {
            this.t |= 64;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.t |= 8;
        }
        return true;
    }

    private boolean a(la laVar, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.t |= 16;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.I) {
            return false;
        }
        synchronized (this) {
            this.t |= 4;
        }
        return true;
    }
}
