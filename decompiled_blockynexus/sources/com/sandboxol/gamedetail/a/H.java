package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.view.widget.MixtureTextView;

/* JADX INFO: compiled from: ItemGameDetailIntroduceBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class H extends G {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f17793b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f17794c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f17795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MixtureTextView f17796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f17797f;
    private long g;

    public H(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f17793b, f17794c));
    }

    public void a(com.sandboxol.gamedetail.c.a.b.g gVar) {
        updateRegistration(0, gVar);
        this.f17792a = gVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.f17769b);
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
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            long r2 = r1.g     // Catch: java.lang.Throwable -> L43
            r4 = 0
            r1.g = r4     // Catch: java.lang.Throwable -> L43
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L43
            com.sandboxol.gamedetail.c.a.b.g r0 = r1.f17792a
            r6 = 7
            long r2 = r2 & r6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 == 0) goto L28
            if (r0 == 0) goto L1b
            com.sandboxol.greendao.entity.BannerPic r0 = r0.getItem()
            goto L1c
        L1b:
            r0 = r6
        L1c:
            if (r0 == 0) goto L28
            java.lang.String r6 = r0.getPicUrl()
            java.lang.String r0 = r0.getDescribe()
            r8 = r6
            goto L2a
        L28:
            r0 = r6
            r8 = r0
        L2a:
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L42
            com.sandboxol.center.view.widget.MixtureTextView r2 = r1.f17796e
            r2.setText(r0)
            android.widget.ImageView r6 = r1.f17797f
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            com.sandboxol.common.binding.adapter.ImageViewBindingAdapters.loadImage(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
        L42:
            return
        L43:
            r0 = move-exception
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L43
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.gamedetail.a.H.executeBindings():void");
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
        return a((com.sandboxol.gamedetail.c.a.b.g) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.gamedetail.a.f17769b != i) {
            return false;
        }
        a((com.sandboxol.gamedetail.c.a.b.g) obj);
        return true;
    }

    private H(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.g = -1L;
        this.f17795d = (LinearLayout) objArr[0];
        this.f17795d.setTag(null);
        this.f17796e = (MixtureTextView) objArr[1];
        this.f17796e.setTag(null);
        this.f17797f = (ImageView) objArr[2];
        this.f17797f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.gamedetail.c.a.b.g gVar, int i) {
        if (i == com.sandboxol.gamedetail.a.f17768a) {
            synchronized (this) {
                this.g |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.gamedetail.a.m) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }
}
