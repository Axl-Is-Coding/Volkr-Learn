package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: DialogTribeGetContributionBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Kc extends Jc {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f7605e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f7606f = new SparseIntArray();
    private final LinearLayout g;
    private final TextView h;
    private final TextView i;
    private long j;

    static {
        f7606f.put(R.id.rlLeft, 4);
        f7606f.put(R.id.rlRight, 5);
    }

    public Kc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f7605e, f7606f));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Jc
    public void a(com.disabngo.blockynexus.view.dialog.Sa sa) {
        this.f7579d = sa;
        synchronized (this) {
            this.j |= 4;
        }
        notifyPropertyChanged(251);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r19 = this;
            r1 = r19
            monitor-enter(r19)
            long r2 = r1.j     // Catch: java.lang.Throwable -> L80
            r4 = 0
            r1.j = r4     // Catch: java.lang.Throwable -> L80
            monitor-exit(r19)     // Catch: java.lang.Throwable -> L80
            com.disabngo.blockynexus.view.dialog.Sa r0 = r1.f7579d
            r6 = 15
            long r6 = r6 & r2
            r8 = 14
            r10 = 13
            r12 = 12
            r14 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L59
            long r6 = r2 & r12
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L25
            if (r0 == 0) goto L25
            com.sandboxol.common.command.ReplyCommand r6 = r0.f11372d
            goto L26
        L25:
            r6 = 0
        L26:
            long r16 = r2 & r10
            int r7 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r7 == 0) goto L3e
            if (r0 == 0) goto L31
            androidx.databinding.ObservableField<java.lang.String> r7 = r0.f11370b
            goto L32
        L31:
            r7 = 0
        L32:
            r1.updateRegistration(r14, r7)
            if (r7 == 0) goto L3e
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L3f
        L3e:
            r7 = 0
        L3f:
            long r16 = r2 & r8
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L5b
            if (r0 == 0) goto L4a
            androidx.databinding.ObservableField<java.lang.String> r0 = r0.f11369a
            goto L4b
        L4a:
            r0 = 0
        L4b:
            r15 = 1
            r1.updateRegistration(r15, r0)
            if (r0 == 0) goto L5b
            java.lang.Object r0 = r0.get()
            r15 = r0
            java.lang.String r15 = (java.lang.String) r15
            goto L5c
        L59:
            r6 = 0
            r7 = 0
        L5b:
            r15 = 0
        L5c:
            long r12 = r12 & r2
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L6b
            android.widget.LinearLayout r0 = r1.g
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r6, r14, r14)
            android.widget.TextView r0 = r1.i
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r0, r6, r14, r14)
        L6b:
            long r10 = r10 & r2
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L75
            android.widget.TextView r0 = r1.h
            androidx.databinding.a.e.a(r0, r7)
        L75:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L7f
            android.widget.TextView r0 = r1.f7578c
            androidx.databinding.a.e.a(r0, r15)
        L7f:
            return
        L80:
            r0 = move-exception
            monitor-exit(r19)     // Catch: java.lang.Throwable -> L80
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Kc.executeBindings():void");
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
        if (251 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.Sa) obj);
        return true;
    }

    private Kc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (RelativeLayout) objArr[4], (RelativeLayout) objArr[5], (TextView) objArr[1]);
        this.j = -1L;
        this.g = (LinearLayout) objArr[0];
        this.g.setTag(null);
        this.h = (TextView) objArr[2];
        this.h.setTag(null);
        this.i = (TextView) objArr[3];
        this.i.setTag(null);
        this.f7578c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }
}
