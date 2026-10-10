package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: ItemDressBuySuitPieceBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class H extends G {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f17005c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f17006d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f17007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f17008f;
    private final View g;
    private final TextView h;
    private long i;

    static {
        f17006d.put(R.id.view29, 4);
    }

    public H(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f17005c, f17006d));
    }

    public void a(com.sandboxol.decorate.view.dialog.a.J j) {
        updateRegistration(1, j);
        this.f17004b = j;
        synchronized (this) {
            this.i |= 2;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.o);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0059 A[PHI: r12
      0x0059: PHI (r12v1 java.lang.String) = (r12v0 java.lang.String), (r12v3 java.lang.String) binds: [B:7:0x0017, B:16:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r23 = this;
            r1 = r23
            monitor-enter(r23)
            long r2 = r1.i     // Catch: java.lang.Throwable -> L86
            r4 = 0
            r1.i = r4     // Catch: java.lang.Throwable -> L86
            monitor-exit(r23)     // Catch: java.lang.Throwable -> L86
            com.sandboxol.decorate.view.dialog.a.J r0 = r1.f17004b
            r6 = 31
            long r6 = r6 & r2
            r8 = 27
            r10 = 23
            r12 = 0
            r13 = 0
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L59
            if (r0 == 0) goto L20
            com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo r0 = r0.getItem()
            goto L21
        L20:
            r0 = r12
        L21:
            r1.updateRegistration(r13, r0)
            long r6 = r2 & r10
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L30
            if (r0 == 0) goto L30
            java.lang.String r12 = r0.getIconUrl()
        L30:
            long r6 = r2 & r8
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L59
            if (r0 == 0) goto L3d
            int r0 = r0.getHasPurchase()
            goto L3e
        L3d:
            r0 = 0
        L3e:
            r14 = 1
            if (r0 != r14) goto L42
            goto L43
        L42:
            r14 = 0
        L43:
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L4f
            if (r14 == 0) goto L4c
            r6 = 64
            goto L4e
        L4c:
            r6 = 32
        L4e:
            long r2 = r2 | r6
        L4f:
            if (r14 == 0) goto L52
            goto L56
        L52:
            r0 = 8
            r13 = 8
        L56:
            r14 = r12
            r0 = r13
            goto L5b
        L59:
            r14 = r12
            r0 = 0
        L5b:
            long r6 = r2 & r10
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L76
            android.widget.ImageView r12 = r1.f17008f
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            com.sandboxol.common.binding.adapter.ImageViewBindingAdapters.loadImage(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
        L76:
            long r2 = r2 & r8
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L85
            android.view.View r2 = r1.g
            r2.setVisibility(r0)
            android.widget.TextView r2 = r1.h
            r2.setVisibility(r0)
        L85:
            return
        L86:
            r0 = move-exception
            monitor-exit(r23)     // Catch: java.lang.Throwable -> L86
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.decorate.c.H.executeBindings():void");
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
            this.i = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((SingleDressInfo) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((com.sandboxol.decorate.view.dialog.a.J) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.o != i) {
            return false;
        }
        a((com.sandboxol.decorate.view.dialog.a.J) obj);
        return true;
    }

    private H(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (View) objArr[4]);
        this.i = -1L;
        this.f17007e = (ConstraintLayout) objArr[0];
        this.f17007e.setTag(null);
        this.f17008f = (ImageView) objArr[1];
        this.f17008f.setTag(null);
        this.g = (View) objArr[2];
        this.g.setTag(null);
        this.h = (TextView) objArr[3];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(SingleDressInfo singleDressInfo, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.i |= 1;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.j) {
            synchronized (this) {
                this.i |= 4;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.i) {
            return false;
        }
        synchronized (this) {
            this.i |= 8;
        }
        return true;
    }

    private boolean a(com.sandboxol.decorate.view.dialog.a.J j, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.i |= 2;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.I) {
            return false;
        }
        synchronized (this) {
            this.i |= 1;
        }
        return true;
    }
}
