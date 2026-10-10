package com.sandboxol.googlepay.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.googlepay.R;
import com.sandboxol.googlepay.view.fragment.recharge.RechargeItem2ViewModel;

/* JADX INFO: compiled from: GooglepayItemRechargeViewBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends k {
    private static final ViewDataBinding.b m = null;
    private static final SparseIntArray n = new SparseIntArray();
    private final ConstraintLayout o;
    private final TextView p;
    private long q;

    static {
        n.put(R.id.v_left, 8);
        n.put(R.id.tv_diamond_tip, 9);
        n.put(R.id.v_diamond, 10);
        n.put(R.id.v_bank, 11);
    }

    public l(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 12, m, n));
    }

    @Override // com.sandboxol.googlepay.a.k
    public void a(Boolean bool) {
        this.l = bool;
        synchronized (this) {
            this.q |= 8;
        }
        notifyPropertyChanged(com.sandboxol.googlepay.a.h);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00dd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0131 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x014f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x015e A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.googlepay.a.l.executeBindings():void");
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
            this.q = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 1) {
            return a((RechargeItem2ViewModel) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableField<Integer>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.googlepay.a.h == i) {
            a((Boolean) obj);
        } else {
            if (com.sandboxol.googlepay.a.f18173b != i) {
                return false;
            }
            a((RechargeItem2ViewModel) obj);
        }
        return true;
    }

    private l(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (ImageView) objArr[1], (TextView) objArr[2], (TextView) objArr[9], (TextView) objArr[3], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[4], (View) objArr[11], (View) objArr[10], (View) objArr[8]);
        this.q = -1L;
        this.f18207a.setTag(null);
        this.o = (ConstraintLayout) objArr[0];
        this.o.setTag(null);
        this.p = (TextView) objArr[7];
        this.p.setTag(null);
        this.f18208b.setTag(null);
        this.f18210d.setTag(null);
        this.f18211e.setTag(null);
        this.f18212f.setTag(null);
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // com.sandboxol.googlepay.a.k
    public void a(RechargeItem2ViewModel rechargeItem2ViewModel) {
        updateRegistration(1, rechargeItem2ViewModel);
        this.k = rechargeItem2ViewModel;
        synchronized (this) {
            this.q |= 2;
        }
        notifyPropertyChanged(com.sandboxol.googlepay.a.f18173b);
        super.requestRebind();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.q |= 1;
        }
        return true;
    }

    private boolean a(RechargeItem2ViewModel rechargeItem2ViewModel, int i) {
        if (i == com.sandboxol.googlepay.a.f18172a) {
            synchronized (this) {
                this.q |= 2;
            }
            return true;
        }
        if (i != com.sandboxol.googlepay.a.i) {
            return false;
        }
        synchronized (this) {
            this.q |= 16;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.q |= 4;
        }
        return true;
    }
}
