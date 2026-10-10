package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.e.b.m.C0873e;
import com.sandboxol.center.entity.AccountCenter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.vd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentChangeDetailBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0752vd extends AbstractC0741ud {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8902b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8903c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EditText f8904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8905e;

    public C0752vd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f8902b, f8903c));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0741ud
    public void a(C0873e c0873e) {
        updateRegistration(2, c0873e);
        this.f8867a = c0873e;
        synchronized (this) {
            this.f8905e |= 4;
        }
        notifyPropertyChanged(327);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r11 = this;
            monitor-enter(r11)
            long r0 = r11.f8905e     // Catch: java.lang.Throwable -> L46
            r2 = 0
            r11.f8905e = r2     // Catch: java.lang.Throwable -> L46
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L46
            com.disabngo.blockynexus.e.b.m.e r4 = r11.f8867a
            r5 = 10
            long r5 = r5 & r0
            r7 = 0
            int r8 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r8 == 0) goto L25
            com.sandboxol.center.entity.AccountCenter r8 = com.sandboxol.center.entity.AccountCenter.newInstance()
            androidx.databinding.ObservableField<java.lang.String> r8 = r8.detail
            r9 = 1
            r11.updateRegistration(r9, r8)
            if (r8 == 0) goto L25
            java.lang.Object r8 = r8.get()
            java.lang.String r8 = (java.lang.String) r8
            goto L26
        L25:
            r8 = r7
        L26:
            r9 = 12
            long r0 = r0 & r9
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 == 0) goto L32
            if (r4 == 0) goto L32
            com.sandboxol.common.command.ReplyCommand<java.lang.String> r4 = r4.f9933c
            goto L33
        L32:
            r4 = r7
        L33:
            int r9 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r9 == 0) goto L3c
            android.widget.EditText r5 = r11.f8904d
            androidx.databinding.a.e.a(r5, r8)
        L3c:
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L45
            android.widget.EditText r0 = r11.f8904d
            com.sandboxol.common.binding.adapter.EditTextBindingAdapters.editTextCommand(r0, r7, r7, r4)
        L45:
            return
        L46:
            r0 = move-exception
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L46
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0752vd.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8905e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8905e = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((AccountCenter) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((C0873e) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (327 != i) {
            return false;
        }
        a((C0873e) obj);
        return true;
    }

    private C0752vd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3);
        this.f8905e = -1L;
        this.f8904d = (EditText) objArr[0];
        this.f8904d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(AccountCenter accountCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8905e |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8905e |= 2;
        }
        return true;
    }

    private boolean a(C0873e c0873e, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8905e |= 4;
        }
        return true;
    }
}
