package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentInboxDetailBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ae extends AbstractC0797ze {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7271c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7272d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final NestedScrollView f7273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f7274f;
    private final LinearLayout g;
    private final DataRecyclerView h;
    private final Button i;
    private final Button j;
    private final LinearLayout k;
    private final Button l;
    private final Button m;
    private long n;

    static {
        f7272d.put(R.id.tvContent, 9);
    }

    public Ae(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, f7271c, f7272d));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0797ze
    public void a(com.disabngo.blockynexus.view.fragment.inboxdetail.k kVar) {
        updateRegistration(1, kVar);
        this.f9042b = kVar;
        synchronized (this) {
            this.n |= 2;
        }
        notifyPropertyChanged(353);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0153 A[PHI: r2
      0x0153: PHI (r2v2 long) = (r2v1 long), (r2v5 long) binds: [B:81:0x0139, B:91:0x014e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ae.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.view.fragment.inboxdetail.k) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (353 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.inboxdetail.k) obj);
        return true;
    }

    private Ae(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (TextView) objArr[9]);
        this.n = -1L;
        this.f7273e = (NestedScrollView) objArr[0];
        this.f7273e.setTag(null);
        this.f7274f = (TextView) objArr[1];
        this.f7274f.setTag(null);
        this.g = (LinearLayout) objArr[2];
        this.g.setTag(null);
        this.h = (DataRecyclerView) objArr[3];
        this.h.setTag(null);
        this.i = (Button) objArr[4];
        this.i.setTag(null);
        this.j = (Button) objArr[5];
        this.j.setTag(null);
        this.k = (LinearLayout) objArr[6];
        this.k.setTag(null);
        this.l = (Button) objArr[7];
        this.l.setTag(null);
        this.m = (Button) objArr[8];
        this.m.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.inboxdetail.k kVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }
}
