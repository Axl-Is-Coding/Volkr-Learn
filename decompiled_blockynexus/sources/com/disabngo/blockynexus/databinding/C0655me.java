package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.me, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentGroupMemberBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0655me extends AbstractC0644le {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8583b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8584c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FrameLayout f8585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f8586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DataRecyclerView f8587f;
    private final RelativeLayout g;
    private final TextView h;
    private final TextView i;
    private final Button j;
    private final Button k;
    private long l;

    public C0655me(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f8583b, f8584c));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 64;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 32;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 8;
        }
        return true;
    }

    private boolean f(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 128;
        }
        return true;
    }

    private boolean g(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0644le
    public void a(com.disabngo.blockynexus.e.b.F.u uVar) {
        updateRegistration(1, uVar);
        this.f8554a = uVar;
        synchronized (this) {
            this.l |= 2;
        }
        notifyPropertyChanged(371);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0128  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 761
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0655me.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return b((ObservableField) obj, i2);
            case 1:
                return a((com.disabngo.blockynexus.e.b.F.u) obj, i2);
            case 2:
                return g((ObservableField) obj, i2);
            case 3:
                return e((ObservableField) obj, i2);
            case 4:
                return a((ObservableField<Boolean>) obj, i2);
            case 5:
                return d((ObservableField) obj, i2);
            case 6:
                return c((ObservableField) obj, i2);
            case 7:
                return f((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (371 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.F.u) obj);
        return true;
    }

    private C0655me(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 8);
        this.l = -1L;
        this.f8585d = (FrameLayout) objArr[0];
        this.f8585d.setTag(null);
        this.f8586e = (TextView) objArr[1];
        this.f8586e.setTag(null);
        this.f8587f = (DataRecyclerView) objArr[2];
        this.f8587f.setTag(null);
        this.g = (RelativeLayout) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.j = (Button) objArr[6];
        this.j.setTag(null);
        this.k = (Button) objArr[7];
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.F.u uVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 16;
        }
        return true;
    }
}
