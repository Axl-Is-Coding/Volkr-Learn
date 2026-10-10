package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemScrapRulePicBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Wi extends Vi {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8011b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8012c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f8013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f8014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8015f;

    public Wi(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f8011b, f8012c));
    }

    public void a(com.disabngo.blockynexus.view.dialog.h.c cVar) {
        updateRegistration(0, cVar);
        this.f7980a = cVar;
        synchronized (this) {
            this.f8015f |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r25 = this;
            r1 = r25
            monitor-enter(r25)
            long r2 = r1.f8015f     // Catch: java.lang.Throwable -> La6
            r4 = 0
            r1.f8015f = r4     // Catch: java.lang.Throwable -> La6
            monitor-exit(r25)     // Catch: java.lang.Throwable -> La6
            com.disabngo.blockynexus.view.dialog.h.c r0 = r1.f7980a
            r6 = 7
            long r8 = r2 & r6
            r10 = 64
            r12 = 1
            r13 = 0
            r14 = 0
            int r15 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r15 == 0) goto L32
            if (r0 == 0) goto L20
            java.lang.String r0 = r0.getItem()
            goto L21
        L20:
            r0 = r13
        L21:
            if (r0 == 0) goto L25
            r15 = 1
            goto L26
        L25:
            r15 = 0
        L26:
            int r16 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r16 == 0) goto L34
            if (r15 == 0) goto L2e
            long r2 = r2 | r10
            goto L34
        L2e:
            r8 = 32
            long r2 = r2 | r8
            goto L34
        L32:
            r0 = r13
            r15 = 0
        L34:
            long r8 = r2 & r10
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 == 0) goto L4d
            if (r0 == 0) goto L43
            java.lang.String r8 = ","
            java.lang.String[] r8 = r0.split(r8)
            goto L44
        L43:
            r8 = r13
        L44:
            if (r8 == 0) goto L48
            int r9 = r8.length
            goto L49
        L48:
            r9 = 0
        L49:
            if (r9 <= r12) goto L4e
            r9 = 1
            goto L4f
        L4d:
            r8 = r13
        L4e:
            r9 = 0
        L4f:
            long r10 = r2 & r6
            r16 = 16
            int r18 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r18 == 0) goto L66
            if (r15 == 0) goto L5a
            r14 = r9
        L5a:
            int r9 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r9 == 0) goto L66
            if (r14 == 0) goto L63
            long r2 = r2 | r16
            goto L66
        L63:
            r9 = 8
            long r2 = r2 | r9
        L66:
            long r9 = r2 & r16
            int r11 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r11 == 0) goto L7d
            if (r0 == 0) goto L74
            java.lang.String r8 = ","
            java.lang.String[] r8 = r0.split(r8)
        L74:
            if (r8 == 0) goto L7d
            java.lang.Object r0 = androidx.databinding.ViewDataBinding.getFromArray(r8, r12)
            java.lang.String r0 = (java.lang.String) r0
            goto L7e
        L7d:
            r0 = r13
        L7e:
            long r2 = r2 & r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L89
            if (r14 == 0) goto L86
            goto L88
        L86:
            java.lang.String r0 = ""
        L88:
            r13 = r0
        L89:
            r16 = r13
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto La5
            android.widget.ImageView r14 = r1.f8014e
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            com.sandboxol.common.binding.adapter.ImageViewBindingAdapters.loadImage(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
        La5:
            return
        La6:
            r0 = move-exception
            monitor-exit(r25)     // Catch: java.lang.Throwable -> La6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Wi.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8015f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8015f = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.dialog.h.c) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.h.c) obj);
        return true;
    }

    private Wi(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f8015f = -1L;
        this.f8013d = (ConstraintLayout) objArr[0];
        this.f8013d.setTag(null);
        this.f8014e = (ImageView) objArr[1];
        this.f8014e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.h.c cVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.f8015f |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.f8015f |= 2;
        }
        return true;
    }
}
