package com.sandboxol.halloween.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.halloween.widget.CenterStrokeTextView;

/* JADX INFO: compiled from: HalloweenItemRewardBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class p extends o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f18628d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f18629e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConstraintLayout f18630f;
    private long g;

    public p(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f18628d, f18629e));
    }

    public void a(com.sandboxol.halloween.view.dialog.a.c cVar) {
        updateRegistration(0, cVar);
        this.f18627c = cVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(com.sandboxol.halloween.a.f18578b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.g     // Catch: java.lang.Throwable -> L43
            r4 = 0
            r1.g = r4     // Catch: java.lang.Throwable -> L43
            monitor-exit(r18)     // Catch: java.lang.Throwable -> L43
            com.sandboxol.halloween.view.dialog.a.c r0 = r1.f18627c
            r6 = 7
            long r2 = r2 & r6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 == 0) goto L28
            if (r0 == 0) goto L1b
            com.sandboxol.halloween.entity.RewardDetailInfo r0 = r0.getItem()
            goto L1c
        L1b:
            r0 = r6
        L1c:
            if (r0 == 0) goto L28
            java.lang.String r6 = r0.getRewardName()
            java.lang.String r0 = r0.getRewardIcon()
            r9 = r0
            goto L29
        L28:
            r9 = r6
        L29:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L42
            android.widget.ImageView r7 = r1.f18625a
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            com.sandboxol.common.binding.adapter.ImageViewBindingAdapters.loadImage(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            com.sandboxol.halloween.widget.CenterStrokeTextView r0 = r1.f18626b
            androidx.databinding.a.e.a(r0, r6)
        L42:
            return
        L43:
            r0 = move-exception
            monitor-exit(r18)     // Catch: java.lang.Throwable -> L43
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.halloween.b.p.executeBindings():void");
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
        return a((com.sandboxol.halloween.view.dialog.a.c) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.halloween.a.f18578b != i) {
            return false;
        }
        a((com.sandboxol.halloween.view.dialog.a.c) obj);
        return true;
    }

    private p(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ImageView) objArr[1], (CenterStrokeTextView) objArr[2]);
        this.g = -1L;
        this.f18625a.setTag(null);
        this.f18630f = (ConstraintLayout) objArr[0];
        this.f18630f.setTag(null);
        this.f18626b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.halloween.view.dialog.a.c cVar, int i) {
        if (i == com.sandboxol.halloween.a.f18577a) {
            synchronized (this) {
                this.g |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.halloween.a.f18579c) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }
}
