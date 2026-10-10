package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.widget.DiscountTextView;

/* JADX INFO: renamed from: com.sandboxol.decorate.c.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogDressBuyBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2591p extends AbstractC2590o {
    private static final ViewDataBinding.b r = null;
    private static final SparseIntArray s = new SparseIntArray();
    private final ConstraintLayout t;
    private final TextView u;
    private final Button v;
    private long w;

    static {
        s.put(R.id.textView25, 14);
        s.put(R.id.view24, 15);
        s.put(R.id.view25, 16);
        s.put(R.id.constraintLayout, 17);
        s.put(R.id.textView27, 18);
    }

    public C2591p(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 19, r, s));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.w |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<Long> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.w |= 1;
        }
        return true;
    }

    private boolean d(ObservableField<Long> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.w |= 16;
        }
        return true;
    }

    @Override // com.sandboxol.decorate.c.AbstractC2590o
    public void a(com.sandboxol.decorate.view.dialog.a.E e2) {
        this.q = e2;
        synchronized (this) {
            this.w |= 32;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.y);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:248:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1053
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.decorate.c.C2591p.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.w != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.w = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return c((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return d((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.y != i) {
            return false;
        }
        a((com.sandboxol.decorate.view.dialog.a.E) obj);
        return true;
    }

    private C2591p(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (Button) objArr[1], (LinearLayout) objArr[17], (DataRecyclerView) objArr[2], (DiscountTextView) objArr[7], (DiscountTextView) objArr[4], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[14], (TextView) objArr[18], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[9], (ImageView) objArr[15], (ConstraintLayout) objArr[16], (ImageView) objArr[3], (ImageView) objArr[6]);
        this.w = -1L;
        this.f17100a.setTag(null);
        this.f17102c.setTag(null);
        this.f17103d.setTag(null);
        this.f17104e.setTag(null);
        this.f17105f.setTag(null);
        this.g.setTag(null);
        this.t = (ConstraintLayout) objArr[0];
        this.t.setTag(null);
        this.u = (TextView) objArr[12];
        this.u.setTag(null);
        this.v = (Button) objArr[13];
        this.v.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.w |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.w |= 8;
        }
        return true;
    }
}
