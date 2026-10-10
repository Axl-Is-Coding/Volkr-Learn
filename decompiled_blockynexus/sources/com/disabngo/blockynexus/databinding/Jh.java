package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.ScaleConstraintLayout;

/* JADX INFO: compiled from: ItemGuessYouLikeItemViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Jh extends Ih {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final ScaleConstraintLayout i;
    private final TextView j;
    private final TextView k;
    private final ProgressBar l;
    private final LinearLayout m;
    private final TextView n;
    private final ImageView o;
    private long p;

    static {
        h.put(R.id.bgPraise, 10);
        h.put(R.id.bgMask, 11);
    }

    public Jh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 12, g, h));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 16;
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

    public void a(com.disabngo.blockynexus.e.b.I.c cVar) {
        updateRegistration(2, cVar);
        this.f7559f = cVar;
        synchronized (this) {
            this.p |= 4;
        }
        notifyPropertyChanged(520);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01c8 A[PHI: r2
      0x01c8: PHI (r2v3 long) = (r2v2 long), (r2v6 long) binds: [B:106:0x01b2, B:115:0x01c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0158  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 589
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Jh.executeBindings():void");
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
            this.p = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableList<String>) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 2) {
            return a((com.disabngo.blockynexus.e.b.I.c) obj, i2);
        }
        if (i == 3) {
            return c((ObservableField) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (520 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.I.c) obj);
        return true;
    }

    private Jh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (View) objArr[11], (View) objArr[10], (ImageView) objArr[1], (TextView) objArr[5], (TextView) objArr[4]);
        this.p = -1L;
        this.f7556c.setTag(null);
        this.f7557d.setTag(null);
        this.i = (ScaleConstraintLayout) objArr[0];
        this.i.setTag(null);
        this.j = (TextView) objArr[2];
        this.j.setTag(null);
        this.k = (TextView) objArr[3];
        this.k.setTag(null);
        this.l = (ProgressBar) objArr[6];
        this.l.setTag(null);
        this.m = (LinearLayout) objArr[7];
        this.m.setTag(null);
        this.n = (TextView) objArr[8];
        this.n.setTag(null);
        this.o = (ImageView) objArr[9];
        this.o.setTag(null);
        this.f7558e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableList<String> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 2;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.I.c cVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.p |= 4;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.p |= 32;
        }
        return true;
    }
}
