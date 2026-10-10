package com.sandboxol.halloween.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.widget.CenterStrokeTextView;
import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.IndicatorStayLayout;

/* JADX INFO: compiled from: HalloweenDialogCurrencyBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends a {
    private static final ViewDataBinding.b i = null;
    private static final SparseIntArray j = new SparseIntArray();
    private final ConstraintLayout k;
    private final View l;
    private final CenterStrokeTextView m;
    private final ImageView n;
    private long o;

    static {
        j.put(R.id.bg_bottom, 8);
        j.put(R.id.pb_content, 9);
        j.put(R.id.seek_bar, 10);
    }

    public b(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, i, j));
    }

    private boolean b(ObservableField<Boolean> observableField, int i2) {
        if (i2 != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.o |= 2;
        }
        return true;
    }

    @Override // com.sandboxol.halloween.b.a
    public void a(com.sandboxol.halloween.view.dialog.m mVar) {
        this.h = mVar;
        synchronized (this) {
            this.o |= 4;
        }
        notifyPropertyChanged(com.sandboxol.halloween.a.f18578b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008b A[PHI: r2
      0x008b: PHI (r2v3 long) = (r2v0 long), (r2v5 long) binds: [B:25:0x005c, B:39:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.halloween.b.b.executeBindings():void");
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
            this.o = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a((ObservableField) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return b((ObservableField) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (com.sandboxol.halloween.a.f18578b != i2) {
            return false;
        }
        a((com.sandboxol.halloween.view.dialog.m) obj);
        return true;
    }

    private b(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (View) objArr[8], (View) objArr[5], (ImageView) objArr[3], (ImageView) objArr[4], (ImageView) objArr[1], (IndicatorStayLayout) objArr[9], (IndicatorSeekBar) objArr[10]);
        this.o = -1L;
        this.f18584b.setTag(null);
        this.f18585c.setTag(null);
        this.f18586d.setTag(null);
        this.f18587e.setTag(null);
        this.k = (ConstraintLayout) objArr[0];
        this.k.setTag(null);
        this.l = (View) objArr[2];
        this.l.setTag(null);
        this.m = (CenterStrokeTextView) objArr[6];
        this.m.setTag(null);
        this.n = (ImageView) objArr[7];
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Integer> observableField, int i2) {
        if (i2 != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }
}
