package com.sandboxol.googlepay.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.googlepay.R;

/* JADX INFO: compiled from: FragmentRechargeBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends c {
    private static final ViewDataBinding.b m = null;
    private static final SparseIntArray n = new SparseIntArray();
    private final ConstraintLayout o;
    private final TextView p;
    private long q;

    static {
        n.put(R.id.ns_content, 10);
        n.put(R.id.tv_star_code_tip, 11);
        n.put(R.id.iv_star_code_arrow, 12);
    }

    public d(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 13, m, n));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.q |= 8;
        }
        return true;
    }

    private boolean c(ObservableField<StarCodeUser> observableField, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.q |= 1;
        }
        return true;
    }

    @Override // com.sandboxol.googlepay.a.c
    public void a(com.sandboxol.googlepay.view.fragment.recharge.w wVar) {
        updateRegistration(2, wVar);
        this.l = wVar;
        synchronized (this) {
            this.q |= 4;
        }
        notifyPropertyChanged(com.sandboxol.googlepay.a.f18175d);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0093 A[PHI: r2
      0x0093: PHI (r2v4 long) = (r2v0 long), (r2v9 long) binds: [B:26:0x0065, B:40:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d2  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.googlepay.a.d.executeBindings():void");
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
            this.q = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return c((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 2) {
            return a((com.sandboxol.googlepay.view.fragment.recharge.w) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.googlepay.a.f18175d != i) {
            return false;
        }
        a((com.sandboxol.googlepay.view.fragment.recharge.w) obj);
        return true;
    }

    private d(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (Button) objArr[6], (EditText) objArr[5], (ImageView) objArr[12], (ImageView) objArr[3], (ImageView) objArr[7], (NestedScrollView) objArr[10], (DataRecyclerView) objArr[1], (TextView) objArr[8], (TextView) objArr[2], (TextView) objArr[4], (TextView) objArr[11]);
        this.q = -1L;
        this.f18184a.setTag(null);
        this.f18185b.setTag(null);
        this.f18187d.setTag(null);
        this.f18188e.setTag(null);
        this.o = (ConstraintLayout) objArr[0];
        this.o.setTag(null);
        this.p = (TextView) objArr[9];
        this.p.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.q |= 2;
        }
        return true;
    }

    private boolean a(com.sandboxol.googlepay.view.fragment.recharge.w wVar, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.q |= 4;
        }
        return true;
    }
}
