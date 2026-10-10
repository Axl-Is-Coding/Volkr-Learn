package com.sandboxol.halloween.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.view.dialog.HalloweenTipsDialog;
import com.sandboxol.halloween.widget.CenterStrokeTextView;

/* JADX INFO: compiled from: HalloweenDialogTipsBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class h extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f18606f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final ConstraintLayout h;
    private final ImageView i;
    private long j;

    static {
        g.put(R.id.bg_bottom, 5);
    }

    public h(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f18606f, g));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    @Override // com.sandboxol.halloween.b.g
    public void a(HalloweenTipsDialog halloweenTipsDialog) {
        this.f18605e = halloweenTipsDialog;
        synchronized (this) {
            this.j |= 4;
        }
        notifyPropertyChanged(com.sandboxol.halloween.a.f18578b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            long r2 = r1.j     // Catch: java.lang.Throwable -> L9d
            r4 = 0
            r1.j = r4     // Catch: java.lang.Throwable -> L9d
            monitor-exit(r21)     // Catch: java.lang.Throwable -> L9d
            com.sandboxol.halloween.view.dialog.HalloweenTipsDialog r0 = r1.f18605e
            r6 = 15
            long r6 = r6 & r2
            r8 = 1
            r9 = 14
            r11 = 13
            r13 = 12
            r15 = 0
            r16 = 0
            int r17 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r17 == 0) goto L65
            long r6 = r2 & r11
            int r17 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r17 == 0) goto L36
            if (r0 == 0) goto L28
            androidx.databinding.ObservableField<java.lang.String> r6 = r0.f18669b
            goto L2a
        L28:
            r6 = r16
        L2a:
            r1.updateRegistration(r15, r6)
            if (r6 == 0) goto L36
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L38
        L36:
            r6 = r16
        L38:
            long r17 = r2 & r13
            int r7 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r7 == 0) goto L45
            if (r0 == 0) goto L45
            com.sandboxol.common.command.ReplyCommand r7 = r0.f18673f
            com.sandboxol.common.command.ReplyCommand r11 = r0.f18672e
            goto L48
        L45:
            r7 = r16
            r11 = r7
        L48:
            long r19 = r2 & r9
            int r12 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r12 == 0) goto L62
            if (r0 == 0) goto L53
            androidx.databinding.ObservableField<java.lang.String> r0 = r0.f18670c
            goto L55
        L53:
            r0 = r16
        L55:
            r1.updateRegistration(r8, r0)
            if (r0 == 0) goto L62
            java.lang.Object r0 = r0.get()
            r16 = r0
            java.lang.String r16 = (java.lang.String) r16
        L62:
            r0 = r16
            goto L6a
        L65:
            r0 = r16
            r6 = r0
            r7 = r6
            r11 = r7
        L6a:
            long r13 = r13 & r2
            int r12 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r12 == 0) goto L79
            android.view.View r12 = r1.f18602b
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r12, r7, r15, r15)
            android.widget.ImageView r7 = r1.i
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r7, r11, r15, r15)
        L79:
            r11 = 8
            long r11 = r11 & r2
            int r7 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r7 == 0) goto L85
            android.widget.TextView r7 = r1.f18603c
            com.sandboxol.common.binding.adapter.TextViewBindingAdapters.setMovementMethod(r7, r8)
        L85:
            long r7 = r2 & r9
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 == 0) goto L90
            android.widget.TextView r7 = r1.f18603c
            androidx.databinding.a.e.a(r7, r0)
        L90:
            r7 = 13
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L9c
            com.sandboxol.halloween.widget.CenterStrokeTextView r0 = r1.f18604d
            androidx.databinding.a.e.a(r0, r6)
        L9c:
            return
        L9d:
            r0 = move-exception
            monitor-exit(r21)     // Catch: java.lang.Throwable -> L9d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.halloween.b.h.executeBindings():void");
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
            return b((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.halloween.a.f18578b != i) {
            return false;
        }
        a((HalloweenTipsDialog) obj);
        return true;
    }

    private h(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (View) objArr[5], (View) objArr[3], (TextView) objArr[2], (CenterStrokeTextView) objArr[1]);
        this.j = -1L;
        this.f18602b.setTag(null);
        this.h = (ConstraintLayout) objArr[0];
        this.h.setTag(null);
        this.i = (ImageView) objArr[4];
        this.i.setTag(null);
        this.f18603c.setTag(null);
        this.f18604d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != com.sandboxol.halloween.a.f18577a) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }
}
