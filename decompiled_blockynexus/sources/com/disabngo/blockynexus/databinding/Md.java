package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.t.C0927f;

/* JADX INFO: compiled from: FragmentEnsureEmailBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Md extends Kd {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7674c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7675d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f7676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f7677f;
    private final Button g;
    private androidx.databinding.f h;
    private long i;

    public Md(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f7674c, f7675d));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Kd
    public void a(C0927f c0927f) {
        updateRegistration(0, c0927f);
        this.f7608b = c0927f;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            long r2 = r1.i     // Catch: java.lang.Throwable -> L9c
            r4 = 0
            r1.i = r4     // Catch: java.lang.Throwable -> L9c
            monitor-exit(r20)     // Catch: java.lang.Throwable -> L9c
            com.disabngo.blockynexus.e.b.t.f r0 = r1.f7608b
            r6 = 15
            long r6 = r6 & r2
            r8 = 11
            r10 = 9
            r12 = 13
            r15 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L62
            long r6 = r2 & r10
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L25
            if (r0 == 0) goto L25
            com.sandboxol.common.command.ReplyCommand r6 = r0.f10184f
            goto L26
        L25:
            r6 = r15
        L26:
            long r16 = r2 & r8
            r7 = 1
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L3f
            if (r0 == 0) goto L32
            androidx.databinding.ObservableField<java.lang.String> r14 = r0.f10182d
            goto L33
        L32:
            r14 = r15
        L33:
            r1.updateRegistration(r7, r14)
            if (r14 == 0) goto L3f
            java.lang.Object r14 = r14.get()
            java.lang.String r14 = (java.lang.String) r14
            goto L40
        L3f:
            r14 = r15
        L40:
            long r17 = r2 & r12
            int r19 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r19 == 0) goto L60
            if (r0 == 0) goto L4b
            androidx.databinding.ObservableField<java.lang.String> r0 = r0.f10183e
            goto L4c
        L4b:
            r0 = r15
        L4c:
            r10 = 2
            r1.updateRegistration(r10, r0)
            if (r0 == 0) goto L59
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            goto L5a
        L59:
            r0 = r15
        L5a:
            boolean r10 = android.text.TextUtils.isEmpty(r0)
            r7 = r7 ^ r10
            goto L66
        L60:
            r0 = r15
            goto L65
        L62:
            r0 = r15
            r6 = r0
            r14 = r6
        L65:
            r7 = 0
        L66:
            long r10 = r2 & r12
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L76
            android.widget.EditText r10 = r1.f7607a
            androidx.databinding.a.e.a(r10, r0)
            android.widget.Button r0 = r1.g
            r0.setEnabled(r7)
        L76:
            r10 = 8
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L84
            android.widget.EditText r0 = r1.f7607a
            androidx.databinding.f r7 = r1.h
            androidx.databinding.a.e.a(r0, r15, r15, r15, r7)
        L84:
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L8e
            android.widget.TextView r0 = r1.f7677f
            androidx.databinding.a.e.a(r0, r14)
        L8e:
            r7 = 9
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L9b
            android.widget.Button r0 = r1.g
            r2 = 0
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r6, r2, r2)
        L9b:
            return
        L9c:
            r0 = move-exception
            monitor-exit(r20)     // Catch: java.lang.Throwable -> L9c
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Md.executeBindings():void");
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
            this.i = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((C0927f) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((C0927f) obj);
        return true;
    }

    private Md(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (EditText) objArr[2]);
        this.h = new Ld(this);
        this.i = -1L;
        this.f7607a.setTag(null);
        this.f7676e = (LinearLayout) objArr[0];
        this.f7676e.setTag(null);
        this.f7677f = (TextView) objArr[1];
        this.f7677f.setTag(null);
        this.g = (Button) objArr[3];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(C0927f c0927f, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 4;
        }
        return true;
    }
}
