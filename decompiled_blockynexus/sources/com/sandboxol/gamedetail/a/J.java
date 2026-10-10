package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.greendao.entity.GameWarmUpResponse;

/* JADX INFO: compiled from: ItemGameDetailIntroduceTopBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class J extends I {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f17799b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f17800c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f17801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f17802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f17803f;
    private final TextView g;
    private final View h;
    private final LinearLayout i;
    private final ImageView j;
    private final TextView k;
    private final LinearLayout l;
    private final Button m;
    private final TextView n;
    private long o;

    public J(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, f17799b, f17800c));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.o |= 8;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.o |= 32;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.o |= 64;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.o |= 16;
        }
        return true;
    }

    public void a(com.sandboxol.gamedetail.c.a.b.m mVar) {
        updateRegistration(1, mVar);
        this.f17798a = mVar;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.f17769b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x015b A[PHI: r2
      0x015b: PHI (r2v6 long) = (r2v5 long), (r2v11 long) binds: [B:92:0x012c, B:106:0x0155] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x012e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 754
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.gamedetail.a.J.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 1024L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return b((ObservableField) obj, i2);
            case 1:
                return a((com.sandboxol.gamedetail.c.a.b.m) obj, i2);
            case 2:
                return a((GameWarmUpResponse) obj, i2);
            case 3:
                return c((ObservableField) obj, i2);
            case 4:
                return f((ObservableField) obj, i2);
            case 5:
                return d((ObservableField) obj, i2);
            case 6:
                return e((ObservableField) obj, i2);
            case 7:
                return a((ObservableField<String>) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.gamedetail.a.f17769b != i) {
            return false;
        }
        a((com.sandboxol.gamedetail.c.a.b.m) obj);
        return true;
    }

    private J(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 8);
        this.o = -1L;
        this.f17801d = (LinearLayout) objArr[0];
        this.f17801d.setTag(null);
        this.f17802e = (RelativeLayout) objArr[1];
        this.f17802e.setTag(null);
        this.f17803f = (TextView) objArr[10];
        this.f17803f.setTag(null);
        this.g = (TextView) objArr[2];
        this.g.setTag(null);
        this.h = (View) objArr[3];
        this.h.setTag(null);
        this.i = (LinearLayout) objArr[4];
        this.i.setTag(null);
        this.j = (ImageView) objArr[5];
        this.j.setTag(null);
        this.k = (TextView) objArr[6];
        this.k.setTag(null);
        this.l = (LinearLayout) objArr[7];
        this.l.setTag(null);
        this.m = (Button) objArr[8];
        this.m.setTag(null);
        this.n = (TextView) objArr[9];
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.gamedetail.c.a.b.m mVar, int i) {
        if (i == com.sandboxol.gamedetail.a.f17768a) {
            synchronized (this) {
                this.o |= 2;
            }
            return true;
        }
        if (i != com.sandboxol.gamedetail.a.m) {
            return false;
        }
        synchronized (this) {
            this.o |= 256;
        }
        return true;
    }

    private boolean a(GameWarmUpResponse gameWarmUpResponse, int i) {
        if (i == com.sandboxol.gamedetail.a.f17768a) {
            synchronized (this) {
                this.o |= 4;
            }
            return true;
        }
        if (i != com.sandboxol.gamedetail.a.f17770c) {
            return false;
        }
        synchronized (this) {
            this.o |= 512;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.o |= 128;
        }
        return true;
    }
}
