package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.lj, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTribeLeaderBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0649lj extends AbstractC0638kj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8561b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8562c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f8564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8565f;
    private long g;

    public C0649lj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f8561b, f8562c));
    }

    public void a(com.disabngo.blockynexus.e.b.ma.f fVar) {
        updateRegistration(0, fVar);
        this.f8533a = fVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
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
            long r2 = r1.g     // Catch: java.lang.Throwable -> L76
            r4 = 0
            r1.g = r4     // Catch: java.lang.Throwable -> L76
            monitor-exit(r25)     // Catch: java.lang.Throwable -> L76
            com.disabngo.blockynexus.e.b.ma.f r0 = r1.f8533a
            r6 = 7
            long r6 = r6 & r2
            r8 = 5
            r10 = 0
            r11 = 0
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 == 0) goto L40
            long r12 = r2 & r8
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 == 0) goto L22
            if (r0 == 0) goto L22
            com.sandboxol.common.command.ReplyCommand r12 = r0.f9938a
            goto L23
        L22:
            r12 = r11
        L23:
            if (r0 == 0) goto L2c
            java.lang.Object r0 = r0.getItem()
            com.sandboxol.center.entity.TribeClanMembersBean r0 = (com.sandboxol.center.entity.TribeClanMembersBean) r0
            goto L2d
        L2c:
            r0 = r11
        L2d:
            if (r0 == 0) goto L3e
            int r11 = r0.getColor()
            java.lang.String r13 = r0.getStringRole()
            java.lang.String r0 = r0.getHeadPic()
            r16 = r0
            goto L45
        L3e:
            r13 = r11
            goto L42
        L40:
            r12 = r11
            r13 = r12
        L42:
            r16 = r13
            r11 = 0
        L45:
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L6b
            android.widget.ImageView r14 = r1.f8564e
            r15 = 0
            r17 = 2131624363(0x7f0e01ab, float:1.8875904E38)
            r18 = 2131624363(0x7f0e01ab, float:1.8875904E38)
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            com.sandboxol.common.binding.adapter.ImageViewBindingAdapters.loadImage(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            android.widget.TextView r0 = r1.f8565f
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.backgroundColor(r0, r11)
            android.widget.TextView r0 = r1.f8565f
            androidx.databinding.a.e.a(r0, r13)
        L6b:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L75
            android.widget.ImageView r0 = r1.f8564e
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r12, r10, r10)
        L75:
            return
        L76:
            r0 = move-exception
            monitor-exit(r25)     // Catch: java.lang.Throwable -> L76
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0649lj.executeBindings():void");
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
        return a((com.disabngo.blockynexus.e.b.ma.f) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ma.f) obj);
        return true;
    }

    private C0649lj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.g = -1L;
        this.f8563d = (LinearLayout) objArr[0];
        this.f8563d.setTag(null);
        this.f8564e = (ImageView) objArr[1];
        this.f8564e.setTag(null);
        this.f8565f = (TextView) objArr[2];
        this.f8565f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ma.f fVar, int i) {
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
