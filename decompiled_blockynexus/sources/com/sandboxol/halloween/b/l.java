package com.sandboxol.halloween.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.widget.CenterStrokeTextView;

/* JADX INFO: compiled from: HalloweenFragmentHomeBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class l extends k {
    private static final ViewDataBinding.b w = null;
    private static final SparseIntArray x = new SparseIntArray();
    private final ImageView A;
    private final ImageView B;
    private final Group C;
    private final ImageView D;
    private final ImageView E;
    private long F;
    private final CoordinatorLayout y;
    private final View z;

    static {
        x.put(R.id.bg_main, 14);
        x.put(R.id.bg_top, 15);
        x.put(R.id.bg_down, 16);
        x.put(R.id.flParent, 17);
        x.put(R.id.bg_info, 18);
        x.put(R.id.tv_time_num_1, 19);
        x.put(R.id.tv_time_num_3, 20);
        x.put(R.id.rb_exchange, 21);
        x.put(R.id.rb_tasks, 22);
        x.put(R.id.decoration_line, 23);
        x.put(R.id.stv_tab_1, 24);
        x.put(R.id.stv_tab_2, 25);
        x.put(R.id.fl_fragment, 26);
        x.put(R.id.mid_line, 27);
    }

    public l(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 28, w, x));
    }

    private boolean b(ObservableField<Drawable> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.F |= 2;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.F |= 16;
        }
        return true;
    }

    private boolean d(ObservableField<Drawable> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.F |= 128;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.F |= 64;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.F |= 256;
        }
        return true;
    }

    private boolean g(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.F |= 8;
        }
        return true;
    }

    private boolean h(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.F |= 32;
        }
        return true;
    }

    @Override // com.sandboxol.halloween.b.k
    public void a(com.sandboxol.halloween.view.activity.l lVar) {
        updateRegistration(2, lVar);
        this.v = lVar;
        synchronized (this) {
            this.F |= 4;
        }
        notifyPropertyChanged(com.sandboxol.halloween.a.f18578b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0182 A[PHI: r2
      0x0182: PHI (r2v9 long) = (r2v8 long), (r2v10 long) binds: [B:110:0x0155, B:124:0x0180] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0093 A[PHI: r2
      0x0093: PHI (r2v3 long) = (r2v0 long), (r2v16 long) binds: [B:29:0x0064, B:43:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00fd A[PHI: r2
      0x00fd: PHI (r2v5 long) = (r2v4 long), (r2v14 long) binds: [B:64:0x00d0, B:78:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0130 A[PHI: r2
      0x0130: PHI (r2v7 long) = (r2v6 long), (r2v12 long) binds: [B:83:0x0102, B:97:0x012b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 559
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.halloween.b.l.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.F != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.F = 512L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((ObservableField<Integer>) obj, i2);
            case 1:
                return b((ObservableField) obj, i2);
            case 2:
                return a((com.sandboxol.halloween.view.activity.l) obj, i2);
            case 3:
                return g((ObservableField) obj, i2);
            case 4:
                return c((ObservableField) obj, i2);
            case 5:
                return h((ObservableField) obj, i2);
            case 6:
                return e((ObservableField) obj, i2);
            case 7:
                return d((ObservableField) obj, i2);
            case 8:
                return f((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.halloween.a.f18578b != i) {
            return false;
        }
        a((com.sandboxol.halloween.view.activity.l) obj);
        return true;
    }

    private l(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 9, (View) objArr[10], (View) objArr[16], (View) objArr[18], (View) objArr[14], (View) objArr[15], (View) objArr[23], (FrameLayout) objArr[26], (FrameLayout) objArr[17], (Guideline) objArr[27], (AppCompatRadioButton) objArr[21], (AppCompatRadioButton) objArr[22], (RadioGroup) objArr[6], (CenterStrokeTextView) objArr[24], (CenterStrokeTextView) objArr[25], (TextView) objArr[7], (ImageView) objArr[2], (ImageView) objArr[3], (ImageView) objArr[4], (ImageView) objArr[19], (ImageView) objArr[5], (ImageView) objArr[20]);
        this.F = -1L;
        this.f18613a.setTag(null);
        this.y = (CoordinatorLayout) objArr[0];
        this.y.setTag(null);
        this.z = (View) objArr[1];
        this.z.setTag(null);
        this.A = (ImageView) objArr[11];
        this.A.setTag(null);
        this.B = (ImageView) objArr[12];
        this.B.setTag(null);
        this.C = (Group) objArr[13];
        this.C.setTag(null);
        this.D = (ImageView) objArr[8];
        this.D.setTag(null);
        this.E = (ImageView) objArr[9];
        this.E.setTag(null);
        this.l.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.t.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.F |= 1;
        }
        return true;
    }

    private boolean a(com.sandboxol.halloween.view.activity.l lVar, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.F |= 4;
        }
        return true;
    }
}
