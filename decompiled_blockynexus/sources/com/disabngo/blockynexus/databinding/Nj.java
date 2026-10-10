package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: compiled from: MainTitleBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Nj extends Mj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7725c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7726d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AppBarLayout f7727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RelativeLayout f7728f;
    private final ImageButton g;
    private final TextView h;
    private final ImageButton i;
    private final ImageButton j;
    private long k;

    static {
        f7726d.put(R.id.tbMainBar, 6);
    }

    public Nj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f7725c, f7726d));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 64;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 8;
        }
        return true;
    }

    private boolean f(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.view.activity.main.nc ncVar) {
        updateRegistration(5, ncVar);
        this.f7695b = ncVar;
        synchronized (this) {
            this.k |= 32;
        }
        notifyPropertyChanged(301);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a A[PHI: r2
      0x008a: PHI (r2v4 long) = (r2v0 long), (r2v15 long) binds: [B:29:0x005d, B:43:0x0084] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ea A[PHI: r2
      0x00ea: PHI (r2v6 long) = (r2v5 long), (r2v13 long) binds: [B:64:0x00bf, B:78:0x00e5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f3  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 414
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Nj.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return d((ObservableField) obj, i2);
            case 1:
                return f((ObservableField) obj, i2);
            case 2:
                return b((ObservableField) obj, i2);
            case 3:
                return e((ObservableField) obj, i2);
            case 4:
                return a((ObservableField<Boolean>) obj, i2);
            case 5:
                return a((com.disabngo.blockynexus.view.activity.main.nc) obj, i2);
            case 6:
                return c((ObservableField) obj, i2);
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

    private Nj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 7, (Toolbar) objArr[6]);
        this.k = -1L;
        this.f7727e = (AppBarLayout) objArr[0];
        this.f7727e.setTag(null);
        this.f7728f = (RelativeLayout) objArr[1];
        this.f7728f.setTag(null);
        this.g = (ImageButton) objArr[2];
        this.g.setTag(null);
        this.h = (TextView) objArr[3];
        this.h.setTag(null);
        this.i = (ImageButton) objArr[4];
        this.i.setTag(null);
        this.j = (ImageButton) objArr[5];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 16;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.activity.main.nc ncVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 32;
        }
        return true;
    }
}
