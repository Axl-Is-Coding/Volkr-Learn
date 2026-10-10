package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityDiscoverBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0574f extends AbstractC0563e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8317c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8318d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FrameLayout f8319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageButton f8320f;
    private final LinearLayout g;
    private final ImageView h;
    private final LinearLayout i;
    private final ImageView j;
    private final PageRecyclerView k;
    private final View l;
    private long m;

    public C0574f(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f8317c, f8318d));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0563e
    public void a(com.disabngo.blockynexus.view.activity.discover.n nVar) {
        updateRegistration(0, nVar);
        this.f8284b = nVar;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(513);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x011c A[PHI: r2
      0x011c: PHI (r2v2 long) = (r2v1 long), (r2v5 long) binds: [B:63:0x0101, B:73:0x0116] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0574f.executeBindings():void");
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
            this.m = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.activity.discover.n) obj, i2);
        }
        if (i == 1) {
            return c((ObservableField) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (513 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.discover.n) obj);
        return true;
    }

    private C0574f(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (TextView) objArr[3]);
        this.m = -1L;
        this.f8319e = (FrameLayout) objArr[0];
        this.f8319e.setTag(null);
        this.f8320f = (ImageButton) objArr[1];
        this.f8320f.setTag(null);
        this.g = (LinearLayout) objArr[2];
        this.g.setTag(null);
        this.h = (ImageView) objArr[4];
        this.h.setTag(null);
        this.i = (LinearLayout) objArr[5];
        this.i.setTag(null);
        this.j = (ImageView) objArr[6];
        this.j.setTag(null);
        this.k = (PageRecyclerView) objArr[7];
        this.k.setTag(null);
        this.l = (View) objArr[8];
        this.l.setTag(null);
        this.f8283a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.discover.n nVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }
}
