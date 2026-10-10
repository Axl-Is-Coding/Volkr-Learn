package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.view.fragment.dress.ka;

/* JADX INFO: compiled from: ItemDressSuitBlankBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class S extends Q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f17035c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f17036d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f17037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f17038f;

    static {
        f17036d.put(R.id.bgView, 1);
    }

    public S(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f17035c, f17036d));
    }

    public void a(ka kaVar) {
        this.f17034b = kaVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f17038f;
            this.f17038f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17038f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17038f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((ka) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.n != i) {
            return false;
        }
        a((ka) obj);
        return true;
    }

    private S(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (View) objArr[1]);
        this.f17038f = -1L;
        this.f17037e = (ConstraintLayout) objArr[0];
        this.f17037e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ka kaVar, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.f17038f |= 1;
        }
        return true;
    }
}
