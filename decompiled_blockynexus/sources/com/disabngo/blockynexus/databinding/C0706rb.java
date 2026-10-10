package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.DialogC1116sa;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.rb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogDiskGameCleanBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0706rb extends AbstractC0696qb {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f8753e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f8754f = new SparseIntArray();
    private final ConstraintLayout g;
    private long h;

    static {
        f8754f.put(R.id.v_bg, 2);
        f8754f.put(R.id.tv_tip, 3);
    }

    public C0706rb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8753e, f8754f));
    }

    private boolean b(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0696qb
    public void a(DialogC1116sa dialogC1116sa) {
        this.f8719d = dialogC1116sa;
        synchronized (this) {
            this.h |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        ObservableField<Long> observableField;
        ObservableField<Long> observableField2;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        DialogC1116sa dialogC1116sa = this.f8719d;
        long j2 = 15 & j;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            if (dialogC1116sa != null) {
                observableField2 = dialogC1116sa.f11682b;
                observableField = dialogC1116sa.f11681a;
            } else {
                observableField = null;
                observableField2 = null;
            }
            updateRegistration(0, observableField2);
            updateRegistration(1, observableField);
            Long l = observableField2 != null ? observableField2.get() : null;
            Long l2 = observableField != null ? observableField.get() : null;
            long jSafeUnbox = ViewDataBinding.safeUnbox(l);
            iSafeUnbox = (int) ((ViewDataBinding.safeUnbox(l2) / 1024) / 1024);
            i = iSafeUnbox - ((int) ((jSafeUnbox / 1024) / 1024));
        } else {
            i = 0;
        }
        if ((j & 14) != 0) {
            this.f8716a.setMax(iSafeUnbox);
        }
        if (j2 != 0) {
            this.f8716a.setProgress(i);
        }
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
            this.h = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((DialogC1116sa) obj);
        return true;
    }

    private C0706rb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ProgressBar) objArr[1], (TextView) objArr[3], (View) objArr[2]);
        this.h = -1L;
        this.g = (ConstraintLayout) objArr[0];
        this.g.setTag(null);
        this.f8716a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 1;
        }
        return true;
    }
}
