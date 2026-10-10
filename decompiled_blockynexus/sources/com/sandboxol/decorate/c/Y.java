package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: ItemNewDressShopSuitBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class Y extends X {
    private static final ViewDataBinding.b m = null;
    private static final SparseIntArray n = new SparseIntArray();
    private final ConstraintLayout o;
    private final ImageView p;
    private long q;

    static {
        n.put(R.id.tvTimeTip, 12);
    }

    public Y(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 13, m, n));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.q |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.q |= 16;
        }
        return true;
    }

    public void a(com.sandboxol.decorate.view.activity.dress.W w) {
        updateRegistration(1, w);
        this.l = w;
        synchronized (this) {
            this.q |= 2;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.D);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0157  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.decorate.c.Y.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.q != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.q = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableList<Long>) obj, i2);
        }
        if (i == 1) {
            return a((com.sandboxol.decorate.view.activity.dress.W) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((SuitDressInfo) obj, i2);
        }
        if (i == 4) {
            return c((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return a((ObservableField<Integer>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.D != i) {
            return false;
        }
        a((com.sandboxol.decorate.view.activity.dress.W) obj);
        return true;
    }

    private Y(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (View) objArr[8], (View) objArr[9], (View) objArr[1], (Group) objArr[11], (ImageView) objArr[2], (ImageView) objArr[6], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[12]);
        this.q = -1L;
        this.f17051a.setTag(null);
        this.f17052b.setTag(null);
        this.f17053c.setTag(null);
        this.f17054d.setTag(null);
        this.f17055e.setTag(null);
        this.f17056f.setTag(null);
        this.o = (ConstraintLayout) objArr[0];
        this.o.setTag(null);
        this.p = (ImageView) objArr[10];
        this.p.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableList<Long> observableList, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.q |= 1;
        }
        return true;
    }

    private boolean a(com.sandboxol.decorate.view.activity.dress.W w, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.q |= 2;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.I) {
            return false;
        }
        synchronized (this) {
            this.q |= 8;
        }
        return true;
    }

    private boolean a(SuitDressInfo suitDressInfo, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.q |= 8;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.q |= 32;
        }
        return true;
    }
}
