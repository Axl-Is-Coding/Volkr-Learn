package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.view.fragment.dress.DressExtraItemViewModel;

/* JADX INFO: compiled from: ItemDressSpecialBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class P extends O {
    private static final ViewDataBinding.b l = null;
    private static final SparseIntArray m = new SparseIntArray();
    private final ConstraintLayout n;
    private long o;

    static {
        m.put(R.id.bgView, 6);
        m.put(R.id.ivPicMore, 7);
        m.put(R.id.tvMore, 8);
        m.put(R.id.ivPicClear, 9);
        m.put(R.id.tvClear, 10);
    }

    public P(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, l, m));
    }

    public void a(DressExtraItemViewModel dressExtraItemViewModel) {
        updateRegistration(1, dressExtraItemViewModel);
        this.k = dressExtraItemViewModel;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.w);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b1  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.decorate.c.P.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<Long>) obj, i2);
        }
        if (i == 1) {
            return a((DressExtraItemViewModel) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((SingleDressInfo) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.w != i) {
            return false;
        }
        a((DressExtraItemViewModel) obj);
        return true;
    }

    private P(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (View) objArr[6], (Group) objArr[4], (Group) objArr[5], (ImageView) objArr[9], (ImageView) objArr[7], (View) objArr[2], (View) objArr[3], (TextView) objArr[10], (TextView) objArr[8], (TextView) objArr[1]);
        this.o = -1L;
        this.f17028b.setTag(null);
        this.f17029c.setTag(null);
        this.f17032f.setTag(null);
        this.n = (ConstraintLayout) objArr[0];
        this.n.setTag(null);
        this.g.setTag(null);
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }

    private boolean a(DressExtraItemViewModel dressExtraItemViewModel, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.o |= 2;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.I) {
            return false;
        }
        synchronized (this) {
            this.o |= 4;
        }
        return true;
    }

    private boolean a(SingleDressInfo singleDressInfo, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.o |= 4;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.l) {
            synchronized (this) {
                this.o |= 8;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.h) {
            return false;
        }
        synchronized (this) {
            this.o |= 16;
        }
        return true;
    }
}
