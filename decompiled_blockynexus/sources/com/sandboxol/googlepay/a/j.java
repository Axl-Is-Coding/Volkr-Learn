package com.sandboxol.googlepay.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.googlepay.R;
import com.sandboxol.googlepay.view.fragment.recharge.RechargeItem2ViewModel;

/* JADX INFO: compiled from: GooglepayItemRechargeList2ViewBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f18204d = new ViewDataBinding.b(3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f18205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f18206f;
    private long g;

    static {
        int i = R.layout.googlepay_item_recharge_view;
        f18204d.a(0, new String[]{"googlepay_item_recharge_view", "googlepay_item_recharge_view"}, new int[]{1, 2}, new int[]{i, i});
        f18205e = null;
    }

    public j(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f18204d, f18205e));
    }

    private boolean b(k kVar, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }

    public void a(RechargeItem2ViewModel rechargeItem2ViewModel) {
        updateRegistration(0, rechargeItem2ViewModel);
        this.f18203c = rechargeItem2ViewModel;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(com.sandboxol.googlepay.a.f18173b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        RechargeItem2ViewModel rechargeItem2ViewModel = this.f18203c;
        if ((9 & j) != 0) {
            this.f18201a.a(rechargeItem2ViewModel);
            this.f18202b.a(rechargeItem2ViewModel);
        }
        if ((j & 8) != 0) {
            this.f18201a.a((Boolean) false);
            this.f18202b.a((Boolean) true);
        }
        ViewDataBinding.executeBindingsOn(this.f18201a);
        ViewDataBinding.executeBindingsOn(this.f18202b);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.g != 0) {
                return true;
            }
            return this.f18201a.hasPendingBindings() || this.f18202b.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 8L;
        }
        this.f18201a.invalidateAll();
        this.f18202b.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((RechargeItem2ViewModel) obj, i2);
        }
        if (i == 1) {
            return b((k) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((k) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        super.setLifecycleOwner(gVar);
        this.f18201a.setLifecycleOwner(gVar);
        this.f18202b.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.googlepay.a.f18173b != i) {
            return false;
        }
        a((RechargeItem2ViewModel) obj);
        return true;
    }

    private j(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (k) objArr[1], (k) objArr[2]);
        this.g = -1L;
        this.f18206f = (LinearLayout) objArr[0];
        this.f18206f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(RechargeItem2ViewModel rechargeItem2ViewModel, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.g |= 1;
        }
        return true;
    }

    private boolean a(k kVar, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.g |= 4;
        }
        return true;
    }
}
