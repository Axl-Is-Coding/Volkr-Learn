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
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: DialogSignInBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ec extends Dc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f7421d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f7422e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f7423f;
    private final ImageView g;
    private final TextView h;
    private final Button i;
    private final ImageView j;
    private final TextView k;
    private final LinearLayout l;
    private final ImageView m;
    private final TextView n;
    private final TextView o;
    private long p;

    static {
        f7422e.put(R.id.rlLeft, 10);
        f7422e.put(R.id.rlRight, 11);
    }

    public Ec(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 12, f7421d, f7422e));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 8;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 2;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 16;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 128;
        }
        return true;
    }

    private boolean g(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 64;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.view.dialog.i.d dVar) {
        updateRegistration(5, dVar);
        this.f7379c = dVar;
        synchronized (this) {
            this.p |= 32;
        }
        notifyPropertyChanged(439);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0113  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ec.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return b((ObservableField) obj, i2);
            case 1:
                return d((ObservableField) obj, i2);
            case 2:
                return a((ObservableField<Integer>) obj, i2);
            case 3:
                return c((ObservableField) obj, i2);
            case 4:
                return e((ObservableField) obj, i2);
            case 5:
                return a((com.disabngo.blockynexus.view.dialog.i.d) obj, i2);
            case 6:
                return g((ObservableField) obj, i2);
            case 7:
                return f((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (439 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.i.d) obj);
        return true;
    }

    private Ec(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 8, (RelativeLayout) objArr[10], (RelativeLayout) objArr[11]);
        this.p = -1L;
        this.f7423f = (LinearLayout) objArr[0];
        this.f7423f.setTag(null);
        this.g = (ImageView) objArr[1];
        this.g.setTag(null);
        this.h = (TextView) objArr[2];
        this.h.setTag(null);
        this.i = (Button) objArr[3];
        this.i.setTag(null);
        this.j = (ImageView) objArr[4];
        this.j.setTag(null);
        this.k = (TextView) objArr[5];
        this.k.setTag(null);
        this.l = (LinearLayout) objArr[6];
        this.l.setTag(null);
        this.m = (ImageView) objArr[7];
        this.m.setTag(null);
        this.n = (TextView) objArr[8];
        this.n.setTag(null);
        this.o = (TextView) objArr[9];
        this.o.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 4;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.i.d dVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 32;
        }
        return true;
    }
}
