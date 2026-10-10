package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.ItemView;
import com.sandboxol.center.entity.AccountCenter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.tf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentSettingBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0732tf extends AbstractC0721sf {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8838d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8839e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f8840f;
    private final ItemView g;
    private final ItemView h;
    private final ItemView i;
    private final ItemView j;
    private final ItemView k;
    private final Button l;
    private long m;

    static {
        f8839e.put(R.id.ll, 8);
    }

    public C0732tf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f8838d, f8839e));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0721sf
    public void a(com.disabngo.blockynexus.e.b.ia.m mVar) {
        updateRegistration(2, mVar);
        this.f8799c = mVar;
        synchronized (this) {
            this.m |= 4;
        }
        notifyPropertyChanged(402);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00c2 A[PHI: r2
      0x00c2: PHI (r2v1 long) = (r2v0 long), (r2v5 long) binds: [B:37:0x0095, B:48:0x00bc] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0732tf.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 1) {
            return d((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((com.disabngo.blockynexus.e.b.ia.m) obj, i2);
        }
        if (i == 3) {
            return c((ObservableField) obj, i2);
        }
        if (i == 4) {
            return b((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (402 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ia.m) obj);
        return true;
    }

    private C0732tf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (LinearLayout) objArr[8], (ItemView) objArr[5]);
        this.m = -1L;
        this.f8840f = (LinearLayout) objArr[0];
        this.f8840f.setTag(null);
        this.g = (ItemView) objArr[1];
        this.g.setTag(null);
        this.h = (ItemView) objArr[2];
        this.h.setTag(null);
        this.i = (ItemView) objArr[3];
        this.i.setTag(null);
        this.j = (ItemView) objArr[4];
        this.j.setTag(null);
        this.k = (ItemView) objArr[6];
        this.k.setTag(null);
        this.l = (Button) objArr[7];
        this.l.setTag(null);
        this.f8798b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.ia.m mVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 32;
        }
        return true;
    }
}
