package com.sandboxol.vip.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.pay.VipProductEntity;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.vip.R;

/* JADX INFO: compiled from: VipDialogSubscribeBottomBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class f extends e {
    private static final ViewDataBinding.b o = null;
    private static final SparseIntArray p = new SparseIntArray();
    private final ConstraintLayout q;
    private final View r;
    private final ImageView s;
    private long t;

    static {
        p.put(R.id.cl_main, 13);
        p.put(R.id.v_line, 14);
        p.put(R.id.tv_list_title, 15);
    }

    public f(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 16, o, p));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 64;
        }
        return true;
    }

    private boolean d(ObservableField<Long> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 2;
        }
        return true;
    }

    private boolean e(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 32;
        }
        return true;
    }

    private boolean f(ObservableField<VipProductEntity> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 16;
        }
        return true;
    }

    @Override // com.sandboxol.vip.b.e
    public void a(com.sandboxol.vip.d.a.a.j jVar) {
        this.n = jVar;
        synchronized (this) {
            this.t |= 128;
        }
        notifyPropertyChanged(com.sandboxol.vip.a.f18952b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00fd  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.vip.b.f.executeBindings():void");
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
            this.t = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((AccountCenter) obj, i2);
            case 1:
                return d((ObservableField) obj, i2);
            case 2:
                return b((ObservableField) obj, i2);
            case 3:
                return a((ObservableField<String>) obj, i2);
            case 4:
                return f((ObservableField) obj, i2);
            case 5:
                return e((ObservableField) obj, i2);
            case 6:
                return c((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.vip.a.f18952b != i) {
            return false;
        }
        a((com.sandboxol.vip.d.a.a.j) obj);
        return true;
    }

    private f(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 7, (Button) objArr[11], (ConstraintLayout) objArr[13], (ImageView) objArr[2], (ImageView) objArr[10], (ImageView) objArr[7], (ImageView) objArr[4], (DataRecyclerView) objArr[8], (TextView) objArr[15], (TextView) objArr[3], (TextView) objArr[9], (TextView) objArr[5], (TextView) objArr[6], (View) objArr[14]);
        this.t = -1L;
        this.f18978a.setTag(null);
        this.f18980c.setTag(null);
        this.f18981d.setTag(null);
        this.f18982e.setTag(null);
        this.f18983f.setTag(null);
        this.q = (ConstraintLayout) objArr[0];
        this.q.setTag(null);
        this.r = (View) objArr[1];
        this.r.setTag(null);
        this.s = (ImageView) objArr[12];
        this.s.setTag(null);
        this.g.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.t |= 8;
        }
        return true;
    }
}
