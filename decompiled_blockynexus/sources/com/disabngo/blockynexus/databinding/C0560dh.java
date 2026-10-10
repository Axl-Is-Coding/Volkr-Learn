package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.VideoStarConfigDescribe;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.dh, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemCashAnsweringBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0560dh extends AbstractC0548ch {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8271c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8272d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8273e;

    public C0560dh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f8271c, f8272d));
    }

    public void a(com.disabngo.blockynexus.e.b.i.e eVar) {
        updateRegistration(0, eVar);
        this.f8237b = eVar;
        synchronized (this) {
            this.f8273e |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f8273e;
            this.f8273e = 0L;
        }
        com.disabngo.blockynexus.e.b.i.e eVar = this.f8237b;
        long j2 = j & 7;
        String des = null;
        if (j2 != 0) {
            VideoStarConfigDescribe item = eVar != null ? eVar.getItem() : null;
            if (item != null) {
                des = item.getDes();
            }
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f8236a, des);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8273e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8273e = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.i.e) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.i.e) obj);
        return true;
    }

    private C0560dh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (TextView) objArr[0]);
        this.f8273e = -1L;
        this.f8236a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.i.e eVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.f8273e |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.f8273e |= 2;
        }
        return true;
    }
}
