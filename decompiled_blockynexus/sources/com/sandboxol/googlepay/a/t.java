package com.sandboxol.googlepay.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.googlepay.R;
import com.sandboxol.googlepay.view.widget.StarCodeHelpPopupWindow;

/* JADX INFO: compiled from: PopwindowStarCodeHelpBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class t extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f18233c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f18234d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f18235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f18236f;

    public t(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f18233c, f18234d));
    }

    @Override // com.sandboxol.googlepay.a.s
    public void a(StarCodeHelpPopupWindow starCodeHelpPopupWindow) {
        this.f18232b = starCodeHelpPopupWindow;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f18236f;
            this.f18236f = 0L;
        }
        long j2 = j & 10;
        String string = null;
        if (j2 != 0) {
            ObservableField<Double> observableField = AccountCenter.newInstance().rate;
            updateRegistration(1, observableField);
            string = this.f18231a.getResources().getString(R.string.googleplay_recharge_tv_star_code_help, String.valueOf(ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null) * 100.0d) + "%");
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f18231a, string);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f18236f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f18236f = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<Double>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.googlepay.a.f18174c != i) {
            return false;
        }
        a((StarCodeHelpPopupWindow) obj);
        return true;
    }

    private t(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (TextView) objArr[1]);
        this.f18236f = -1L;
        this.f18235e = (LinearLayout) objArr[0];
        this.f18235e.setTag(null);
        this.f18231a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.f18236f |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Double> observableField, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.f18236f |= 2;
        }
        return true;
    }
}
