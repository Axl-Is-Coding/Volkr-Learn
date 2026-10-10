package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ke, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentGroupManageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0633ke extends AbstractC0622je {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8513c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8514d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f8515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RelativeLayout f8516f;
    private final RelativeLayout g;
    private final CheckBox h;
    private final RelativeLayout i;
    private final LinearLayout j;
    private final ImageView k;
    private final ImageView l;
    private final ImageView m;
    private final RelativeLayout n;
    private final RelativeLayout o;
    private final CheckBox p;
    private long q;

    static {
        f8514d.put(R.id.right_into_icon_2, 12);
    }

    public C0633ke(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 13, f8513c, f8514d));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 64;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 32;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 128;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 4;
        }
        return true;
    }

    private boolean f(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 8;
        }
        return true;
    }

    private boolean g(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 16;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0622je
    public void a(com.disabngo.blockynexus.e.b.E.x xVar) {
        updateRegistration(1, xVar);
        this.f8478b = xVar;
        synchronized (this) {
            this.q |= 2;
        }
        notifyPropertyChanged(462);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0104  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0633ke.executeBindings():void");
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
            this.q = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((ObservableField<Integer>) obj, i2);
            case 1:
                return a((com.disabngo.blockynexus.e.b.E.x) obj, i2);
            case 2:
                return e((ObservableField) obj, i2);
            case 3:
                return f((ObservableField) obj, i2);
            case 4:
                return g((ObservableField) obj, i2);
            case 5:
                return c((ObservableField) obj, i2);
            case 6:
                return b((ObservableField) obj, i2);
            case 7:
                return d((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (462 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.E.x) obj);
        return true;
    }

    private C0633ke(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 8, (ImageView) objArr[12]);
        this.q = -1L;
        this.f8515e = (LinearLayout) objArr[0];
        this.f8515e.setTag(null);
        this.f8516f = (RelativeLayout) objArr[1];
        this.f8516f.setTag(null);
        this.g = (RelativeLayout) objArr[10];
        this.g.setTag(null);
        this.h = (CheckBox) objArr[11];
        this.h.setTag(null);
        this.i = (RelativeLayout) objArr[2];
        this.i.setTag(null);
        this.j = (LinearLayout) objArr[3];
        this.j.setTag(null);
        this.k = (ImageView) objArr[4];
        this.k.setTag(null);
        this.l = (ImageView) objArr[5];
        this.l.setTag(null);
        this.m = (ImageView) objArr[6];
        this.m.setTag(null);
        this.n = (RelativeLayout) objArr[7];
        this.n.setTag(null);
        this.o = (RelativeLayout) objArr[8];
        this.o.setTag(null);
        this.p = (CheckBox) objArr[9];
        this.p.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.E.x xVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 2;
        }
        return true;
    }
}
