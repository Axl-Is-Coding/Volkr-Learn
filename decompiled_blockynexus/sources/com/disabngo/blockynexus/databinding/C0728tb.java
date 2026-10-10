package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.DialogC1118ta;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.tb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogDownloadInfoBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0728tb extends AbstractC0717sb {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = new SparseIntArray();
    private final ConstraintLayout l;
    private final TextView m;
    private long n;

    static {
        k.put(R.id.v, 5);
        k.put(R.id.v_title, 6);
        k.put(R.id.tv_title, 7);
        k.put(R.id.tv_downloading, 8);
        k.put(R.id.tv_tips_1, 9);
    }

    public C0728tb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, j, k));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0717sb
    public void a(DialogC1118ta dialogC1118ta) {
        this.i = dialogC1118ta;
        synchronized (this) {
            this.n |= 8;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0085  */
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
            long r2 = r1.n     // Catch: java.lang.Throwable -> Lb5
            r4 = 0
            r1.n = r4     // Catch: java.lang.Throwable -> Lb5
            monitor-exit(r21)     // Catch: java.lang.Throwable -> Lb5
            com.disabngo.blockynexus.view.dialog.ta r0 = r1.i
            r6 = 24
            long r6 = r6 & r2
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 == 0) goto L18
            if (r0 == 0) goto L18
            com.sandboxol.common.command.ReplyCommand r0 = r0.f11686a
            goto L19
        L18:
            r0 = 0
        L19:
            r9 = 23
            long r9 = r9 & r2
            r11 = 20
            r13 = 18
            r15 = 17
            r8 = 0
            int r17 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r17 == 0) goto L87
            com.sandboxol.center.download.entity.DownloadInfoCenter r9 = com.sandboxol.center.download.entity.DownloadInfoCenter.getInstance()
            long r17 = r2 & r15
            int r10 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r10 == 0) goto L45
            if (r9 == 0) goto L38
            androidx.databinding.ObservableField r10 = r9.getTotalProgressText()
            goto L39
        L38:
            r10 = 0
        L39:
            r1.updateRegistration(r8, r10)
            if (r10 == 0) goto L45
            java.lang.Object r10 = r10.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L46
        L45:
            r10 = 0
        L46:
            long r17 = r2 & r13
            int r19 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r19 == 0) goto L69
            if (r9 == 0) goto L55
            androidx.databinding.ObservableField r17 = r9.getTotalProgressValue()
            r13 = r17
            goto L56
        L55:
            r13 = 0
        L56:
            r14 = 1
            r1.updateRegistration(r14, r13)
            if (r13 == 0) goto L63
            java.lang.Object r13 = r13.get()
            java.lang.Integer r13 = (java.lang.Integer) r13
            goto L64
        L63:
            r13 = 0
        L64:
            int r13 = androidx.databinding.ViewDataBinding.safeUnbox(r13)
            goto L6a
        L69:
            r13 = 0
        L6a:
            long r19 = r2 & r11
            int r14 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r14 == 0) goto L85
            if (r9 == 0) goto L77
            androidx.databinding.ObservableField r9 = r9.getTotalProgressPercentStr()
            goto L78
        L77:
            r9 = 0
        L78:
            r14 = 2
            r1.updateRegistration(r14, r9)
            if (r9 == 0) goto L85
            java.lang.Object r9 = r9.get()
            java.lang.String r9 = (java.lang.String) r9
            goto L8a
        L85:
            r9 = 0
            goto L8a
        L87:
            r9 = 0
            r10 = 0
            r13 = 0
        L8a:
            int r14 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r14 == 0) goto L93
            android.widget.TextView r6 = r1.f8783a
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r6, r0, r8, r8)
        L93:
            long r6 = r2 & r15
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L9e
            android.widget.TextView r0 = r1.m
            androidx.databinding.a.e.a(r0, r10)
        L9e:
            r6 = 18
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto Laa
            android.widget.ProgressBar r0 = r1.f8784b
            r0.setProgress(r13)
        Laa:
            long r2 = r2 & r11
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto Lb4
            android.widget.TextView r0 = r1.f8786d
            androidx.databinding.a.e.a(r0, r9)
        Lb4:
            return
        Lb5:
            r0 = move-exception
            monitor-exit(r21)     // Catch: java.lang.Throwable -> Lb5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0728tb.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return b((ObservableField) obj, i2);
        }
        if (i == 1) {
            return c((ObservableField) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((DialogC1118ta) obj);
        return true;
    }

    private C0728tb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (TextView) objArr[4], (ProgressBar) objArr[2], (TextView) objArr[8], (TextView) objArr[3], (TextView) objArr[9], (TextView) objArr[7], (View) objArr[5], (View) objArr[6]);
        this.n = -1L;
        this.f8783a.setTag(null);
        this.l = (ConstraintLayout) objArr[0];
        this.l.setTag(null);
        this.m = (TextView) objArr[1];
        this.m.setTag(null);
        this.f8784b.setTag(null);
        this.f8786d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }
}
