package com.sandboxol.googlepay.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.googlepay.R;
import com.sandboxol.googlepay.view.fragment.recharge.RechargeItemViewModel;

/* JADX INFO: compiled from: ItemRechargeViewBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class r extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f18228d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f18229e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RelativeLayout f18230f;
    private final LinearLayout g;
    private final TextView h;
    private final RelativeLayout i;
    private final View j;
    private final View k;
    private final ImageView l;
    private final TextView m;
    private final TextView n;
    private final TextView o;
    private final LinearLayout p;
    private final ImageView q;
    private final TextView r;
    private final LinearLayout s;
    private long t;

    static {
        f18229e.put(R.id.ivFreeAds, 15);
    }

    public r(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 16, f18228d, f18229e));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.t |= 8;
        }
        return true;
    }

    public void a(RechargeItemViewModel rechargeItemViewModel) {
        updateRegistration(1, rechargeItemViewModel);
        this.f18227c = rechargeItemViewModel;
        synchronized (this) {
            this.t |= 2;
        }
        notifyPropertyChanged(com.sandboxol.googlepay.a.f18173b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01ec A[PHI: r2
      0x01ec: PHI (r2v3 long) = (r2v2 long), (r2v6 long) binds: [B:104:0x01d0, B:114:0x01e6] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.googlepay.a.r.executeBindings():void");
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
            this.t = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 1) {
            return a((RechargeItemViewModel) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.googlepay.a.f18173b != i) {
            return false;
        }
        a((RechargeItemViewModel) obj);
        return true;
    }

    private r(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (ImageView) objArr[11], (ImageView) objArr[15]);
        this.t = -1L;
        this.f18225a.setTag(null);
        this.f18230f = (RelativeLayout) objArr[0];
        this.f18230f.setTag(null);
        this.g = (LinearLayout) objArr[1];
        this.g.setTag(null);
        this.h = (TextView) objArr[10];
        this.h.setTag(null);
        this.i = (RelativeLayout) objArr[12];
        this.i.setTag(null);
        this.j = (View) objArr[13];
        this.j.setTag(null);
        this.k = (View) objArr[14];
        this.k.setTag(null);
        this.l = (ImageView) objArr[2];
        this.l.setTag(null);
        this.m = (TextView) objArr[3];
        this.m.setTag(null);
        this.n = (TextView) objArr[4];
        this.n.setTag(null);
        this.o = (TextView) objArr[5];
        this.o.setTag(null);
        this.p = (LinearLayout) objArr[6];
        this.p.setTag(null);
        this.q = (ImageView) objArr[7];
        this.q.setTag(null);
        this.r = (TextView) objArr[8];
        this.r.setTag(null);
        this.s = (LinearLayout) objArr[9];
        this.s.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.t |= 1;
        }
        return true;
    }

    private boolean a(RechargeItemViewModel rechargeItemViewModel, int i) {
        if (i == com.sandboxol.googlepay.a.f18172a) {
            synchronized (this) {
                this.t |= 2;
            }
            return true;
        }
        if (i != com.sandboxol.googlepay.a.i) {
            return false;
        }
        synchronized (this) {
            this.t |= 16;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.t |= 4;
        }
        return true;
    }
}
