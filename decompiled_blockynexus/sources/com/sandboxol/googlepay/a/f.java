package com.sandboxol.googlepay.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.router.moduleInfo.pay.PayRecordInfo;

/* JADX INFO: compiled from: FragmentRechargeDetailBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f18191b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f18192c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f18193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f18194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f18195f;
    private final TextView g;
    private final TextView h;
    private final TextView i;
    private long j;

    public f(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f18191b, f18192c));
    }

    @Override // com.sandboxol.googlepay.a.e
    public void a(com.sandboxol.googlepay.c.a.b.b bVar) {
        updateRegistration(0, bVar);
        this.f18190a = bVar;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(com.sandboxol.googlepay.a.f18177f);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String created;
        PayRecordInfo payRecordInfo;
        synchronized (this) {
            j = this.j;
            this.j = 0L;
        }
        com.sandboxol.googlepay.c.a.b.b bVar = this.f18190a;
        long j2 = j & 3;
        String orderId = null;
        if (j2 != 0) {
            if (bVar != null) {
                str2 = bVar.f18344c;
                str3 = bVar.f18345d;
                payRecordInfo = bVar.f18343b;
                str = bVar.f18346e;
            } else {
                str = null;
                str2 = null;
                str3 = null;
                payRecordInfo = null;
            }
            if (payRecordInfo != null) {
                orderId = payRecordInfo.getOrderId();
                created = payRecordInfo.getCreated();
            } else {
                created = null;
            }
        } else {
            str = null;
            str2 = null;
            str3 = null;
            created = null;
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f18194e, orderId);
            androidx.databinding.a.e.a(this.f18195f, str3);
            androidx.databinding.a.e.a(this.g, str2);
            androidx.databinding.a.e.a(this.h, created);
            androidx.databinding.a.e.a(this.i, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.googlepay.c.a.b.b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.googlepay.a.f18177f != i) {
            return false;
        }
        a((com.sandboxol.googlepay.c.a.b.b) obj);
        return true;
    }

    private f(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.j = -1L;
        this.f18193d = (LinearLayout) objArr[0];
        this.f18193d.setTag(null);
        this.f18194e = (TextView) objArr[1];
        this.f18194e.setTag(null);
        this.f18195f = (TextView) objArr[2];
        this.f18195f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.googlepay.c.a.b.b bVar, int i) {
        if (i != com.sandboxol.googlepay.a.f18172a) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }
}
