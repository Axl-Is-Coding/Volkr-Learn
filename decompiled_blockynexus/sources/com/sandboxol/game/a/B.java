package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blockmango.BedWarScreenshotShareDialog;
import com.sandboxol.game.R;

/* JADX INFO: compiled from: DialogScreenshotShareForBedWarBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class B extends A {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = new SparseIntArray();
    private final ConstraintLayout l;
    private final AppCompatImageView m;
    private final AppCompatImageView n;
    private long o;

    static {
        k.put(R.id.bg_dialog, 7);
        k.put(R.id.dialog, 8);
        k.put(R.id.vBg, 9);
        k.put(R.id.ivBg, 10);
    }

    public B(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, j, k));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.o |= 2;
        }
        return true;
    }

    public void a(BedWarScreenshotShareDialog bedWarScreenshotShareDialog) {
        this.i = bedWarScreenshotShareDialog;
        synchronized (this) {
            this.o |= 4;
        }
        notifyPropertyChanged(com.sandboxol.game.a.g);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b A[PHI: r2
      0x004b: PHI (r2v4 long) = (r2v0 long), (r2v8 long) binds: [B:9:0x0020, B:23:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0095  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.game.a.B.executeBindings():void");
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
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.game.a.g != i) {
            return false;
        }
        a((BedWarScreenshotShareDialog) obj);
        return true;
    }

    private B(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ConstraintLayout) objArr[7], (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[5], (ConstraintLayout) objArr[8], (AppCompatEditText) objArr[2], (AppCompatImageView) objArr[3], (ImageView) objArr[10], (View) objArr[9]);
        this.o = -1L;
        this.f17633b.setTag(null);
        this.f17634c.setTag(null);
        this.f17636e.setTag(null);
        this.f17637f.setTag(null);
        this.l = (ConstraintLayout) objArr[0];
        this.l.setTag(null);
        this.m = (AppCompatImageView) objArr[4];
        this.m.setTag(null);
        this.n = (AppCompatImageView) objArr[6];
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.o |= 1;
        }
        return true;
    }
}
