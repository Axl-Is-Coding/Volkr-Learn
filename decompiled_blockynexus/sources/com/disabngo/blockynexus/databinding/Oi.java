package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemScrapHistoryBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Oi extends Ni {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f7751e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f7752f = null;
    private final ConstraintLayout g;
    private final ImageView h;
    private final ImageView i;
    private long j;

    public Oi(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f7751e, f7752f));
    }

    public void a(com.disabngo.blockynexus.view.dialog.f.c cVar) {
        updateRegistration(0, cVar);
        this.f7724d = cVar;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
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
            long r2 = r1.j     // Catch: java.lang.Throwable -> L9c
            r4 = 0
            r1.j = r4     // Catch: java.lang.Throwable -> L9c
            monitor-exit(r25)     // Catch: java.lang.Throwable -> L9c
            com.disabngo.blockynexus.view.dialog.f.c r0 = r1.f7724d
            r6 = 15
            long r6 = r6 & r2
            r8 = 11
            r10 = 13
            r12 = 0
            r13 = 0
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L63
            long r6 = r2 & r8
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L32
            if (r0 == 0) goto L24
            androidx.databinding.ObservableField<java.lang.String> r6 = r0.f11558a
            goto L25
        L24:
            r6 = r13
        L25:
            r7 = 1
            r1.updateRegistration(r7, r6)
            if (r6 == 0) goto L32
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L33
        L32:
            r6 = r13
        L33:
            long r14 = r2 & r10
            int r7 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r7 == 0) goto L5f
            if (r0 == 0) goto L40
            com.sandboxol.center.entity.ScrapHistoryInfo r0 = r0.getItem()
            goto L41
        L40:
            r0 = r13
        L41:
            if (r0 == 0) goto L51
            int r12 = r0.getCardQuality()
            java.lang.String r7 = r0.getCombineTime()
            java.lang.String r0 = r0.getRewardPic()
            r13 = r7
            goto L52
        L51:
            r0 = r13
        L52:
            android.graphics.drawable.Drawable r7 = com.sandboxol.center.utils.ScrapOutlineViewReturnHelper.getRewardOutline(r12)
            int r12 = com.sandboxol.center.utils.ScrapOutlineViewReturnHelper.getInsideBgColor(r12)
            r16 = r0
            r0 = r13
            r13 = r7
            goto L67
        L5f:
            r0 = r13
            r16 = r0
            goto L67
        L63:
            r0 = r13
            r6 = r0
            r16 = r6
        L67:
            long r10 = r10 & r2
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L91
            android.widget.ImageView r14 = r1.f7721a
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
            android.widget.ImageView r7 = r1.h
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.backgroundColor(r7, r12)
            android.widget.ImageView r7 = r1.i
            androidx.databinding.a.f.a(r7, r13)
            android.widget.TextView r7 = r1.f7723c
            androidx.databinding.a.e.a(r7, r0)
        L91:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L9b
            android.widget.TextView r0 = r1.f7722b
            androidx.databinding.a.e.a(r0, r6)
        L9b:
            return
        L9c:
            r0 = move-exception
            monitor-exit(r25)     // Catch: java.lang.Throwable -> L9c
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Oi.executeBindings():void");
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
            this.j = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.dialog.f.c) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.f.c) obj);
        return true;
    }

    private Oi(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageView) objArr[4], (TextView) objArr[2], (TextView) objArr[1]);
        this.j = -1L;
        this.f7721a.setTag(null);
        this.g = (ConstraintLayout) objArr[0];
        this.g.setTag(null);
        this.h = (ImageView) objArr[3];
        this.h.setTag(null);
        this.i = (ImageView) objArr[5];
        this.i.setTag(null);
        this.f7722b.setTag(null);
        this.f7723c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.f.c cVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.j |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.j |= 4;
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
