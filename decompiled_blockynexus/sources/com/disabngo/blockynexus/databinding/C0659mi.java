package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.mi, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemNewFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0659mi extends AbstractC0648li {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8595d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8596e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f8597f;
    private final ImageView g;
    private final TextView h;
    private final TextView i;
    private final TextView j;
    private final TextView k;
    private final RelativeLayout l;
    private final Button m;
    private final Button n;
    private long o;

    public C0659mi(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, f8595d, f8596e));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 8;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.e.b.Q.g gVar) {
        updateRegistration(1, gVar);
        this.f8560c = gVar;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004a A[PHI: r2
      0x004a: PHI (r2v4 long) = (r2v0 long), (r2v9 long) binds: [B:9:0x0020, B:23:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0659mi.executeBindings():void");
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
            this.o = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return b((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.e.b.Q.g) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return c((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.Q.g) obj);
        return true;
    }

    private C0659mi(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (TextView) objArr[4], (TextView) objArr[2]);
        this.o = -1L;
        this.f8597f = (LinearLayout) objArr[0];
        this.f8597f.setTag(null);
        this.g = (ImageView) objArr[1];
        this.g.setTag(null);
        this.h = (TextView) objArr[10];
        this.h.setTag(null);
        this.i = (TextView) objArr[3];
        this.i.setTag(null);
        this.j = (TextView) objArr[5];
        this.j.setTag(null);
        this.k = (TextView) objArr[6];
        this.k.setTag(null);
        this.l = (RelativeLayout) objArr[7];
        this.l.setTag(null);
        this.m = (Button) objArr[8];
        this.m.setTag(null);
        this.n = (Button) objArr[9];
        this.n.setTag(null);
        this.f8558a.setTag(null);
        this.f8559b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.Q.g gVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.o |= 2;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.o |= 16;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 4;
        }
        return true;
    }
}
