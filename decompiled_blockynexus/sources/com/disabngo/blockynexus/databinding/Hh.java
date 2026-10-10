package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.ScaleConstraintLayout;
import com.sandboxol.center.view.widget.DownloadCircleView;

/* JADX INFO: compiled from: ItemGuessYouLikeItemNewViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Hh extends Gh {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final ScaleConstraintLayout i;
    private final TextView j;
    private final TextView k;
    private final DownloadCircleView l;
    private final LinearLayout m;
    private final ImageView n;
    private long o;

    static {
        h.put(R.id.bgPraise, 9);
        h.put(R.id.bgMask, 10);
    }

    public Hh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, g, h));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 64;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 32;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 128;
        }
        return true;
    }

    private boolean f(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 8;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.e.b.I.c cVar) {
        updateRegistration(2, cVar);
        this.f7506f = cVar;
        synchronized (this) {
            this.o |= 4;
        }
        notifyPropertyChanged(520);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d3 A[PHI: r2
      0x00d3: PHI (r2v23 long) = (r2v22 long), (r2v37 long) binds: [B:44:0x00a8, B:58:0x00ce] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0164  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 694
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Hh.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 512L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((ObservableList<String>) obj, i2);
            case 1:
                return b((ObservableField) obj, i2);
            case 2:
                return a((com.disabngo.blockynexus.e.b.I.c) obj, i2);
            case 3:
                return f((ObservableField) obj, i2);
            case 4:
                return a((ObservableField<Boolean>) obj, i2);
            case 5:
                return d((ObservableField) obj, i2);
            case 6:
                return c((ObservableField) obj, i2);
            case 7:
                return e((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (520 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.I.c) obj);
        return true;
    }

    private Hh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 8, (View) objArr[10], (View) objArr[9], (ImageView) objArr[1], (TextView) objArr[5], (TextView) objArr[4]);
        this.o = -1L;
        this.f7503c.setTag(null);
        this.f7504d.setTag(null);
        this.i = (ScaleConstraintLayout) objArr[0];
        this.i.setTag(null);
        this.j = (TextView) objArr[2];
        this.j.setTag(null);
        this.k = (TextView) objArr[3];
        this.k.setTag(null);
        this.l = (DownloadCircleView) objArr[6];
        this.l.setTag(null);
        this.m = (LinearLayout) objArr[7];
        this.m.setTag(null);
        this.n = (ImageView) objArr[8];
        this.n.setTag(null);
        this.f7505e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableList<String> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.I.c cVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.o |= 4;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.o |= 256;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o |= 16;
        }
        return true;
    }
}
