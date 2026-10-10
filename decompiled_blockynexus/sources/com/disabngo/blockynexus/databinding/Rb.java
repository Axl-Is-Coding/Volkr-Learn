package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.UploadNewGameDialog;

/* JADX INFO: compiled from: DialogNewGameDownloadBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Rb extends Qb {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final LinearLayout i;
    private long j;

    static {
        h.put(R.id.btnCancel, 5);
    }

    public Rb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, g, h));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 8;
        }
        return true;
    }

    private boolean d(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 16;
        }
        return true;
    }

    private boolean e(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Qb
    public void a(UploadNewGameDialog.a aVar) {
        updateRegistration(1, aVar);
        this.f7797f = aVar;
        synchronized (this) {
            this.j |= 2;
        }
        notifyPropertyChanged(518);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ce  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Rb.executeBindings():void");
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
            this.j = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return e((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((UploadNewGameDialog.a) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i == 3) {
            return c((ObservableField) obj, i2);
        }
        if (i == 4) {
            return d((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (518 != i) {
            return false;
        }
        a((UploadNewGameDialog.a) obj);
        return true;
    }

    private Rb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (Button) objArr[5], (ProgressBar) objArr[3], (TextView) objArr[2], (TextView) objArr[4], (TextView) objArr[1]);
        this.j = -1L;
        this.i = (LinearLayout) objArr[0];
        this.i.setTag(null);
        this.f7793b.setTag(null);
        this.f7794c.setTag(null);
        this.f7795d.setTag(null);
        this.f7796e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(UploadNewGameDialog.a aVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 32;
        }
        return true;
    }
}
