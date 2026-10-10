package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.f.C0848i;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ld, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentBindPhoneBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0643ld extends AbstractC0632kd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8549b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8550c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EditText f8552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EditText f8553f;
    private final Button g;
    private final Button h;
    private long i;

    public C0643ld(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f8549b, f8550c));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0632kd
    public void a(C0848i c0848i) {
        updateRegistration(1, c0848i);
        this.f8512a = c0848i;
        synchronized (this) {
            this.i |= 2;
        }
        notifyPropertyChanged(431);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r15 = this;
            monitor-enter(r15)
            long r0 = r15.i     // Catch: java.lang.Throwable -> L64
            r2 = 0
            r15.i = r2     // Catch: java.lang.Throwable -> L64
            monitor-exit(r15)     // Catch: java.lang.Throwable -> L64
            com.disabngo.blockynexus.e.b.f.i r4 = r15.f8512a
            r5 = 7
            long r5 = r5 & r0
            r7 = 6
            r9 = 0
            r10 = 0
            int r11 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r11 == 0) goto L3c
            if (r4 == 0) goto L1a
            androidx.databinding.ObservableField<java.lang.Boolean> r11 = r4.g
            goto L1b
        L1a:
            r11 = r10
        L1b:
            r15.updateRegistration(r9, r11)
            if (r11 == 0) goto L27
            java.lang.Object r11 = r11.get()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            goto L28
        L27:
            r11 = r10
        L28:
            long r12 = r0 & r7
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 == 0) goto L39
            if (r4 == 0) goto L39
            com.sandboxol.common.command.ReplyCommand<java.lang.String> r12 = r4.f9763e
            com.sandboxol.common.command.ReplyCommand r13 = r4.f9762d
            com.sandboxol.common.command.ReplyCommand r14 = r4.f9761c
            com.sandboxol.common.command.ReplyCommand<java.lang.String> r4 = r4.f9764f
            goto L41
        L39:
            r4 = r10
            r12 = r4
            goto L3f
        L3c:
            r4 = r10
            r11 = r4
            r12 = r11
        L3f:
            r13 = r12
            r14 = r13
        L41:
            long r0 = r0 & r7
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 == 0) goto L5a
            android.widget.EditText r0 = r15.f8552e
            com.sandboxol.common.binding.adapter.EditTextBindingAdapters.editTextCommand(r0, r10, r10, r12)
            android.widget.EditText r0 = r15.f8553f
            com.sandboxol.common.binding.adapter.EditTextBindingAdapters.editTextCommand(r0, r10, r10, r4)
            android.widget.Button r0 = r15.g
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r14, r9, r9)
            android.widget.Button r0 = r15.h
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r13, r9, r9)
        L5a:
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 == 0) goto L63
            android.widget.EditText r0 = r15.f8553f
            com.sandboxol.common.binding.adapter.EditTextBindingAdapters.requestFocusCommand(r0, r11)
        L63:
            return
        L64:
            r0 = move-exception
            monitor-exit(r15)     // Catch: java.lang.Throwable -> L64
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0643ld.executeBindings():void");
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
            this.i = 4L;
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
        return a((C0848i) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (431 != i) {
            return false;
        }
        a((C0848i) obj);
        return true;
    }

    private C0643ld(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.i = -1L;
        this.f8551d = (LinearLayout) objArr[0];
        this.f8551d.setTag(null);
        this.f8552e = (EditText) objArr[1];
        this.f8552e.setTag(null);
        this.f8553f = (EditText) objArr[2];
        this.f8553f.setTag(null);
        this.g = (Button) objArr[3];
        this.g.setTag(null);
        this.h = (Button) objArr[4];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 1;
        }
        return true;
    }

    private boolean a(C0848i c0848i, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 2;
        }
        return true;
    }
}
