package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.DialogC1122va;

/* JADX INFO: compiled from: DialogAppEnterGameBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ya extends Xa {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f8050f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final FrameLayout h;
    private final LinearLayout i;
    private final TextView j;
    private long k;

    static {
        g.put(R.id.ivLoading, 5);
        g.put(R.id.tvTitle, 6);
    }

    public Ya(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f8050f, g));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Xa
    public void a(DialogC1122va.b bVar) {
        updateRegistration(1, bVar);
        this.f8023e = bVar;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(364);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
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
            long r2 = r1.k     // Catch: java.lang.Throwable -> Lb5
            r4 = 0
            r1.k = r4     // Catch: java.lang.Throwable -> Lb5
            monitor-exit(r20)     // Catch: java.lang.Throwable -> Lb5
            com.disabngo.blockynexus.view.dialog.va$b r0 = r1.f8023e
            r6 = 15
            long r6 = r6 & r2
            r8 = 14
            r10 = 10
            r12 = 11
            r15 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L89
            long r6 = r2 & r12
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L60
            if (r0 == 0) goto L25
            androidx.databinding.ObservableField<java.lang.Boolean> r14 = r0.f11699b
            goto L26
        L25:
            r14 = 0
        L26:
            r1.updateRegistration(r15, r14)
            if (r14 == 0) goto L32
            java.lang.Object r14 = r14.get()
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            goto L33
        L32:
            r14 = 0
        L33:
            boolean r14 = androidx.databinding.ViewDataBinding.safeUnbox(r14)
            int r17 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r17 == 0) goto L43
            if (r14 == 0) goto L40
            r6 = 128(0x80, double:6.3E-322)
            goto L42
        L40:
            r6 = 64
        L42:
            long r2 = r2 | r6
        L43:
            r6 = r14 ^ 1
            r7 = 8
            if (r14 == 0) goto L4b
            r14 = 0
            goto L4d
        L4b:
            r14 = 8
        L4d:
            long r17 = r2 & r12
            int r19 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r19 == 0) goto L5c
            if (r6 == 0) goto L58
            r17 = 32
            goto L5a
        L58:
            r17 = 16
        L5a:
            long r2 = r2 | r17
        L5c:
            if (r6 == 0) goto L62
            r7 = 0
            goto L62
        L60:
            r7 = 0
            r14 = 0
        L62:
            long r17 = r2 & r8
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 == 0) goto L7b
            if (r0 == 0) goto L6d
            androidx.databinding.ObservableField<java.lang.String> r6 = r0.f11698a
            goto L6e
        L6d:
            r6 = 0
        L6e:
            r8 = 2
            r1.updateRegistration(r8, r6)
            if (r6 == 0) goto L7b
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L7c
        L7b:
            r6 = 0
        L7c:
            long r8 = r2 & r10
            int r19 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r19 == 0) goto L87
            if (r0 == 0) goto L87
            com.sandboxol.common.command.ReplyCommand r0 = r0.f11700c
            goto L8d
        L87:
            r0 = 0
            goto L8d
        L89:
            r0 = 0
            r6 = 0
            r7 = 0
            r14 = 0
        L8d:
            long r8 = r2 & r10
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 == 0) goto L98
            android.widget.Button r8 = r1.f8019a
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r8, r0, r15, r15)
        L98:
            long r8 = r2 & r12
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto La8
            android.widget.LinearLayout r0 = r1.f8021c
            r0.setVisibility(r14)
            android.widget.LinearLayout r0 = r1.i
            r0.setVisibility(r7)
        La8:
            r7 = 14
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto Lb4
            android.widget.TextView r0 = r1.j
            androidx.databinding.a.e.a(r0, r6)
        Lb4:
            return
        Lb5:
            r0 = move-exception
            monitor-exit(r20)     // Catch: java.lang.Throwable -> Lb5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ya.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 1) {
            return a((DialogC1122va.b) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (364 != i) {
            return false;
        }
        a((DialogC1122va.b) obj);
        return true;
    }

    private Ya(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (Button) objArr[4], (ImageView) objArr[5], (LinearLayout) objArr[2], (TextView) objArr[6]);
        this.k = -1L;
        this.f8019a.setTag(null);
        this.f8021c.setTag(null);
        this.h = (FrameLayout) objArr[0];
        this.h.setTag(null);
        this.i = (LinearLayout) objArr[1];
        this.i.setTag(null);
        this.j = (TextView) objArr[3];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean a(DialogC1122va.b bVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
