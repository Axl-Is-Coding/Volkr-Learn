package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.TribeCenter;

/* JADX INFO: compiled from: FragmentTribeSettingBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Zf extends Yf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8097b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8098c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CheckBox f8100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8101f;

    public Zf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f8097b, f8098c));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8101f |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Yf
    public void a(com.disabngo.blockynexus.e.b.sa.e eVar) {
        updateRegistration(3, eVar);
        this.f8064a = eVar;
        synchronized (this) {
            this.f8101f |= 8;
        }
        notifyPropertyChanged(295);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
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
            long r2 = r1.f8101f     // Catch: java.lang.Throwable -> L81
            r4 = 0
            r1.f8101f = r4     // Catch: java.lang.Throwable -> L81
            monitor-exit(r18)     // Catch: java.lang.Throwable -> L81
            com.disabngo.blockynexus.e.b.sa.e r0 = r1.f8064a
            r6 = 18
            long r6 = r6 & r2
            r8 = 0
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L2f
            com.sandboxol.center.entity.TribeCenter r10 = com.sandboxol.center.entity.TribeCenter.newInstance()
            androidx.databinding.ObservableField<java.lang.Integer> r10 = r10.verification
            r11 = 1
            r1.updateRegistration(r11, r10)
            if (r10 == 0) goto L27
            java.lang.Object r10 = r10.get()
            java.lang.Integer r10 = (java.lang.Integer) r10
            goto L28
        L27:
            r10 = 0
        L28:
            int r10 = androidx.databinding.ViewDataBinding.safeUnbox(r10)
            if (r10 != r11) goto L2f
            goto L30
        L2f:
            r11 = 0
        L30:
            r12 = 28
            long r12 = r12 & r2
            r14 = 24
            int r10 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r10 == 0) goto L62
            long r16 = r2 & r14
            int r10 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r10 == 0) goto L44
            if (r0 == 0) goto L44
            com.sandboxol.common.command.ReplyCommand<java.lang.Boolean> r10 = r0.f10174c
            goto L45
        L44:
            r10 = 0
        L45:
            if (r0 == 0) goto L4a
            androidx.databinding.ObservableField<java.lang.Boolean> r0 = r0.f10173b
            goto L4b
        L4a:
            r0 = 0
        L4b:
            r9 = 2
            r1.updateRegistration(r9, r0)
            if (r0 == 0) goto L5b
            java.lang.Object r0 = r0.get()
            r9 = r0
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            r16 = r9
            goto L5d
        L5b:
            r16 = 0
        L5d:
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox(r16)
            goto L64
        L62:
            r0 = 0
            r10 = 0
        L64:
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L6d
            android.widget.CheckBox r6 = r1.f8100e
            androidx.databinding.a.a.a(r6, r11)
        L6d:
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r6 == 0) goto L76
            android.widget.CheckBox r6 = r1.f8100e
            r6.setClickable(r0)
        L76:
            long r2 = r2 & r14
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L80
            android.widget.CheckBox r0 = r1.f8100e
            com.sandboxol.common.binding.adapter.CheckBoxBindingAdapters.onCheckedChangeListener(r0, r10, r8)
        L80:
            return
        L81:
            r0 = move-exception
            monitor-exit(r18)     // Catch: java.lang.Throwable -> L81
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Zf.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8101f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8101f = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((TribeCenter) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.sa.e) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (295 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.sa.e) obj);
        return true;
    }

    private Zf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4);
        this.f8101f = -1L;
        this.f8099d = (LinearLayout) objArr[0];
        this.f8099d.setTag(null);
        this.f8100e = (CheckBox) objArr[1];
        this.f8100e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(TribeCenter tribeCenter, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8101f |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8101f |= 2;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.sa.e eVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8101f |= 8;
        }
        return true;
    }
}
