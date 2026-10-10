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
import com.disabngo.blockynexus.view.dialog.UploadApkDialog;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.fb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogAppUploadApkBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0576fb extends AbstractC0565eb {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = new SparseIntArray();
    private final LinearLayout l;
    private final ImageView m;
    private long n;

    static {
        k.put(R.id.btnCancel, 6);
        k.put(R.id.btnUpload, 7);
        k.put(R.id.btnRestart, 8);
        k.put(R.id.btnInstall, 9);
    }

    public C0576fb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, j, k));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }

    private boolean d(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 8;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    private boolean f(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 32;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0565eb
    public void a(UploadApkDialog.a aVar) {
        updateRegistration(4, aVar);
        this.i = aVar;
        synchronized (this) {
            this.n |= 16;
        }
        notifyPropertyChanged(250);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004f A[PHI: r2
      0x004f: PHI (r2v3 long) = (r2v0 long), (r2v7 long) binds: [B:9:0x0024, B:23:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f6  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0576fb.executeBindings():void");
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
            this.n = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return b((ObservableField) obj, i2);
            case 1:
                return e((ObservableField) obj, i2);
            case 2:
                return c((ObservableField) obj, i2);
            case 3:
                return d((ObservableField) obj, i2);
            case 4:
                return a((UploadApkDialog.a) obj, i2);
            case 5:
                return f((ObservableField) obj, i2);
            case 6:
                return a((ObservableField<Boolean>) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (250 != i) {
            return false;
        }
        a((UploadApkDialog.a) obj);
        return true;
    }

    private C0576fb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 7, (Button) objArr[6], (Button) objArr[5], (Button) objArr[9], (Button) objArr[8], (Button) objArr[7], (ProgressBar) objArr[3], (TextView) objArr[2], (TextView) objArr[4]);
        this.n = -1L;
        this.f8289b.setTag(null);
        this.l = (LinearLayout) objArr[0];
        this.l.setTag(null);
        this.m = (ImageView) objArr[1];
        this.m.setTag(null);
        this.f8293f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(UploadApkDialog.a aVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 16;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 64;
        }
        return true;
    }
}
