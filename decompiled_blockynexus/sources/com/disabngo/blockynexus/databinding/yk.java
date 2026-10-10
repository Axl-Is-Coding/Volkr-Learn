package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.fragment.more.MoreViewModel;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.VideoStarConfig;

/* JADX INFO: compiled from: ViewDiamondExchangeBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class yk extends xk {
    private static final ViewDataBinding.b q = null;
    private static final SparseIntArray r = new SparseIntArray();
    private final ConstraintLayout s;
    private long t;

    static {
        r.put(R.id.v_divide, 13);
        r.put(R.id.v_detail, 14);
        r.put(R.id.iv_diamond_exchange, 15);
    }

    public yk(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 16, q, r));
    }

    private boolean b(ObservableField<Double> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 16;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 8;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 2;
        }
        return true;
    }

    private boolean e(ObservableField<VideoStarConfig> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.xk
    public void a(MoreViewModel moreViewModel) {
        updateRegistration(6, moreViewModel);
        this.p = moreViewModel;
        synchronized (this) {
            this.t |= 64;
        }
        notifyPropertyChanged(311);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 820
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.yk.executeBindings():void");
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
        switch (i) {
            case 0:
                return a((AccountCenter) obj, i2);
            case 1:
                return d((ObservableField) obj, i2);
            case 2:
                return e((ObservableField) obj, i2);
            case 3:
                return c((ObservableField) obj, i2);
            case 4:
                return b((ObservableField) obj, i2);
            case 5:
                return a((ObservableField<Long>) obj, i2);
            case 6:
                return a((MoreViewModel) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (311 != i) {
            return false;
        }
        a((MoreViewModel) obj);
        return true;
    }

    private yk(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 7, (Button) objArr[12], (ConstraintLayout) objArr[4], (ImageView) objArr[15], (ImageView) objArr[3], (ImageView) objArr[2], (TextView) objArr[9], (TextView) objArr[11], (TextView) objArr[10], (TextView) objArr[6], (TextView) objArr[1], (TextView) objArr[5], (TextView) objArr[7], (TextView) objArr[8], (View) objArr[14], (View) objArr[13]);
        this.t = -1L;
        this.f8994a.setTag(null);
        this.f8995b.setTag(null);
        this.f8997d.setTag(null);
        this.f8998e.setTag(null);
        this.s = (ConstraintLayout) objArr[0];
        this.s.setTag(null);
        this.f8999f.setTag(null);
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
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 32;
        }
        return true;
    }

    private boolean a(MoreViewModel moreViewModel, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 64;
        }
        return true;
    }
}
