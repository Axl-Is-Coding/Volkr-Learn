package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableMap;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.c.C0823c;
import com.disabngo.blockynexus.entity.ActivityTaskTitle;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.widget.TimeCountDownView;

/* JADX INFO: compiled from: ItemActivityListBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Eg extends Dg {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = new SparseIntArray();
    private final ConstraintLayout l;
    private long m;

    static {
        k.put(R.id.bg_content, 6);
        k.put(R.id.bg_bounder, 7);
        k.put(R.id.bg_timer, 8);
    }

    public Eg(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, j, k));
    }

    private boolean b(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    public void a(C0823c c0823c) {
        updateRegistration(2, c0823c);
        this.i = c0823c;
        synchronized (this) {
            this.m |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0173  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Eg.executeBindings():void");
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
            this.m = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((C0823c) obj, i2);
        }
        if (i == 3) {
            return a((ObservableField<Long>) obj, i2);
        }
        if (i == 4) {
            return a((ActivityTaskTitle) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return a((ObservableMap<String, Integer>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((C0823c) obj);
        return true;
    }

    private Eg(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (View) objArr[7], (View) objArr[6], (View) objArr[8], (ImageView) objArr[1], (ImageView) objArr[5], (TimeCountDownView) objArr[4], (TextView) objArr[2], (TextView) objArr[3]);
        this.m = -1L;
        this.f7393d.setTag(null);
        this.f7394e.setTag(null);
        this.l = (ConstraintLayout) objArr[0];
        this.l.setTag(null);
        this.f7395f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean a(C0823c c0823c, int i) {
        if (i == 0) {
            synchronized (this) {
                this.m |= 4;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }

    private boolean a(ActivityTaskTitle activityTaskTitle, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }

    private boolean a(ObservableMap<String, Integer> observableMap, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 32;
        }
        return true;
    }
}
