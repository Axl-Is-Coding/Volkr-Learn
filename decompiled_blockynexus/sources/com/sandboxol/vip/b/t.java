package com.sandboxol.vip.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.router.moduleInfo.pay.VipProductEntity;
import com.sandboxol.vip.R;

/* JADX INFO: compiled from: VipListItemSubscribeBottomBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class t extends s {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f19025f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final ConstraintLayout h;
    private final TextView i;
    private final ImageView j;
    private long k;

    static {
        g.put(R.id.v_tip_left, 5);
        g.put(R.id.tv_tip_left, 6);
    }

    public t(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f19025f, g));
    }

    public void a(com.sandboxol.vip.d.a.a.k kVar) {
        updateRegistration(0, kVar);
        this.f19024e = kVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(com.sandboxol.vip.a.f18952b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c5  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.vip.b.t.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.sandboxol.vip.d.a.a.k) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<VipProductEntity>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.vip.a.f18952b != i) {
            return false;
        }
        a((com.sandboxol.vip.d.a.a.k) obj);
        return true;
    }

    private t(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (TextView) objArr[4], (TextView) objArr[1], (TextView) objArr[6], (View) objArr[5]);
        this.k = -1L;
        this.h = (ConstraintLayout) objArr[0];
        this.h.setTag(null);
        this.i = (TextView) objArr[2];
        this.i.setTag(null);
        this.j = (ImageView) objArr[3];
        this.j.setTag(null);
        this.f19020a.setTag(null);
        this.f19021b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.vip.d.a.a.k kVar, int i) {
        if (i == com.sandboxol.vip.a.f18951a) {
            synchronized (this) {
                this.k |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.vip.a.h) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<VipProductEntity> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
