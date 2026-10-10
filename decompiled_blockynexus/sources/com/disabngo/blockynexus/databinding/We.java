package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.opensource.svgaplayer.SVGAImageView;

/* JADX INFO: compiled from: FragmentRefreshDataBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class We extends Ve {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final ConstraintLayout i;
    private final TextView j;
    private final TextView k;
    private final TextView l;
    private final TextView m;
    private long n;

    static {
        h.put(R.id.bg_up, 6);
        h.put(R.id.bg_down, 7);
        h.put(R.id.top_of_down, 8);
        h.put(R.id.iv_banner, 9);
    }

    public We(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, g, h));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 32;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 16;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Ve
    public void a(com.disabngo.blockynexus.e.b.p.o oVar) {
        updateRegistration(0, oVar);
        this.f7966f = oVar;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(499);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.We.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.p.o) obj, i2);
        }
        if (i == 1) {
            return c((ObservableField) obj, i2);
        }
        if (i == 2) {
            return d((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i == 4) {
            return e((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (499 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.p.o) obj);
        return true;
    }

    private We(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (View) objArr[7], (View) objArr[6], (SVGAImageView) objArr[9], (ProgressBar) objArr[2], (View) objArr[8]);
        this.n = -1L;
        this.i = (ConstraintLayout) objArr[0];
        this.i.setTag(null);
        this.j = (TextView) objArr[1];
        this.j.setTag(null);
        this.k = (TextView) objArr[3];
        this.k.setTag(null);
        this.l = (TextView) objArr[4];
        this.l.setTag(null);
        this.m = (TextView) objArr[5];
        this.m.setTag(null);
        this.f7964d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.p.o oVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 8;
        }
        return true;
    }
}
