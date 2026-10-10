package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.StarCodeUserIncomeInfo;
import com.sandboxol.center.utils.TimeUtil;

/* JADX INFO: compiled from: ItemIncomeTitleBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Vh extends Uh {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7976b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7977c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextView f7978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7979e;

    public Vh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f7976b, f7977c));
    }

    public void a(com.disabngo.blockynexus.e.b.M.d dVar) {
        updateRegistration(0, dVar);
        this.f7944a = dVar;
        synchronized (this) {
            this.f7979e |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7979e;
            this.f7979e = 0L;
        }
        com.disabngo.blockynexus.e.b.M.d dVar = this.f7944a;
        long j2 = j & 7;
        String dateToString = null;
        if (j2 != 0) {
            String str = TimeUtil.DEFAULT_DAY_FORMAT;
            updateRegistration(0, dVar);
            StarCodeUserIncomeInfo item = dVar != null ? dVar.getItem() : null;
            dateToString = TimeUtil.getDateToString(str, item != null ? item.getCreateTime() : 0L);
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f7978d, dateToString);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7979e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7979e = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.M.d) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.M.d) obj);
        return true;
    }

    private Vh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f7979e = -1L;
        this.f7978d = (TextView) objArr[0];
        this.f7978d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.M.d dVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.f7979e |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.f7979e |= 2;
        }
        return true;
    }
}
