package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.rd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentCashBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0708rd extends AbstractC0698qd {
    private static final ViewDataBinding.b k = null;
    private static final SparseIntArray l = new SparseIntArray();
    private final ConstraintLayout m;
    private final DataRecyclerView n;
    private final ImageView o;
    private long p;

    static {
        l.put(R.id.v_detail, 6);
        l.put(R.id.tv_cash_tip, 7);
        l.put(R.id.rb_item_1, 8);
        l.put(R.id.rb_item_2, 9);
        l.put(R.id.rb_item_3, 10);
        l.put(R.id.tv_explanation_title, 11);
    }

    public C0708rd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 12, k, l));
    }

    private boolean b(ObservableField<Double> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 16;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0698qd
    public void a(com.disabngo.blockynexus.e.b.i.h hVar) {
        updateRegistration(3, hVar);
        this.j = hVar;
        synchronized (this) {
            this.p |= 8;
        }
        notifyPropertyChanged(341);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a A[PHI: r6
      0x003a: PHI (r6v1 double) = (r6v0 double), (r6v10 double) binds: [B:7:0x0016, B:13:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b0  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0708rd.executeBindings():void");
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
            this.p = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<Double>) obj, i2);
        }
        if (i == 1) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((com.disabngo.blockynexus.e.b.i.h) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return c((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (341 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.i.h) obj);
        return true;
    }

    private C0708rd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (Button) objArr[3], (AppCompatRadioButton) objArr[8], (AppCompatRadioButton) objArr[9], (AppCompatRadioButton) objArr[10], (RadioGroup) objArr[2], (TextView) objArr[1], (TextView) objArr[7], (TextView) objArr[11], (ConstraintLayout) objArr[6]);
        this.p = -1L;
        this.f8720a.setTag(null);
        this.m = (ConstraintLayout) objArr[0];
        this.m.setTag(null);
        this.n = (DataRecyclerView) objArr[4];
        this.n.setTag(null);
        this.o = (ImageView) objArr[5];
        this.o.setTag(null);
        this.f8724e.setTag(null);
        this.f8725f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Double> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 1;
        }
        return true;
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 2;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.i.h hVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 8;
        }
        return true;
    }
}
