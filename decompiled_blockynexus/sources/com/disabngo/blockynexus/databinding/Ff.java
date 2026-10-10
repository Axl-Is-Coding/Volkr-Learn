package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: compiled from: FragmentTribeContributionBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ff extends Ef {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f7453e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f7454f = new SparseIntArray();
    private final LinearLayout g;
    private final ImageView h;
    private final PageRecyclerView i;
    private final TextView j;
    private final TextView k;
    private final Button l;
    private final TextView m;
    private final Button n;
    private final TextView o;
    private final Button p;
    private long q;

    static {
        f7454f.put(R.id.tvLevel, 11);
        f7454f.put(R.id.iv_tribe_donate_crown, 12);
    }

    public Ff(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 13, f7453e, f7454f));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 32;
        }
        return true;
    }

    private boolean d(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 16;
        }
        return true;
    }

    private boolean e(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 8;
        }
        return true;
    }

    private boolean f(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 2;
        }
        return true;
    }

    private boolean g(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Ef
    public void a(com.disabngo.blockynexus.e.b.ka.p pVar) {
        updateRegistration(6, pVar);
        this.f7431d = pVar;
        synchronized (this) {
            this.q |= 64;
        }
        notifyPropertyChanged(509);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0115  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ff.executeBindings():void");
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
                return b((ObservableField) obj, i2);
            case 1:
                return f((ObservableField) obj, i2);
            case 2:
                return g((ObservableField) obj, i2);
            case 3:
                return e((ObservableField) obj, i2);
            case 4:
                return d((ObservableField) obj, i2);
            case 5:
                return c((ObservableField) obj, i2);
            case 6:
                return a((com.disabngo.blockynexus.e.b.ka.p) obj, i2);
            case 7:
                return a((ObservableField<String>) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (509 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ka.p) obj);
        return true;
    }

    private Ff(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 8, (ImageView) objArr[12], (ProgressBar) objArr[2], (TextView) objArr[11]);
        this.q = -1L;
        this.g = (LinearLayout) objArr[0];
        this.g.setTag(null);
        this.h = (ImageView) objArr[1];
        this.h.setTag(null);
        this.i = (PageRecyclerView) objArr[10];
        this.i.setTag(null);
        this.j = (TextView) objArr[3];
        this.j.setTag(null);
        this.k = (TextView) objArr[4];
        this.k.setTag(null);
        this.l = (Button) objArr[5];
        this.l.setTag(null);
        this.m = (TextView) objArr[6];
        this.m.setTag(null);
        this.n = (Button) objArr[7];
        this.n.setTag(null);
        this.o = (TextView) objArr[8];
        this.o.setTag(null);
        this.p = (Button) objArr[9];
        this.p.setTag(null);
        this.f7429b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ka.p pVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 64;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.q |= 128;
        }
        return true;
    }
}
