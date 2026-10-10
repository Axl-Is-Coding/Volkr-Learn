package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityEnterGameBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0596h extends AbstractC0585g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8393b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8394c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f8395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f8396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ProgressBar f8397f;
    private final AppCompatTextView g;
    private long h;

    public C0596h(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8393b, f8394c));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 16;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0585g
    public void a(com.disabngo.blockynexus.view.activity.join.s sVar) {
        updateRegistration(3, sVar);
        this.f8353a = sVar;
        synchronized (this) {
            this.h |= 8;
        }
        notifyPropertyChanged(485);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004a A[PHI: r2
      0x004a: PHI (r2v3 long) = (r2v0 long), (r2v8 long) binds: [B:9:0x0020, B:23:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ba  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0596h.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return b((ObservableField) obj, i2);
        }
        if (i == 1) {
            return d((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 3) {
            return a((com.disabngo.blockynexus.view.activity.join.s) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return c((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (485 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.join.s) obj);
        return true;
    }

    private C0596h(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5);
        this.h = -1L;
        this.f8395d = (ConstraintLayout) objArr[0];
        this.f8395d.setTag(null);
        this.f8396e = (ConstraintLayout) objArr[1];
        this.f8396e.setTag(null);
        this.f8397f = (ProgressBar) objArr[2];
        this.f8397f.setTag(null);
        this.g = (AppCompatTextView) objArr[3];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 4;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.activity.join.s sVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 8;
        }
        return true;
    }
}
