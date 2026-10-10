package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.widget.XEditText;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.xd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentChangeNameBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0774xd extends AbstractC0763wd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8967b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8968c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final XEditText f8970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8971f;
    private long g;

    public C0774xd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f8967b, f8968c));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 1;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0763wd
    public void a(com.disabngo.blockynexus.e.b.n.h hVar) {
        updateRegistration(1, hVar);
        this.f8929a = hVar;
        synchronized (this) {
            this.g |= 2;
        }
        notifyPropertyChanged(488);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x006e  */
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
            long r2 = r1.g     // Catch: java.lang.Throwable -> L94
            r4 = 0
            r1.g = r4     // Catch: java.lang.Throwable -> L94
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L94
            com.disabngo.blockynexus.e.b.n.h r0 = r1.f8929a
            r6 = 15
            long r6 = r6 & r2
            r8 = 10
            r10 = 11
            r12 = 14
            r14 = 0
            r15 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L70
            long r6 = r2 & r10
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L49
            if (r0 == 0) goto L26
            androidx.databinding.ObservableField<java.lang.Boolean> r10 = r0.f9967d
            goto L27
        L26:
            r10 = r15
        L27:
            r1.updateRegistration(r14, r10)
            if (r10 == 0) goto L33
            java.lang.Object r10 = r10.get()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            goto L34
        L33:
            r10 = r15
        L34:
            boolean r10 = androidx.databinding.ViewDataBinding.safeUnbox(r10)
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 == 0) goto L44
            if (r10 == 0) goto L41
            r6 = 32
            goto L43
        L41:
            r6 = 16
        L43:
            long r2 = r2 | r6
        L44:
            if (r10 == 0) goto L47
            goto L49
        L47:
            r14 = 8
        L49:
            long r6 = r2 & r8
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L54
            if (r0 == 0) goto L54
            com.sandboxol.common.command.ReplyCommand<java.lang.String> r6 = r0.f9969f
            goto L55
        L54:
            r6 = r15
        L55:
            long r10 = r2 & r12
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L6e
            if (r0 == 0) goto L60
            androidx.databinding.ObservableField<java.lang.String> r0 = r0.f9968e
            goto L61
        L60:
            r0 = r15
        L61:
            r7 = 2
            r1.updateRegistration(r7, r0)
            if (r0 == 0) goto L6e
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            goto L72
        L6e:
            r0 = r15
            goto L72
        L70:
            r0 = r15
            r6 = r0
        L72:
            long r10 = r2 & r12
            int r7 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r7 == 0) goto L7d
            com.disabngo.blockynexus.view.widget.XEditText r7 = r1.f8970e
            androidx.databinding.a.e.a(r7, r0)
        L7d:
            long r8 = r8 & r2
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L87
            com.disabngo.blockynexus.view.widget.XEditText r0 = r1.f8970e
            com.sandboxol.common.binding.adapter.EditTextBindingAdapters.editTextCommand(r0, r15, r15, r6)
        L87:
            r6 = 11
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L93
            android.widget.TextView r0 = r1.f8971f
            r0.setVisibility(r14)
        L93:
            return
        L94:
            r0 = move-exception
            monitor-exit(r17)     // Catch: java.lang.Throwable -> L94
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0774xd.executeBindings():void");
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
            return b((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.e.b.n.h) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableField<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (488 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.n.h) obj);
        return true;
    }

    private C0774xd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3);
        this.g = -1L;
        this.f8969d = (LinearLayout) objArr[0];
        this.f8969d.setTag(null);
        this.f8970e = (XEditText) objArr[1];
        this.f8970e.setTag(null);
        this.f8971f = (TextView) objArr[2];
        this.f8971f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.n.h hVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 4;
        }
        return true;
    }
}
