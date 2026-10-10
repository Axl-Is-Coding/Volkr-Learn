package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blockmango.ScreenshotShareDialog;
import com.sandboxol.game.R;

/* JADX INFO: compiled from: DialogScreenshotShareBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class z extends y {
    private static final ViewDataBinding.b h = null;
    private static final SparseIntArray i = new SparseIntArray();
    private final ConstraintLayout j;
    private final AppCompatImageView k;
    private final AppCompatButton l;
    private final AppCompatImageView m;
    private long n;

    static {
        i.put(R.id.dialog, 7);
        i.put(R.id.vBg, 8);
        i.put(R.id.ivBg, 9);
    }

    public z(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, h, i));
    }

    private boolean b(ObservableField<Boolean> observableField, int i2) {
        if (i2 != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    public void a(ScreenshotShareDialog screenshotShareDialog) {
        this.g = screenshotShareDialog;
        synchronized (this) {
            this.n |= 4;
        }
        notifyPropertyChanged(com.sandboxol.game.a.g);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b A[PHI: r2
      0x004b: PHI (r2v3 long) = (r2v0 long), (r2v7 long) binds: [B:9:0x0020, B:23:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
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
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.game.a.z.executeBindings():void");
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
            this.n = 8L;
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
        if (com.sandboxol.game.a.g != i2) {
            return false;
        }
        a((ScreenshotShareDialog) obj);
        return true;
    }

    private z(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[7], (AppCompatEditText) objArr[2], (AppCompatImageView) objArr[3], (ImageView) objArr[9], (View) objArr[8]);
        this.n = -1L;
        this.f17732a.setTag(null);
        this.f17734c.setTag(null);
        this.f17735d.setTag(null);
        this.j = (ConstraintLayout) objArr[0];
        this.j.setTag(null);
        this.k = (AppCompatImageView) objArr[4];
        this.k.setTag(null);
        this.l = (AppCompatButton) objArr[5];
        this.l.setTag(null);
        this.m = (AppCompatImageView) objArr[6];
        this.m.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i2) {
        if (i2 != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }
}
