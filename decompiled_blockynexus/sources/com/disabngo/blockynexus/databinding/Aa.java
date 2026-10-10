package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: ContentRankWeekTypePageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Aa extends AbstractC0793za {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7255c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7256d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f7257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DataRecyclerView f7258f;
    private long g;

    public Aa(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f7255c, f7256d));
    }

    public void a(com.disabngo.blockynexus.view.activity.overviewrank.j jVar) {
        this.f9030b = jVar;
        synchronized (this) {
            this.g |= 2;
        }
        notifyPropertyChanged(386);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        boolean z;
        com.disabngo.blockynexus.view.activity.overviewrank.g gVar;
        com.disabngo.blockynexus.view.activity.overviewrank.i iVar;
        com.disabngo.blockynexus.view.activity.overviewrank.g gVar2;
        com.disabngo.blockynexus.view.activity.overviewrank.i iVar2;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        com.disabngo.blockynexus.view.activity.overviewrank.j jVar = this.f9030b;
        long j2 = j & 7;
        int i = 0;
        if (j2 != 0) {
            if ((j & 6) == 0 || jVar == null) {
                gVar2 = null;
                iVar2 = null;
            } else {
                iVar2 = jVar.f11053d;
                gVar2 = jVar.f11054e;
            }
            ObservableField<String> observableField = jVar != null ? jVar.f11052c : null;
            updateRegistration(0, observableField);
            str = observableField != null ? observableField.get() : null;
            z = str == null;
            if (j2 != 0) {
                j = z ? j | 64 : j | 32;
            }
            gVar = gVar2;
            iVar = iVar2;
        } else {
            str = null;
            z = false;
            gVar = null;
            iVar = null;
        }
        boolean zEquals = ((j & 32) == 0 || str == null) ? false : str.equals("");
        long j3 = j & 7;
        if (j3 != 0) {
            boolean z2 = z ? true : zEquals;
            if (j3 != 0) {
                j |= z2 ? 16L : 8L;
            }
            if (z2) {
                i = 4;
            }
        }
        if ((6 & j) != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f7258f, gVar, iVar, me.tatarka.bindingcollectionadapter2.k.a(2), false, null, false, 0, false);
        }
        if ((j & 7) != 0) {
            androidx.databinding.a.e.a(this.f9029a, str);
            this.f9029a.setVisibility(i);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (386 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.overviewrank.j) obj);
        return true;
    }

    private Aa(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (TextView) objArr[1]);
        this.g = -1L;
        this.f7257e = (ConstraintLayout) objArr[0];
        this.f7257e.setTag(null);
        this.f7258f = (DataRecyclerView) objArr[2];
        this.f7258f.setTag(null);
        this.f9029a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 1;
        }
        return true;
    }
}
