package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: ItemActivitySignUpPlusBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ig extends Hg {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7549b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7550c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RelativeLayout f7551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f7552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f7553f;
    private final DataRecyclerView g;
    private final View h;
    private final ImageView i;
    private final ImageView j;
    private long k;

    public Ig(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f7549b, f7550c));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Hg
    public void a(com.disabngo.blockynexus.view.dialog.a.e eVar) {
        updateRegistration(1, eVar);
        this.f7527a = eVar;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b2  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ig.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.view.dialog.a.e) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return a((ObservableField<Integer>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.a.e) obj);
        return true;
    }

    private Ig(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4);
        this.k = -1L;
        this.f7551d = (RelativeLayout) objArr[0];
        this.f7551d.setTag(null);
        this.f7552e = (ImageView) objArr[1];
        this.f7552e.setTag(null);
        this.f7553f = (TextView) objArr[2];
        this.f7553f.setTag(null);
        this.g = (DataRecyclerView) objArr[3];
        this.g.setTag(null);
        this.h = (View) objArr[4];
        this.h.setTag(null);
        this.i = (ImageView) objArr[5];
        this.i.setTag(null);
        this.j = (ImageView) objArr[6];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.a.e eVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.k |= 2;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.k |= 16;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 8;
        }
        return true;
    }
}
