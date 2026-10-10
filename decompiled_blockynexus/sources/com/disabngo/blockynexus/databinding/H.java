package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: AppDialogVipConvertBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class H extends G {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = new SparseIntArray();
    private final ConstraintLayout l;
    private final TextView m;
    private final TextView n;
    private final TextView o;
    private long p;

    static {
        k.put(R.id.bg_main, 8);
        k.put(R.id.iv_arrow, 9);
        k.put(R.id.bg_bottom, 10);
        k.put(R.id.line_middle, 11);
    }

    public H(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 12, j, k));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 1;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.view.dialog.Ra ra) {
        this.i = ra;
        synchronized (this) {
            this.p |= 8;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ac  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.H.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return c((ObservableField) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.Ra) obj);
        return true;
    }

    private H(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (View) objArr[10], (View) objArr[8], (ImageView) objArr[9], (ImageView) objArr[2], (ImageView) objArr[4], (View) objArr[11], (TextView) objArr[3], (TextView) objArr[1]);
        this.p = -1L;
        this.f7475d.setTag(null);
        this.f7476e.setTag(null);
        this.l = (ConstraintLayout) objArr[0];
        this.l.setTag(null);
        this.m = (TextView) objArr[5];
        this.m.setTag(null);
        this.n = (TextView) objArr[6];
        this.n.setTag(null);
        this.o = (TextView) objArr[7];
        this.o.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 4;
        }
        return true;
    }
}
