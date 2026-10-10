package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.ReceiveAttachmentSuccessDialog;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ic, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogReceiveAttachmentSuccessBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0610ic extends AbstractC0599hc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8444d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8445e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f8446f;
    private final DataRecyclerView g;
    private long h;

    static {
        f8445e.put(R.id.tvTitle, 2);
        f8445e.put(R.id.btnSure, 3);
    }

    public C0610ic(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8444d, f8445e));
    }

    public void a(ReceiveAttachmentSuccessDialog.a aVar) {
        updateRegistration(0, aVar);
        this.f8402c = aVar;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(282);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.disabngo.blockynexus.e.b.X.a aVar;
        com.disabngo.blockynexus.view.fragment.inboxdetail.e eVar;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        ReceiveAttachmentSuccessDialog.a aVar2 = this.f8402c;
        long j2 = j & 3;
        if (j2 == 0 || aVar2 == null) {
            aVar = null;
            eVar = null;
        } else {
            com.disabngo.blockynexus.e.b.X.a aVar3 = aVar2.f11360a;
            eVar = aVar2.f11361b;
            aVar = aVar3;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.g, aVar, eVar, me.tatarka.bindingcollectionadapter2.k.a(3), false, null, false, 0, false);
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
            this.h = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((ReceiveAttachmentSuccessDialog.a) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (282 != i) {
            return false;
        }
        a((ReceiveAttachmentSuccessDialog.a) obj);
        return true;
    }

    private C0610ic(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (Button) objArr[3], (TextView) objArr[2]);
        this.h = -1L;
        this.f8446f = (LinearLayout) objArr[0];
        this.f8446f.setTag(null);
        this.g = (DataRecyclerView) objArr[1];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ReceiveAttachmentSuccessDialog.a aVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 1;
        }
        return true;
    }
}
