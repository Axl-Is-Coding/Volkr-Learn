package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.widget.NineGirdImageView;

/* JADX INFO: compiled from: ItemGroupBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ah extends AbstractC0800zh {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7280c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7281d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f7282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final NineGirdImageView f7283f;
    private final ImageView g;
    private long h;

    public Ah(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f7280c, f7281d));
    }

    public void a(com.disabngo.blockynexus.e.b.B.e eVar) {
        updateRegistration(1, eVar);
        this.f9050b = eVar;
        synchronized (this) {
            this.h |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049 A[PHI: r2
      0x0049: PHI (r2v4 long) = (r2v0 long), (r2v6 long) binds: [B:9:0x001e, B:23:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0076  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.h     // Catch: java.lang.Throwable -> La3
            r4 = 0
            r1.h = r4     // Catch: java.lang.Throwable -> La3
            monitor-exit(r22)     // Catch: java.lang.Throwable -> La3
            com.disabngo.blockynexus.e.b.B.e r0 = r1.f9050b
            r6 = 15
            long r6 = r6 & r2
            r8 = 14
            r10 = 11
            r12 = 10
            r14 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L78
            long r6 = r2 & r10
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L49
            if (r0 == 0) goto L25
            androidx.databinding.ObservableField<java.lang.Boolean> r15 = r0.f9114c
            goto L26
        L25:
            r15 = 0
        L26:
            r1.updateRegistration(r14, r15)
            if (r15 == 0) goto L32
            java.lang.Object r15 = r15.get()
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            goto L33
        L32:
            r15 = 0
        L33:
            boolean r15 = androidx.databinding.ViewDataBinding.safeUnbox(r15)
            int r17 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r17 == 0) goto L43
            if (r15 == 0) goto L40
            r6 = 32
            goto L42
        L40:
            r6 = 16
        L42:
            long r2 = r2 | r6
        L43:
            if (r15 == 0) goto L46
            goto L49
        L46:
            r6 = 8
            goto L4a
        L49:
            r6 = 0
        L4a:
            long r17 = r2 & r12
            int r7 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r7 == 0) goto L5e
            if (r0 == 0) goto L5e
            com.disabngo.blockynexus.adapter.e<java.lang.String> r7 = r0.f9115d
            com.sandboxol.common.command.ReplyCommand r15 = r0.f9113b
            java.util.List<com.disabngo.blockynexus.entity.GroupMember> r10 = r0.f9112a
            r21 = r15
            r15 = r7
            r7 = r21
            goto L61
        L5e:
            r7 = 0
            r10 = 0
            r15 = 0
        L61:
            long r19 = r2 & r8
            int r11 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r11 == 0) goto L76
            if (r0 == 0) goto L6e
            com.disabngo.blockynexus.entity.GroupInfo r0 = r0.getItem()
            goto L6f
        L6e:
            r0 = 0
        L6f:
            if (r0 == 0) goto L76
            java.lang.String r0 = r0.getGroupName()
            goto L7d
        L76:
            r0 = 0
            goto L7d
        L78:
            r0 = 0
            r6 = 0
            r7 = 0
            r10 = 0
            r15 = 0
        L7d:
            long r12 = r12 & r2
            int r11 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r11 == 0) goto L8c
            android.widget.LinearLayout r11 = r1.f7282e
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r11, r7, r14, r14)
            com.disabngo.blockynexus.view.widget.NineGirdImageView r7 = r1.f7283f
            com.disabngo.blockynexus.binding.adapter.m.a(r7, r15, r10)
        L8c:
            r10 = 11
            long r10 = r10 & r2
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L98
            android.widget.ImageView r7 = r1.g
            r7.setVisibility(r6)
        L98:
            long r2 = r2 & r8
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto La2
            android.widget.TextView r2 = r1.f9049a
            androidx.databinding.a.e.a(r2, r0)
        La2:
            return
        La3:
            r0 = move-exception
            monitor-exit(r22)     // Catch: java.lang.Throwable -> La3
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ah.executeBindings():void");
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
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.B.e) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.B.e) obj);
        return true;
    }

    private Ah(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (TextView) objArr[3]);
        this.h = -1L;
        this.f7282e = (LinearLayout) objArr[0];
        this.f7282e.setTag(null);
        this.f7283f = (NineGirdImageView) objArr[1];
        this.f7283f.setTag(null);
        this.g = (ImageView) objArr[2];
        this.g.setTag(null);
        this.f9049a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.B.e eVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.h |= 2;
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
}
