package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.view.fragment.dress.DressSuitExtraItemViewModel;

/* JADX INFO: compiled from: ItemDressShopSpecialBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class N extends M {
    private static final ViewDataBinding.b i = null;
    private static final SparseIntArray j = new SparseIntArray();
    private final ConstraintLayout k;
    private long l;

    static {
        j.put(R.id.bgView, 5);
        j.put(R.id.ivPicMore, 6);
        j.put(R.id.tvMore, 7);
    }

    public N(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, i, j));
    }

    public void a(DressSuitExtraItemViewModel dressSuitExtraItemViewModel) {
        updateRegistration(1, dressSuitExtraItemViewModel);
        this.h = dressSuitExtraItemViewModel;
        synchronized (this) {
            this.l |= 2;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.x);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0179 A[PHI: r2
      0x0179: PHI (r2v3 long) = (r2v2 long), (r2v7 long) binds: [B:118:0x015b, B:128:0x0173] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0058 A[PHI: r2
      0x0058: PHI (r2v9 long) = (r2v0 long), (r2v22 long) binds: [B:9:0x0022, B:27:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.decorate.c.N.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a((ObservableField<Long>) obj, i3);
        }
        if (i2 == 1) {
            return a((DressSuitExtraItemViewModel) obj, i3);
        }
        if (i2 != 2) {
            return false;
        }
        return a((SuitDressInfo) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (com.sandboxol.decorate.c.x != i2) {
            return false;
        }
        a((DressSuitExtraItemViewModel) obj);
        return true;
    }

    private N(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (View) objArr[5], (Group) objArr[4], (ImageView) objArr[6], (View) objArr[2], (View) objArr[3], (TextView) objArr[7], (TextView) objArr[1]);
        this.l = -1L;
        this.f17022b.setTag(null);
        this.f17024d.setTag(null);
        this.k = (ConstraintLayout) objArr[0];
        this.k.setTag(null);
        this.f17025e.setTag(null);
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Long> observableField, int i2) {
        if (i2 != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean a(DressSuitExtraItemViewModel dressSuitExtraItemViewModel, int i2) {
        if (i2 == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.l |= 2;
            }
            return true;
        }
        if (i2 != com.sandboxol.decorate.c.I) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }

    private boolean a(SuitDressInfo suitDressInfo, int i2) {
        if (i2 == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.l |= 4;
            }
            return true;
        }
        if (i2 == com.sandboxol.decorate.c.l) {
            synchronized (this) {
                this.l |= 8;
            }
            return true;
        }
        if (i2 != com.sandboxol.decorate.c.h) {
            return false;
        }
        synchronized (this) {
            this.l |= 16;
        }
        return true;
    }
}
