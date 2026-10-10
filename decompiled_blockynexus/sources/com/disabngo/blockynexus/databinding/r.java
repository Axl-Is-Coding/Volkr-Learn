package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: ActivityNewSearchFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class r extends AbstractC0694q {
    private static final ViewDataBinding.b i = null;
    private static final SparseIntArray j = new SparseIntArray();
    private final CoordinatorLayout k;
    private final RelativeLayout l;
    private final ImageView m;
    private final TextView n;
    private final DataRecyclerView o;
    private final RelativeLayout p;
    private final View q;
    private final ImageButton r;
    private final TextView s;
    private final TextView t;
    private long u;

    static {
        j.put(R.id.tbMainBar, 15);
        j.put(R.id.input_name, 16);
    }

    public r(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 17, i, j));
    }

    private boolean b(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.u |= 64;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.u |= 256;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.u |= 16;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.u |= 1;
        }
        return true;
    }

    private boolean f(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.u |= 4;
        }
        return true;
    }

    private boolean g(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.u |= 128;
        }
        return true;
    }

    private boolean h(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.u |= 32;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0694q
    public void a(com.disabngo.blockynexus.view.activity.newsearch.o oVar) {
        updateRegistration(1, oVar);
        this.h = oVar;
        synchronized (this) {
            this.u |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0164  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 829
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.r.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.u != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.u = 512L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return e((ObservableField) obj, i3);
            case 1:
                return a((com.disabngo.blockynexus.view.activity.newsearch.o) obj, i3);
            case 2:
                return f((ObservableField) obj, i3);
            case 3:
                return a((ObservableField<String>) obj, i3);
            case 4:
                return d((ObservableField) obj, i3);
            case 5:
                return h((ObservableField) obj, i3);
            case 6:
                return b((ObservableField) obj, i3);
            case 7:
                return g((ObservableField) obj, i3);
            case 8:
                return c((ObservableField) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (2 != i2) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.newsearch.o) obj);
        return true;
    }

    private r(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 9, (TextInputEditText) objArr[11], (TextInputLayout) objArr[16], (LinearLayout) objArr[7], (LinearLayout) objArr[5], (AppCompatCheckBox) objArr[9], (AppCompatCheckBox) objArr[10], (Toolbar) objArr[15]);
        this.u = -1L;
        this.f8709a.setTag(null);
        this.f8711c.setTag(null);
        this.f8712d.setTag(null);
        this.k = (CoordinatorLayout) objArr[0];
        this.k.setTag(null);
        this.l = (RelativeLayout) objArr[1];
        this.l.setTag(null);
        this.m = (ImageView) objArr[12];
        this.m.setTag(null);
        this.n = (TextView) objArr[13];
        this.n.setTag(null);
        this.o = (DataRecyclerView) objArr[14];
        this.o.setTag(null);
        this.p = (RelativeLayout) objArr[2];
        this.p.setTag(null);
        this.q = (View) objArr[3];
        this.q.setTag(null);
        this.r = (ImageButton) objArr[4];
        this.r.setTag(null);
        this.s = (TextView) objArr[6];
        this.s.setTag(null);
        this.t = (TextView) objArr[8];
        this.t.setTag(null);
        this.f8713e.setTag(null);
        this.f8714f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.newsearch.o oVar, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.u |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.u |= 8;
        }
        return true;
    }
}
