package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.widget.SignInItemView;
import com.sandboxol.center.entity.WeekTaskResponse;

/* JADX INFO: compiled from: ContentSignInPageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ca extends Ba {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7335b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7336c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SignInItemView f7338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SignInItemView f7339f;
    private final SignInItemView g;
    private final SignInItemView h;
    private final SignInItemView i;
    private final SignInItemView j;
    private final SignInItemView k;
    private final TextView l;
    private long m;

    public Ca(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f7335b, f7336c));
    }

    public void a(com.disabngo.blockynexus.view.dialog.i.c cVar) {
        updateRegistration(1, cVar);
        this.f7299a = cVar;
        synchronized (this) {
            this.m |= 2;
        }
        notifyPropertyChanged(261);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ca.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.view.dialog.i.c) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((WeekTaskResponse) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (261 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.i.c) obj);
        return true;
    }

    private Ca(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3);
        this.m = -1L;
        this.f7337d = (LinearLayout) objArr[0];
        this.f7337d.setTag(null);
        this.f7338e = (SignInItemView) objArr[1];
        this.f7338e.setTag(null);
        this.f7339f = (SignInItemView) objArr[2];
        this.f7339f.setTag(null);
        this.g = (SignInItemView) objArr[3];
        this.g.setTag(null);
        this.h = (SignInItemView) objArr[4];
        this.h.setTag(null);
        this.i = (SignInItemView) objArr[5];
        this.i.setTag(null);
        this.j = (SignInItemView) objArr[6];
        this.j.setTag(null);
        this.k = (SignInItemView) objArr[7];
        this.k.setTag(null);
        this.l = (TextView) objArr[8];
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.i.c cVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    private boolean a(WeekTaskResponse weekTaskResponse, int i) {
        if (i == 0) {
            synchronized (this) {
                this.m |= 4;
            }
            return true;
        }
        if (i == 165) {
            synchronized (this) {
                this.m |= 8;
            }
            return true;
        }
        if (i != 179) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }
}
