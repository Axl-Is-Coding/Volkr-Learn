package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentTribalLevelDescriptionBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Bf extends Af {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7312b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7313c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ScrollView f7314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7315e;

    public Bf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f7312b, f7313c));
    }

    @Override // com.disabngo.blockynexus.databinding.Af
    public void a(com.disabngo.blockynexus.view.fragment.tribehas.G g) {
        this.f7275a = g;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f7315e;
            this.f7315e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7315e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7315e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.fragment.tribehas.G) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (466 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.tribehas.G) obj);
        return true;
    }

    private Bf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f7315e = -1L;
        this.f7314d = (ScrollView) objArr[0];
        this.f7314d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.tribehas.G g, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7315e |= 1;
        }
        return true;
    }
}
