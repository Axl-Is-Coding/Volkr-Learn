package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.game.R;
import com.sandboxol.recharge.dialog.rechargeshop.StarCodeHelpPopupWindow;

/* JADX INFO: compiled from: GamePopwindowStarCodeHelpBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class D extends C {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f17640c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f17641d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f17642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f17643f;

    public D(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f17640c, f17641d));
    }

    @Override // com.sandboxol.game.a.C
    public void a(StarCodeHelpPopupWindow starCodeHelpPopupWindow) {
        this.f17639b = starCodeHelpPopupWindow;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f17643f;
            this.f17643f = 0L;
        }
        long j2 = j & 10;
        String string = null;
        if (j2 != 0) {
            ObservableField<Double> observableField = AccountCenter.newInstance().rate;
            updateRegistration(1, observableField);
            string = this.f17638a.getResources().getString(R.string.dialog_recharge_tv_star_code_help, String.valueOf(ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null) * 100.0d) + "%");
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f17638a, string);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f17643f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f17643f = 8L;
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
        if (com.sandboxol.game.a.f17628c != i) {
            return false;
        }
        a((StarCodeHelpPopupWindow) obj);
        return true;
    }

    private D(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (TextView) objArr[1]);
        this.f17643f = -1L;
        this.f17642e = (LinearLayout) objArr[0];
        this.f17642e.setTag(null);
        this.f17638a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.f17643f |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Double> observableField, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.f17643f |= 2;
        }
        return true;
    }
}
