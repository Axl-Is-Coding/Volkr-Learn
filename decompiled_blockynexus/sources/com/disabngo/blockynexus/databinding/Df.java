package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: FragmentTribalMissionStatementBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Df extends Cf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7386b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7387c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ScrollView f7388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7389e;

    public Df(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f7386b, f7387c));
    }

    @Override // com.disabngo.blockynexus.databinding.Cf
    public void a(com.disabngo.blockynexus.e.b.ua.h hVar) {
        this.f7349a = hVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f7389e;
            this.f7389e = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7389e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7389e = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.ua.h) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (292 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ua.h) obj);
        return true;
    }

    private Df(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f7389e = -1L;
        this.f7388d = (ScrollView) objArr[0];
        this.f7388d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ua.h hVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7389e |= 1;
        }
        return true;
    }
}
