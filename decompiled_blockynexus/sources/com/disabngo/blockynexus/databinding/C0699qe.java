package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.qe, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentGroupNoticeBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0699qe extends AbstractC0688pe {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8726d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8727e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f8728f;
    private final TextView g;
    private final TextView h;
    private final DataRecyclerView i;
    private long j;

    public C0699qe(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f8726d, f8727e));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 32;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 16;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 4;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 8;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0688pe
    public void a(com.disabngo.blockynexus.e.b.G.f fVar) {
        updateRegistration(0, fVar);
        this.f8688c = fVar;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(373);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0699qe.executeBindings():void");
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
            this.j = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.G.f) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i == 2) {
            return d((ObservableField) obj, i2);
        }
        if (i == 3) {
            return e((ObservableField) obj, i2);
        }
        if (i == 4) {
            return c((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (373 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.G.f) obj);
        return true;
    }

    private C0699qe(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (ImageView) objArr[1], (TextView) objArr[2]);
        this.j = -1L;
        this.f8686a.setTag(null);
        this.f8728f = (LinearLayout) objArr[0];
        this.f8728f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (DataRecyclerView) objArr[5];
        this.i.setTag(null);
        this.f8687b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.G.f fVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }
}
