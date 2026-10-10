package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentTribeHasBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Lf extends Kf {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f7647d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f7648e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoordinatorLayout f7649f;
    private final RelativeLayout g;
    private final Button h;
    private final LinearLayout i;
    private final LinearLayout j;
    private final LinearLayout k;
    private final LinearLayout l;
    private final LinearLayout m;
    private final TextView n;
    private final DataRecyclerView o;
    private final ImageButton p;
    private final RelativeLayout q;
    private final ImageView r;
    private final ImageView s;
    private final TextView t;
    private final TextView u;
    private final ImageView v;
    private final ImageView w;
    private long x;

    static {
        f7648e.put(R.id.tbMainBar, 18);
        f7648e.put(R.id.img, 19);
    }

    public Lf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 20, f7647d, f7648e));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 64;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 128;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 256;
        }
        return true;
    }

    private boolean e(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 4;
        }
        return true;
    }

    private boolean f(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 32;
        }
        return true;
    }

    private boolean g(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 16;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Kf
    public void a(com.disabngo.blockynexus.view.fragment.tribehas.T t) {
        updateRegistration(3, t);
        this.f7615c = t;
        synchronized (this) {
            this.x |= 8;
        }
        notifyPropertyChanged(340);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041 A[PHI: r2
      0x0041: PHI (r2v1 long) = (r2v0 long), (r2v5 long) binds: [B:7:0x0012, B:22:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0152  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 629
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Lf.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.x != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.x = 512L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((TribeCenter) obj, i2);
            case 1:
                return a((ObservableField<Integer>) obj, i2);
            case 2:
                return e((ObservableField) obj, i2);
            case 3:
                return a((com.disabngo.blockynexus.view.fragment.tribehas.T) obj, i2);
            case 4:
                return g((ObservableField) obj, i2);
            case 5:
                return f((ObservableField) obj, i2);
            case 6:
                return b((ObservableField) obj, i2);
            case 7:
                return c((ObservableField) obj, i2);
            case 8:
                return d((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (340 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.tribehas.T) obj);
        return true;
    }

    private Lf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 9, (RelativeLayout) objArr[19], (Toolbar) objArr[18]);
        this.x = -1L;
        this.f7649f = (CoordinatorLayout) objArr[0];
        this.f7649f.setTag(null);
        this.g = (RelativeLayout) objArr[1];
        this.g.setTag(null);
        this.h = (Button) objArr[10];
        this.h.setTag(null);
        this.i = (LinearLayout) objArr[11];
        this.i.setTag(null);
        this.j = (LinearLayout) objArr[12];
        this.j.setTag(null);
        this.k = (LinearLayout) objArr[13];
        this.k.setTag(null);
        this.l = (LinearLayout) objArr[14];
        this.l.setTag(null);
        this.m = (LinearLayout) objArr[15];
        this.m.setTag(null);
        this.n = (TextView) objArr[16];
        this.n.setTag(null);
        this.o = (DataRecyclerView) objArr[17];
        this.o.setTag(null);
        this.p = (ImageButton) objArr[2];
        this.p.setTag(null);
        this.q = (RelativeLayout) objArr[3];
        this.q.setTag(null);
        this.r = (ImageView) objArr[4];
        this.r.setTag(null);
        this.s = (ImageView) objArr[5];
        this.s.setTag(null);
        this.t = (TextView) objArr[6];
        this.t.setTag(null);
        this.u = (TextView) objArr[7];
        this.u.setTag(null);
        this.v = (ImageView) objArr[8];
        this.v.setTag(null);
        this.w = (ImageView) objArr[9];
        this.w.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(TribeCenter tribeCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 2;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.tribehas.T t, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.x |= 8;
        }
        return true;
    }
}
