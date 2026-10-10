package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.UploadSoDialog;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.hb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogAppUploadSoBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0598hb extends AbstractC0587gb {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = new SparseIntArray();
    private final LinearLayout l;
    private long m;

    static {
        k.put(R.id.ivTop, 3);
        k.put(R.id.tvDetails, 4);
        k.put(R.id.btnCancel, 5);
        k.put(R.id.btnClose, 6);
        k.put(R.id.btnUpload, 7);
        k.put(R.id.btnRestart, 8);
    }

    public C0598hb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, j, k));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0587gb
    public void a(UploadSoDialog.a aVar) {
        updateRegistration(1, aVar);
        this.i = aVar;
        synchronized (this) {
            this.m |= 2;
        }
        notifyPropertyChanged(278);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r15 = this;
            monitor-enter(r15)
            long r0 = r15.m     // Catch: java.lang.Throwable -> L64
            r2 = 0
            r15.m = r2     // Catch: java.lang.Throwable -> L64
            monitor-exit(r15)     // Catch: java.lang.Throwable -> L64
            com.disabngo.blockynexus.view.dialog.UploadSoDialog$a r4 = r15.i
            r5 = 15
            long r5 = r5 & r0
            r7 = 11
            r9 = 14
            r11 = 0
            r12 = 0
            int r13 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r13 == 0) goto L4e
            long r5 = r0 & r7
            int r13 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r13 == 0) goto L2f
            if (r4 == 0) goto L22
            androidx.databinding.ObservableField<java.lang.String> r5 = r4.f11430b
            goto L23
        L22:
            r5 = r12
        L23:
            r15.updateRegistration(r11, r5)
            if (r5 == 0) goto L2f
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            goto L30
        L2f:
            r5 = r12
        L30:
            long r13 = r0 & r9
            int r6 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r6 == 0) goto L4f
            if (r4 == 0) goto L3b
            androidx.databinding.ObservableField<java.lang.Integer> r4 = r4.f11429a
            goto L3c
        L3b:
            r4 = r12
        L3c:
            r6 = 2
            r15.updateRegistration(r6, r4)
            if (r4 == 0) goto L49
            java.lang.Object r4 = r4.get()
            r12 = r4
            java.lang.Integer r12 = (java.lang.Integer) r12
        L49:
            int r11 = androidx.databinding.ViewDataBinding.safeUnbox(r12)
            goto L4f
        L4e:
            r5 = r12
        L4f:
            long r9 = r9 & r0
            int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r4 == 0) goto L59
            android.widget.ProgressBar r4 = r15.f8362f
            r4.setProgress(r11)
        L59:
            long r0 = r0 & r7
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L63
            android.widget.TextView r0 = r15.h
            androidx.databinding.a.e.a(r0, r5)
        L63:
            return
        L64:
            r0 = move-exception
            monitor-exit(r15)     // Catch: java.lang.Throwable -> L64
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0598hb.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return b((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((UploadSoDialog.a) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableField<Integer>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (278 != i) {
            return false;
        }
        a((UploadSoDialog.a) obj);
        return true;
    }

    private C0598hb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (Button) objArr[5], (Button) objArr[6], (Button) objArr[8], (Button) objArr[7], (ImageView) objArr[3], (ProgressBar) objArr[1], (TextView) objArr[4], (TextView) objArr[2]);
        this.m = -1L;
        this.l = (LinearLayout) objArr[0];
        this.l.setTag(null);
        this.f8362f.setTag(null);
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(UploadSoDialog.a aVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 4;
        }
        return true;
    }
}
