package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: MainContentBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Lj extends Kj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7659c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7660d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f7661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7662f;

    static {
        f7660d.put(R.id.flHomePage, 1);
    }

    public Lj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f7659c, f7660d));
    }

    public void a(com.disabngo.blockynexus.view.activity.main.nc ncVar) {
        this.f7629b = ncVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f7662f;
            this.f7662f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7662f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7662f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.activity.main.nc) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (301 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.main.nc) obj);
        return true;
    }

    private Lj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (FrameLayout) objArr[1]);
        this.f7662f = -1L;
        this.f7661e = (RelativeLayout) objArr[0];
        this.f7661e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.main.nc ncVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7662f |= 1;
        }
        return true;
    }
}
