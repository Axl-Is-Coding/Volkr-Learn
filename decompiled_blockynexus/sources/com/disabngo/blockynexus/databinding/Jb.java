package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: DialogItemFirstTopRewardBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Jb extends Ib {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f7573d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f7574e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f7575f;
    private long g;

    public Jb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f7573d, f7574e));
    }

    public void a(com.disabngo.blockynexus.view.dialog.b.b bVar) {
        updateRegistration(0, bVar);
        this.f7545c = bVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(2);
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
            long r2 = r1.g     // Catch: java.lang.Throwable -> L44
            r4 = 0
            r1.g = r4     // Catch: java.lang.Throwable -> L44
            monitor-exit(r18)     // Catch: java.lang.Throwable -> L44
            com.disabngo.blockynexus.view.dialog.b.b r0 = r1.f7545c
            r6 = 7
            long r2 = r2 & r6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 == 0) goto L28
            if (r0 == 0) goto L1b
            com.sandboxol.center.entity.FirstTopUpList r0 = r0.getItem()
            goto L1c
        L1b:
            r0 = r6
        L1c:
            if (r0 == 0) goto L28
            java.lang.String r6 = r0.getPicUrl()
            java.lang.String r0 = r0.getName()
            r9 = r6
            goto L2a
        L28:
            r0 = r6
            r9 = r0
        L2a:
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L43
            android.widget.ImageView r7 = r1.f7543a
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
            android.widget.TextView r2 = r1.f7544b
            androidx.databinding.a.e.a(r2, r0)
        L43:
            return
        L44:
            r0 = move-exception
            monitor-exit(r18)     // Catch: java.lang.Throwable -> L44
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Jb.executeBindings():void");
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
        return a((com.disabngo.blockynexus.view.dialog.b.b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.b.b) obj);
        return true;
    }

    private Jb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ImageView) objArr[1], (TextView) objArr[2]);
        this.g = -1L;
        this.f7543a.setTag(null);
        this.f7575f = (LinearLayout) objArr[0];
        this.f7575f.setTag(null);
        this.f7544b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.b.b bVar, int i) {
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
