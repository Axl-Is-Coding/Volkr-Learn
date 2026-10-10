package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.TabRadioButton;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityMainBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0683p extends AbstractC0672o {
    private static final ViewDataBinding.b l = null;
    private static final SparseIntArray m = new SparseIntArray();
    private final CoordinatorLayout n;
    private final ImageView o;
    private final ImageView p;
    private final ImageView q;
    private long r;

    static {
        m.put(R.id.rlMain, 6);
        m.put(R.id.rb_1, 7);
        m.put(R.id.rb_2, 8);
        m.put(R.id.rb_3, 9);
        m.put(R.id.rb_4, 10);
        m.put(R.id.rb_5, 11);
        m.put(R.id.flHomePage, 12);
        m.put(R.id.rlGLSurfaceView, 13);
    }

    public C0683p(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 14, l, m));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 64;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 128;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 2;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 256;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 1;
        }
        return true;
    }

    private boolean g(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 16;
        }
        return true;
    }

    private boolean h(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 8;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0672o
    public void a(com.disabngo.blockynexus.view.activity.main.nc ncVar) {
        updateRegistration(5, ncVar);
        this.k = ncVar;
        synchronized (this) {
            this.r |= 32;
        }
        notifyPropertyChanged(301);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x015d A[PHI: r2
      0x015d: PHI (r2v11 long) = (r2v10 long), (r2v12 long) binds: [B:101:0x012e, B:115:0x0158] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a5 A[PHI: r2
      0x00a5: PHI (r2v7 long) = (r2v6 long), (r2v16 long) binds: [B:36:0x0079, B:50:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d5 A[PHI: r2
      0x00d5: PHI (r2v9 long) = (r2v8 long), (r2v14 long) binds: [B:55:0x00aa, B:69:0x00d0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0129  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0683p.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.r != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.r = 512L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return f((ObservableField) obj, i2);
            case 1:
                return d((ObservableField) obj, i2);
            case 2:
                return a((ObservableField<Integer>) obj, i2);
            case 3:
                return h((ObservableField) obj, i2);
            case 4:
                return g((ObservableField) obj, i2);
            case 5:
                return a((com.disabngo.blockynexus.view.activity.main.nc) obj, i2);
            case 6:
                return b((ObservableField) obj, i2);
            case 7:
                return c((ObservableField) obj, i2);
            case 8:
                return e((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (301 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.main.nc) obj);
        return true;
    }

    private C0683p(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 9, (FrameLayout) objArr[12], (ImageView) objArr[5], (TabRadioButton) objArr[7], (TabRadioButton) objArr[8], (TabRadioButton) objArr[9], (TabRadioButton) objArr[10], (TabRadioButton) objArr[11], (RadioGroup) objArr[1], (RelativeLayout) objArr[13], (RelativeLayout) objArr[6]);
        this.r = -1L;
        this.f8638b.setTag(null);
        this.n = (CoordinatorLayout) objArr[0];
        this.n.setTag(null);
        this.o = (ImageView) objArr[2];
        this.o.setTag(null);
        this.p = (ImageView) objArr[3];
        this.p.setTag(null);
        this.q = (ImageView) objArr[4];
        this.q.setTag(null);
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 4;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.activity.main.nc ncVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.r |= 32;
        }
        return true;
    }
}
