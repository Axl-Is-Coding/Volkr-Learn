package com.sandboxol.googlepay.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.router.moduleInfo.pay.PayRecordInfo;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: ItemRechargeHistoryBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class p extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f18220b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f18221c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f18222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f18223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f18224f;
    private final TextView g;
    private final TextView h;
    private long i;

    public p(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f18220b, f18221c));
    }

    public void a(com.sandboxol.googlepay.c.a.c.c cVar) {
        updateRegistration(0, cVar);
        this.f18219a = cVar;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(com.sandboxol.googlepay.a.f18173b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String created;
        String str;
        String str2;
        String str3;
        boolean z;
        ReplyCommand replyCommand;
        int status;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        com.sandboxol.googlepay.c.a.c.c cVar = this.f18219a;
        long j2 = 7 & j;
        ReplyCommand replyCommand2 = null;
        if (j2 != 0) {
            if ((j & 5) == 0 || cVar == null) {
                replyCommand = null;
                str = null;
                str2 = null;
                str3 = null;
            } else {
                replyCommand = cVar.f18351d;
                str = cVar.f18350c;
                str2 = cVar.f18349b;
                str3 = cVar.f18348a;
            }
            PayRecordInfo item = cVar != null ? cVar.getItem() : null;
            if (item != null) {
                status = item.getStatus();
                created = item.getCreated();
            } else {
                created = null;
                status = 0;
            }
            z = status == 1;
            replyCommand2 = replyCommand;
        } else {
            created = null;
            str = null;
            str2 = null;
            str3 = null;
            z = false;
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f18222d, replyCommand2, false, 0);
            androidx.databinding.a.e.a(this.f18223e, str3);
            androidx.databinding.a.e.a(this.f18224f, str);
            androidx.databinding.a.e.a(this.h, str2);
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.g, created);
            this.h.setEnabled(z);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.googlepay.c.a.c.c) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.googlepay.a.f18173b != i) {
            return false;
        }
        a((com.sandboxol.googlepay.c.a.c.c) obj);
        return true;
    }

    private p(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.i = -1L;
        this.f18222d = (LinearLayout) objArr[0];
        this.f18222d.setTag(null);
        this.f18223e = (TextView) objArr[1];
        this.f18223e.setTag(null);
        this.f18224f = (TextView) objArr[2];
        this.f18224f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.googlepay.c.a.c.c cVar, int i) {
        if (i == com.sandboxol.googlepay.a.f18172a) {
            synchronized (this) {
                this.i |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.googlepay.a.i) {
            return false;
        }
        synchronized (this) {
            this.i |= 2;
        }
        return true;
    }
}
