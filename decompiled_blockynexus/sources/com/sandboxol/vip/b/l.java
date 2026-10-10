package com.sandboxol.vip.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.vip.R;

/* JADX INFO: compiled from: VipDialogSubscribeValidPeriodHelpBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class l extends k {
    private static final ViewDataBinding.b o = null;
    private static final SparseIntArray p = new SparseIntArray();
    private final ConstraintLayout q;
    private long r;

    static {
        p.put(R.id.v_bg, 10);
        p.put(R.id.tv_title, 11);
        p.put(R.id.tv_content_tip, 12);
        p.put(R.id.v_bottom, 13);
    }

    public l(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 14, o, p));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.r |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.r |= 2;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.r |= 32;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.r |= 128;
        }
        return true;
    }

    private boolean f(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.r |= 1;
        }
        return true;
    }

    private boolean g(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.r |= 64;
        }
        return true;
    }

    private boolean h(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.r |= 16;
        }
        return true;
    }

    @Override // com.sandboxol.vip.b.k
    public void a(com.sandboxol.vip.d.a.f fVar) {
        this.n = fVar;
        synchronized (this) {
            this.r |= 256;
        }
        notifyPropertyChanged(com.sandboxol.vip.a.f18952b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01af  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1066
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.vip.b.l.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.r != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.r = 512L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return f((ObservableField) obj, i2);
            case 1:
                return c((ObservableField) obj, i2);
            case 2:
                return b((ObservableField) obj, i2);
            case 3:
                return a((ObservableField) obj, i2);
            case 4:
                return h((ObservableField) obj, i2);
            case 5:
                return d((ObservableField) obj, i2);
            case 6:
                return g((ObservableField) obj, i2);
            case 7:
                return e((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.vip.a.f18952b != i) {
            return false;
        }
        a((com.sandboxol.vip.d.a.f) obj);
        return true;
    }

    private l(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 8, (Button) objArr[9], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[12], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[11], (View) objArr[10], (View) objArr[13]);
        this.r = -1L;
        this.f18996a.setTag(null);
        this.q = (ConstraintLayout) objArr[0];
        this.q.setTag(null);
        this.f18997b.setTag(null);
        this.f18998c.setTag(null);
        this.f18999d.setTag(null);
        this.f19000e.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.r |= 8;
        }
        return true;
    }
}
