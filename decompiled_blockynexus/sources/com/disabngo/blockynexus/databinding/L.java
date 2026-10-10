package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.AllGameIdInfo;

/* JADX INFO: compiled from: AppPartyCreateGameItemBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class L extends K {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7630c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7631d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f7632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f7633f;
    private final View g;
    private long h;

    public L(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f7630c, f7631d));
    }

    public void a(com.disabngo.blockynexus.e.b.S.m mVar) {
        updateRegistration(0, mVar);
        this.f7597b = mVar;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r30 = this;
            r1 = r30
            monitor-enter(r30)
            long r2 = r1.h     // Catch: java.lang.Throwable -> Lbc
            r4 = 0
            r1.h = r4     // Catch: java.lang.Throwable -> Lbc
            monitor-exit(r30)     // Catch: java.lang.Throwable -> Lbc
            com.disabngo.blockynexus.e.b.S.m r0 = r1.f7597b
            r6 = 15
            long r8 = r2 & r6
            r10 = 9
            r12 = 13
            r14 = 0
            int r16 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r16 == 0) goto L79
            long r16 = r2 & r10
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L24
            if (r0 == 0) goto L24
            com.sandboxol.common.command.ReplyCommand r15 = r0.f9421b
            goto L25
        L24:
            r15 = 0
        L25:
            if (r0 == 0) goto L2e
            androidx.databinding.ObservableField<com.sandboxol.center.entity.AllGameIdInfo> r6 = r0.f9420a
            com.sandboxol.center.entity.AllGameIdInfo r0 = r0.getItem()
            goto L30
        L2e:
            r0 = 0
            r6 = 0
        L30:
            r7 = 1
            r1.updateRegistration(r7, r6)
            if (r6 == 0) goto L3d
            java.lang.Object r6 = r6.get()
            com.sandboxol.center.entity.AllGameIdInfo r6 = (com.sandboxol.center.entity.AllGameIdInfo) r6
            goto L3e
        L3d:
            r6 = 0
        L3e:
            if (r0 == 0) goto L45
            java.lang.String r7 = r0.getGameId()
            goto L46
        L45:
            r7 = 0
        L46:
            if (r6 == 0) goto L4d
            java.lang.String r6 = r6.getGameId()
            goto L4e
        L4d:
            r6 = 0
        L4e:
            boolean r6 = android.text.TextUtils.equals(r6, r7)
            int r7 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r7 == 0) goto L5e
            if (r6 == 0) goto L5b
            r7 = 32
            goto L5d
        L5b:
            r7 = 16
        L5d:
            long r2 = r2 | r7
        L5e:
            if (r6 == 0) goto L62
            r6 = 0
            goto L64
        L62:
            r6 = 8
        L64:
            long r7 = r2 & r12
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 == 0) goto L77
            if (r0 == 0) goto L77
            java.lang.String r7 = r0.getPicUrl()
            java.lang.String r0 = r0.getGameName()
            r21 = r7
            goto L7e
        L77:
            r0 = 0
            goto L7c
        L79:
            r0 = 0
            r6 = 0
            r15 = 0
        L7c:
            r21 = 0
        L7e:
            long r7 = r2 & r12
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 == 0) goto La4
            android.widget.ImageView r7 = r1.f7596a
            r20 = 0
            r22 = 2131624363(0x7f0e01ab, float:1.8875904E38)
            r23 = 2131624363(0x7f0e01ab, float:1.8875904E38)
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r19 = r7
            com.sandboxol.common.binding.adapter.ImageViewBindingAdapters.loadImage(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            android.widget.TextView r7 = r1.f7633f
            androidx.databinding.a.e.a(r7, r0)
        La4:
            long r7 = r2 & r10
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 == 0) goto Laf
            android.widget.RelativeLayout r0 = r1.f7632e
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r15, r14, r14)
        Laf:
            r7 = 15
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto Lbb
            android.view.View r0 = r1.g
            r0.setVisibility(r6)
        Lbb:
            return
        Lbc:
            r0 = move-exception
            monitor-exit(r30)     // Catch: java.lang.Throwable -> Lbc
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.L.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.S.m) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<AllGameIdInfo>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.S.m) obj);
        return true;
    }

    private L(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageView) objArr[1]);
        this.h = -1L;
        this.f7596a.setTag(null);
        this.f7632e = (RelativeLayout) objArr[0];
        this.f7632e.setTag(null);
        this.f7633f = (TextView) objArr[2];
        this.f7633f.setTag(null);
        this.g = (View) objArr[3];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.S.m mVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.h |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.h |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<AllGameIdInfo> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }
}
