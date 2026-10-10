package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.bh, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemAppVideoRecommendTagBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0536bh extends AbstractC0524ah {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8200b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8201c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AppCompatTextView f8202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8203e;

    public C0536bh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f8200b, f8201c));
    }

    public void a(com.disabngo.blockynexus.e.b.xa.o oVar) {
        updateRegistration(0, oVar);
        this.f8175a = oVar;
        synchronized (this) {
            this.f8203e |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f8203e;
            this.f8203e = 0L;
        }
        String item = null;
        com.disabngo.blockynexus.e.b.xa.o oVar = this.f8175a;
        long j2 = j & 7;
        if (j2 != 0 && oVar != null) {
            item = oVar.getItem();
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f8202d, item);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8203e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8203e = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.xa.o) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (1 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.xa.o) obj);
        return true;
    }

    private C0536bh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f8203e = -1L;
        this.f8202d = (AppCompatTextView) objArr[0];
        this.f8202d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.xa.o oVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.f8203e |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.f8203e |= 2;
        }
        return true;
    }
}
