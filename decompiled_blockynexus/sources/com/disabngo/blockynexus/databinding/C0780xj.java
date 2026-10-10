package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableMap;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.TribeCenter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.xj, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTribeShopBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0780xj extends AbstractC0769wj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8990c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8991d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f8992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8993f;
    private final TextView g;
    private final TextView h;
    private final ImageView i;
    private final TextView j;
    private long k;

    public C0780xj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f8990c, f8991d));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.view.activity.tribeshop.B b2) {
        updateRegistration(0, b2);
        this.f8948b = b2;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x014a  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 519
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0780xj.executeBindings():void");
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
            this.k = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.activity.tribeshop.B) obj, i2);
        }
        if (i == 1) {
            return a((TribeCenter) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return a((ObservableMap<Long, String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.tribeshop.B) obj);
        return true;
    }

    private C0780xj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (ImageView) objArr[2]);
        this.k = -1L;
        this.f8947a.setTag(null);
        this.f8992e = (RelativeLayout) objArr[0];
        this.f8992e.setTag(null);
        this.f8993f = (TextView) objArr[1];
        this.f8993f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (ImageView) objArr[5];
        this.i.setTag(null);
        this.j = (TextView) objArr[6];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.tribeshop.B b2, int i) {
        if (i == 0) {
            synchronized (this) {
                this.k |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.k |= 32;
        }
        return true;
    }

    private boolean a(TribeCenter tribeCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 8;
        }
        return true;
    }

    private boolean a(ObservableMap<Long, String> observableMap, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 16;
        }
        return true;
    }
}
