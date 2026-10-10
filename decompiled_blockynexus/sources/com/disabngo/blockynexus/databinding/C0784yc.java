package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.yc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogScrapRewardReceiveBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0784yc extends AbstractC0773xc {
    private static final ViewDataBinding.b i = null;
    private static final SparseIntArray j = new SparseIntArray();
    private final ConstraintLayout k;
    private final TextView l;
    private long m;

    static {
        j.put(R.id.ivFlash, 8);
    }

    public C0784yc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, i, j));
    }

    private boolean b(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0773xc
    public void a(com.disabngo.blockynexus.view.dialog.Qa qa) {
        this.h = qa;
        synchronized (this) {
            this.m |= 8;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065 A[PHI: r2
      0x0065: PHI (r2v3 long) = (r2v0 long), (r2v5 long) binds: [B:18:0x0037, B:32:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bf  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0784yc.executeBindings():void");
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
            this.m = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return b((ObservableField) obj, i3);
        }
        if (i2 == 1) {
            return c((ObservableField) obj, i3);
        }
        if (i2 != 2) {
            return false;
        }
        return a((ObservableField) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (2 != i2) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.Qa) obj);
        return true;
    }

    private C0784yc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (View) objArr[2], (View) objArr[5], (View) objArr[7], (ImageView) objArr[8], (ImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[4]);
        this.m = -1L;
        this.f8961a.setTag(null);
        this.f8962b.setTag(null);
        this.f8963c.setTag(null);
        this.f8965e.setTag(null);
        this.k = (ConstraintLayout) objArr[0];
        this.k.setTag(null);
        this.l = (TextView) objArr[6];
        this.l.setTag(null);
        this.f8966f.setTag(null);
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }
}
