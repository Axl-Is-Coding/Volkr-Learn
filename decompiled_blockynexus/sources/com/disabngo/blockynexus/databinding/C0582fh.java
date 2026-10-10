package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.k.C0862b;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.fh, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemCashInstructionsBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0582fh extends AbstractC0571eh {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8342d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8343e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConstraintLayout f8344f;
    private long g;

    public C0582fh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f8342d, f8343e));
    }

    public void a(C0862b c0862b) {
        updateRegistration(0, c0862b);
        this.f8308c = c0862b;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r7 = this;
            monitor-enter(r7)
            long r0 = r7.g     // Catch: java.lang.Throwable -> L35
            r2 = 0
            r7.g = r2     // Catch: java.lang.Throwable -> L35
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L35
            com.disabngo.blockynexus.e.b.k.b r4 = r7.f8308c
            r5 = 7
            long r0 = r0 & r5
            r5 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L25
            if (r4 == 0) goto L19
            com.sandboxol.center.entity.VideoStarConfigDescribe r4 = r4.getItem()
            goto L1a
        L19:
            r4 = r5
        L1a:
            if (r4 == 0) goto L25
            java.lang.String r5 = r4.getDes()
            java.lang.String r4 = r4.getTitle()
            goto L26
        L25:
            r4 = r5
        L26:
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L34
            android.widget.TextView r0 = r7.f8306a
            androidx.databinding.a.e.a(r0, r5)
            android.widget.TextView r0 = r7.f8307b
            androidx.databinding.a.e.a(r0, r4)
        L34:
            return
        L35:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L35
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0582fh.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((C0862b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((C0862b) obj);
        return true;
    }

    private C0582fh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (TextView) objArr[2], (TextView) objArr[1]);
        this.g = -1L;
        this.f8344f = (ConstraintLayout) objArr[0];
        this.f8344f.setTag(null);
        this.f8306a.setTag(null);
        this.f8307b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(C0862b c0862b, int i) {
        if (i == 0) {
            synchronized (this) {
                this.g |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }
}
