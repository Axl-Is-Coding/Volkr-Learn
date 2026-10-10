package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.pj, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTribeMessageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0693pj extends AbstractC0682oj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8702b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8703c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f8705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8706f;
    private final TextView g;
    private final RelativeLayout h;
    private final TextView i;
    private final LinearLayout j;
    private final Button k;
    private final Button l;
    private long m;

    public C0693pj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f8702b, f8703c));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 8;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.e.b.pa.i iVar) {
        updateRegistration(1, iVar);
        this.f8670a = iVar;
        synchronized (this) {
            this.m |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0054 A[PHI: r2
      0x0054: PHI (r2v8 long) = (r2v0 long), (r2v13 long) binds: [B:9:0x0028, B:23:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f3  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0693pj.executeBindings():void");
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
            this.m = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return b((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.e.b.pa.i) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return c((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.pa.i) obj);
        return true;
    }

    private C0693pj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4);
        this.m = -1L;
        this.f8704d = (LinearLayout) objArr[0];
        this.f8704d.setTag(null);
        this.f8705e = (ImageView) objArr[1];
        this.f8705e.setTag(null);
        this.f8706f = (TextView) objArr[2];
        this.f8706f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (RelativeLayout) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.j = (LinearLayout) objArr[6];
        this.j.setTag(null);
        this.k = (Button) objArr[7];
        this.k.setTag(null);
        this.l = (Button) objArr[8];
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.pa.i iVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.m |= 2;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.m |= 16;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }
}
