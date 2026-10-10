package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ui, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemPartyChooseTypeBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0746ui extends AbstractC0735ti {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8879b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8880c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f8881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f8882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8883f;
    private long g;

    public C0746ui(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f8879b, f8880c));
    }

    public void a(com.disabngo.blockynexus.view.dialog.e.b bVar) {
        updateRegistration(0, bVar);
        this.f8848a = bVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b A[PHI: r2
      0x004b: PHI (r2v3 long) = (r2v0 long), (r2v5 long) binds: [B:9:0x001e, B:23:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
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
            long r2 = r1.g     // Catch: java.lang.Throwable -> L8d
            r4 = 0
            r1.g = r4     // Catch: java.lang.Throwable -> L8d
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L8d
            com.disabngo.blockynexus.view.dialog.e.b r0 = r1.f8848a
            r6 = 15
            long r6 = r6 & r2
            r8 = 9
            r10 = 11
            r12 = 13
            r14 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L68
            long r6 = r2 & r10
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L4b
            if (r0 == 0) goto L25
            androidx.databinding.ObservableField<java.lang.Boolean> r15 = r0.f11548b
            goto L26
        L25:
            r15 = 0
        L26:
            r10 = 1
            r1.updateRegistration(r10, r15)
            if (r15 == 0) goto L34
            java.lang.Object r10 = r15.get()
            r15 = r10
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            goto L35
        L34:
            r15 = 0
        L35:
            boolean r10 = androidx.databinding.ViewDataBinding.safeUnbox(r15)
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 == 0) goto L45
            if (r10 == 0) goto L42
            r6 = 32
            goto L44
        L42:
            r6 = 16
        L44:
            long r2 = r2 | r6
        L45:
            if (r10 == 0) goto L48
            goto L4b
        L48:
            r6 = 8
            goto L4c
        L4b:
            r6 = 0
        L4c:
            long r10 = r2 & r8
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L58
            if (r0 == 0) goto L58
            com.sandboxol.common.command.ReplyCommand r7 = r0.f11547a
            r15 = r7
            goto L59
        L58:
            r15 = 0
        L59:
            long r10 = r2 & r12
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L66
            if (r0 == 0) goto L66
            java.lang.String r0 = r0.getItem()
            goto L6b
        L66:
            r0 = 0
            goto L6b
        L68:
            r0 = 0
            r6 = 0
            r15 = 0
        L6b:
            long r10 = r2 & r12
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L76
            android.widget.TextView r7 = r1.f8882e
            androidx.databinding.a.e.a(r7, r0)
        L76:
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L80
            android.widget.TextView r0 = r1.f8882e
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r15, r14, r14)
        L80:
            r7 = 11
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L8c
            android.widget.TextView r0 = r1.f8883f
            r0.setVisibility(r6)
        L8c:
            return
        L8d:
            r0 = move-exception
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L8d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0746ui.executeBindings():void");
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
            this.g = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.dialog.e.b) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.e.b) obj);
        return true;
    }

    private C0746ui(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.g = -1L;
        this.f8881d = (ConstraintLayout) objArr[0];
        this.f8881d.setTag(null);
        this.f8882e = (TextView) objArr[1];
        this.f8882e.setTag(null);
        this.f8883f = (TextView) objArr[2];
        this.f8883f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.e.b bVar, int i) {
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
            this.g |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }
}
