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

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ki, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemMoreGameItemViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0637ki extends AbstractC0626ji {
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

    public C0637ki(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 12, g, h));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p |= 16;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.view.fragment.main.X x) {
        updateRegistration(3, x);
        this.f8495f = x;
        synchronized (this) {
            this.p |= 8;
        }
        notifyPropertyChanged(493);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01c9 A[PHI: r2
      0x01c9: PHI (r2v4 long) = (r2v3 long), (r2v7 long) binds: [B:107:0x01b2, B:116:0x01c4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0182  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0637ki.executeBindings():void");
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
            return b((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((com.disabngo.blockynexus.view.fragment.main.X) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return c((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (493 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.main.X) obj);
        return true;
    }

    private C0637ki(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (View) objArr[11], (View) objArr[10], (ImageView) objArr[1], (TextView) objArr[5], (TextView) objArr[4]);
        this.p = -1L;
        this.f8492c.setTag(null);
        this.f8493d.setTag(null);
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
        this.f8494e.setTag(null);
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

    private boolean a(com.disabngo.blockynexus.view.fragment.main.X x, int i) {
        if (i == 0) {
            synchronized (this) {
                this.p |= 8;
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
