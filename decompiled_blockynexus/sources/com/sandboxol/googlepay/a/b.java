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

/* JADX INFO: compiled from: FragmentPayBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends a {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final LinearLayout i;
    private final TextView j;
    private final TextView k;
    private final TextView l;
    private final TextView m;
    private final RelativeLayout n;
    private final TextView o;
    private final LinearLayout p;
    private final TextView q;
    private final LinearLayout r;
    private final TextView s;
    private final TextView t;
    private final LinearLayout u;
    private long v;

    static {
        h.put(R.id.ivPay, 15);
        h.put(R.id.tvPay, 16);
        h.put(R.id.ivArrow, 17);
    }

    public b(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 18, g, h));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.v |= 16;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.v |= 1;
        }
        return true;
    }

    @Override // com.sandboxol.googlepay.a.a
    public void a(com.sandboxol.googlepay.c.a.a.d dVar) {
        updateRegistration(2, dVar);
        this.f18183f = dVar;
        synchronized (this) {
            this.v |= 4;
        }
        notifyPropertyChanged(com.sandboxol.googlepay.a.g);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.googlepay.a.b.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.v != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.v = 32L;
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
            return a((com.sandboxol.googlepay.c.a.a.d) obj, i2);
        }
        if (i == 3) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.googlepay.a.g != i) {
            return false;
        }
        a((com.sandboxol.googlepay.c.a.a.d) obj);
        return true;
    }

    private b(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (ImageView) objArr[17], (ImageView) objArr[15], (TextView) objArr[4], (TextView) objArr[16], (TextView) objArr[13]);
        this.v = -1L;
        this.i = (LinearLayout) objArr[0];
        this.i.setTag(null);
        this.j = (TextView) objArr[1];
        this.j.setTag(null);
        this.k = (TextView) objArr[10];
        this.k.setTag(null);
        this.l = (TextView) objArr[11];
        this.l.setTag(null);
        this.m = (TextView) objArr[12];
        this.m.setTag(null);
        this.n = (RelativeLayout) objArr[14];
        this.n.setTag(null);
        this.o = (TextView) objArr[2];
        this.o.setTag(null);
        this.p = (LinearLayout) objArr[3];
        this.p.setTag(null);
        this.q = (TextView) objArr[5];
        this.q.setTag(null);
        this.r = (LinearLayout) objArr[6];
        this.r.setTag(null);
        this.s = (TextView) objArr[7];
        this.s.setTag(null);
        this.t = (TextView) objArr[8];
        this.t.setTag(null);
        this.u = (LinearLayout) objArr[9];
        this.u.setTag(null);
        this.f18180c.setTag(null);
        this.f18182e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.v |= 2;
        }
        return true;
    }

    private boolean a(com.sandboxol.googlepay.c.a.a.d dVar, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.v |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.v |= 8;
        }
        return true;
    }
}
