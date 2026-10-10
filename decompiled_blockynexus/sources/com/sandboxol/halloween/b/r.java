package com.sandboxol.halloween.b;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.view.widget.counDownView.NormalCountDownView;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.view.fragment.tasks.TasksItemViewModel;
import com.sandboxol.halloween.widget.CenterStrokeTextView;

/* JADX INFO: compiled from: HalloweenItemTaskBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class r extends q {
    private static final ViewDataBinding.b m = null;
    private static final SparseIntArray n = new SparseIntArray();
    private final ConstraintLayout o;
    private long p;

    static {
        n.put(R.id.bg_base, 8);
        n.put(R.id.bg_name, 9);
        n.put(R.id.bg_progress, 10);
        n.put(R.id.bg_img, 11);
    }

    public r(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 12, m, n));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.p |= 128;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.p |= 32;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.p |= 256;
        }
        return true;
    }

    private boolean e(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.p |= 1;
        }
        return true;
    }

    private boolean f(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.p |= 4;
        }
        return true;
    }

    private boolean g(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.p |= 8;
        }
        return true;
    }

    private boolean h(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.p |= 64;
        }
        return true;
    }

    public void a(TasksItemViewModel tasksItemViewModel) {
        updateRegistration(1, tasksItemViewModel);
        this.l = tasksItemViewModel;
        synchronized (this) {
            this.p |= 2;
        }
        notifyPropertyChanged(com.sandboxol.halloween.a.f18578b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x015e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.halloween.b.r.executeBindings():void");
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
            this.p = 1024L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return e((ObservableField) obj, i2);
            case 1:
                return a((TasksItemViewModel) obj, i2);
            case 2:
                return f((ObservableField) obj, i2);
            case 3:
                return g((ObservableField) obj, i2);
            case 4:
                return a((ObservableField<Drawable>) obj, i2);
            case 5:
                return c((ObservableField) obj, i2);
            case 6:
                return h((ObservableField) obj, i2);
            case 7:
                return b((ObservableField) obj, i2);
            case 8:
                return d((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.halloween.a.f18578b != i) {
            return false;
        }
        a((TasksItemViewModel) obj);
        return true;
    }

    private r(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 9, (View) objArr[8], (View) objArr[6], (View) objArr[11], (View) objArr[9], (View) objArr[10], (ProgressBar) objArr[3], (NormalCountDownView) objArr[2], (TextView) objArr[7], (CenterStrokeTextView) objArr[5], (CenterStrokeTextView) objArr[1], (TextView) objArr[4]);
        this.p = -1L;
        this.f18632b.setTag(null);
        this.o = (ConstraintLayout) objArr[0];
        this.o.setTag(null);
        this.f18636f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(TasksItemViewModel tasksItemViewModel, int i) {
        if (i == com.sandboxol.halloween.a.f18577a) {
            synchronized (this) {
                this.p |= 2;
            }
            return true;
        }
        if (i != com.sandboxol.halloween.a.f18579c) {
            return false;
        }
        synchronized (this) {
            this.p |= 512;
        }
        return true;
    }

    private boolean a(ObservableField<Drawable> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.p |= 16;
        }
        return true;
    }
}
